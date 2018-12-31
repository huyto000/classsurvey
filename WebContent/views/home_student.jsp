<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                <a class="navbar-brand" href="HomeStudentForward"><b>Class Survey</b></a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                
                <!-- /.dropdown -->
                
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <b>${member.getFullname()}</b> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="HomeForward"><i class="fa fa-sign-out fa-fw"></i>Thoát</a>
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
                        <li>
                            <a href="StudentSurveyForward"><i class="fa fa-edit fa-fw"></i> Đánh giá môn học</a>
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
			<div class="col-lg-1"></div>
			<div class="col-lg-10 ajax-area">
				<div class="row">
					<div class="panel panel-default">
						<h1 align="center">Danh sách tất cả các học phần</h1>
					</div>
					<table class="table table-striped" border="1">
						<thead>
							<tr>
								<th>Mã lớp học phần</th>
								<th>Tên lớp học phần</th>
								<th>Tên giảng viên</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${listCourse}" var="list">
								<tr>
									<td>${list.courseId}</td>
									<td>${list.courseName}</td>
									<td>${list.teacherName}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<!-- /.panel-heading -->
					<div class="panel-body"></div>
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
    
	
</body>

</html>
