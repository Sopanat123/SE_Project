<%-- 
    Document   : homepage
    Created on : Oct 28, 2018, 6:28:12 PM
    Author     : 58070158
--%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
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

    <title>Homepage</title>

</head>

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
                    <a class="nav-link disabled" id="nav-item-edit" href="mywork" disabled>Doing Work</a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link" id="nav-item-edit" href="editprofile">Edit Profile</a>
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

<body>
    <div id="main" class="container">
        <div class="panel panel-default">
            <div class="panel-heading">New Post</div>
            <div class="panel-body">
                <form>
                    <div class="form-group">
                        <label for="title">Title</label>
                        <input type="email" class="form-control" id="title">
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
        <div class="grid-item col-sm-3">
            <div class="grid-inner">
                <div class="media profile-info">
                    <div class="media-left">
                        <a href="#">
                            <img class="media-object profile-img" src="assets/img/img.jpg" alt="profile">
                        </a>
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">Name Surname</h4>
                        Posted: 12/05/2018 10:49
                    </div>
                </div>

                <a href="#" class="thumbnail">
                    <img src="assets/img/img.jpg" alt="post-image">
                </a>
                <button type="submit" class="btn btn-success">View</button>
            </div>
        </div>

        <div class="grid-item col-sm-3">
            <div class="grid-inner">
                <div class="media profile-info">
                    <div class="media-left">
                        <a href="#">
                            <img class="media-object profile-img" src="assets/img/img.jpg" alt="profile">
                        </a>
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">Name Surname</h4>
                        Posted: 12/05/2018 10:49
                    </div>
                </div>

                <a href="#" class="thumbnail">
                    <img src="assets/img/img.jpg" alt="post-image">
                </a>
                <button type="submit" class="btn btn-success">View</button>
            </div>
        </div>

        <div class="grid-item col-sm-3">
            <div class="grid-inner">
                <div class="media profile-info">
                    <div class="media-left">
                        <a href="#">
                            <img class="media-object profile-img" src="assets/img/img.jpg" alt="profile">
                        </a>
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">Name Surname</h4>
                        Posted: 12/05/2018 10:49
                    </div>
                </div>

                <a href="#" class="thumbnail">
                    <img src="assets/img/img.jpg" alt="post-image">
                </a>
                <button type="submit" class="btn btn-success">View</button>
            </div>
        </div>

        <div class="grid-item col-sm-3">
            <div class="grid-inner">
                <div class="media profile-info">
                    <div class="media-left">
                        <a href="#">
                            <img class="media-object profile-img" src="assets/img/img.jpg" alt="profile">
                        </a>
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">Name Surname</h4>
                        Posted: 12/05/2018 10:49
                    </div>
                </div>

                <a href="#" class="thumbnail">
                    <img src="assets/img/img.jpg" alt="post-image">
                </a>
                <button type="submit" class="btn btn-success">View</button>
            </div>
        </div>

        <div class="grid-item col-sm-3">
            <div class="grid-inner">
                <div class="media profile-info">
                    <div class="media-left">
                        <a href="#">
                            <img class="media-object profile-img" src="assets/img/img.jpg" alt="profile">
                        </a>
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">Name Surname</h4>
                        Posted: 12/05/2018 10:49
                    </div>
                </div>

                <a href="#" class="thumbnail">
                    <img src="assets/img/img.jpg" alt="post-image">
                </a>
                <button type="submit" class="btn btn-success">View</button>
            </div>
        </div>

        <div class="grid-item col-sm-3">
            <div class="grid-inner">
                <div class="media profile-info">
                    <div class="media-left">
                        <a href="#">
                            <img class="media-object profile-img" src="assets/img/img.jpg" alt="profile">
                        </a>
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">Name Surname</h4>
                        Posted: 12/05/2018 10:49
                    </div>
                </div>

                <a href="#" class="thumbnail">
                    <img src="assets/img/img.jpg" alt="post-image">
                </a>
                <button type="submit" class="btn btn-success">View</button>
            </div>
        </div>
    </div>
</div>
</body>

<script src="assets/js/jquery-3.3.1.min.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>

</html>
