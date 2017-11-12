//参考：http://jingyan.baidu.com/article/ed2a5d1f3fb4d309f6be17c3.html
//参考：http://www.cnblogs.com/zhangqs008/p/3677098.html

jQuery(document).ready(function() {
	Map.init();
});
var map;    
var point=new Array();//存放标注点经纬度信息的数组
var marker=new Array();//存放标注点对象的数组
var info=new Array();//存放提示信息窗对象的数组
var Map=function(){
	var initMap=function(){
		// 百度地图API功能
		map = new BMap.Map("allmap");    // 创建Map实例
		map.centerAndZoom(new BMap.Point(104.001404, 30.55915), 5);  // 初始化地图,设置中心点坐标和地图级别
		map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
		map.setCurrentCity("成都");          // 设置地图显示的城市 此项是必须设置的
		map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
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
	


	var addMarker=function(){	//添加标注
	            
                
       $.post("gps_device.jsp",function(data){

                   
                    //alert(JSON.stringify(data));
		var json=eval("("+data+")");
                     //var json=data;
                      var list=json.aaData;
                    
                      for(var i=0;i<list.length;i++){                       
                          var ID=list[i].device_id;
                        
                          var L0=list[i].longitude;
                          var L1=list[i].latitude;
                          var tem=list[i].tem;
                          var hum=list[i].hum;
                          var p=list[i].pm;
                        var myIcon = new BMap.Icon(scr="../images/fly.png", new BMap.Size(57,57));
                          point[i]=new BMap.Point(L0,L1);
                         
                          marker[i]=new BMap.Marker(point[i],{icon:myIcon});                
                          map.addOverlay(marker[i]);
                          info[i]=new window.BMap.InfoWindow("<input type='hidden' id='device_id' value='"+ID+"'> <div>设备ID:"+ID+"<br>经度:"+L0+"<br>纬度:"+L1+"<br>温度："+tem+"<br>湿度:"+hum+"<br>PM2.5:"+p+"<br><a href='javascript:Map.Gototrack(\""+ID+"\");'>轨迹</a> <a href='javascript:Map.Gotoback(\""+ID+"\");'>回放</a></div>");
                          addPopup(i);
                      }

		
                });
                
    };
    var Gototrack=function(deviceId){
    	
   	  var track_id=document.getElementById("device_id").value;
   	
   	//var timeFrom="2015-09-19"
   		//var timeTo="2015-09-21";
   		window.location="show_track.jsp?trackid=" + track_id;
		//+"&gps_time_from="+timeFrom+"&gps_time_to="+timeTo;
   		//+"&gps_time_from="+timeFrom+"&gps_time_to="+timeTo

     };
     var Gotoback=function(deviceId){
     	
      	  var track_id=document.getElementById("device_id").value;
      		window.location="show_back.jsp?trackid=" + track_id+"";
      		//+"&gps_time_from="+timeFrom+"&gps_time_to="+timeTo

        };
             var addPopup=function(i){

                 marker[i].addEventListener("click",function(){

                     this.openInfoWindow(info[i]);

                  });
              };
            
							return{
                                  init: function(){
                                       initMap();
                                       addMarker();
                                       //addLine();
							},
                                       
                                  Gototrack:function(deviceId){
                                    	 Gototrack(deviceId);
                                       },
                                       Gotoback:function(deviceId){
                                      	 Gotoback(deviceId);
                                         }
                                    
                      };

}(); 