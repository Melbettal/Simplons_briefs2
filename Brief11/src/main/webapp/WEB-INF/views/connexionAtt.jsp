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

<body style="font-family: 'Montserrat', sans-serif; ">
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
                    <div class="navbar-nav" style="margin-left: 700px;">
                        <span class="nav-link active" aria-current="page" href="#">Home</span>
                        <span class="nav-link" style="margin-left: 25px;" href="#">Reservation</span>
                        <span class="nav-link" style="margin-left: 20px; " href="#">Contact us</span>
                        <button type="button" style="border-radius: 1.5em; border-color: black; width: 150px ;margin-left: 20px;"
                            class="btn">S'inscrire</button >
                            </div>
                    </div>
                </div>
        </nav>
    </header>

	
    <div class="container" style="padding: 0%;">
        <div class="row">
            <div class="col-sm" style="padding: 6%; margin-left: -160px; ">
                <div class="col-sm border" style="padding: 15%;">
                <div class="alert alert-warning" role="alert">
  					Hold on, Votre demande d'inscription n'a pas encore été acceptée ! 
				</div>
                    <div class="form-group ">
                        <div class="btn-group btn-group-toggle" data-toggle="buttons"> 
                            <label class="btn btn-primary">
                                <input type="radio" name="options" id="option2"> Se connecter
                            </label>
                            <label class="btn btn-light active">
                                <input type="radio" name="options"
                                    style="border-radius: 1.5em; border-color: black; width: 150px ;" id="option1"
                                    onclick="window.location.href='./Connexion.php'"> S'inscrire
                            </label>
                        </div>
                        <form action="connexion" method="post" style="align-content: center;">
                            <p>Nouveau sur YouBook? <br>
                                Inscrivez-vous pour profiter de toutes les fonctionnalités</p>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Email :</label>
                                <input type="email" name="email" class="form-control" id="exampleInputEmail1"
                                    style="background-color: #E8EFF6; border-color: transparent;"
                                    aria-describedby="emailHelp">
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Mot de passe :</label>
                                    <input type="password" name="mdp" class="form-control" id="exampleInputPassword1"
                                        style="background-color: #E8EFF6; border-color: transparent;">
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                    <label class="form-check-label" for="flexCheckDefault" style="font-size: 10px;">
                                        I accept to share my data with us. I acknowledge that the
                                        collection and use of my personal data will follow
                                        the treatment as described on their privacy policies
                                    </label>
                                </div>
                                <button type="submit" name="Inscription" class="btn btn-primary"
                                    style="  padding:8px 25px; margin-left: 150px; border-radius: 2em;">Se connecter</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-6" style="margin-top: 100px;">
            <img src="./resources/img/undraw_noted_pc9f.png" style="width: 100%;">
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