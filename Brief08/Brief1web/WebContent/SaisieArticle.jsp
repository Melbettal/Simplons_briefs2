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
		<div class="container col-md-8 col-md-offset-2 col-xs-12">
			<div class="card card-warning">
			<div class="card-header"> Ajouter des Articles</div>
			<div class="card-body">
			<form action="SaveArticle.do" method="post">
			<div class="form-group">
				<label class="control-label">Nom</label>
				<input type="text" name="nom" value="${article.nom }"  class="form-control" required="required"/>
				<span></span>
			</div>
			
			<div class="form-group">
				<label class="control-label">Description</label>
				<input type="text" name="description" value="${article.description }"  class="form-control" />
				<span></span>
			</div>
				
			<div class="form-group">
				<label class="control-label">Prix</label>
				<input type="text" name="prix" value="${article.prix}"  class="form-control" />
				<span></span>
			</div>
				
			<div class="form-group">
				<label class="control-label">Quantité</label>
				<input type="text" name="quantite" value="${article.quantite }" class="form-control" />
				<span></span>
			</div>
			
			<div>
				<button type="submit" class="btn btn-warning">Ajouter</button>
			</div>
			</form>
		</div>
	</div>
	</div>
		</body>
	</html>