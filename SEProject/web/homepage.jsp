<%-- 
    Document   : homepage
    Created on : Oct 28, 2018, 6:28:12 PM
    Author     : 58070001
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/homepage.css" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
        <!--<link href="assets/css/all.min.css" rel="stylesheet">-->
        <link href="https://fonts.googleapis.com/css?family=K2D" rel="stylesheet">
        <!--<link href="assets/css/propeller.min.css" rel="stylesheet">-->
        <script src="assets/js/jquery-3.3.1.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <title>Homepage</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Title</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item active ">
                        <a class="nav-link" href="homepage.jsp">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">My Work</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Doing Work</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="edit_profile.jsp">Edit Profile</a>
                    </li>
                    <!--                    <form class="form-inline my-2 my-lg-0">
                                            <input class="form-control mr-sm-2" type="search" placeholder="Search">
                                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                                        </form>-->
                </ul>

                <form class="form-inline my-2 my-lg-0 ml-5">
                    <button class="btn btn-danger my-2 my-sm-0" type="submit">Sign Out</button>
                </form>
            </div>
        </nav>
        <div class="container-fluid">
            <div class="row height-100">
                <div class="col-10 bg-danger pt-3 pl-3" id="post-zone">

                    <div class="card-columns">
                        <div class="card">
                            <div class="card-header row">
                                <div class="col-2">
                                    <img class="img-circle" src="http://semantic-ui.com/images/avatar/large/elliot.jpg"  width="40" height="40" alt="user img">
                                </div>
                                <div class="col-10">
                                    <h3 class="car">Card title</h3>
                                    <small class="text-muted">Last posted 3 mins ago</small>
                                </div>
                            </div>
                            <img class="card-img-top" src="https://semantic-ui.com/images/wireframe/image.png" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#model">View</button>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-header row">
                                <div class="col-2">
                                    <img class="img-circle" src="http://semantic-ui.com/images/avatar/large/elliot.jpg"  width="40" height="40" alt="user img">
                                </div>
                                <div class="col-10">
                                    <h3 class="car">Card title</h3>
                                    <small class="text-muted">Last posted 3 mins ago</small>
                                </div>
                            </div>
                            <img class="card-img-top" src="https://semantic-ui.com/images/wireframe/image.png" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#model">View</button>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-header row">
                                <div class="col-2">
                                    <img class="img-circle" src="http://semantic-ui.com/images/avatar/large/elliot.jpg"  width="40" height="40" alt="user img">
                                </div>
                                <div class="col-10">
                                    <h3 class="car">Card title</h3>
                                    <small class="text-muted">Last posted 3 mins ago</small>
                                </div>
                            </div>
                            <img class="card-img-top" src="https://semantic-ui.com/images/wireframe/image.png" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#model">View</button>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-header row">
                                <div class="col-2">
                                    <img class="img-circle" src="http://semantic-ui.com/images/avatar/large/elliot.jpg"  width="40" height="40" alt="user img">
                                </div>
                                <div class="col-10">
                                    <h3 class="car">Card title</h3>
                                    <small class="text-muted">Last posted 3 mins ago</small>
                                </div>
                            </div>
                            <img class="card-img-top" src="https://semantic-ui.com/images/wireframe/image.png" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#model">View</button>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-header row">
                                <div class="col-2">
                                    <img class="img-circle" src="http://semantic-ui.com/images/avatar/large/elliot.jpg"  width="40" height="40" alt="user img">
                                </div>
                                <div class="col-10">
                                    <h3 class="car">Card title</h3>
                                    <small class="text-muted">Last posted 3 mins ago</small>
                                </div>
                            </div>
                            <img class="card-img-top" src="https://semantic-ui.com/images/wireframe/image.png" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#model">View</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-2 bg-info">
                    <button type="button" class="mt-3 btn btn-success btn-lg btn-block" data-toggle="modal" data-target="#newPost">New Post</button>
                    <div class="mt-3 pt-1 pb-3 border-top border-bottom">
                        <h1>Filter Category</h1>
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="customCheck1" onclick="filterSelection('cars')">
                            <label class="custom-control-label" for="customCheck1">Type 1</label>
                        </div>
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="customCheck2" onclick="filterSelection('cars')">
                            <label class="custom-control-label" for="customCheck2">Type 2</label>
                        </div>
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="customCheck3" onclick="filterSelection('cars')">
                            <label class="custom-control-label" for="customCheck3">Type 3</label>
                        </div>
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="customCheck4" onclick="filterSelection('cars')">
                            <label class="custom-control-label" for="customCheck4">Type 4</label>
                        </div>
                    </div>
                </div>
                <div class="modal fade " id="model" role="dialog">
                    <div class="modal-dialog modal-lg">
                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title model-center welcome-text">Title</h4>
                                <button type="button" class="close fmargin" data-dismiss="modal">&times;</button>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-4">
                                        <div class="card">
                                            <div class="card-header row no-margin">
                                                <div class="col-3 no-pl">
                                                    <img class="img-circle" src="http://semantic-ui.com/images/avatar/large/elliot.jpg"  width="40" height="40" alt="user img">
                                                </div>
                                                <div class="col-9 no-pl">
                                                    <h3 class="car">Card title</h3>
                                                </div>
                                            </div>
                                            <img class="card-img-top" src="https://semantic-ui.com/images/wireframe/image.png" alt="Card image cap">
                                            <div class="card-body">
                                                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                                <button type="button" class="btn btn-primary">Interested</button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-8">

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Modal -->
                <div class="modal fade" id="newPost" role="dialog">
                    <div class="modal-dialog modal-lg">
                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title model-center welcome-text">New Post</h4>
                                <button type="button" class="close fmargin" data-dismiss="modal">&times;</button>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-12">
                                        <form class="was-validated">
                                            <div class="form-group">
                                                <label for="title" class="col-form-label">Title:</label>
                                                <input type="text" class="form-control" id="post-title" placeholder="exemple" autocomplete="off" pattern="[A-Za-z0-9]+" size="25" minlength="8" maxlength="25" required>
                                            </div>
                                            <div class="form-group">
                                                <label for="description" class="col-4 no-pd-l col-form-label">Description:</label> 
                                                <div class="col-12 no-pl">
                                                    <textarea id="info" name="description" placeholder="exemple" cols="40" rows="4" class="form-control" minlength="1" required></textarea>
                                                </div>
                                            </div>
                                            <div class="float-right">
                                                <button type="button" class="btn btn-success btn-lg">Post</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
//            filterSelection("all")
//            function filterSelection(c) {
//                var x, i;
//                x = document.getElementsByClassName("filterDiv");
//                if (c == "all")
//                    c = "";
//                // Add the "show" class (display:block) to the filtered elements, and remove the "show" class from the elements that are not selected
//                for (i = 0; i < x.length; i++) {
//                    w3RemoveClass(x[i], "show");
//                    if (x[i].className.indexOf(c) > -1)
//                        w3AddClass(x[i], "show");
//                }
//            }
//
//// Show filtered elements
//            function w3AddClass(element, name) {
//                var i, arr1, arr2;
//                arr1 = element.className.split(" ");
//                arr2 = name.split(" ");
//                for (i = 0; i < arr2.length; i++) {
//                    if (arr1.indexOf(arr2[i]) == -1) {
//                        element.className += " " + arr2[i];
//                    }
//                }
//            }
//
//// Hide elements that are not selected
//            function w3RemoveClass(element, name) {
//                var i, arr1, arr2;
//                arr1 = element.className.split(" ");
//                arr2 = name.split(" ");
//                for (i = 0; i < arr2.length; i++) {
//                    while (arr1.indexOf(arr2[i]) > -1) {
//                        arr1.splice(arr1.indexOf(arr2[i]), 1);
//                    }
//                }
//                element.className = arr1.join(" ");
//            }
//
//// Add active class to the current control button (highlight it)
//            var btnContainer = document.getElementById("myBtnContainer");
//            var btns = btnContainer.getElementsByClassName("btn");
//            for (var i = 0; i < btns.length; i++) {
//                btns[i].addEventListener("click", function () {
//                    var current = document.getElementsByClassName("active");
//                    current[0].className = current[0].className.replace(" active", "");
//                    this.className += " active";
//                });
//            }
        </script>
    </body>
</html>
