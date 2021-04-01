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
    <title>S'inscrire</title>
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
                <img src="./resources/img/logo.jpg" style="width: 180px"></img>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav" style="margin-left: 800px;">
                        <span class="nav-link active" aria-current="page" href="${pageContext.servletContext.contextPath}/">Home</span>
                        <span class="nav-link" style="margin-left: 25px;" href="${pageContext.servletContext.contextPath}/admin/demandeAcces">Reservation</span>
                        <span class="nav-link" style="margin-left: 20px; " href=#>Contact us</span>
                        <button type="button" style="border-radius: 1.5em; border-color: black; width: 150px ;"
                            class="btn" href="${pageContext.servletContext.contextPath}/admin/demandeAcces">S'inscrire</button> </div>
                    </div>
                </div>
        </nav>
    </header>

    <div class="container" style="padding: 1%;">
        <div class="alert alert-success" role="alert" style="padding: 2%; ">
            <img src="./resources/img/11.png" style="width: 2%;">
            Ton Compte a été validé
        </div>
    </div>


    <div class="container" style="padding: 0%;">
        <div class="row">
            <div class="col-sm" style="padding: 6%; margin-left: -160px; ">
                <div class="col-sm border" style="padding: 15%;">
                     <h2 style="text-align: center;">Liste de validation</h2>
        <table class="table ">
            <tr>
                <th>ID</th><th>Date</th><th>Nombre de places</th>
            </tr>
        <c:forEach items="${listUser}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.date}</td>
                <td>${p.nmbr_places}</td>
                <td><form action="demandeInscription" method="POST">
                	<input type="hidden" name="id" value="${p.id_gest}">
                	<button type=submit style="border-radius: 25px; " class="btn btn-primary" name="accepter" >Valider</button>
                </form></td>
                <td><form action="demandeInscription" method="POST">
                	<input type="hidden" name="id" value="${p.id_gest}">
                	<button type=submit style="border-radius: 25px; " class="btn btn-primary" name="refuser" >Supprimer</button>
                </form></td>
            </tr>
        </c:forEach>
        </table>
                </div>
            </div>
            </div>
        <div class="col-sm-6" style="margin-top: 100px;">
            <img src="./resources/img/undraw_Booking_re_gw4j(1).png" style="width: 100%;">
        </div>
    </div>
</div>

    <div class="container">
        <h2 style="text-align: center;">Historique des réservations</h2>
    <table class="table">
        <tr>
            <th>Description</th><th>Date</th>
        </tr>
    <c:forEach items="${model.produits}" var="p">
        <tr>
            <td>${p.description}</td>
            <td>${p.date}</td>
            <td><button onclick="document.location='supprimer.do?id=${p.id}'" style="border-radius: 25px; " class="btn btn-primary" >Supprimer</button></td>
        </tr>
    </c:forEach>
    </table>
    <c:if test="${! empty listDemande }">
			<table class="table table-striped mt-5">
				<thead>
					<tr>
						<th scope="col">date demande</th>
						<th scope="col">état de demande</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="demande" items="${listDemande}">
						<tr>
							<th scope="row"><fmt:formatDate type = "date" value = "${demande.id.gestion.date}" /></th>
							<td>
								<c:choose>
									<c:when test="${ demande.etat == 0 }">en attente</c:when>
									<c:when test="${ demande.etat == 1 }">approuvée</c:when>
									<c:otherwise>rejetée</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
        
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