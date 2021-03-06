<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/homepage.css" rel="stylesheet">
        <link href="assets/css/mywork.css" rel="stylesheet">
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
<%-- NAV HEAD --%> <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="mywork">My Work</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="home" disabled>Doing Work</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="editprofile">Edit Profile</a>
                    </li>
                    <!--                    <form class="form-inline my-2 my-lg-0">
                                            <input class="form-control mr-sm-2" type="search" placeholder="Search">
                                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                                        </form>-->
<%-- NAV TAIL --%> </ul>

<%-- 'sign out' HEAD --%> <form action="signout" method="POST" class="form-inline my-2 my-lg-0 ml-5">
                    <button class="btn btn-danger my-2 my-sm-0" type="submit">Sign Out</button>
<%-- 'sign out' TAIL --%> </form>
            </div>
        </nav>
        <div class="accordion" id="accordionExample">
            <div class="card">
                <div class="card-header bg-secondary" id="headingOne">
                    <h5 class="mb-0">
                        <button class="btn btn-link link-color" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                            Requested Work
                        </button>
                    </h5>
                </div>

                <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                    <div class="card-body card-body-height card-columns bg-danger ">
                        <c:forEach var="work" items="${sessionScope.workbyowner}}" >
                        <div class="card card-width">
                            <div class="card-header row">
                                <div class="col-2">
                                    <img class="img-circle" src="http://semantic-ui.com/images/avatar/large/elliot.jpg"  width="40" height="40" alt="user img">
                                </div>
                                <div class="col-10">
                                    <h3 class="car col-6">Card title</h3>
                                    <small class="text-muted col-6">Last posted 3 mins ago</small>
                                </div>
                            </div>
                            <img class="card-img-top" src="//placehold.it/800x400" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#model">View</button>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header bg-secondary" id="headingTwo">
                    <h5 class="mb-0">
                        <button class="btn btn-link collapsed link-color" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                            Doing Work
                        </button>
                    </h5>
                </div>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                    <div class="card-body card-body-height bg-danger">

                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header bg-secondary" id="headingThree">
                    <h5 class="mb-0">
                        <button class="btn btn-link collapsed link-color" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                            Completed Work
                        </button>
                    </h5>
                </div>
                <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
                    <div class="card-body card-body-height bg-danger">

                    </div>
                </div>
            </div>
        </div>
        <!--        <div class="container-fluid">
                    <div class="row height-100">
                        <div class="col bg-danger pt-3 pl-3">
                            <div class="col pt-2 pb-2">
                                <p class="text-white font-weight-bold h2">Requested Work</p>
                            </div>
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
                            </div>
                            
                            
                            
                            <div class="col pt-2 pb-2">
                                <p class="text-white font-weight-bold h2">Doing Work</p>
                            </div>
                            
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
                            </div>
                            
                            
                            <div class="col pt-2 pb-2">
                                <p class="text-white font-weight-bold h2">Completed Work</p>
                            </div>
                            
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
                            </div>     
                        </div>-->

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
    </div>
</div>
</body>
</html>