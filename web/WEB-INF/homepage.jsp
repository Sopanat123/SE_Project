<%-- 
    Document   : homepage
    Created on : Oct 28, 2018, 6:28:12 PM
    Author     : 58070158
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Homepage</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

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
    </head>

    <body>
        <!-- Navigation -->
        <nav id="mainNav" class="navbar navbar-default navbar-custom">
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
                            <a class="nav-link" id="nav-item-edit" href="mywork">My Tasks</a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" id="nav-item-edit" href="editprofile">Edit Profile</a>
                        </li>
                        <!-- Sign OUT -->
                        <li class="nav-item">
                            <a class="nav-link btn btn-danger" id="nav-item-edit" role="button" href="signout">Sign Out</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


        <div id="main" class="container">
            <div class="panel panel-default">
                <div class="panel-heading">New Post</div>
                <div class="panel-body">
                    <form action="addnewwork" method="POST">
                        <div class="form-group">
                            <label for="title">Title</label>
                            <input type="text" name="title" class="form-control" id="title">
                        </div>
                        <div class="form-group">
                            <label for="desc">Description</label>
                            <textarea name="desc" class="form-control" rows="4"></textarea>
                        </div>
                        <button type="submit" class="btn btn-default">Post</button>
                    </form>
                </div>
            </div>
        </div>

        <div id="grid-container" class="container row">
            <c:forEach var="work" items="${works}">
                <div class="grid-item col-sm-3">
                    <div class="grid-inner">
                        <div class="media profile-info">
                            <div class="media-left">
                                <a href="#">
                                    <c:choose>
                                        <c:when test="${empty work.imgUrl}">
                                            <img class="media-object profile-img" src="assets/img/img.jpg" alt="profile">
                                        </c:when>
                                        <c:otherwise>
                                            <img class="media-object profile-img" src="${work.imgUrl}" alt="profile">
                                        </c:otherwise>
                                    </c:choose>
                                </a>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">${work.owner}</h4>
                                Posted: ${work.created}
                            </div>
                        </div>

                        <a href="#" class="thumbnail">
                            <c:choose>
                                <c:when test="${empty work.imgUrl}">
                                    <img class="media-object profile-img" src="assets/img/img.jpg" alt="post-image">
                                </c:when>
                                <c:otherwise>
                                    <img class="media-object profile-img" src="${work.imgUrl}" alt="post-image">
                                </c:otherwise>
                            </c:choose>
                        </a>
                        <!-- Button trigger modal -->
                        <button type="submit" class="btn btn-success" data-toggle="modal" data-target="#exampleModal">View</button>
                    </div>
                </div>
            </c:forEach>
        </div>
        <!-- modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Detail Content</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
<form>
          <div class="form-group">
            <label  class="col-form-label">Recipient:</label>
            <input type="text" class="form-control" id="Title" placeholder="หัวข้อ">
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">From language:</label>
            <textarea class="form-control" id="message-text" placeholder="ภาษาต้นฉับบ"></textarea>
          </div>
    <div class="form-group">
            <label for="message-text" class="col-form-label">To language:</label>
            <textarea class="form-control" id="message-text" placeholder="ภาษาที่ต้องการให้แปล"></textarea>
          </div>
    <div class="form-group">
            <label for="message-text" class="col-form-label">Description:</label>
            <textarea class="form-control" id="message-text" placeholder="รายละเอียดเพิ่มเติม เช่น ขอแบบผ่านการเกลาคำไม่จำเป็นต้องแปลตรงตัว"></textarea>
          </div>
    <div class="form-group">
            <label for="message-text" class="col-form-label">Tag:</label>
            <textarea class="form-control" id="message-text"></textarea>
          </div>
    <div class="form-group">
            <label for="message-text" class="col-form-label">Deadline:</label>
            <textarea class="form-control" id="message-text" placeholder="ส่งภายในวันที่"></textarea>
          </div>
    <div class="form-group">
            <label for="message-text" class="col-form-label">Price:</label>
            <textarea class="form-control" id="message-text" placeholder="ราคา"></textarea>
          </div>
    
        </form>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" id="accept" class="btn btn-primary">Accept</button>
                    </div>
                </div>
            </div>
        </div>

        <script src="assets/js/jquery-3.3.1.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
