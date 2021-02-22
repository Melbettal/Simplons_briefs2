<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
	<html>
		<head>
			<meta charset="ISO-8859-1">
			<title>Articles</title>
			<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" /> 
			<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
		</head>
		<body>
			<%@include file="header.jsp" %>
	
	<div class="container">
  		<div class="row">
		</div>

		<div class="row" style="padding: 50px">
						<c:forEach items="${model.produits}" var="p">
	<div class="col">
    	<div class="card">
      		<img src="img/${p.image}" width="100" height="100" class="card-img-top" alt="...">
      	<div class="card-body">
        	<h5 class="card-title" style="font-weight: bold; text-align: center;">${p.nom}</h5>
        	<p class="card-text"style="text-align: center;">${p.description}</p>
          	<h5 class="card-title" style="font-weight: bold; text-align: center;">${p.prix}</h5> 
			<a href='Vote.do?id=${p.id}'><i class="far fa-heart"></i> </a>
			
		</div>
    </div>
  </div>
  

  
  			</c:forEach>
    </div>
  
 
	</div>
	

	    <%@include file="footer.jsp" %>

</body>
</html>