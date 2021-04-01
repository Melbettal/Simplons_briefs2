<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>Admin</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/style.css">
<script src="${pageContext.servletContext.contextPath}/resources/js/popper.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.min.js"></script>
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
</head>

<body style="font-family: 'Montserrat', sans-serif;">
    <header>
        <nav class="navbar navbar-expand-lg navbar-light ">
            <div class="container-fluid">
                <img src=".././resources/img/logo.jpg" style="width: 180px"></img>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav" style="margin-left: 600px;">
                        <span class="nav-link active" aria-current="page" href="#">Home</span>
                        <span class="nav-link" style="margin-left: 25px;" href="#">Reservation</span>
                        <span class="nav-link" style="margin-left: 20px; " href="#">Contact us</span>
                        <button type="button" style="border-radius: 1.5em; border-color: black; width: 150px ;margin-left: 20px;"
                            class="btn" action="${pageContext.servletContext.contextPath}/deconnexion">Déconnexion</button> </div>
                    </div>
                </div>
        </nav>
    </header>

    <div class="row row-cols-4 row-cols-md-3 g-4" style="padding: 5%; margin-left: 50px;">
        <div class="col">
            <div class="card alert-primary" style="width: 18rem;">
                <div class="card-body">
                    <h4 class="card-title" style="text-align: center;">Apprenants</h4>
                    <h4 class="card-text" style="text-align: center;">90</h4>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card alert-danger" style="width: 18rem;">
                <div class="card-body">
                    <h4 class="card-title" style="text-align: center;">Places vacantes</h4>
                    <h4 class="card-text" style="text-align: center;">35</h4>
                </div>
            </div>
        </div>
        
        <div class="col">
            <div class="card alert-warning" style="width: 18rem;">
                <div class="card-body">
                    <h4 class="card-title" style="text-align: center;">Places réservés</h4>
                    <h4 class="card-text" style="text-align: center;">15</h4>
                </div>
            </div>
        </div>
    </div>


<div class="container" style="padding: 0%;">
        <div class="row">
            <div class="col-sm" style="padding: 6%; margin-left: -160px; ">
                <div class="col-sm border" style="padding: 15%;">
                    <div class="form-group ">
                        <form action="registeresrv123" method="post" style="align-content: center;">
                            <h4 style="text-align: center;;">Réservation</h4>
                            <p style="text-align: center;;">Ajoutez votre nombre place et date disponible !</p>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Date :</label>
                                <input type="date" name="date"  class="form-control"
					    		id="date" style="background-color: #E8EFF6; border-color: transparent;">
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Nombre de places :</label>
                                    <input type="number" name="nmbr_places" min="1" step="1" class="form-control"
								id="nbrjrs" style="background-color: #E8EFF6; border-color: transparent;"
								aria-describedby="Nombre de jours">
                                </div>
                                <button type="submit" id="idAjoutButton" class="btn btn-primary"
                                    style="padding:8px 25px; margin-left: 150px; border-radius: 2em;" >Ajouter</button>
                                    
                                    </form>
                        </div>
                    </div>
                </div>
            </div>
        <div class="col-sm-6" style="margin-top: 100px;">
            <img src=".././resources/img/undraw_Booking_re_gw4j(1).png" style="width: 100%;">
        </div>
    </div>
    </div>

    <div class="container">
        <h2 style="text-align: center;">Liste de validation</h2>
        <table class="table ">
            <tr>
                <th>ID</th><th>Nom Complet</th><th>Email</th>
            </tr>
        <c:forEach items="${listUser}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.nom_complet}</td>
                <td>${p.email}</td>
                <td><form action="demandeInscription" method="POST">
                	<input type="hidden" name="id" value="${p.id}">
                	<button type=submit style="border-radius: 25px; " class="btn btn-primary" name="accepter" >Valider</button>
                </form></td>
                <td><form action="demandeInscription" method="POST">
                	<input type="hidden" name="id" value="${p.id}">
                	<button type=submit style="border-radius: 25px; " class="btn btn-primary" name="refuser" >Supprimer</button>
                </form></td>
            </tr>
        </c:forEach>
        </table>
    </div>
    
    


    <div class="footer" style="padding: 2px;
    text-align: center;
    background: black;
    line-height: 25px;
    color: #fff;
    font-size: 15px;
    letter-spacing: 2px;
    margin: 0px;
    margin-top: 130px;">
        <div>Powered By YouCode-Safi.</div>
        <p>Copyright © 2020. All rights reserved.</p>
    </div>






</body>
<script type="text/javascript">

 
function checkDate() {

	  var startDate = new Date(document.getElementById('date').value);
	  var today = new Date();
	  if (startDate.getTime() > today.getTime()) {
	    return true;
	  }
	  else return false;
	}
function validateMyForm()
{
	
  if(checkDate()==false)
  { 
    alert("La date ne doit pas être alterieur à la date d'aujourd'hui");
 
    return false;
  }else
 
  return true;
}
 
</script>

</html>