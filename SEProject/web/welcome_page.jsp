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
                            <div class="col-2 offset-3 rounded-circle text-center label">
                                <div id="welcome_text">Welcome</div>
                            </div>
                            <div class="col-8 offset-2 text-center welcome-text" id="intro_text">ตลาด(นัด)นักแปล</div>
                            <div class="col-8 offset-2 text-center welcome-text">แหล่งรวมพลนักแปลรอรับงาน</div>
                            <div class="row mt-5">
                                <div class="col-2 offset-2">
                                    <i class="fas fa-users fa-5x"></i>
                                </div>
                                <div class="col-2">
                                    <i class="fas fa-handshake fa-5x"></i>
                                </div>
                                <div class="col-2">
                                    <i class="fas fa-file-alt fa-5x"></i>
                                </div>
                                <div class="col-2">
                                    <i class="fas fa-lock fa-5x"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-3" id="action">
                    <div class="h-100 row align-items-center">
                        <div class="col">
                            <button type="button" id="signin_btn" class="btn btn-lg btn-block" data-toggle="modal" data-target="#signIn">Sign In</button>
                            <button type="button" id="signup_btn" class="btn btn-lg btn-block" data-toggle="modal" data-target="#signUp">Sign Up</button>
                        </div>
                    </div>
                </div>
                <!-- Modal -->
                <div class="modal fade" id="signIn" role="dialog">
                    <div class="modal-dialog modal-lg">
                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title model-center welcome-text">Sign In</h4>
                                <button type="button" class="close fmargin" data-dismiss="modal">&times;</button>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-4">
                                        <form>
                                            <div class="form-group">
                                                <label for="username" class="col-form-label">Username:</label>
                                                <input type="text" class="form-control" id="in-username" placeholder="exemple" autocomplete="off" pattern="[A-Za-z0-9]+" size="25" minlength="8" maxlength="25" required>
                                            </div>
                                            <div class="form-group">
                                                <label for="password" class="col-form-label">Password:</label>
                                                <input type="password" class="form-control" id="in-password" placeholder="password" autocomplete="off" pattern="[A-Za-z0-9]+" size="25" minlength="8" maxlength="25" required>
                                            </div>
                                            <div class="float-right">
                                                <button type="button" class="btn btn-primary btn-lg">Sign In</button>
                                            </div>
                                            <div class="text-right btn-signup">
                                                <p class="pull-right"><a href="#" class="text-primary" data-dismiss="modal" data-toggle="modal" data-target="#signUp" onmousedown="goSignUp()">Sign Up?</a></p>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="col-8">
                                        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                                            <ol class="carousel-indicators">
                                                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                                                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                                                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                                            </ol>
                                            <div class="carousel-inner">
                                                <div class="carousel-item active">
                                                    <img class="d-block w-100" src="assets/promotion.jpg" alt="First slide">
                                                </div>
                                                <div class="carousel-item">
                                                    <img class="d-block w-100" src="assets/promotion.jpg" alt="Second slide">
                                                </div>
                                                <div class="carousel-item">
                                                    <img class="d-block w-100" src="assets/promotion.jpg" alt="Third slide">
                                                </div>
                                            </div>
                                            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                                <span class="sr-only">Previous</span>
                                            </a>
                                            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                                <span class="sr-only">Next</span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Modal -->
                <div class="modal fade" id="signUp" role="dialog">
                    <div class="modal-dialog modal-lg">

                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title model-center welcome-text">Sign Up</h4>
                                <button type="button" class="close fmargin" data-dismiss="modal">&times;</button>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col">
                                        <form>
                                            <div class="form-group">
                                                <label for="fullname" class="col-form-label">Fullname:</label>
                                                <div class="row pl-3 pr-3">
                                                    <input type="text" class="col-11 form-control" id="out-fullname" placeholder="exemple" autocomplete="off" pattern="[A-Za-z0-9]+" minlength="1" required/>
                                                    <span class="col-1 text-center validity"></span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="lastname" class="col-form-label">Lastname:</label>
                                                <div class="row pl-3 pr-3">
                                                    <input type="text" class="col-11 form-control" id="out-lastname" placeholder="exemple" autocomplete="off" pattern="[A-Za-z0-9]+" minlength="1" required/>
                                                    <span class="col-1 text-center validity"></span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="username" class="col-form-label">Username:</label>
                                                <div class="row pl-3 pr-3">
                                                    <input type="text" class="col-11 form-control" id="out-username" placeholder="username" autocomplete="off" pattern="[A-Za-z0-9]+" size="25" minlength="8" maxlength="25" required/>
                                                    <span class="col-1 text-center validity"></span>
                                                    <small id="usernameHelpBlock" class="form-text text-muted">
                                                        Your username must be 8-25 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.
                                                    </small>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="password" class="col-form-label">Password:</label>
                                                <div class="row pl-3 pr-3">
                                                    <button class="col-1 btn btn-default" type="button" onmousedown="mouseDown()" onmouseup="mouseUp()">
                                                        <i class="far fa-eye"></i>
                                                    </button>
                                                    <input type="password" class="col-10 form-control" id="out-password" placeholder="password" autocomplete="off" pattern="[A-Za-z0-9]+" size="25" minlength="8" maxlength="25" required/>
                                                    <span class="col-1 text-center validity"></span>
                                                    <small id="passwordHelpBlock" class="form-text text-muted">
                                                        Your password must be 8-25 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.
                                                    </small>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="phonenumber" class="col-form-label">Phone:</label>
                                                <div class="row pl-3 pr-3">
                                                    <input type="tel" class="col-11 form-control" id="out-phone" placeholder="099-999-9999" autocomplete="off" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" size="12" minlength="12" maxlength="12" required/>
                                                    <span class="col-1 text-center validity"></span>
                                                    <small id="phoneHelpBlock" class="form-text text-muted">
                                                        Your password must be 8-25 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.
                                                    </small>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="email" class="col-form-label">Email:</label>
                                                <div class="row pl-3 pr-3">
                                                    <input type="email" class="col-11 form-control" id="out-email" placeholder="exemple@mail.com" autocomplete="off" pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$" required/>
                                                    <span class="col-1 text-center validity"></span>
                                                </div>
                                            </div>
                                            <button type="button" class="float-right btn btn-primary btn-lg">Sign Up</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

<script>
    function mouseDown() {
        document.getElementById("out-password").type = "text";
    }
    function mouseUp() {
        document.getElementById("out-password").type = "password";
    }
    function goSignUp() {
        document.getElementById("signUp").style.overflow = "auto";
    }
//    $('div, #intro').load(
//            function ()
//            {
//                $(this).addClass('.introafter');
//            }
//    );
//    $(function () {
//        var x = 0;
//        setInterval(function () {
//            x -= 1;
//            $('.introafter').css('background-position', x + 'px 0');
//        }, 10);
//    })
</script>
