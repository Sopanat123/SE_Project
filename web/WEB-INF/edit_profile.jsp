<%-- 
    Document   : edit_profile
    Created on : Oct 28, 2018, 3:46:42 PM
    Author     : 58070001
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/edit_profile.css" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
        <!--<link href="assets/css/all.min.css" rel="stylesheet">-->
        <link href="https://fonts.googleapis.com/css?family=K2D" rel="stylesheet">
        <script src="assets/js/jquery-3.3.1.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <title>Edit Profile</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <div class="row text-center">
                        <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-profile-circle img-thumbnail mx-auto" alt="avatar">
                    </div>
                    <div class="text-center">
                        <h6>Upload a different photo...</h6>
                        <div class="input-group mb-3">
                            <div class="custom-file">
                                <input type="file" class="custom-file-input" id="inputFile" onchange="myFunction()">
                                <label class="custom-file-label text-center" id="user-pic" for="inputFile">Choose file</label>
                            </div>

                        </div>
                        <!--<input type="file" class="text-center center-block file-upload">-->
                    </div><br>
                </div>
                <!--                <div class="col-md-3 ">
                                    <div class="list-group ">
                                        <a href="#" class="list-group-item list-group-item-action active">Dashboard</a>
                                        <a href="#" class="list-group-item list-group-item-action">User Management</a>
                                        <a href="#" class="list-group-item list-group-item-action">Used</a>
                                        <a href="#" class="list-group-item list-group-item-action">Enquiry</a>
                                        <a href="#" class="list-group-item list-group-item-action">Dealer</a>
                                        <a href="#" class="list-group-item list-group-item-action">Media</a>
                                        <a href="#" class="list-group-item list-group-item-action">Post</a>
                                        <a href="#" class="list-group-item list-group-item-action">Category</a>
                                        <a href="#" class="list-group-item list-group-item-action">New</a>
                                        <a href="#" class="list-group-item list-group-item-action">Comments</a>
                                        <a href="#" class="list-group-item list-group-item-action">Appearance</a>
                                        <a href="#" class="list-group-item list-group-item-action">Reports</a>
                                        <a href="#" class="list-group-item list-group-item-action">Settings</a>
                                    </div>
                                </div>-->
                <div class="col-md-9">
                    <div class="card no-border bg-transparent">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-12">
                                    <h4>Your Profile</h4>
                                    <hr>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12 scroll">
                                    <c:set var="user" scope="session" value="${user}" />
                                    <font color="red">${msg}</font>
<%-- 'editprofile' HEAD --%>        <form action="editprofile" method="POST" class="was-validated">
                                        <div class="form-group">
                                            <label for="displayname" class="col-4 col-form-label">Display Name</label> 
                                            <div class="col-12">
                                                <input id="displayname" name="displayname" value="${user.displayname}" class="form-control here" type="text" pattern="[A-Za-z0-9]{8,25}" readonly />
                                                <div class="invalid-feedback">Please enter the correct display name.</div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="username" class="col-4 col-form-label">User Name</label> 
                                            <div class="col-12">
                                                <input id="username" name="username" value="${user.username}" class="form-control here" type="text" pattern="[A-Za-z0-9]{8,25}" />
                                                <div class="invalid-feedback">Please enter the correct user name.</div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="password" class="col-4 col-form-label">Password</label> 
                                            <div class="col-12">
                                                <input id="password" name="password" class="form-control here" type="password" pattern="[A-Za-z0-9]{8,25}" />
                                                <div class="invalid-feedback">Please enter the correct password.</div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="firstname" class="col-4 col-form-label">First Name</label> 
                                            <div class="col-12">
                                                <input id="firstname" name="firstname" value="${user.firstname}" class="form-control here" type="text" pattern="[A-Za-z0-9]{1,}" readonly />
                                                <div class="invalid-feedback">Please choose a first name.</div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="lastname" class="col-4 col-form-label">Last Name</label> 
                                            <div class="col-12">
                                                <input id="lastname" name="lastname" value="${user.lastname}" class="form-control here" type="text" pattern="[A-Za-z0-9]{1,}" readonly />
                                                <div class="invalid-feedback">Please choose a last name.</div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="email" class="col-4 col-form-label">Email</label> 
                                            <div class="col-12">
                                                <input id="email" name="email" class="form-control here" type="email" value="${user.email}" autocomplete="off" pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$" />
                                                <div class="invalid-feedback">Please choose a email.</div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="phone" class="col-4 col-form-label">Phone</label> 
                                            <div class="col-12">
                                                <input id="phone" name="phone" class="form-control here" type="tel" value="${user.phone}" autocomplete="off" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" />
                                                <div class="invalid-feedback">Please choose a phone number.</div>
                                            </div>
                                        </div>
                                        <div class="form-group text-center">
                                            <div class="mx-auto">
                                                <button name="submit" type="submit" class="btn btn-primary">Update My Profile</button>
                                            </div>
                                        </div>
<%-- 'editprofile' TAIL --%>        </form>
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
