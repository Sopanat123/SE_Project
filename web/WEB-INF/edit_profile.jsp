<%-- 
    Document   : edit_profile
    Created on : Oct 28, 2018, 3:46:42 PM
    Author     : 58070001
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <c:set var="user" scope="session" value="${cruser}" />
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/homepage.css" rel="stylesheet">
        <link href="assets/css/edit_profile.css" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
        <!--<link href="assets/css/all.min.css" rel="stylesheet">-->
        <link href="https://fonts.googleapis.com/css?family=K2D" rel="stylesheet">
        <script src="assets/js/jquery-3.3.1.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <title>Edit Profile</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Title</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                <%-- NAV HEAD --%> <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="mywork">My Work</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="mywork" disabled>Doing Work</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="editprofile">Edit Profile</a>
                    </li>
                    <!--                    <form class="form-inline my-2 my-lg-0">
                                            <input class="form-control mr-sm-2" type="search" placeholder="Search">
                                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                                        </form>-->
                    <%-- NAV TAIL --%> </ul>

                <%-- sign out HEAD --%> <form action="signout" method="POST" class="form-inline my-2 my-lg-0 ml-5">
                    <button class="btn btn-danger my-2 my-sm-0" type="submit">Sign Out</button>
                    <%-- sign out TAIL --%> </form>
            </div>
        </nav>

        <form action="editprofile" method="POST" enctype="multipart/form-data" class="was-validated" id="edp"></form>

        <div class="container pt-5">
            <div class="row">
                <div class="col-sm-3">
                    <div class="row text-center">
                        <img src="${user.image}" class="avatar img-profile-circle img-thumbnail mx-auto" alt="avatar">
                        <!--<img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-profile-circle img-thumbnail mx-auto" alt="avatar">-->
                    </div>
                    <div class="text-center">
                        <h6>Upload a different photo...</h6>
                        <div class="input-group mb-3">
<%-- IMG HEAD --%>          <div class="custom-file">
                                <input type="file" name="image" accept="image/*" class="custom-file-input" id="inputFile" onchange="myFunction()" form="edp"/>
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
                                        <label for="displayname" class="col-4 col-form-label">Display Name</label> 
                                        <div class="col-12">
                                            <input id="displayname" name="displayname" class="form-control here" type="text" pattern="[A-Za-z0-9]{8,25}" form="edp"/>
                                            <div class="invalid-feedback">Please enter the correct display name.</div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="password" class="col-4 col-form-label">Password</label> 
                                        <div class="col-12">
                                            <input id="password" name="password" class="form-control here" type="password" pattern="[A-Za-z0-9]{8,25}" form="edp"/>
                                            <div class="invalid-feedback">Please enter the correct password.</div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="email" class="col-4 col-form-label">Email</label> 
                                        <div class="col-12">
                                            <input id="email" name="email" class="form-control here" type="email" pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$" form="edp"/>
                                            <div class="invalid-feedback">Please choose a email.</div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="phone" class="col-4 col-form-label">Phone</label> 
                                        <div class="col-12">
                                            <input id="phone" name="phone" class="form-control here" type="tel" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" form="edp"/>
                                            <div class="invalid-feedback">Please choose a phone number.</div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="publicinfo" class="col-4 col-form-label">Public Info</label> 
                                        <div class="col-12">
                                            <textarea id="info" name="info" placeholder="example" cols="40" rows="4" class="form-control" form="edp"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="tag" class="col-4 col-form-label">Tag</label> 
                                        <div class="col-12">
                                            <input id="tag" name="tag" class="form-control here" type="text" pattern="[a-zA-Z][A-Za-z0-9]{2,9}" form="edp"/>
                                            <div class="invalid-feedback">Please enter the correct tag.</div>
                                        </div>
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
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

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
    </body>
</html>
