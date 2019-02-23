<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>跆拳道九段联盟-管理页</title>

    <!-- Bootstrap -->
    <link rel="shortcut  icon" type="image/x-icon" href="../../images/icon/icon.ico" media="screen"  />
    <link href="../venstyles/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../venstyles/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../venstyles/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../venstyles/green.css" rel="stylesheet">

    <!-- bootstrap-progressbar -->
    <link href="../venstyles/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="../venstyles/jqvmap.min.css" rel="stylesheet"/>
    <!-- bootstrap-daterangepicker -->
    <link href="../venstyles/daterangepicker.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../venstyles/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="/admin/home/" class="site_title"> <span>跆拳道九段联盟</span></a>
                </div>

                <div class="clearfix"></div>

                <!-- menu profile quick info -->
                <div class="profile clearfix">
                    <div class="profile_pic">
                        <img src="../../images/logo.png" alt="..." class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
                        <span>欢迎，</span>
                        <h2>John Doe</h2>
                    </div>
                </div>
                <!-- /menu profile quick info -->

                <br />

                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <h3>目录</h3>
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-edit"></i>新闻<span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="/admin/news_add/">添加</a></li>
                                    <li><a href="/admin/news_talbes/">目录</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-desktop"></i>成员<span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="/admin/person_add/">添加</a></li>
                                    <li><a href="/admin/person_gallery/">成员目录</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-table"></i>证书<span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="/admin/cert_add/">添加</a></li>
                                    <li><a href="/admin/cert_adds/">批量添加</a></li>
                                    <li><a href="/admin/cert_tables/">目录</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
                <!-- /sidebar menu -->

                <!-- /menu footer buttons -->
                <div class="sidebar-footer hidden-small">
                    <a data-toggle="tooltip" data-placement="top" title="Settings">
                        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                        <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Lock">
                        <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
                        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                    </a>
                </div>
                <!-- /menu footer buttons -->
            </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <nav>
                    <div class="nav toggle">
                        <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                    </div>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="">
                            <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                John Doe
                            </a>
                            <ul class="dropdown-menu dropdown-usermenu pull-right">
                                <li><a href="#">帮助</a></li>
                                <li><a href="/logout/">注销</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->
