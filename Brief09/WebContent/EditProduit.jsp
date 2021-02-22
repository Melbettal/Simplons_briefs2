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
		
		
		<div class="container">
		<div class="row" >
		<div class="col-lg" >
    			 <img src="./img/1.jpg" alt="Italian Trulli" style="margin-left: -80px; margin-top:50px; ">
    			</div>
    	<div class="col-lg two" style="padding: 50px; ">
			<div class="card card-warning">
			<div class="card-header" style="background-color: #01476A; color: #FFFFFF; border-radius: 0px"> Ajouter des Produits</div>
			<div class="card-body">
			<form action="UpdateProduit.do" method="post" enctype="multipart/form-data">
							
			<div class="form-group">
				<label class="control-label">ID</label>
				<input type="text" name="id" value="${produit.id}"  class="form-control" required="required"/>				<span></span>
			</div>
			
			<div class="form-group">
				<label class="control-label">Nom</label>
				<input type="text" name="nom" value="${produit.nom }"  class="form-control" required="required"/>
				<span></span>
			</div>
			
			<div class="form-group">
				<label class="control-label">Image</label>
				<input type="file" name="image">
				<span></span>
			</div>
			
			<div class="form-group">
				<label class="control-label">Description</label>
				<input type="text" name="description" value="${produit.description }"  class="form-control" />
				<span></span>
			</div>
				
			<div class="form-group">
				<label class="control-label">Prix</label>
				<input type="text" name="prix" value="${produit.prix}"  class="form-control" />
				<span></span>
			</div>
				
			<div class="form-group">
				<label class="control-label">Quantité</label>
				<input type="text" name="quantite" value="${produit.quantite}" class="form-control" />
				<span></span>
			</div>
			
			<div>
				<button type="submit" style="margin-left: 200px; background-color: #01476A; color: #FFFFFF; border-radius: 0px;" class="btn btn-warning">Ajouter</button>
			</div>
			</form>
		</div>
	</div>
	</div>
	</div>
	</div>
	
		    			<%@include file="footer.jsp" %>
	
		</body>
	</html>