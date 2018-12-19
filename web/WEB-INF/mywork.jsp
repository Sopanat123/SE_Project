<%-- 
    Document   : homepage
    Created on : Oct 28, 2018, 6:28:12 PM
    Author     : 58070158
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
        <!--<link href="assets/css/all.min.css" rel="stylesheet">-->
        <link href="https://fonts.googleapis.com/css?family=K2D" rel="stylesheet">
        <!--<link href="assets/css/propeller.min.css" rel="stylesheet">-->
        <script src="assets/js/jquery-3.3.1.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="assets/css/style.css">
        <title>Homepage</title>
    </head>
    
  <body>
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
                                <div class="col-xs-12 work-item">
                                    <div class="col-xs-2 col-sm-1"><img class="profile-img" src="img/img.jpg" /></div>
                                    <div class="col-xs-10 col-sm-11">
                                        <div class="col-xs-12 col-sm-3"><a href="#">Work title Lorem ipsum dolor sit
                                                amet.</a></div>
                                        <div class="col-xs-12 col-sm-7">Lorem ipsum dolor sit amet consectetur
                                            adipisicing elit. Sint amet blanditiis ea quod consequatur eius dignissimos
                                            veritatis tempore voluptates aspernatur distinctio nam inventore eaque
                                            minus voluptatem ex, exercitationem facilis accusamus.</div>
                                        <div class="col-xs-12 col-sm-2 text-right">3 min ago</div>
                                    </div>
                                </div>

                                <div class="col-xs-12 work-item">
                                    <div class="col-xs-2 col-sm-1"><img class="profile-img" src="img/img.jpg" /></div>
                                    <div class="col-xs-10 col-sm-11">
                                        <div class="col-xs-12 col-sm-3"><a href="#">Work title Lorem ipsum dolor sit
                                                amet.</a></div>
                                        <div class="col-xs-12 col-sm-7">Lorem ipsum dolor sit amet consectetur
                                            adipisicing elit. Sint amet blanditiis ea quod consequatur eius dignissimos
                                            veritatis tempore voluptates aspernatur distinctio nam inventore eaque
                                            minus voluptatem ex, exercitationem facilis accusamus.</div>
                                        <div class="col-xs-12 col-sm-2 text-right">3 min ago</div>
                                    </div>
                                </div>

                                <div class="col-xs-12 work-item">
                                    <div class="col-xs-2 col-sm-1"><img class="profile-img" src="img/img.jpg" /></div>
                                    <div class="col-xs-10 col-sm-11">
                                        <div class="col-xs-12 col-sm-3"><a href="#">Work title Lorem ipsum dolor sit
                                                amet.</a></div>
                                        <div class="col-xs-12 col-sm-7">Lorem ipsum dolor sit amet consectetur
                                            adipisicing elit. Sint amet blanditiis ea quod consequatur eius dignissimos
                                            veritatis tempore voluptates aspernatur distinctio nam inventore eaque
                                            minus voluptatem ex, exercitationem facilis accusamus.</div>
                                        <div class="col-xs-12 col-sm-2 text-right">3 min ago</div>
                                    </div>
                                </div>

                                <div class="col-xs-12 work-item">
                                    <div class="col-xs-2 col-sm-1"><img class="profile-img" src="img/img.jpg" /></div>
                                    <div class="col-xs-10 col-sm-11">
                                        <div class="col-xs-12 col-sm-3"><a href="#">Work title Lorem ipsum dolor sit
                                                amet.</a></div>
                                        <div class="col-xs-12 col-sm-7">Lorem ipsum dolor sit amet consectetur
                                            adipisicing elit. Sint amet blanditiis ea quod consequatur eius dignissimos
                                            veritatis tempore voluptates aspernatur distinctio nam inventore eaque
                                            minus voluptatem ex, exercitationem facilis accusamus.</div>
                                        <div class="col-xs-12 col-sm-2 text-right">3 min ago</div>
                                    </div>
                                </div>

                                <div class="col-xs-12 work-item">
                                    <div class="col-xs-2 col-sm-1"><img class="profile-img" src="img/img.jpg" /></div>
                                    <div class="col-xs-10 col-sm-11">
                                        <div class="col-xs-12 col-sm-3"><a href="#">Work title Lorem ipsum dolor sit
                                                amet.</a></div>
                                        <div class="col-xs-12 col-sm-7">Lorem ipsum dolor sit amet consectetur
                                            adipisicing elit. Sint amet blanditiis ea quod consequatur eius dignissimos
                                            veritatis tempore voluptates aspernatur distinctio nam inventore eaque
                                            minus voluptatem ex, exercitationem facilis accusamus.</div>
                                        <div class="col-xs-12 col-sm-2 text-right">3 min ago</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane" id="doing">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-xs-12 work-item">
                                    <div class="col-xs-2 col-sm-1"><img class="profile-img" src="img/img.jpg" /></div>
                                    <div class="col-xs-10 col-sm-11">
                                        <div class="col-xs-12 col-sm-3"><a href="#">Work title Lorem ipsum dolor sit
                                                amet.</a></div>
                                        <div class="col-xs-12 col-sm-7">Lorem ipsum dolor sit amet consectetur
                                            adipisicing elit. Sint amet blanditiis ea quod consequatur eius dignissimos
                                            veritatis tempore voluptates aspernatur distinctio nam inventore eaque
                                            minus voluptatem ex, exercitationem facilis accusamus.</div>
                                        <div class="col-xs-12 col-sm-2 text-right">3 min ago</div>
                                    </div>
                                </div>

                                <div class="col-xs-12 work-item">
                                    <div class="col-xs-2 col-sm-1"><img class="profile-img" src="img/img.jpg" /></div>
                                    <div class="col-xs-10 col-sm-11">
                                        <div class="col-xs-12 col-sm-3"><a href="#">Work title Lorem ipsum dolor sit
                                                amet.</a></div>
                                        <div class="col-xs-12 col-sm-7">Lorem ipsum dolor sit amet consectetur
                                            adipisicing elit. Sint amet blanditiis ea quod consequatur eius dignissimos
                                            veritatis tempore voluptates aspernatur distinctio nam inventore eaque
                                            minus voluptatem ex, exercitationem facilis accusamus.</div>
                                        <div class="col-xs-12 col-sm-2 text-right">3 min ago</div>
                                    </div>
                                </div>

                                <div class="col-xs-12 work-item">
                                    <div class="col-xs-2 col-sm-1"><img class="profile-img" src="img/img.jpg" /></div>
                                    <div class="col-xs-10 col-sm-11">
                                        <div class="col-xs-12 col-sm-3"><a href="#">Work title Lorem ipsum dolor sit
                                                amet.</a></div>
                                        <div class="col-xs-12 col-sm-7">Lorem ipsum dolor sit amet consectetur
                                            adipisicing elit. Sint amet blanditiis ea quod consequatur eius dignissimos
                                            veritatis tempore voluptates aspernatur distinctio nam inventore eaque
                                            minus voluptatem ex, exercitationem facilis accusamus.</div>
                                        <div class="col-xs-12 col-sm-2 text-right">3 min ago</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</body>

<script src="assets/js/jquery-3.3.1.min.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script>
    $('#myTabs a').click(function (e) {
        e.preventDefault()
        $(this).tab('show')
    })
</script>

</html>
