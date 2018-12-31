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
                         <div class="row">
                           <div class="col-sm-6">
                            Danh sách lớp học phần.
                            </div>
                            <div class="col-sm-3">
                            <div class="form-group input-file">
						<div class = "col-sm-4"><label>Chọn file</label></div>
						<input type="hidden" id="urlPath" name="urlPath">
						<div class = "col-sm-8 "><input type="file" id= "file-upload"></div>
						</div>
            </div>			<div class="col-sm-3">
                            <button id="add-course" class="btn btn-primary btn-add" type="button">Thêm lớp học phần</button>
            </div>
                            </div>
                        </div>
	<table class="table table-striped">
			<thead>
				<tr>
					<th></th>
					<th>Mã lớp học phần</th>
					<th>Tên lớp học phần</th>
					<th>Tên giảng viên</th>
					<th>Số sinh viên</th>
					
				</tr>
			</thead>

			<tbody>
			
				 <c:forEach items= "${listCourse}" var="list">	
					<tr>
						<td><button id="show-course${list.courseId}" type="button"  data-toggle="modal" data-target="#myModal" class="btn btn-success" <%-- onclick="showModal('${list.courseName}','${teacherDao.getUserNameById(Integer.parseInt(list.teacherId))}')" --%>><span class="fa fa-eye"></span></button>
						<button id="delete-course${list.courseId}" type="button"  class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></button></td>	
						<td>${list.courseId}</td>
						<td>${list.courseName}</td>
						<td>${teacherDao.getUserNameById(Integer.parseInt(list.teacherId))}</td>
						<td>${studentCourseImport.getNumberStudent(list.courseId)}</td>	
						
					</tr>
				</c:forEach> 
			</tbody>
		</table>
		
		
		<!-- Modal show info course -->
		<%-- <div id="myModal" class="modal fade" aria-hidden="true" aria-labelledby="exampleModalLongTitle" tabindex="-1">
  <div class="modal-dialog modal-lg">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title" align="center">Kết quả phản hồi của người học</h4>
        <p align="center">Học kỳ II năm học 2018-2019</p>
        <p id="className">Tên học phần: </p>
        <p id="teacherName">Tên giảng viên: </p>
        <p >Số lượng sinh viên đánh giá: </p>
      </div>
      <div class="modal-body">
      <div id="table-result">
      	<table class="tg table table-bordered" style="undefined;table-layout: fixed">
<colgroup>

</colgroup>
  <!-- <tr>
    <th class="tg-wrlh" style="width: 6%">STT</th>
    <th class="tg-wrlh" style="width: 58%">Tiêu chí</th>
    <th class="tg-wrlh" style="width: 6%">M</th>
    <th class="tg-wrlh" style="width: 6%">STD</th>
    <th class="tg-wrlh" style="width: 6%">M1</th>
    <th class="tg-wrlh" style="width: 6%">STD1</th>
    <th class="tg-wrlh" style="width: 6%">M2</th>
    <th class="tg-wrlh" style="width: 6%">STD2</th>
  </tr> -->
  
  <table class="table table-striped" border="1">
		<thead>
			<tr>
				<th>STT</th>
				<th>Tiêu chí</th>
				<th>Điểm trung bình</th>
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
  
  
</table>
		<div id= "ghichu">
		<p>Ghi chú</p>
		<p>- M: Gía trị trung bình của các tiêu chí theo lớp học phần </p>
		<p>- STD: Gía trị trung bình của các tiêu chí theo lớp học phần </p>
		<p>- M1: Gía trị trung bình của các tiêu chí dựa trên phản hồi của sinh viên cho các giảng viên dạy cùng môn học với thầy cô</p>
		<p>- STD1: Độ lệch chuẩn của các tiêu chí dựa trên phản hồi của sinh viên cho các giảng viên dạy cùng môn học với thầy cô</p>
		<p>- M2: Gía trị trung bình của các tiêu chí dựa trên phản hồi của sinh viên về các môn học mà thầy cô đã giảng dạy</p>
		<p>- STD2: Độ lệch chuẩn của các tiêu chí dựa trên phản hồi của sinh viên về các môn học mà thầy cô đã giảng dạy</p>
		</div>

      </div>
      </div>
      <div class="modal-footer">
      	<button type="button" class="btn btn-primary" id="btn-insert-student">Thêm</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
      </div>
    </div>

  </div>
</div> --%>
		<script>
		
		function showModal(className,teacherName)
		{
		   //you can do anything with data, or pass more data to this function. i set this data to modal header for example
		   $("#className").html('Tên học phần: '+ className);
		   $("#teacherName").html('Tên giảng viên: ' + teacherName);

		}
		
		
		$(document).ready(function(){
	  $('#file-upload').change(function () {
	    
	    var filename = $('input[type=file]').val().split('\\').pop();
		
	    console.log(filename);
	  });
	  
	  
	  $('#add-course').click(function () {
			var fileName = $("#file-upload").val().split('\\').pop();
          console.log(fileName);
          $.ajax({
				type:'GET',
				url :'import-studentcourse',
				data:{"fileName":fileName},
				success:function(response) {
					alert("Thêm thành công!.Danh sách đã được cập nhật.");
					$(".panel-default").html(response);
				}
			});   
          
		});
	  
	  
	  $(".btn-danger").click(function() {
			var id = $(this).attr("id").slice(13);
			
			console.log("xoa phan tu co id la: " +id);
			  $.ajax({
					type:'GET',
					url :'delete-course',
	 				data:{"id":id
	 				
	 				},
					success:function(response) {
						alert("Xoa thanh cong!");
						$(".panel-default").html(response);
					}
				});    	
		});
	  
	  
	  $(".btn-success").click(function() {
			var id = $(this).attr("id").slice(11);
			
			console.log("xem thong tin danh gia khoa hoc co id la:  " +id);
			   $.ajax({
					type:'GET',
					url :'view-result-course',
	 				data:{"id":id
	 				
	 				},
					success:function(response) {
						
						$(".panel-default").html(response);
					}
				});     	
		});
	  
	});
</script>
</body>
</html>