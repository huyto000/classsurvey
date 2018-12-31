<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
body{
  background: white;
}

form{
  position: absolute;
  top: 50%;
  left: 50%;
  margin-top: 100px;
  margin-left: -250px;
  width: 500px;
  height: 200px;
  border: 4px dashed black;
}
form p{
  width: 100%;
  height: 100%;
  text-align: center;
  line-height: 170px;
  color: black;
  font-family: Arial;
}


form input{
  position: absolute;
  margin: 0;
  padding: 0;
  width: 100%;
  height: 100%;
  outline: none;
  opacity: 0;
}


form button{
  margin: 0;
  color: #fff;
  background: #16a085;
  border: none;
  width: 508px;
  height: 35px;
  margin-top: -20px;
  margin-left: -4px;
  border-radius: 4px;
  border-bottom: 4px solid #117A60;
  transition: all .2s ease;
  outline: none;
}



form button:hover{
  background: #149174;
	color: #0C5645;
}
form button:active{
  border:0;
}



</style>
</head>
<body>
		<form action="" method="POST">
  
<input type="file" multiple>
  <p>Chọn file cần tải lên.</p>
  
<button type="submit">Tải lên</button>

</form>

<script>

$(document).ready(function(){
	  $('form input').change(function () {
	    $('form p').text(this.files.length + " file được chọn");
	    var filename = $('input[type=file]').val().split('\\').pop();
		
	    console.log(filename);
	  });
	});
	
	

	
	</script>

</body>

</html>

