<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div class="panel-heading">
                         <div class="row" align="center">
                           
                           <h2>Kết quả đánh giá.</h2>
                            
                           </div>
                           <h4>Mã môn học:  ${courseId}</h4>
                          <h4>Tên lớp học phần:  ${courseName}</h4> 
                          <h4>Tên giảng viên:  ${teacherName}</h4>
                        </div>
	<table class="table table-striped" border="1">
						<thead>
							<tr>
								<th>STT</th>
								<th>Tiêu chí</th>
								<th>Đánh giá trung bình</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${listQuestion}" var="lq">
								<tr>
									<td>${lq.questionId}</td>
									<td>${lq.content}</td>
									<td>${lq.result}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
		<div id= "ghichu">
		<p>Ghi chú</p>
		<p>- M: Gía trị trung bình của các tiêu chí theo lớp học phần </p>
		<!-- <p>- STD: Gía trị trung bình của các tiêu chí theo lớp học phần </p>
		<p>- M1: Gía trị trung bình của các tiêu chí dựa trên phản hồi của sinh viên cho các giảng viên dạy cùng môn học với thầy cô</p>
		<p>- STD1: Độ lệch chuẩn của các tiêu chí dựa trên phản hồi của sinh viên cho các giảng viên dạy cùng môn học với thầy cô</p>
		<p>- M2: Gía trị trung bình của các tiêu chí dựa trên phản hồi của sinh viên về các môn học mà thầy cô đã giảng dạy</p>
		<p>- STD2: Độ lệch chuẩn của các tiêu chí dựa trên phản hồi của sinh viên về các môn học mà thầy cô đã giảng dạy</p> -->
		</div>
		
		
		
		<script>
		
		
</script>
</body>
</html>