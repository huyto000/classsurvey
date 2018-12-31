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
                        <i class="fa fa-user fa-fw"></i> <b>Admin</b> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="HomeForward"><i class="fa fa-sign-out fa-fw"></i> Thoát</a>
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
                            <a  id="show-question" href="javascript:void(0)"><i class="fa fa-edit fa-fw"></i> Quản lý phiếu khảo sát</a>
                        </li> 
                        <li>
                            <a  id="import-studentcourse" href="javascript:void(0)"><i class="fa fa-pencil-square fa-fw"></i> Quản lý cuộc khảo sát</a>
                        </li> 
                        
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- Page Content -->
        <div id="page-wrapper" style="min-height: 1600px;">
            
            <!-- /.row -->
            <div class="col-lg-1"></div>
            <div class="col-lg-10 ajax-area">
					
                    <div class="panel panel-default">
                    <h1>Chào mừng đến với trang chính thức của Admin</h1>
                    <h2>Các chức năng chính:</h3>
                    <h3>-Thêm sinh viên từ file , sửa xóa sinh viên.</h3>
                    <h3>-Thêm giảng viên từ file , sửa xóa giảng viên.</h3>
                    <h3>-Chỉnh sửa đặt mặc định các phiếu khảo sát.</h3>
                    <h3>-Xem kết quả đánh giá của từng lớp học phần.</h3>
                    <h3>-Thêm danh sách lớp môn học.</h2>
                        <!-- <div class="panel-heading">
                            Danh sách tài khoản giảng viên.
                        </div> -->
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <div class="col-lg-1"></div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
    
	<script>
$(document).ready(function() {
	$("#show-student").click(function() {
		var page = 1;
		$.ajax({
				type:'GET',
				url :'show-student',
 				data:{"page":page},
				success:function(response) {
					$(".panel-default").html(response);
				}
			});  	
	}); 
	
$("#show-teacher").click(function() {
		
		$.ajax({
				type:'GET',
				url :'show-teacher',
 
				success:function(response) {
					$(".panel-default").html(response);
				}
			});  	
	}); 
	
$("#show-question").click(function() {
	
	$.ajax({
			type:'GET',
			url :'show-question',

			success:function(response) {
				$(".panel-default").html(response);
			}
		});  	
}); 
	
$("#import-studentcourse").click(function() {
	
	$.ajax({
			type:'GET',
			url :"show-studentcourse",

			success:function(response) {
				$(".panel-default").html(response);
			}
		});  	
}); 
});
	</script>
</body>

</html>
