<%--
  Created by IntelliJ IDEA.
  User: Nguyen Huu Nghia
  Date: 03/22/2021
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value='/assets/bootstrap/dist/css/bootstrap.css' />" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/assets/css/style.css' />" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <title>Furama Resort Danang – A Culinary Beach Resort In Vietnam</title>
</head>
<body class="custom-background">
<!--Top Header-->
<div class="container-fluid" style="border-bottom: #F6F6F6 solid 4px;">
    <div class="container my-2">
        <div class="row">
            <div class="col-xl-6 align-self-center">
                <div class="row">
                    <div class="col-xl-6"><p style="margin-bottom: unset">Weather: 30 °C / 86 °F</p></div>
                    <div class="col-xl-6"><p style="margin-bottom: unset">Local time: 12:00 am</p></div>
                </div>
            </div>
            <div class="col-xl-6">
                <ul class="float-xl-right" style="margin-bottom: unset">
                    <li>EN</li>
                    <li>VI</li>
                    <li>JA</li>
                    <li>KR</li>
                    <li>RU</li>
                    <li>CN</li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!--End Top Header-->

<!--Header Content-->
<div class="container my-2">
    <div class="row">
        <div class="col-xl-3"><img src="assets/images/logo@2x.png" alt=""
                                   height="100px"></div>
        <div class="col-xl-3">
            <img src="assets/images/tripadvisor.jpg"
                 alt="" height="90px">
        </div>
        <div class="col-xl-3"><p>103 - 105 Vo Nguyen Giap Street, Khue My Ward, Ngu Hanh Son District, Danang City,
            Vietnam</p></div>
        <div class="col-xl-3">
            <p>84-236-3847 333/888</p>
            <p>reservation@furamavietnam.com</p>
        </div>
    </div>
</div>
<!--End Header Content-->

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light custom-nav position-sticky"
     style="top: 0; height: 70px; z-index: 9999;">
    <div class="container">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link text-white" href="#">THE RESORT<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="#">ROOM & SUITES</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="#">CULINARY</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="#">MEETING & EVENTS</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="#">SPA & FITNESS</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="#">RECREATION</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="#">DESTINATION</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="#">SPECIAL OFFERS</a>
                </li>
                <%--kiểm tra fullname (trong session) không tồn tại thì show login k thì show fullname--%>
                <c:if test="${empty fullname}">
                    <li class="nav-item">
                        <a class="nav-link text-white" href='<c:url value="/?action=login" />'>LOGIN</a>
                    </li>
                </c:if>
                <c:if test="${not empty fullname}">
                    <li class="nav-item">
                        <a class="nav-link text-white" href='<c:url value="/?action=logout&logout=ok" />'>${fullname}</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
<!-- End Navigation -->

<!-- Carousel -->
<div id="slides" class="carousel slide" data-ride="carousel">
    <ul class="carousel-indicators">
        <li data-target="#slides" data-slide-to="0" class="active"></li>
        <li data-target="#slides" data-slide-to="1"></li>
        <li data-target="#slides" data-slide-to="2"></li>
        <li data-target="#slides" data-slide-to="3"></li>
        <li data-target="#slides" data-slide-to="4"></li>
    </ul>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="assets/images/carousel0.jpg">
        </div>
        <div class="carousel-item">
            <img src="assets/images/carousel1.jpg">
        </div>
        <div class="carousel-item">
            <img src="assets/images/carousel2.png">
        </div>
        <div class="carousel-item">
            <img src="assets/images/carousel3.jfif">
        </div>
        <div class="carousel-item">
            <img src="assets/images/carousel4.jpg">
        </div>
    </div>
</div>
<!-- End Carousel -->

<div class="container my-5">
    <div class="row">
        <div class="col-xl-4">
            <h3>THIS WORLD CLASS RESORT, FURAMA DANANG, REPUTABLE FOR BEING A CULINARY RESORT IN VIETNAM</h3>
        </div>
        <div class="col-xl-4 embed-responsive embed-responsive-16by9">
            <iframe width=350px src="https://www.youtube.com/embed/IjlT_4mvd-c" frameborder="0"
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                    allowfullscreen></iframe>
        </div>
        <div class="col-xl-4">
            <p>Overlooking the long stretch of wide white sand on Danang Beach, Furama Resort Danang is a gateway to
                three
                World Heritage Sites of Hoi An (20 minutes), My Son (90 minutes) and Hue (2 hours). The 198 rooms and
                suites
                plus 70 two to four bedroom pool villas feature tasteful décor, designed with traditional Vietnamese
                style
                and a touch of French colonial architecture and guarantee the Vietnam’s the most prestigious resort
                -counting royalty, presidents, movie stars and international business leaders among its celebrity
                guests.</p>
        </div>
    </div>
</div>

<div class="container-fluid padding" style="background-color: #F3F3F3;">
    <div class="container">
        <h3 style="text-align: center;">OFFERS & DEAL</h3>
        <div class="row">
            <div class="col-xl-6" style="height: 300px; border: #0c5460 solid 1px">
                left
            </div>
            <div class="col-xl-6" style="height: 300px; border: #0c5460 solid 1px">
                right
            </div>
        </div>
    </div>
</div>

<div class="container">
    <h3 style="text-align: center;">ROOMS & SUITES</h3>
    <div class="row">
        <div class="col-xl-3"></div>
        <div class="col-xl-6">
            <p>All 198 rooms & suites have polished timber floors, natural fabrics, comfortable cane furniture,
                plantation style shutters and ceiling fans. Each room also has its own balcony or spacious terrace
                providing complete privacy and with a superb view of the ocean, the tropical garden or the freshwater
                swimming lagoon pool.</p>
        </div>
        <div class="col-xl-3"></div>
    </div>
</div>

<div class="container">
    <h5 style="text-align: center;">VIEW ALL ROOMS</h5>
    <div class="card-group">
        <div class="card">
            <img src="assets/images/oceansuite.jpg" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">OCEAN SUITE</h5>
                <p class="card-text"><small class="text-muted">Room size: 85.8 m<sup>2</sup></small></p>
            </div>
        </div>
        <div class="card">
            <img src="assets/images/gardensuperior.jpg" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">GARDEN SUPERIOR</h5>
                <p class="card-text"><small class="text-muted">Room size: 40.1 m<sup>2</sup></small></p>
            </div>
        </div>
        <div class="card">
            <img src="assets/images/oceanstudiosuite.jpg" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">OCEAN STUDIO SUITE</h5>
                <p class="card-text"><small class="text-muted">Room size: 40.1 m<sup>2</sup></small></p>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <h3 style="text-align: center;">JOINING OUR CULINARY & RECREATIONAL EXPERIENCE</h3>
    <div class="row">
        <div class="col-xl-3"></div>
        <div class="col-xl-6">
            <p>The Furama Resort aims to make your stay in Vietnam a unique and unforgettable experience. Whether
                you prefer to be active or just to relax, we offer a wide range of activities and services to suit
                your needs.</p>
        </div>
        <div class="col-xl-3"></div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-xl-6">
            <img src="assets/images/culinary.jpg" alt="" style="width:100%;">
        </div>
        <div class="col-xl-6">
            <h4>CULINARY</h4>
            <p>The resort’s culinary experience features a mixture of the authentic and locally inspired Vietnamese,
                Asian, Italian and other European cuisines plus the best imported steaks. The resort presents guests
                with varied gastronomic venues – the hip and breezy bar overlooking the beach, the exclusive Lagoon pool
                surrounded by a tropical garden, the true Italian flare offered at the Don Cipriani’s, the refined Asian
                touch at Café Indochine or the authentic central Vietnam cuisine at the Danaksara.</p>
            <button>READ MORE</button>
        </div>
    </div>
    <div class="row">
        <div class="col-xl-6">
            <h4>MEETING & EVENT</h4>
            <p>A well-appointed International Convention Palace with ballrooms can accommodate up to 1,000 people in
                style, with another ten function rooms for 50 to 300 people each. A variety of cultural-themed parties
                on the beach or around the lagoon, in the ballrooms or outside the resort, with the surprising arrivals
                of VIPs from Helicopter landing on the resort’s own Helipad…</p>
            <button>READ MORE</button>
        </div>
        <div class="col-xl-6">
            <img src="assets/images/meetingroom.jpg" alt="" style="width:100%;">
        </div>
    </div>
    <div class="row">
        <div class="col-xl-6">
            <img src="assets/images/recreation.jpg" alt="" style="width:100%;">
        </div>
        <div class="col-xl-6">
            <h4>RECREATION</h4>
            <p>A full range of Water Sports will keep you busy. Stop by the Water Sport House where our experienced
                staff are waiting to assist or train you in the use of any of our equipment.</p>
            <button>READ MORE</button>
        </div>
    </div>
</div>

<!--Footer-->
<footer>
    <div class="container-fluid padding" style="background-color: #ADDCCF;">
        <div class="container">
            <div class="row">
                <div class="col-xl-4">
                    <h4>How to Get to Us</h4>
                    <p>Furama is a premier base for exploring one of Asia’s most exciting new destinations. Just a short
                        drive from Danang lay four UNESCO-listed World Heritage Sites:</p>
                    <button>View on Map</button>
                    <h5>Local Places</h5>
                </div>
                <div class="col-xl-4">
                    <a href="#" style="display: block;">News</a>
                    <a href="#" style="display: block;">Rack Rate</a>
                    <a href="#" style="display: block;">Lifestyle Blog</a>
                    <a href="#" style="display: block;">Work with us</a>
                    <a href="#" style="display: block;">Contact us</a>
                </div>
                <div class="col-xl-4">
                    <h5>Contact US</h5>
                    <p>103 - 105 Vo Nguyen Giap Street, Khue My Ward, Ngu Hanh Son District, Danang City, Vietnam</p>
                </div>
            </div>
        </div>

    </div>
</footer>
<!--End Footer-->

<script src="<c:url value='/assets/bootstrap/js/jquery/jquery.js' />"></script>
<script src="<c:url value='/assets/bootstrap/dist/js/bootstrap.bundle.js' />"></script>
<script>
    $(document).on('click', '.dropdown-menu', function (e) {
        e.stopPropagation();
    });
</script>
</body>
</html>
