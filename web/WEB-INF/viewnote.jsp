<%-- 
    Document   : viewnote
    Created on : 2020-10-4, 8:27:30
    Author     : jingbo hou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
    
            <tr><td><h2>Title:</h2><p>${title}</p></tr>
            <tr><td><h2>Content:</h2><p>${content}</p></tr>
    
        <div>
            <a href="note?edit">Edit</a>
        </div>
    </body>
</html>
