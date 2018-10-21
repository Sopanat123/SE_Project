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
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
        <!--<link href="assets/css/all.min.css" rel="stylesheet">-->
        <link href="https://fonts.googleapis.com/css?family=K2D" rel="stylesheet">
        <script src="assets/js/jquery-3.3.1.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <title>Welcome Page</title>
    </head>
    <body>
        <div class="container-fluid" id="page">
            <div class="row">
                <div class="col-9" id="intro">
                    <div class="h-100 row align-items-center">
                        <div class="col">
                            <div class="col-4 offset-1 rounded-circle text-center lable" style="font-size: 3em;
                                 background-color: #4dc0b5;
                                 transform: rotate(-13deg);">Welcome</div>
                            <div class="col-8 offset-2 text-center welcome-text">ตลาด(นัด)นักแปล</div>
                            <div class="col-8 offset-2 text-center welcome-text">แหล่งรวมพลนักแปลรอรับงาน</div>
                            <div class="row">
                                <div class="col-2 offset-2">
                                    <i class="fas fa-users fa-5x fas-magin" style="margin-top: 1em;"></i>
                                </div>
                                <div class="col-2">
                                    <i class="fas fa-handshake fa-5x fas-magin" style="margin-top: 1em;"></i>
                                </div>
                                <div class="col-2">
                                    <i class="fas fa-file-alt fa-5x fas-magin" style="margin-top: 1em;"></i>
                                </div>
                                <div class="col-2">
                                    <i class="fas fa-lock fa-5x fas-magin" style="margin-top: 1em;"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-3" id="action">
                    <div class="h-100 row align-items-center">
                        <div class="col">
                            <button type="button" class="btn btn-primary btn-lg btn-block" data-toggle="modal" data-target="#myModal">Sign In</button>
                            <button type="button" class="btn btn-secondary btn-lg btn-block">Sign Up</button>
                        </div>
                    </div>
                </div>
                <!-- Modal -->
                <div class="modal fade" id="myModal" role="dialog">
                    <div class="modal-dialog">

                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title model-center welcome-text">Sign In</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <div class="modal-body">
                                <p>Some text in the modal.</p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
