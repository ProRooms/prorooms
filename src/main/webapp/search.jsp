<%-- 
<%@page import="java.util.ArrayList"%>
<%@page import="com.sanvalero.netflix.domain.Movie"%>
<%@page import="com.sanvalero.netflix.dao.MovieDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <!--Compatibilidad de Internet Explorer (edge), aun así puede no siempre todo funcionar en IE-->
        <title>ProRooms</title>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;700&display=swap" rel="stylesheet">
        <!-- Importando fuente Montserrat de Google Fonts-->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Audiowide&display=swap" rel="stylesheet">
        <!-- Importando fuente Audiowide de Google Fonts-->
        <link rel="stylesheet" href="css/styles.css"> <!-- Enlazando CSS3-->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <!-- Enlazando JS-->
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

        <form action="search" style="border:1px solid #ccc" method="post">
            <div class="containerform">
                <h1>Search</h1>
                <label for="property"><b>Search for your dream property! Press cntrl to select multiple property
                        types.</b></label>
                <!--al nombre definido en la propiedad name le agregamos al final los caracteres [] para que desde el
                                  servidor podamos identificar que el control retorna posiblemente muchos valores.-->
                <select name="tipos[]" size="4" multiple>
                    <option value="1">House</option>
                    <option value="2">Flat</option>
                    <option value="3">Chalet</option>
                    <option value="4">Commercial property</option>
                    <option value="5">Price: 50,000e to 100,000e</option>
                    <option value="6">Price: 100,000e to 150,000e</option>
                    <option value="7">Price: 150,000e to 200,000e</option>
                    <option value="8">More than 200,000e</option>
                </select>
                <button type="button" class="cancelbtn">Cancel</button>
                <button type="submit" class="signupbtn">Search</button>


            </div>
        </div>
    </form>
</body>

</html>
