<%-- 
    Document   : My Work 
    Created on : Oct 28, 2018, 6:28:12 PM
    Author     : 58070158
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
        <!--<link href="assets/css/all.min.css" rel="stylesheet">-->
        <link href="https://fonts.googleapis.com/css?family=K2D" rel="stylesheet">
        <!--<link href="assets/css/propeller.min.css" rel="stylesheet">-->

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
        <link rel="stylesheet" href="assets/css/style.css">

        <title>Homepage</title>
    </head>

    <body>
        <!-- Navigation -->
        <nav id="mainNav" class="navbar navbar-default navbar-custom ">
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
                    <ul class="nav navbar-nav navbar-right force-flex-middle">
                        <li class="nav-item">
                            <a class="nav-link" id="nav-item-edit" href="home">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="nav-item-edit" href="mywork">My Work</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="nav-item-edit" href="mywork" >Doing Work</a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" id="nav-item-edit" href="editprofile">Edit Profile</a>
                        </li>
                        <!-- Sign OUT -->
                        <li class="nav-item" >
                            <form action="signout" method="POST" class="form-inline my-2 my-lg-0 ml-5">
                                <button class="btn btn-danger my-2 my-sm-0" type="submit">Sign Out</button>
                            </form>
                        </li>
                    </ul>
                </div>
        </nav>

        <div id="main" class="container">
            <div>

                <!-- Nav tabs -->
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active">
                        <a href="#request" aria-controls="home" role="tab" data-toggle="tab">
                            Request work
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="#doing" aria-controls="profile" role="tab" data-toggle="tab">
                            Doing work
                        </a>
                    </li>
                </ul>

                <!-- Tab panes -->
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="request">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="row">
                                    <c:forEach var="work" items="${rwork}">
                                        <div class="col-xs-12 work-item">
                                            <div class="col-xs-2 col-sm-1"><img class="profile-img" src="${work.ownerImage}" /></div>
                                            <div class="col-xs-10 col-sm-11">
                                                <div class="col-xs-12 col-sm-3"><a href="#">${work.title}</a></div>
                                                <div class="col-xs-12 col-sm-7">${work.desc}</div>
                                                <div class="col-xs-12 col-sm-2 text-right">${work.created}</div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="doing">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="row">
                                    <c:forEach var="work" items="${twork}">
                                        <div class="col-xs-12 work-item">
                                            <div class="col-xs-2 col-sm-1"><img class="profile-img" src="${work.ownerImage}" /></div>
                                            <div class="col-xs-10 col-sm-11">
                                                <div class="col-xs-12 col-sm-3"><a href="#">${work.title}</a></div>
                                                <div class="col-xs-12 col-sm-7">${work.desc}</div>
                                                <div class="col-xs-12 col-sm-2 text-right">${work.accepted}</div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="assets/js/jquery-3.3.1.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
        <script>
            $('#myTabs a').click(function (e) {
                e.preventDefault();
                $(this).tab('show');
            });
        </script>
    </body>
</html>
