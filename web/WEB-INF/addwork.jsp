<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Work</title>
    </head>
    <body>
        <form action="addwork" method="POST" enctype="multipart/form-data">
            <input type="text" name="title" pattern="[AZ][0-9A-Za-z]{1,}" placeholder="Title" required /> <br>
            <textarea name="desc" rows="4" cols="20" placeholder="Enter a description here"></textarea> <br>
            <input type="text" name="worktag" pattern="[a-z]+" placeholder="use comma (,) to seperate between tags" /> <br>
            <input type="text" name="deadline" pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}" placeholder="31-11-2561 (optional)" /> <br>
            <input type="text" name="price" pattern="[0-9]{1,}" /> <br>
            <input type="checkbox" name="hidden" value="hidden" /> <br>
            <input type="file" name="image" accept="image/*" /> <br>
            <input type="file" name="file" required /> <br>
            <input type="submit" value="Create" /> <br>
        </form>
    </body>
</html>
