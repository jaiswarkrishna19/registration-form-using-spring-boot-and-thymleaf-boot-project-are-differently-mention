<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="css/style.css"/>

<body class="body_bg">
   
   <h4>Register Form</h4>
   
   <c:if test="${not empty successMsg}">
        <h4 style="color: green"> ${successMsg}</h4>
   </c:if>
   
   
    <c:if test="${not empty errorMsg}">
        <h4 style="color: red"> ${errorMsg}</h4>
   </c:if>
   
   
   <form action="regForm" method="post">
   Name:<input type="text" name="name"/><br/><br/>
   Email:<input type="text" name="email"/><br/><br/>
   Password:<input type="password" name="password"/><br/><br/>
   Phone no:<input type="text" name="phoneno"/><br/><br/>
    <input type="submit" value="register" />
    
    <br><br>
    if already registered .... click here<a href="loginPage"> <br><br>click me</a>
    
   </form>
</body>
</html>