<%-- 
    Document   : welcome_page
    Created on : Oct 19, 2018, 3:57:07 PM
    Author     : 58070001
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/welcome_page.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=K2D" rel="stylesheet">
        <title>Welcome Page</title>
    </head>
    <body>
        <div class="container-fluid" id="page">
            <div class="row">
                <div class="col-9" id="intro">
                    <div class="h-100 row align-items-center">
                        <div class="col">
                            <div class="btn btn-primary btn-lg btn-block" disabled>Welcome</div>
                            <div class="col-8 offset-2 text-center welcome-text">ตลาด(นัด)นักแปล</div>
                            <div class="col-8 offset-2 text-center welcome-text">แหล่งรวมพลนักแปลรอรับงาน</div>
                        </div>
                    </div>
                </div>
                <div class="col-3" id="action">
                    <div class="h-100 row align-items-center">
                        <div class="col">
                            <button type="button" class="btn btn-primary btn-lg btn-block">Sign In</button>
                            <button type="button" class="btn btn-secondary btn-lg btn-block">Sign Up</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
