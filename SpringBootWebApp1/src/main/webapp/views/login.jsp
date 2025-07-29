<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="css/style.css"/>

<body class="body_bg">
   
   <h4>Login Here</h4>
   

   
   
    <c:if test="${not empty errorMsg}">
        <h4 style="color: red"> ${errorMsg}</h4>
   </c:if>
   
   
   <form action="loginForm" method="post">
   
   Email:<input type="text" name="email"/><br/><br/>
   Password:<input type="password" name="password"/><br/><br/>
  
    <input type="submit" value="Login" />
    
    <br><br>
    if not registered .... click here<a href="regPage"> <br><br>click me</a>
    
   </form>
</body>
</html>