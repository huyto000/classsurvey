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
				<div class="col-sm-12">
	<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Mã Sinh Viên</th>
					<th>Mật khẩu</th>
					<th>Họ và tên</th>
					<th>Email</th>
					<th>Lớp</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
			
				 <c:forEach items= "${listOfStudent}" var="list">	
					<tr>
						<td>${list.id}</td>
						<td>${list.userName}</td>
						<td>${list.passWord}</td>
						<td>${list.fullName}</td>
						<td>${list.email}</td> 	
						<td>${list.className}</td>
						<td><button type="button" id="update-stu-${list.id}" data-toggle="modal" data-target="#myModal" class="btn btn-success"  onclick="showModal('${list.id}','${list.userName}','${list.passWord}','${list.fullName}','${list.email}','${list.className}')"><span class="fa fa-list-alt"></span> Sửa</button>
						<button type="button" id="delete-stu-${list.id}" class="btn btn-danger"><span class="glyphicon glyphicon-trash delete-stu"></span> Xóa</button></td>
					</tr>
				</c:forEach> 
			</tbody>
		</table>
		</div>
		
			<script>
			$(".btn-danger").click(function() {
				var id = $(this).attr("id").slice(11);
				
				console.log("xoa phan tu co id la: " +id);
				 $.ajax({
						type:'GET',
						url :'delete-student',
		 				data:{"id":id
		 				
		 				},
						success:function(response) {
							$(".panel-default").html(response);
						}
					});   	
			});
			</script>
</body>
</html>