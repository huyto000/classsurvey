<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Class Survey</title>
	<link rel="stylesheet" type="text/css"
		href="<%=request.getContextPath()%>/resources/css/style.css">
    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath()%>/views/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%=request.getContextPath()%>/views/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath()%>/views/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
  

    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath()%>/views/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
		<!-- jQuery -->
    <script src="<%=request.getContextPath()%>/views/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()%>/views/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=request.getContextPath()%>/views/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
   

    <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath()%>/views/dist/js/sb-admin-2.js"></script>
</head>

<body>

    <body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" id = "fixnav" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html"><b>Class Survey</b></a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                
                <!-- /.dropdown -->
                
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav in" id="side-menu">
                        <div></div>
                        <li>
                            <a id = "show-student" href="javascript:void(0)"><i class="fa fa-graduation-cap fa-fw"></i> Quản lý Sinh viên</a>
                        </li>
                        <li>
                            <a id="show-teacher" href="javascript:void(0)"><i class="fa fa-user fa-fw"></i> Quản lý Giảng viên</a>
                        </li> 
                        <li>
                            <a  href="javascript:void(0)"><i class="fa fa-edit fa-fw"></i> Quản lý phiếu khảo sát</a>
                        </li> 
                        <li>
                            <a  href="javascript:void(0)"><i class="fa fa-pencil-square fa-fw"></i> Quản lý cuộc khảo sát</a>
                        </li> 
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Charts<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse">
                                <li>
                                    <a href="flot.html">Flot Charts</a>
                                </li>
                                <li>
                                    <a href="morris.html">Morris.js Charts</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- Page Content -->
        <div id="page-wrapper" style="min-height: 655px;">
            
            <!-- /.row -->
            <div class="col-lg-2"></div>
            <div class="col-lg-8 ajax-area">
					
                    <div class="panel panel-default">
                    <h2 align="center">Thêm tài khoản sinh viên</h2>
                        <!-- <div class="panel-heading">
                            Danh sách tài khoản giảng viên.
                        </div> -->
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <form method="post" action="show-student"  id = "form-add-student">
                            <div class="form-group input-add">
                                            <label>Nhập Tên đăng nhập</label>
                                            <input id="id-stu" class="form-control" name ="userName">
                                            <p class="help-block">Example block-level help text here.</p>
                                        </div>
                                        <div class="form-group input-add">
                                            <label>Nhập mật khẩu</label>
                                            <input id ="passWord-stu" class="form-control" name ="passWord">
                                            <p class="help-block">Example block-level help text here.</p>
                                        </div>
                                        <div class="form-group input-add">
                                            <label>Nhập họ tên</label>
                                            <input id = "fullName-stu" class="form-control " name="fullName">
                                            <p class="help-block">Example block-level help text here.</p>
                                        </div>
                                        <div class="form-group input-add">
                                            <label>Nhập email</label>
                                            <input id="email-stu" class="form-control " name="email">
                                            <p class="help-block">Example block-level help text here.</p>
                                        </div>
                                        <div class="form-group input-add">
                                            <label>Nhập lớp</label>
                                            <input id="class-stu" class="form-control " name="class">
                                            <p class="help-block">Example block-level help text here.</p>
                                        </div>
                                        <button type="submit" class ="btn btn-primary" id="submit-form-add">Thêm sinh viên</button>
                                        </form>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <div class="col-lg-2"></div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
    
	<script>

	</script>
</body>

</html>
