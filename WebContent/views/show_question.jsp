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
                            Danh sách câu hỏi khảo sát.
                        </div>
	<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nội dung</th>
					<th>Loại khảo sát</th>
					
				</tr>
			</thead>

			<tbody>
			
				 <c:forEach items= "${listOfQuestion}" var="list">	
					<tr>
						<td>${list.questionId}</td>
						<td>${list.content}</td>
						<td>${list.type}</td>
						
						<td><button type="button" id="update-que-${list.questionId}" data-toggle="modal" data-target="#myModal" class="btn btn-success" onclick="showModal('${list.questionId}','${list.content}')" ><span class="fa fa-list-alt"></span> Sửa</button>
						</td>	
					</tr>
				</c:forEach> 
			</tbody>
		</table>
		
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
			
				<b>Nội dung </b> 	
				<input type="text" name="content" id = "content_modal" class = 'form-control' /><span id='oldpass_error'></span>
				
		</div>
		<input type="hidden" id="fixId" name="fixId">
		</form>
      </div>
      <div class="modal-footer">
      	<button type="button" class="btn btn-primary" id="btn-fix-question"  >Sửa</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
      </div>
    </div>

  </div>
</div>
		<script>
		
		function showModal(id,content)
			{
			   //you can do anything with data, or pass more data to this function. i set this data to modal header for example
			   $("#myModal .modal-title").html('Chỉnh sửa thông tin câu hỏi khảo sát số: '+ id);
			   
			   $("#content_modal").val(content);
			   
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
			
			
			// update question  
			$("#btn-fix-question").click(function() {
					
				   	var content = $("#content_modal").val();
				   	var id = $("#fixId").val();
				   	editModal();
				   	console.log(id + content);
				   
				   $.ajax({		  
						type:'POST',
						url :'update-question',
		 				data: {
		 					"id":id,
		 					"content":content
		 					
		 					
		 					}, 
		 				
						success:function(response) {
							
							console.log("truoc responde");
							
							$.ajax({
			type:'GET',
			url :'show-question',
			success:function(response) {
				$(".panel-default").html(response);
			}
		}); 
							console.log("sau responde");							
						}
					}); 	   
			}); 
		});  
		
		</script> 
		</body>
		