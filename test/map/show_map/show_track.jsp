<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.text.*"%>


<!-- 调用地图show_map/map_view.html里面的内容 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>百度地图</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1" name="viewport" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script src="../script/jquery-1.8.3.min.js" ></script>
<script src="../script/track_view.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=0.0&ak=B7d71c582e960e8bc1eae517183b5f77"></script>
		
	</head>
	
      <body>
		<div>
		<!-- 以前叫allmap,改成了markers_popup_track/map_view.htm（openlayers）里面的 map -->
			
				<div class="map_panel_div" id="map_panel_div">
				
				
				
				时间：<input type="text" style="color:#429812;" id="gps_time_from" value="2017-11-06 00:00:00"/>到
    <input type="text" style="color:#429812;" id="gps_time_to" value="2017-11-12 24:00:00"/>
	<input type="button" class="" id="" value="查询" onclick="Map.addLine();"/>
				</div>
				<div id="allmap" style="width:100%;height:100%;">
			    </div>
			
		</div>
		
	</body>
</html>


	
		