<%-- 
    Document   : editnote
    Created on : 2020-10-4, 8:27:57
    Author     : jingbo hou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="post" action="note">
            Title: <input type="text" name="title" value="${title}"><br>
            Content: <input type="text" name="content" value="${content}"><br>

            <input type="submit" value="save">
        </form>
    </body>
</html>
