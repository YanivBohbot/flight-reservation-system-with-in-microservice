<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="utf-8" %>

<html>
  <head>
        <title> Register User </title>
  </head>
  <body>
  <H2>User Registration</H2>
    <form  action="registerUser" method="post">
        <pre>
        First Name:<input type="text" name="firstName"/>
        First Name:<input type="text" name="firstName"/>
        Email:<input type="text" name="email"/>
        Password:<input type="password" name="password"/>
        Confirm Password:<input type="password" name="confirmpassword"/>
        <input type="submit" value="register"/>
        </pre>
    </form>

  </body>
</html>