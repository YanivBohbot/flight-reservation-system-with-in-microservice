<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html"; charset=UTF-8">
    <title> Register User </title>
</head>
<body>
<H2>Login</H2>
<form  action="login" method="post">
        <pre>
        User Name:<input type="text" name="email"/>
        Password:<input type="password" name="password"/>
        <input type="submit" value="login"/>
        </pre>
    {$msg}
</form>
</body>
</html>