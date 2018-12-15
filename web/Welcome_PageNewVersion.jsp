<%-- 
    Document   : Welcome_PageNewVersion
    Created on : Dec 11, 2018, 7:34:54 PM
    Author     : 58070158
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE htm l>
<html>
    <head>

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title id="welcome">Translator Marketplace</title>
        
        <!-- Bootstrap Core CSS -->
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        
        <script src="assets/js/jquery-3.3.1.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
        
        <!-- Custom Fonts -->
        <link href="assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

        <!-- Theme CSS -->
        <link href="assets/css/agency.css" rel="stylesheet">
        <link href="assets/css/NewCss.css" rel="stylesheet">

    </head>
    
    <body id="page-top" class="index">

    <!-- Navigation -->
    <nav id="mainNav" class="navbar navbar-default navbar-custom navbar-fixed-top">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">Translator Marketplace</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#services">ABOUT</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#team">Team</a>
                    </li>
                    <li>
                        <a type="button" id="sign-in" data-toggle="modal" data-target="#signIN">Log IN</a>
                    </li>
                </ul>
            </div>
             
        <!-- /.container-fluid -->
    </nav>

    <!-- Header -->
    <header>
        <div class="container">
            <div class="intro-text">
                <div class="intro-lead-in">Welcome To The Translator Marketplace</div>
                <div class="intro-heading">It's Nice To Meet You</div>
                <button type="button" class="page-scroll btn btn-xl" data-toggle="modal" data-target="#signUp" id="sign-up">Registration</button>
            </div>
        </div>
    </header>
        
     <!-- About Section -->
    <section id="services">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">About US</h2>
                </div>
            </div>
            <div class="row text-center">
                <div class="col-md-4">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-stack-2x text-primary">
                            <img src="assets/img/bath.png" style=" width: 75px; height: 75px;">
                        </i>
                        <i class="fa fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading">Extra Income</h4>
                    <p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minima maxime quam architecto quo inventore harum ex magni, dicta impedit.</p>
                </div>
                <div class="col-md-4">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-stack-2x text-primary">
                            <img src="assets/img/tran.png" style=" width: 75px; height: 75px;">
                        </i>
                            
                        <i class="fa fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading">Translate Content</h4>
                    <p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minima maxime quam architecto quo inventore harum ex magni, dicta impedit.</p>
                </div>
                <div class="col-md-4">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-stack-2x text-primary">
                            <img src="assets/img/commu1.png" style=" width: 75px; height: 75px;">
                        </i>
                        <i class="fa fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading">Comunication</h4>
                    <p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minima maxime quam architecto quo inventore harum ex magni, dicta impedit.</p>
                </div>
            </div>
        </div>
    </section>
 
    <!-- Team Section -->
    <section id="team" class="bg-light-gray">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Our Amazing Team</h2>
                    <h3 class="section-subheading text-muted">Lorem ipsum dolor sit amet consectetur.</h3>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <div class="team-member">
                        <img src="assets/img/team/1.jpg" class="img-responsive img-circle" alt="">
                        <h4>Kay Garland</h4>
                        <p class="text-muted">Lead Designer</p>
                        <ul class="list-inline social-buttons">
                            <li><a href="#"><i class="fa fa-twitter" id="tweet"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-facebook" id="tweet"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-linkedin" id="tweet"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="team-member">
                        <img src="assets/img/team/2.jpg" class="img-responsive img-circle" alt="">
                        <h4>Larry Parker</h4>
                        <p class="text-muted">Lead Marketer</p>
                        <ul class="list-inline social-buttons">
                            <li><a href="#"><i class="fa fa-twitter" id="tweet"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-facebook" id="tweet"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-linkedin" id="tweet"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="team-member">
                        <img src="assets/img/team/3.jpg" class="img-responsive img-circle" alt="">
                        <h4>Diana Pertersen</h4>
                        <p class="text-muted">Lead Developer</p>
                        <ul class="list-inline social-buttons">
                            <li><a href="#"><i class="fa fa-twitter" id="tweet"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-facebook" id="tweet"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-linkedin" id="tweet"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
                 <div class="col-sm-4">
                    <div class="team-member">
                        <img src="assets/img/team/3.jpg" class="img-responsive img-circle" alt="">
                        <h4>Diana Pertersen</h4>
                        <p class="text-muted">Lead Developer</p>
                        <ul class="list-inline social-buttons">
                            <li><a href="#"><i class="fa fa-twitter" id="tweet"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-facebook" id="tweet"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-linkedin" id="tweet"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
                 <div class="col-sm-4">
                    <div class="team-member">
                        <img src="assets/img/team/3.jpg" class="img-responsive img-circle" alt="">
                        <h4>Diana Pertersen</h4>
                        <p class="text-muted">Lead Developer</p>
                        <ul class="list-inline social-buttons">
                            <li><a href="#"><i class="fa fa-twitter" id="tweet"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-facebook" id="tweet"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-linkedin" id="tweet"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
                 <div class="col-sm-4">
                    <div class="team-member">
                        <img src="assets/img/team/3.jpg" class="img-responsive img-circle" alt="">
                        <h4>Diana Pertersen</h4>
                        <p class="text-muted">Lead Developer</p>
                        <ul class="list-inline social-buttons">
                            <li><a href="#"><i class="fa fa-twitter" id="tweet"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-facebook" id="tweet"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-linkedin" id="tweet"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <p class="large text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aut eaque, laboriosam veritatis, quos non quis ad perspiciatis, totam corporis ea, alias ut unde.</p>
                </div>
            </div>
        </div>
    </section>
     <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <span class="copyright">Copyright &copy; Your Website 2018</span>
                </div>
    
    <!-- Model: SignUP -->
    <div class="modal fade" id="signUp" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Registration</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
        </div>   
        <div id="modal-body" class="modal-body">
           <!-- 'sign up' HEAD -->       
                            <div class="row">
                                    <div class="col-lg-12">
                                        <form action="signup" method="POST">
                                            <div class="form-group col-lg-12">
                                                <div class="row">
                                                    <label for="firstname" class="col-form-label">First name:</label>
                                                </div>
                                                <div class="row ">
                                                    <input type="text" name="firstname" class="col-7 form-control" id="out-fullname" placeholder="firstname" autocomplete="off" pattern="[A-Za-z0-9]{1,}" required/>
                                                    <span class="col-1 text-center validity"></span>
                                                </div>
                                            </div>
                                            <div class="form-group col-lg-12">
                                                <div class="row">
                                                    <label for="lastname" class="col-form-label">Last name:</label>
                                                </div>
                                                <div class="row pl-3 pr-3">
                                                    <input type="text" name="lastname" class="col-11 form-control" id="out-lastname" placeholder="lastname" autocomplete="off" pattern="[A-Za-z0-9]{1,}" required/>
                                                    <span class="col-1 text-center validity"></span>
                                                </div>
                                            </div>
                                            <div class="form-group col-lg-12">
                                                <div class="row">
                                                    <label for="username" class="col-form-label">Username:</label>
                                                </div>
                                                <div class="row pl-3 pr-3">
                                                    <input type="text" name="username" class="col-11 form-control" id="out-username" placeholder="username" autocomplete="off" pattern="[A-Za-z0-9]{8,25}" required/>
                                                    <span class="col-1 text-center validity"></span>
                                                    <small id="usernameHelpBlock" class="form-text text-muted">
                                                        Your username must be 8-25 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.
                                                    </small>
                                                </div>
                                            </div>
                                            <div class="form-group col-lg-12">
                                                <div class="row">
                                                    <label for="password" class="col-form-label">Password:</label>
                                                </div>
                                                <div class="row pl-3 pr-3">
                                                    <button class="col-1 btn btn-default" type="button" onmousedown="mouseDown()" onmouseup="mouseUp()">
                                                    </button>
                                                    <input type="password" name="password" class="col-10 form-control" id="out-password" placeholder="password" autocomplete="off" pattern="[A-Za-z0-9]{8,25}" required/>
                                                    <span class="col-1 text-center validity"></span>
                                                    <small id="passwordHelpBlock" class="form-text text-muted">
                                                        Your password must be 8-25 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.
                                                    </small>
                                                </div>
                                            </div>
                                            <div class="form-group col-lg-12">
                                                <div class="row">
                                                    <label for="email" class="col-form-label">Email:</label>
                                                </div>
                                                <div class="row pl-3 pr-3">
                                                    <input type="email" name="email" class="col-11 form-control" id="out-email" placeholder="example@mail.com" autocomplete="off" pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$" required/>
                                                    <span class="col-1 text-center validity"></span>
                                                </div>
                                            </div>
                                            <div class="form-group col-lg-12">
                                                <div class="row">
                                                    <label for="phonenumber" class="col-form-label">Phone:</label>
                                                </div>
                                                <div class="row pl-3 pr-3">
                                                    <input type="tel" name="phone" class="col-11 form-control" id="out-phone" placeholder="099-999-9999" autocomplete="off" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" required/>
                                                    <span class="col-1 text-center validity"></span>
                                                    <small id="phoneHelpBlock" class="form-text text-muted">
                                                        Your password must be 8-25 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.
                                                    </small>
                                                </div>
                                            </div>
                                          </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <!-- Model: Log in -->
    <div class="modal fade" id="signIN" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Log IN</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
        </div>
         <div class="modal-body">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <form action="signin" method="POST">
                                            <div>
                                                <font color="red">${msg}</font>
                                                <c:remove var="msg" scope="request"/>
                                            </div>
                                            <div class="form-group">
                                                <label for="username" class="col-form-label">Username:</label>
                                                <input type="text" name="username" class="form-control" id="in-username" placeholder="username" autocomplete="off" pattern="[A-Za-z0-9]{8,25}" required>
                                                
                                                <br>
                                                <label for="password" class="col-form-label">Password:</label>
                                                <input type="password" name="password" class="form-control" id="in-password" placeholder="password" autocomplete="off" pattern="[A-Za-z0-9]{8,25}" required>
                                                <br>
                                                <button type="submit" class="btn btn-primary btn-lg">Sign In</button>
                                            </div>
                                              
            <!-- /.navbar-collapse -->
        </div>
      </div>
    </div>
  
    <!-- jQuery -->
    <script src="assets/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="assets/js/jqBootstrapValidation.js"></script>
    <script src="assets/js/contact_me.js"></script>

    <!-- Theme JavaScript -->
    <script src="assets/js/agency.min.js"></script>

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
