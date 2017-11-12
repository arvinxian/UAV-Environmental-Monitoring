//参考：http://jingyan.baidu.com/article/ed2a5d1f3fb4d309f6be17c3.html
//参考：http://www.cnblogs.com/zhangqs008/p/3677098.html

jQuery(document).ready(function() {
	Map.init();
});
var map;
var trackId;
var Map = function() {
	var initMap = function() {
		// 百度地图API功能
		trackId = GetQueryString("trackid");
document.getElementById("device_Id").value=trackId;
		map = new BMap.Map("allmap"); // 创建Map实例
		map.centerAndZoom(new BMap.Point(104.001404, 30.55915), 5); // 初始化地图,设置中心点坐标和地图级别
		map.addControl(new BMap.MapTypeControl()); // 添加地图类型控件
		map.setCurrentCity("成都"); // 设置地图显示的城市 此项是必须设置的
		map.enableScrollWheelZoom(true); // 开启鼠标滚轮缩放
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
	function GetQueryString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null;
	};

	var addLine = function() { // 添加线路
		var timeFrom=document.getElementById("gps_time_from").value;
		var timeTo=document.getElementById("gps_time_to").value;
		//var timeFrom = "2017-10-01 00:00:00";
		//var timeTo = "2017-12-31 24:00:00";
		//+"device_id="+trackId&gps_time_from=2016-12-01 &gps_time_to=2017-12-21 "
	
		$.post("gps_track.jsp?device_id="+trackId+"&gps_time_from="+timeFrom+"&gps_time_to="+timeTo,function(data){
		
			
			var polylinePoint = new Array();
			var json=eval("("+data+")");
                        var list=json.aaData;
          
                        for(var i=0;i<list.length;i++){
				/*
				 * var p0=list[i].longitude; var p1=list[i].latitude; var
				 * polylinePoint[i]=new BMap.Point(p0,p1);
				 */
                var ID=list[i].device_id;
				var L0 = list[i].longitude;
			
				var L1 = list[i].latitude;
				var tem=list[i].tem;
                                var hum=list[i].hum;
                                var p=list[i].pm
				polylinePoint[i] = new BMap.Point(L0, L1);
				
				var myIcon = new BMap.Icon(scr="../images/fly.png", new BMap.Size(57,57));
			    var point = new BMap.Point(list[0].longitude,list[0].latitude);
	            var marker = new BMap.Marker(point,{icon:myIcon});  // 创建标注
	            map.addOverlay(marker); 
				var infoWindow = new BMap.InfoWindow("<input type='hidden' id='device_id' value='"+trackId+"'><div>设备ID："+trackId+"<br>温度："+tem+"<br>湿度："+hum+"<br>PM2.5:"+p+"<br><a href='javascript:Map.Gotoback(trackId);'>回放    </a><a href='services.jsp'>返回</a>");  // 创建信息窗口对象 
	            marker.addEventListener("click", function(){          
		        map.openInfoWindow(infoWindow,point); //开启信息窗口
	});

			}
	
			var polyline = new BMap.Polyline(polylinePoint, {
				strokeColor : "yellow",
				strokeWeight : 6,
				strokeOpacity : 0.5
			});

       
        map.addOverlay(polyline);// 添加线路图层
	map.centerAndZoom(polylinePoint[0], 10);// 初始化地图，设置中心点坐标和地图级别
			});

	};

        var Gotoback=function(deviceId){
     	
      	  var track_id=document.getElementById("device_id").value;
      		window.location="show_back.jsp?trackid=" + track_id+"";
      		//+"&gps_time_from="+timeFrom+"&gps_time_to="+timeTo

        };    
	 return{
        init: function(){
            initMap();
        },
        GetQueryString:function(name){
            GetQueryString(name);
        },

        addLine:function(){
            addLine();
        },
		Gotoback:function(deviceId){
            Gotoback(deviceId);
        }
		
    };
}();