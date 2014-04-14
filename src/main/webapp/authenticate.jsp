<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Authenticate user</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" charset="UTF-8">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
    <script type="text/javascript">
        function authenticateUserAjax() {
            var username = $('#username').val();
            var password = $('#password').val();
            var jsonobject = {
            	"username": username,
            	"password": password
        	};

            $.ajax({
            	type: "post",
           	    url: "/mgo/user/authenticate",
           	    contentType: "application/json",
           	    data: JSON.stringify(jsonobject),
           	    success: function(result) {
           	        alert('authentication successful');
           	        document.getElementById("username").value = "";
           	     	document.getElementById("password").value = "";
           	    },
           	    error: function(){
           	        alert('authentication failed');
           	    }
            });
        } 
</script>
</head>
<body>
    <div align="left">
        <label>Enter username and password</label>
        <input type="text" id="username"/>
        <input type="password" id="password"/>
        <input type="submit" value="Authenticate" onclick="authenticateUserAjax()" />
    </div>
</body>
</html>