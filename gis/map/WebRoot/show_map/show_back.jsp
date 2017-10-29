<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Track</title>
    <style type="text/css">
        html{height:100%}
        body{height:100%;margin:0px;padding:0px}
        #controller{width:100%; border-bottom:3px outset; height:30px; filter:alpha(Opacity=100); -moz-opacity:1; opacity:1; z-index:10000; background-color:lightblue;}
        #Container{height:100%}
    </style>
   <script src="../script/jquery-1.8.3.min.js" ></script>
<script src="../script/track_back.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=B7d71c582e960e8bc1eae517183b5f77"></script>


</head>

<body  >

<div id="controller" align="center">
    时间：<input type="text" style="color:#429812;" id="gps_time_from" value="2015-09-19"/>到
    <input type="text" style="color:#429812;" id="gps_time_to" value="2015-09-21"/>
    超速限制
    <input type="text" style="color:#429812;" id="chaosuxianzhi" value="60"/>
    <!-- <input type="text" class="" id="device_id" value="381215032027883"/>-->
    <input type="button" class="" id="" value="查询" onclick="Map.addline();"/>
    <input id="follow" type="checkbox"><span style="font-size:12px;">画面跟随</span></input>
    <input id="play" type="button" value="播放" onclick="play();" disabled />
    <input id="pause" type="button" value="暂停" onclick="pause();" disabled />
    <input id="reset" type="button" value="重置" onclick="reset()" disabled />
</div>
<div class="body-nest" id="Footable1" >

超速统计
    <table class="table-striped footable-res footable metro-blue" data-page-size="6" width="1200" border="1" cellspacing="0">
        <thead>
        <tr>
            <th>
                设备ID
            </th>

            <th>
                经度
            </th>
            <th>
                纬度
            </th>
            <th>
                速度
            </th>

            <th>
                时间
            </th>
        </tr>
        </thead >
        <tbody id="tbody1">

        </tbody>
        <tfoot>
        <tr>
            <td colspan="6">
                <div class="pagination pagination-centered"></div>
            </td>
        </tr>
        </tfoot>
    </table>

</div>
<div class="body-nest" id="Footable" >

里程统计
    <table class="table-striped footable-res footable metro-blue" data-page-size="6" width="1200" border="1" cellspacing="0">
        <thead>
        <tr>
            <th>
                设备ID
            </th>

            <th>
                参考行驶公里数(Km)
            </th>
            <th>
                参考油耗(升)
            </th>
            <th>
               时间
            </th>
        </tr>
        </thead >
        <tbody id="tbody">

        </tbody>
        <tfoot>
        <tr>
            <td colspan="6">
                <div class="pagination pagination-centered"></div>
            </td>
        </tr>
        </tfoot>
    </table>

</div>
<div id="container" style="width:100%;height:100%;"></div>
</body>
</html>