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
                            Danh sách tài khoản Giảng viên.
                        </div>
	<table class="table table-striped">
			<thead>
				<tr>
					
					<th>Tên đăng nhập</th>
					<th>Mật khẩu</th>
					<th>Họ và tên</th>
					<th>Email</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
			
				 <c:forEach items= "${listOfTeacher}" var="list">	
					<tr>
						
						<td align="center">${list.userName}</td>
						<td>${list.passWord}</td>
						<td>${list.fullName}</td>
						<td>${list.email}</td> 	
						<td><button type="button" id="update-tea-${list.id}" data-toggle="modal" data-target="#myModal" class="btn btn-success"  onclick="showModal('${list.id}','${list.userName}','${list.passWord}','${list.fullName}','${list.email}')"><span class="fa fa-list-alt"></span> Sửa</button>
						<button type="button" id="delete-tea-${list.id}" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> Xóa</button></td>	
					</tr>
				</c:forEach> 
			</tbody>
		</table>
		<div class="row">
			<div class = "col-sm-4">
			<button class="btn btn-primary btn-add" type="button" data-toggle="modal" data-target="#myModal-add">Thêm giảng viên</button>
			</div>
			<div class = "col-sm-4">
			<div class="form-group input-file">
						<div class = "col-sm-4"><label>Chọn file</label></div>
						<input type="hidden" id="urlPath" name="urlPath">
						<div class = "col-sm-8 "><input type="file" id= "file-upload"></div>
						
            </div>
                                        
			</div>
			<div class="col-sm-4"><button type="button" class="btn btn-primary" id="btn-upload"  >Upload</button></div>
		</div>
		
		<!-- Modal update teacher -->
		
		<div id="myModal" class="modal fade" aria-hidden="true" tabindex="-1">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Modal Header</h4>
      </div>
      <div class="modal-body">
      <form name = 'form-update-student' method= "POST" id="form-update-student">
        <div class="form-group">
			
				<b>Mật khẩu </b> 	
				<input type="text" name="oldpass" id = "pass_modal" class = 'form-control' /><span id='oldpass_error'></span>
				
		</div>
		<div class="form-group">
				
				<b>Tên đầy đủ</b>
					<input type="text" name="newpass"  id = "fullName_modal" class = 'form-control'><span id = 'newpass_error'></span>
		</div>
		<div class="form-group">
				
				<b>Email</b>
					<input type="text" name="cf_newpass"  id = "email_modal" class = 'form-control'><span id = 'cf_newpass_error'></span>
		</div>
		<input type="hidden" id="fixId" name="fixId">
		</form>
      </div>
      <div class="modal-footer">
      	<button type="button" class="btn btn-primary" id="btn-fix-teacher"  >Sửa</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
      </div>
    </div>

  </div>
</div>

<div id="myModal-add" class="modal fade" aria-hidden="true" tabindex="-1">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Modal Header</h4>
      </div>
      <div class="modal-body">
      <form name = 'form-add-teacher' method= "POST" id="form-add-teacher">
        
        <div class="form-group">
			
				<b>Tên đăng nhập </b> 	
				<input type="text" name="oldpass" id = "insert_userName_modal" class = 'form-control' /><span id='oldpass_error'></span>
				
		</div>
        
        <div class="form-group">
			
				<b>Mật khẩu </b> 	
				<input type="text" name="oldpass" id = "insert_pass_modal" class = 'form-control' /><span id='oldpass_error'></span>
				
		</div>
		<div class="form-group">
				
				<b>Tên đầy đủ</b>
					<input type="text" name="newpass"  id = "insert_fullName_modal" class = 'form-control'><span id = 'newpass_error'></span>
		</div>
		<div class="form-group">
				
				<b>Email</b>
					<input type="text" name="cf_newpass"  id = "insert_email_modal" class = 'form-control'><span id = 'cf_newpass_error'></span>
		</div>
		
		
		</form>
      </div>
      <div class="modal-footer">
      	<button type="button" class="btn btn-primary" id="btn-insert-teacher">Thêm</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
      </div>
    </div>

  </div>
</div>


<script>
			function showModal(id,userName,passWord,fullName,email)
			{
			   //you can do anything with data, or pass more data to this function. i set this data to modal header for example
			   $("#myModal .modal-title").html('Chỉnh sửa thông tin của giảng viên: '+ userName);
			   $("#pass_modal").val(passWord);
			   $("#fullName_modal").val(fullName);
			   $("#email_modal").val(email);
			   
			   $("#fixId").val(id);
			    /* $("#myModal").modal(); */ 
			}
			
			//close modal
			function editModal(){
				 $(".modal").removeClass("in");
				  $(".modal-backdrop").remove();
				  $('body').removeClass('modal-open');
				  $('body').css('padding-right', ''); 
				$("#myModal").modal("hide");
				$("#myModal-add").modal("hide");
				console.log('doi xiu');
			}
			
			$(document).ready(function() {
				
				
				// update teacher 
				$("#btn-fix-teacher").click(function() {
						var passWord = $("#pass_modal").val();
					   	var fullName = $("#fullName_modal").val();
					   	var email = $("#email_modal").val();
					   	var className = $("#className_modal").val();
					   	var id = $("#fixId").val();
					   	editModal();
					   	console.log(id + passWord + fullName + email );
					   
					   $.ajax({		  
							type:'POST',
							url :'update-teacher',
			 				data: {
			 					"id":id,
			 					"passWord":passWord,
			 					"fullName":fullName,
			 					"email":email
			 					
			 					}, 
			 				
							success:function(response) {
								
								console.log("truoc responde");
								/* $(".panel-default").html(response); */
								$.ajax({
				type:'GET',
				url :'show-teacher',
				success:function(response) {
					$(".panel-default").html(response);
				}
			}); 
								console.log("sau responde");							
							}
						}); 	   
				}); 
				
				//insert teacher form
				$("#btn-insert-teacher").click(function() {
					var userName = $("#insert_userName_modal").val();
					var passWord = $("#insert_pass_modal").val();
				   	var fullName = $("#insert_fullName_modal").val();
				   	var email = $("#insert_email_modal").val();
				   	
				  
				   	editModal();
				   	console.log(userName + passWord + fullName + email );
				   	
				   $.ajax({		  
						type:'POST',
						url :'add-teacher',
		 				data: {
		 					"userName":userName,
		 					"passWord":passWord,
		 					"fullName":fullName,
		 					"email":email
		 					
		 					}, 
		 				
						success:function(response) {
							
							console.log("truoc responde");
							/* $(".panel-default").html(response); */
							$.ajax({
			type:'GET',
			url :'show-teacher',
			
			success:function(response) {
				$(".panel-default").html(response);
			}
		}); 
							console.log("sau responde");							
						}
					}); 	   
			}); 
				
				
				// get path of file input
				 $('#file-upload').change(function () {				
					var filename = $('input[type=file]').val().split('\\').pop();
					
		            console.log(filename);
		            
				}); 
				
			
				
			
				$('#btn-upload').click(function () {
					var fileName = $("#file-upload").val().split('\\').pop();
		            console.log(fileName);
		            $.ajax({
						type:'GET',
						url :'teacher-import',
		 				data:{"fileName":fileName},
						success:function(response) {
							alert("Thêm thành công!.Danh sách đã được cập nhật.");
							$(".panel-default").html(response);
						}
					});   
		            
				});
				
				//delete teacher
				$(".btn-danger").click(function() {
					var id = $(this).attr("id").slice(11);
					
					console.log("xoa giang vien co id la: " +id);
					 $.ajax({
							type:'GET',
							url :'delete-teacher',
			 				data:{"id":id},
							success:function(response) {
								alert("Xoa thanh cong!");
								$(".panel-default").html(response);
							}
						});   	
				});
});
			
			
			
			</script>
</body>
</html>