<%-- 
    Document   : edit_profile
    Created on : Oct 28, 2018, 3:46:42 PM
    Author     : 58070158
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <c:set var="user" scope="session" value="${cruser}" />
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
        <link href="assets/css/Edit_Profile.css" rel="stylesheet">

    </head>

    <body id="page-top" class="index"> 

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
                            <a class="nav-link" id="nav-item-edit" href="homepage.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="nav-item-edit" href="mywork">My Work</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" id="nav-item-edit" href="mywork" disabled>Doing Work</a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" id="nav-item-edit" href="editprofile.jsp">Edit Profile</a>
                        </li
                        <!-- Sign OUT -->
                        <li class="nav-item" >
                            <form action="signout" method="POST" class="form-inline my-2 my-lg-0 ml-5">
                                <button class="btn btn-danger my-2 my-sm-0" type="submit">Sign Out</button>
                            </form>
                        </li>
                    </ul>
                </div>
        </nav>

        <form action="editprofile" method="POST" enctype="multipart/form-data" class="was-validated" id="edp">

            <div class="container pt-5">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="row text-center">
                            <!-- ${user.image}-->
                            <img src="assets/img/avatar.png" class="avatar img-profile-circle img-thumbnail mx-auto" alt="avatar">
                            <!--<img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-profile-circle img-thumbnail mx-auto" alt="avatar">-->
                        </div>
                        <div class="text-center" id="avatar">
                            <h6>Upload a different photo...</h6>
                            <div class="input-group mb-3">
                                <%-- IMG HEAD --%>          <div class="custom-file">
                                    <input type="file" name="image-profile" accept="image/*" class="custom-file-input" id="inputFile" onchange="myFunction()" form="edp"/>
                                    <label class="custom-file-label text-center" id="user-pic" for="inputFile">Choose file</label>
                                    <%-- IMG TAIL --%>          </div>
                            </div>
                            <!--<input type="file" class="text-center center-block file-upload">-->
                        </div><br>
                    </div>
                    <div class="col-md-9">
                        <div class="card no-border bg-transparent">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <h4>Your Profile</h4>
                                        <hr>
                                    </div>
                                    <%-- ERROR --%>                 <font color="red">${msg}</font>
                                </div>
                                <div class="row">
                                    <div class="col-md-12 scroll">
                                        <div class="form-group">
                                            <label for="displayname" class="col-4 col-form-label" id="fill-profile">Display Name</label> 
                                            <div class="col-12">
                                                <input id="displayname" name="displayname" placeholder="Please enter the correct display name." class="form-control here" type="text" pattern="[A-Za-z0-9]{8,25}" form="edp"/>                                        
                                                <br>
                                            </div>
                                        <div class="form-group">
                                            <label for="password" class="col-4 col-form-label" id="fill-profile">Password</label> 
                                            <div class="col-12">
                                                <input id="password" name="password" class="form-control here" placeholder="Please enter the correct password." type="password" pattern="[A-Za-z0-9]{8,25}" form="edp"/>
                                                <br>
                                        </div>
                                        <div class="form-group">
                                            <label for="email" class="col-4 col-form-label" id="fill-profile">Email</label> 
                                            <div class="col-12">
                                                <input id="email" name="email" class="form-control here" placeholder="Please choose a email." type="email" pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$" form="edp"/>
                                                <br>
                                        </div>
                                        <div class="form-group">
                                            <label for="phone" class="col-4 col-form-label" id="fill-profile">Phone</label> 
                                            <div class="col-12">
                                                <input id="phone" name="phone" class="form-control here"placeholder="Please choose a phone number." type="tel" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" form="edp"/>
                                                <br>
                                        </div>
                                        <div class="form-group">
                                            <label for="publicinfo" class="col-4 col-form-label" id="fill-profile">Public Info</label> 
                                            <div class="col-12">
                                                <textarea id="info" name="info" placeholder="explain youself" cols="40" rows="4" class="form-control" form="edp"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="tag" class="col-4 col-form-label" id="fill-profile">Tag</label> 
                                            <div class="col-12">
                                                <input id="tag" name="tag" class="form-control here" placeholder="Please enter the correct tag." type="text" pattern="[a-zA-Z][A-Za-z0-9]{2,9}" form="edp"/>
                                                <br>
                                        </div>
                                        <!--<div class="form-group row">
                                          <label for="newpass" class="col-4 col-form-label">New Password</label> 
                                          <div class="col-8">
                                            <input id="newpass" name="newpass" placeholder="New Password" class="form-control here" type="text">
                                          </div>
                                        </div>  -->
                                        <div class="form-group text-center">
                                            <div class="mx-auto">
                                                <button name="submit" type="submit" class="btn btn-primary" form="edp">Update My Profile</button>
                                                <button type="button" id="authentication" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                                                    Authentication
                                                </button>

                                                <!-- Modal -->
                                                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog" role="document">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h5 class="modal-title" id="exampleModalLabel">Authentication Title</h5>
                                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                    <span aria-hidden="true">&times;</span>
                                                                </button>
                                                            </div>
                                                            <div class="modal-body">
                                                                <div class="row">
                                                                    <div class="col-lg-12">
                                                                        <form action="authentication" method="POST">
                                                                            <div class="form-group">
                                                                                <label for="username" id="font-authen" class="col-form-label">ID Card:</label>
                                                                                <input type="file" name="image-id-card" accept="image/*" class="custom-file-input" id="inputFile2" onchange="myFunction()" form="edp"/>
                                                                                <br>
                                                                                <label for="password" id="font-authen" class="col-form-label">Selfie with ID Card:</label>
                                                                                <input type="file" name="image-selfie" accept="image/*" class="custom-file-input" id="inputFile3" onchange="myFunction()" form="edp"/>
                                                                                <br>
                                                                                <button type="submit" id="confirm"class="btn btn-primary btn-lg">Confirm</button>
                                                                            </div>
                                                                        </form>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </form>
                        </body>
                        <script>
                            function myFunction() {
                                var x = document.getElementById("inputFile");
                                txt = "";
                                file = x.files[0];
                                if ('files' in x) {
                                    if ('name' in file) {
                                        txt += file.name;
                                    }
                                }
                                document.getElementById("user-pic").innerHTML = txt;
                            }
                        </script>
                        </html>