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
			<div class="card-header"> Recherche des Articles</div>
			<div class="card-body">
			<form action="chercher.do" method="get"> <!-- get pour chercher , Post ajouter update delete -->
				<label>Mot clé</label>
				<input type="text" name="motCle" value="${model.motCle }">
				<button type="submit" class="btn btn-warning" >chercher</button>
			</form>
			<p></p>
			<table class="table table-dark">
				<tr>
					<th>ID</th><th>Nom</th><th>Description</th><th>Prix</th><th>Quantité</th>
				</tr>
			<c:forEach items="${model.articles}" var="p">
				<tr>
					<td>${p.id}</td>
					<td>${p.nom}</td>
					<td>${p.description}</td>
					<td>${p.prix}</td>
					<td>${p.quantite}</td>	
					<td><a onclick="return confirm('Etes vous sûre de vouloir supprimer ?')" href="supprimer.do?id=${p.id}">Supprimer</a></td>
					<td><a href="edit.do?id=${p.id}">Modifier</a></td>
				</tr>
			</c:forEach>
			</table>
		</div>
	</div>
	</div>
		</body>
	</html>