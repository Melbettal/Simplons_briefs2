<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="ISO-8859-1">
			<title>Articles</title>
			<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/> 
		</head>
		<body>
		<%@include file="header.jsp" %>
		<p></p>
		<div class="container">
			<div class="card card-warning">
			<div class="card-header" style="background-color: #CA6701; color: #FFFFFF;"> Recherche des Articles</div>
			<div class="card-body">
			<form action="chercher.do" method="get"> <!-- get pour chercher , Post ajouter update delete -->
				<label>Rechercher par mot Cl�: </label>
				<input type="text" name="motCle" value="${model.motCle }">
				<button type="submit" style="border-radius: 0px; background-color: #CA6701" class="btn btn-warning" >chercher</button>
			</form>
							<button onclick="document.location='ajoutProduit.jsp'" style="margin-left: 900px; border-radius: 0px; background-color: #CA6701" class="btn btn-warning" >Ajouter un produit</button>
			
			<p></p>
			<table class="table ">
				<tr>
					<th>ID</th><th>Image</th><th>Nom</th><th>Description</th><th>Prix</th><th>Quantit�</th>
				</tr>
			<c:forEach items="${model.produits}" var="p">
				<tr>
					<td>${p.id}</td>
					<td><img src="img/${p.image}" width="150" height="100"></td>
					<td>${p.nom}</td>
					<td>${p.description}</td>
					<td>${p.prix}</td>	
					<td>${p.quantite}</td>
					<td><button onclick="document.location='supprimer.do?id=${p.id}'" style="border-radius: 0px; background-color: #CA6701" class="btn btn-warning" >Supprimer</button></td>
					<td><button onclick="document.location='edit.do?id=${p.id}'" style="border-radius: 0px; background-color: #CA6701" class="btn btn-warning" >Modifier</button></td>
				</tr>
			</c:forEach>
			</table>
		</div>
	</div>
	</div>
	    			<%@include file="footer.jsp" %>
	
		</body>
	</html>