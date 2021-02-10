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
			<div class="card-header"> Confirmation des Articles</div>
				<div class="card-body">
					<div class="form-group">
						<label>ID :</label>
						<label>${article.id}</label>
					</div>
					<div class="form-group">
						<label>Nom :</label>
						<label>${article.nom}</label>
					</div>
					<div class="form-group">
						<label>Description :</label>
						<label>${article.description}</label>
					</div>
					<div class="form-group">
						<label>Prix :</label>
						<label>${article.prix}</label>
					</div>
					<div class="form-group">
						<label>Quantité :</label>
						<label>${article.quantite}</label>
					</div>
			</div>
		</div>
	</div>
		</body>
	</html>