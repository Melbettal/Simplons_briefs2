<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../Public/Style/Connexion.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
    <title>S'inscrire</title>
</head>

<body style="font-family: 'Montserrat', sans-serif;">
    <header>
        <nav class="navbar navbar-expand-lg navbar-light ">
            <div class="container-fluid">
                <img src="./resources/img/logo.jpg" style="width: 180px"></img>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav" style="margin-left: 800px;">
                        <span class="nav-link active"  aria-current="page" href="${pageContext.servletContext.contextPath}/connexion">Home</span>
                        <span class="nav-link" style="margin-left: 25px;" href="#">Reservation</span>
                        <span class="nav-link" style="margin-left: 20px; "href="#">Contact us</span>
                        <button type="button" style="border-radius: 1.5em; border-color: black; width: 150px ;"
                        class="btn" onclick="location.href='${pageContext.request.contextPath}/register'">S'inscrire </button>
                         </div>
                </div>
            </div>
        </nav>
    </header>

    <div class="container" style="padding: 5%;">
        <div class="row">
            <div class="col-sm-6" style="padding: 6%; margin-left: -160px; ">
                <h1 style="font-weight: 700;">YouBook,Inscrivez-vous et
                    reservez votre Place facilement ! </h1>
                <p>Cette application offre la possibilité de réserver et visualiser des demandes d'accès hors les heures
                    de la formation et le week-end. </p>
                <button type="button" style="border-radius: 1.5em; border-color: black; width: 40% ;"
                    class="btn"  onclick="location.href='${pageContext.request.contextPath}/register'">S'inscrire</button>
                <button type="button" style="border-radius: 1.5em; width: 40% ;"
                    class="btn btn-primary" >Explorer</button>
            </div>
            <div class="col-md">
                <img src="./resources/img/undraw_working_late_pukg.png" style="width: 100%;">
                </img>
            </div>
        </div>
    </div>

    <div class="footer" style="padding: 2px;
    text-align: center;
    background: black;
    line-height: 25px;
    color: #fff;
    font-size: 15px;
    letter-spacing: 2px;
    margin: 0px;">
        <div>Powered By YouCode-Safi.</div>
        <p>Copyright © 2020. All rights reserved.</p>
    </div>
</body>

</html>