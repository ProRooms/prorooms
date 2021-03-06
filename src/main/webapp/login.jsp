<%@page import="com.sanvalero.proweek.domain.User"%>
<%@page import="com.sanvalero.proweek.dao.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <!--Compatibilidad de Internet Explorer (edge), aun así puede no siempre todo funcionar en IE-->
        <title>ProRooms</title>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;700&display=swap" rel="stylesheet">  <!-- Importando fuente Montserrat de Google Fonts-->
        <link rel="preconnect" href="https://fonts.gstatic.com">  
        <link href="https://fonts.googleapis.com/css2?family=Audiowide&display=swap" rel="stylesheet">     <!-- Importando fuente Audiowide de Google Fonts-->
        <link rel="stylesheet" href="css/styles.css"> <!-- Enlazando CSS3-->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script><!-- Enlazando JS-->
        <script src="js/funciones.js"></script> <!-- Enlazando JS-->
        <link rel="icon" type="image/png" href="img/favicchome.png">
        <!--FAVICON-->

    </head>

        <body>
            <header id="header" class="sticky-top">
                <div class="container">
    
                    <a href="index.html" title="home" class="capaLogo-lg">
                        <img class="logo img-fluid" src="img/favicchome.png" alt="ProRooms" title="ProRooms" />
                    </a>
                    <a href="index.html" title="home" class="capaLogo-sm">
                        <img class="logo-sm img-fluid" src="img/favicchome.png" alt="ProRooms" title="ProRooms" />
                    </a>
    
                    <div class="menuPrincipal">
                        <ul>
                            <!-- ANCLAS EN EL MENU PRINCIPAL: van enlazadas a los ID de las secciones posteriores-->
                            <li><a href="#cabecera" title="conócenos" alt="conócenos" class="scroll">Get to Know us</a>
                            </li>
                            <li><a href="#productos" title="productos" alt="productos" class="scroll">Products</a>
                            </li>
                            <li><a href="#contacto" title="privacidad" alt="privacidad">Privacy Policy</a>
                            </li>
                        </ul>
                    </div>
            </header>
            
            <form action="login" style="border:1px solid #ccc" method="post">
                
                <div class="containerform">
                  <h1>Sign Up</h1>
                  <p>Fill in the form to create an account</p>
                  <hr>             
                  <label for="nombre"><b>Name</b></label>
                  <input type="text" placeholder="Introduce nombre" name="nombre" required>
                  <label for="apellidos"><b>Surname</b></label>
                  <input type="text" placeholder="Introduce apellidos" name="apellidos" required>
                  <label for="email"><b>Email</b></label>
                  <input type="text" placeholder="Enter Email" name="email" required>
                  <label for="telefono"><b>Telephone</b></label>
                  <input type="phone" name="telefono" class="input_text" id="inputPhone"
                    aria-describedby="PhoneHelp" placeholder="Enter your telephone">     
                  <label for="psw"><b>Password</b></label>
                  <input type="password" placeholder="Enter Password" name="psw" required>            
                  <label for="psw-repeat"><b>Re-enter your password</b></label>
                  <input type="password" placeholder="Re-enter Password" name="psw-repeat" required>
              
                  <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Conditions</a>.</p>
              
                  <div class="clearfix">
                    <button type="button" class="cancelbtn">Cancel</button>
                    <button type="submit" class="signupbtn">Sign Up</button>
                  </div>
                </div>
            </form>
            
            <%
                String status = request.getParameter("status");
                if (status == null)
                     status = "";

                if (status.equals("ok")) {
                     out.println("<p style='color:green'>Registration success!</p>");
                } else if (status.equals("error")) {
                     out.println("<p style='color:red'>Unfortunately, we were unable to register you.  Please try again.</p>");
                }
            %>
        </body>
</html>