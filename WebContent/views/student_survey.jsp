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
                            <a id = "show-student" href="javascript:void(0)"><i class="fa fa-edit fa-fw"></i> Đánh giá môn học</a>
                        </li>
                        
                        
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- Page Content -->
		<div id="page-wrapper" style="min-height:1600px;">

			<!-- /.row -->
			<div class="col-lg-1"></div>
			<div class="col-lg-10 ajax-area">
				<div class="row">
					<div class="panel panel-default">
						<h1 align="center">Danh sách các học phần đã đăng ký</h1>
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
							<c:forEach items="${listUserCourse}" var="luc">
								<tr>
									<td>${luc.courseId}</td>
									<td>${luc.courseName}</td>
									<td>${luc.teacherName}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<form name="SurveyForm" action="StudentSurveyController" method="POST">

						<c:if test="${surveymess != null}">
							<h2 style="color: red">${surveymess}</h2>
						</c:if>
						<p><b>Thông tin đánh giá</b></p>
						<p>Hãy điển số điểm tương ứng các mức với các ý kiến mà anh/chị cho là phù hợp và đúng với quan điểm của mình theo chỉ dẫn dưới đây:
						(Với các mức đo tương ứng: 1 = Rất không đồng ý; 2 = Không đồng ý; 3 = Phân vân; 4 = Đồng ý; 5 = Hoàn toàn đồng ý)</p>
						<hr>
						
						<p><b>Chọn môn học đánh giá</b></p>
						<select name="course">
							<c:forEach items="${listUserCourse}" var="luc">
								<option value="${luc.courseId}">${luc.courseName} - ${luc.courseId}</option>
							</c:forEach>
						</select>

						<div style="margin-left: 30px">
							<div class="row">
								<div class="col-sm-8"></div>
								<div class="col-sm-4">
									<div class="row" style="margin-left: 10px">
										<div class="col-sm-2">
											<p>1</p>
										</div>
										<div class="col-sm-2">
											<p>2</p>
										</div>
										<div class="col-sm-2">
											<p>3</p>
										</div>
										<div class="col-sm-2">
											<p>4</p>
										</div>
										<div class="col-sm-2">
											<p>5</p>
										</div>



									</div>
								</div>
							</div>
						</div>
						
						<p>1. Cơ sở vật chất</p>
						<c:forEach items="${listQuestion}" var="lq">
							<c:if test="${lq.type == 1}">
								
								<div style="margin-left: 30px">
									<div class="row">
									<div class="col-sm-8">
									<p>${lq.content}</p>
									</div>
									<div class="col-sm-4">
									<div class ="row" style="margin-left: 10px">
									<div class="col-sm-2">
										<input type="radio" name="ques[${lq.questionId}]" value="1">  
										</div>
										<div class="col-sm-2">
										<input type="radio" name="ques[${lq.questionId}]" value="2"> 
										</div>
										<div class="col-sm-2">
										<input type="radio" name="ques[${lq.questionId}]" value="3"> 
										</div>
										<div class="col-sm-2">
										<input type="radio" name="ques[${lq.questionId}]" value="4"> 
										</div>
										<div class="col-sm-2">
										
										<input type="radio" name="ques[${lq.questionId}]" value="5"> 
									</div>
									</div>
									</div>
								</div>
								</div>
								
							</c:if>
						</c:forEach>
						<hr>

						<p>2. Môn học</p>
						<c:forEach items="${listQuestion}" var="lq">
							<c:if test="${lq.type == 2}">
								<div style="margin-left: 30px">
								<div class="row">
								<div class="col-sm-8">
									<p>${lq.content}</p>
									</div>
									<div class="col-sm-4">
									<div class="row" style="margin-left: 10px">
										<div class="col-sm-2">
										<input type="radio" name="ques[${lq.questionId}]" value="1">  
										</div>
										<div class="col-sm-2">
										<input type="radio" name="ques[${lq.questionId}]" value="2"> 
										</div>
										<div class="col-sm-2">
										<input type="radio" name="ques[${lq.questionId}]" value="3"> 
										</div>
										<div class="col-sm-2">
										<input type="radio" name="ques[${lq.questionId}]" value="4"> 
										</div>
										<div class="col-sm-2">
										<input type="radio" name="ques[${lq.questionId}]" value="5"> 
										</div>
									</div>
									</div>
								</div>
								</div>
							</c:if>
						</c:forEach>
						<hr>

						<p>3. Hoạt động giảng dạy của giảng viên</p>
						<c:forEach items="${listQuestion}" var="lq">
							<c:if test="${lq.type == 3}">
								<div style="margin-left: 30px">
									<div class="row">
									<div class="col-sm-8">
									<p>${lq.content}</p>
									</div>
									<div class="col-sm-4">
									<div class="row"style="margin-left: 10px">
										<div class="col-sm-2">
										<input type="radio" name="ques[${lq.questionId}]" value="1">  
										</div>
										<div class="col-sm-2">
										<input type="radio" name="ques[${lq.questionId}]" value="2"> 
										</div>
										<div class="col-sm-2">
										<input type="radio" name="ques[${lq.questionId}]" value="3"> 
										</div>
										<div class="col-sm-2">
										<input type="radio" name="ques[${lq.questionId}]" value="4"> 
										</div>
										<div class="col-sm-2">																	
										<input type="radio" name="ques[${lq.questionId}]" value="5"> 
										</div>
									</div>
									</div>
									</div>
								</div>
							</c:if>
						</c:forEach>
						<br>
						<div style="text-align: center;">
							<input style="background-color: #74DF00" type="submit" value="Ghi Nhận">
						</div>
					</form>

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
