<!DOCTYPE html>
    <head>
        <meta charset="utf-8">
        <title>Artcore - Services</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" href="../css/bootstrap.css">
        <link rel="stylesheet" href="../css/font-awesome.css">
        <link rel="stylesheet" href="../css/animate.css">
        <link rel="stylesheet" href="../css/templatemo-misc.css">
        <link rel="stylesheet" href="../css/templatemo-style.css">
        <script src="../js/vendor/modernizr-2.6.1-respond-1.1.0.min.js"></script>
  

    </head>
    <body>

        <section id="pageloader">
            <div class="loader-item fa fa-spin colored-border"></div>
        </section> <!-- /#pageloader -->

        <header class="site-header container-fluid">
             <div class="top-header">
                <div class="logo col-md-6 col-sm-6">
                    <h1><a href="../index.html"><em>无人机</em>环境监测</a></h1>
                    <span>by PYX小组</span>
                </div> <!-- /.logo -->
            </div> <!-- /.top-header -->
             <div class="main-header">
                <div class="row">
                    <div class="main-header-left col-md-3 col-sm-6 col-xs-8">
                        <a id="search-icon" class="btn-left fa fa-search" href="#search-overlay"></a>
                        <div id="search-overlay">
                            <a href="#search-overlay" class="close-search"><i class="fa fa-times-circle"></i></a>
                            <div class="search-form-holder">
                                <h2>Type keywords and hit enter</h2>
                                <form id="search-form" action="#">
                                    <input type="search" name="s" placeholder="" autocomplete="off" />
                                </form>
                            </div>
                        </div><!-- #search-overlay -->
                        <a href="#" class="btn-left arrow-left fa fa-angle-left"></a>
                        <a href="#" class="btn-left arrow-right fa fa-angle-right"></a>
                    </div> <!-- /.main-header-left -->
                    <div class="menu-wrapper col-md-9 col-sm-6 col-xs-4">
                        <a href="#" class="toggle-menu visible-sm visible-xs"><i class="fa fa-bars"></i></a>
                        <ul class="sf-menu hidden-xs hidden-sm">
                            <li class="active"><a href="../index.html">首页</a></li>
                            <li><a href="services.jsp">无人机地图数据</a>
                                
                            </li>
                                
                            <li><a href="http://localhost:8090/en_uav_cam/uavcam.html">现场视频</a></li>
                            <li><a href="#">分析报告</a>
                                <ul>
                                    <li><a href="blog.html">Blog Masonry</a></li>
                                    <li><a href="blog-single.html">Post Single</a></li>
                                </ul>
                            </li>
                            <li><a href="#">关于</a>
                                <ul>
                                    <li><a href="our-team.html">Our Team</a></li>
                                    <li><a href="archives.html">Archives</a></li>
                                    <li><a href="grids.html">Columns</a></li>
                                    <li><a href="404.html">404 Page</a></li>
                                </ul>
                            </li>
                            <li><a href="contact.html">Contact</a></li>
                        </ul>
                    </div> <!-- /.menu-wrapper -->
                </div> <!-- /.row -->
            </div> <!-- /.main-header -->
<div id="responsive-menu">
                <ul>
                    <li><a href="../index.html">首页</a></li>
                    <li><a href="services.jsp">无人机地图数据</a></li>
                    <li><a href="http://localhost:8090/en_uav_cam/uavcam.html">现场视频</a></li>
                    <li><a href="#">分析报告</a>
                        <ul>
                            <li><a href="blog.html">Blog Masonry</a></li>
                            <li><a href="blog-single.html">Post Single</a></li>
                        </ul>
                    </li>
                    <li><a href="#">关于</a>
                        <ul>
                            <li><a href="our-team.html">Our Team</a></li>
                            <li><a href="archives.html">Archives</a></li>
                            <li><a href="grids.html">Columns</a></li>
                            <li><a href="404.html">404 Page</a></li>
                        </ul>
                    </li>
                    <li><a href="contact.html">Contact</a></li>
                </ul>
            </div>
        </header> <!-- /.site-header -->

          <div class="content-wrapper">
            <div class="inner-container container" >
                <div class="row">
                    <div class="col-md-12">
                        <p><font size="5">无人机轨迹信息</font></p>
                       <br>设备ID： <input type="text" style="color:#429812;" id="device_Id" value="">时间：<input type="text" style="color:#429812;" id="gps_time_from" value="2017-11-06 00:00:00"/>到
    <input type="text" style="color:#429812;" id="gps_time_to" value="2017-11-12 24:00:00"/>
	<input type="button" class="" id="" style="color:#429812;"  value="查询" onclick="Map.addLine();"/>

 <div id="allmap" style="height:600px"></div>                   
</div> <!-- /.section-header -->
                </div> <!-- /.row -->
              </div><!-- /.inner-content -->  
        </div> <!-- /.content-wrapper -->
       <script src="../script/jquery-1.8.3.min.js" ></script>

	<script src="../script/track_view.js"></script>

 

  <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=B7d71c582e960e8bc1eae517183b5f77"></script>
    
    
        <script src="../js/vendor/jquery-1.11.0.min.js"></script>
        <script>window.jQuery || document.write('<script src="../js/vendor/jquery-1.11.0.min.js"><\/script>')</script>
        <script src="../js/plugins.js"></script>
        <script src="../js/main.js"></script>

        <!-- Preloader -->
        <script type="text/javascript">
            //<![CDATA[
            $(window).load(function() { // makes sure the whole site is loaded
                $('.loader-item').fadeOut(); // will first fade out the loading animation
                    $('#pageloader').delay(350).fadeOut('slow'); // will fade out the white DIV that covers the website.
                $('body').delay(350).css({'overflow-y':'visible'});
            })
            //]]>
        </script>
 
 

    </body>
</html>
