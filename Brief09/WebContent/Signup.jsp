<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
	<html>
		<head>
			<head charset="ISO-8859-1">
			<title>Articles</title>
			<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/> 
			<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Montserrat:wght@600&display=swap" type="text/css" href="css/styling.css"/> 
		</head>
		<body>
		<%@include file="header.jsp" %>
		<p></p>
  		<div class="container">
  			<div class="row" >
    			<div class="col-lg" >
    			 <img src="./img/pic2.png" alt="Italian Trulli" style="margin-left: -80px; width: 100%;">
    			</div>
    			<form action="Saveuser.do" method="post">
    			
    		<div class="col-lg two" style="padding: 50px; border-style: solid; border-color: #E5DCDC;">
    			<div class="" style= "padding: 10px; text-align: center;">
    			<h3 style="color: #CA6701">Enregistrez-vous! </h3>
				<p>Et consulter le salon de poterie en ligne "SBahia"</p> </div>
    			<div class="mb-3" style="padding: 15px; ">
  					<label for="formGroupExampleInput" class="form-label">Nom Complet :</label>
  					<input type="text" id="nom" class="form-control" value="<c:out value="${user.nom}"/>"name="nom" >
  					                <span class="erreur">${form.erreurs['nom']}</span>
				</div>
			<div class="mb-3" style="padding: 15px">
  					<label for="formGroupExampleInput2" class="form-label">Email :</label>
  					<input type="email" id="email" class="form-control" value="<c:out value="${user.email}"/>"name="email" >
  					                <span class="erreur">${form.erreurs['email']}</span>
			</div>
			<div class="mb-3" style="padding: 15px">
  					<label for="formGroupExampleInput2" class="form-label">Mot de passe :</label>
  					<input type="password" id="mdp" class="form-control" minlength="8" value="<c:out value="${user.mdp}"/>" name="mdp" >
  					                <span class="erreur">${form.erreurs['mdp']}</span>
			</div>
			<div class="mb-3" style="padding: 15px">
  					<label for="formGroupExampleInput2" class="form-label">Confirmez Mot de passe :</label>
  					<input type="password" id="confmdp" class="form-control" value="<c:out value="${user.confmdp}"/>" name="confmdp" >
  					                <span class="erreur">${form.erreurs['confmdp']}</span>
			</div>
			<div class="col-12">
    			<button class="btn btn-primary" type="submit" style="margin-left: 180px; background-color: #024669; border-radius: 0px;">Se connecter</button>
  			</div>
  			<div class="" style= "padding: 10px; text-align: center; padding: 10px">
  			<p>Vous avez déja un compte?</p>
    		<h5 onclick="document.location='Signin.jsp'" >Se connecter </h5> </div>
    		</div>
    		    		</form>
    		
    		</div>
    	</div>
    	
    			<%@include file="footer.jsp" %>
    	
</body>
</html>