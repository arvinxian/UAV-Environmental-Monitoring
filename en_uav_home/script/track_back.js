/**
 * Created by Emma on 2017/5/27.
 */
//参考：http://jingyan.baidu.com/article/ed2a5d1f3fb4d309f6be17c3.html
//参考：http://www.cnblogs.com/zhangqs008/p/3677098.html

jQuery(document).ready(function() {
    Map.init();
});
//初始化坐标点
var points = [];
//初始化地图
var map; //百度地图对象
var car; //汽车图标
var label; //信息标签
var centerPoint;
//初始化控件
var timer; //定时器
var index = 0; //记录播放到第几个point
var followChk, playBtn,pauseBtn, resetBtn; //几个控制按钮
//初始化上一页传过来的参数
var trackId;
//初始化时间
var date1=new Date();  //开始时间

var date2=new Date();    //结束时间
var Map=function(){
    var initMap=function(){
        // 百度地图API功能
        trackId=GetQueryString("trackid");
		document.getElementById("device_Id").value=trackId;
        //alert(trackId);
        map = new BMap.Map("allmap");
        map.centerAndZoom(new BMap.Point(104.001404, 30.55915), 10);
        map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
        map.setCurrentCity("成都");
        map.enableScrollWheelZoom(true);
        map.addControl(new BMap.NavigationControl());
map.enableInertialDragging();

                map.enableContinuousZoom();
                map.disable3DBuilding();
var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT});
// 左上角，添加比例尺
var top_left_navigation = new BMap.NavigationControl();  
//左上角，添加默认缩放平移控件
var top_right_navigation = new BMap.NavigationControl({anchor: BMAP_ANCHOR_TOP_RIGHT, type: BMAP_NAVIGATION_CONTROL_SMALL}); 
//右上角，仅包含平移和缩放按钮
var size = new BMap.Size(90, 50);
        map.addControl(top_left_control);        
	map.addControl(top_left_navigation);     
	map.addControl(top_right_navigation);  

        map.addControl(new BMap.CityListControl({
        anchor: BMAP_ANCHOR_TOP_LEFT,
        offset: size,
    // 切换城市之间事件
    // onChangeBefore: function(){
    //    alert('before');
    // },
    // 切换城市之后事件
    // onChangeAfter:function(){
    //   alert('after');
    // }
}));
	  var styleJson = [
		    {
                    "featureType": "water",
                    "elementType": "all",
                    "stylers": {
                              "color": "#073763",
                              "hue": "#3d85c6"
                    }
          },
          {
                    "featureType": "background",
                    "elementType": "all",
                    "stylers": {
                              "color": "#d0e0e3"
                    }
          },
          {
                    "featureType": "land",
                    "elementType": "all",
                    "stylers": {
                              "color": "#a2c4c9",
                              "hue": "#a2c4c9"
                    }
          },
          {
                    "featureType": "road",
                    "elementType": "all",
                    "stylers": {
                              "color": "#d0e0e3",
                              "hue": "#d0e0e3"
                    }
          }
]
	map.setMapStyle({styleJson:styleJson});
    };
    function GetQueryString(name)
    {
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  unescape(r[2]); return null;
    };

    var addline=function () {
        var gpsTimeFrom=document.getElementById("gps_time_from").value;
        var gpsTimeTo=document.getElementById("gps_time_to").value;
        $.post("gps_track.jsp?device_id="+trackId+"&gps_time_from="+gpsTimeFrom+"&gps_time_to="+gpsTimeTo,function(data){
            var json=eval("("+data+")");
            //alert(JSON.stringify(data));
            var list=json.aaData;
            var deviceid;
            var devicetime;

            //alert(list.length);
            for(var i=0;i<list.length;i++){
                devicetime=list[i].time;
                deviceid=list[i].device_id;
                var L1=list[i].latitude;
                var L0=list[i].longitude;

                // var spe=list[i][5];
                // var loc=list[i][6];

                points[i]=new BMap.Point(L0,L1);
                map.centerAndZoom(points[1], 15);
            }

           
            

           //里程统计显示
                       
        //     alert(points[0]);
        followChk = document.getElementById("follow");
        playBtn = document.getElementById("play");
       
        pauseBtn = document.getElementById("pause");
        resetBtn = document.getElementById("reset");
        //alert("1");

        //连接所有点
        var myIcon = new BMap.Icon(scr="../images/fly.png", new BMap.Size(57,57));
        map.addOverlay(new BMap.Polyline(points, {strokeColor: "yellow", strokeWeight: 5, strokeOpacity: 1}));
        //显示小车子
        label = new BMap.Label("", {offset: new BMap.Size(-20, -20)});
        car = new BMap.Marker(points[0],{icon:myIcon});
        car.setLabel(label);
        map.addOverlay(car);

//点亮操作按钮
        playBtn.disabled = false;
        resetBtn.disabled = false;
        fastplayBtn.disabled =false;
        })

    };

    return{
        init: function(){
            initMap();
        },
        GetQueryString:function(name){
            GetQueryString(name);
        },

        addline:function(){
            addline();
        }
    };

}();
function play() {
    playBtn.disabled = true;
    pauseBtn.disabled = false;
 

    var point = points[index];
    if(index > 0) {
        map.addOverlay(new BMap.Polyline([points[index - 1], point], {strokeColor: "red", strokeWeight: 1, strokeOpacity: 1}));
    }

    label.setContent("经度: " + point.lng + "<br>纬度: " + point.lat);
    car.setPosition(point);
    index++;
    if(followChk.checked) {
        map.panTo(point);
    }

    if(index < points.length) {
        timer = window.setTimeout("play(" + index + ")", 100);

    } else {
        playBtn.disabled = true;
        pauseBtn.disabled = true;
        map.panTo(point);
    }

};


function pause() {
    playBtn.disabled = false;
    pauseBtn.disabled = true;

    if(timer) {
        window.clearTimeout(timer);
    }
};

function reset() {
    followChk.checked = false;
    playBtn.disabled = false;
    pauseBtn.disabled = true;

            if(timer) {
        window.clearTimeout(timer);    index = 0;

    }
    car.setPosition(points[0]);
    map.panTo(centerPoint);
};
function jisuanshijiancha(date1,date2) {
    //alert(date2+"1"+date1);

    var date11=new Date(date1);
    var date22=new Date(date2);
    var date3=date22.getTime()-date11.getTime() ; //时间差的毫秒数


//计算出相差天数
    var days=Math.floor(date3/(24*3600*1000));

//计算出小时数

    var leave1=date3%(24*3600*1000) ;   //计算天数后剩余的毫秒数
    var hours=Math.floor(leave1/(3600*1000));
//计算相差分钟数;
    var leave2=leave1%(3600*1000) ;       //计算小时数后剩余的毫秒数
    var minutes=Math.floor(leave2/(60*1000));


//计算相差秒数
    var leave3=leave2%(60*1000)  ;    //计算分钟数后剩余的毫秒数
    var seconds=Math.round(leave3/1000);
    //alert(" 相差 "+days+"天 "+hours+"小时 "+minutes+" 分钟"+seconds+" 秒");
   // alert(date3/3600000);
    return (date3/3600000)



}

