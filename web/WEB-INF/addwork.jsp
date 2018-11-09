<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Work</title>
    </head>
    <body>
        <div>
            <font color="red">${msg}</font>
            <c:remove var="msg" scope="request"/>
        </div>
        <form action="addwork" method="POST" enctype="multipart/form-data">
            Title : <input type="text" name="title" pattern="[A-Z][ _()0-9A-Za-z]{1,24}[0-9A-Za-z]" placeholder="Title" required /> <br>
            From language : <input type="text" name="orilang" pattern="[a-zA-Z]{2,20}" required /> <br>
            To language : <input type="text" name="destlang" pattern="[a-zA-Z]{2,20}" required /> <br>
            Description <textarea name="desc" rows="4" cols="20" placeholder="Enter a description here"></textarea> <br>
            Tag : <input type="text" name="worktag" pattern="[a-z,]+" placeholder="Lower case, use comma (,) to seperate between tags" /> <br>
            Deadline : <input type="text" name="deadline" pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}" placeholder="30-11-2561 (optional)" /> <br>
            Price : <input type="text" name="price" pattern="[0-9.]{1,}" /> <br>
            Only sample : <input type="checkbox" name="onlysample" value="true" checked="checked" /> <br>
            Hidden : <input type="checkbox" name="hidden" value="true" /> <br>
            Image : <input type="file" name="image" accept="image/*" /> <br>
            Sample : <input type="file" name="sample" /> <br>
            File : <input type="file" name="file" required /> <br>
            <input type="submit" value="Create" /> <br>
        </form>
    </body>
</html>
