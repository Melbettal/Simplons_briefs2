<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../Public/Style/Evenements.css">
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
    <title> Signup </title>
    </link>

<body>
    <nav class="navbar navbar-expand-lg"style="background-color : #FAD8B1">
        <div class="container-fluid">
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
            <span class="navbar-text" style="margin-left: 800px;">
              Home
            </span>
            <span class="navbar-text" style="margin-left: 100px;">
                FAQ
              </span>
              <span class="navbar-text" style="margin-left: 100px;">
                Calendar
              </span>
              <span class="navbar-text" style="margin-left: 50px;">
                <button class="btn " type="submit" style="border-color: black; border-radius: 1em; color: black; width: 100px;">Login</button>
                        
              </span>
        </div>
      </nav>
    <div style="background-color: #FAD8B1; min-height: 400px;"></div>
        <div class="container" style="padding: 10%;margin-top: -400px;">
            <div class="row">
                <div class="col-lg">
                    <h2>Sign Up!</h2>
                    <img src="zfeaea.png" alt="cat" style="margin-left: -80px; width: 110%;">
                </div>
                <div class="col-lg" style="background-color: #E5E5E5; padding: 5%; border-radius: 2em;">
				
				<form action="<%=request.getContextPath()%>/register" method="post">                
                    
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Full Name : </label>
                        <input  style="border-radius: 10em; box-shadow: 2px 2px #888888;"
                            name="nom_complet" class="form-control" id="exampleFormControlInput1">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlTextarea1" class="form-label">Email :</label>
                        <input type="email" style="border-radius: 10em; box-shadow: 2px 2px #888888;"
                            name="email" class="form-control" id="exampleFormControlInput1">
                    </div>
                    <div class="mb-3">
                            <label for="exampleFormControlTextarea1" class="form-label">Password :</label>
                            <input type="password" style="border-radius: 10em; box-shadow: 2px 2px #888888;"
                                name="mdp" class="form-control" id="exampleFormControlInput1">
                    </div>
                    <div class="mb-3">
                            <label for="exampleFormControlTextarea1" class="form-label">Confirm Password :</label>
                            <input type="password" style="border-radius: 10em; box-shadow: 2px 2px #888888;"
                                class="form-control" id="exampleFormControlInput1">
                    </div>
                     <button class="btn " type="submit" style="margin-left: 140px; background-color: #EB5E30; border-radius: 1em; color: white; box-shadow: 2px 2px #888888;">Signup</button>
                  </form>
                    
                    </div>               
                </div>
            </div>
</body>
</html>