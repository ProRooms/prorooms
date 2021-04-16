
<%@page import="com.sanvalero.proweek.domain.User"%>
<%@page import="com.sanvalero.proweek.dao.UserDAO"%>
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
                        <li><a href="#cabecera" title="conócenos" alt="conócenos" class="scroll">Conócenos</a>
                        </li>
                        <li><a href="#productos" title="productos" alt="productos" class="scroll">Productos</a>
                        </li>
                        <li><a href="#contacto" title="privacidad" alt="privacidad">Política de privacidad</a>
                        </li>
                    </ul>
                </div>
        </header>

        <form action="create_a_visit" style="border:1px solid #ccc" method="post">
            <div class="containerform" id="user_portal">
                <h1>User Portal</h1>
                <p>All your account in the same place</p>
                <hr>
                <h2>Create a visit</h2>
                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" required>
                <label for="id_prop"><b>Id Property</b></label>
                <input type="text" placeholder="Id Property" name="id_prop" required>
                <label for="date"><b>Choose a day</b></label>
                <input type="date" placeholder="Choose a day" name="date" required>
                <div class="clearfix">
                    <button type="button" class="cancelbtn">Cancel</button>
                    <button type="submit" class="signupbtn">Send</button>
                    <!--<input type="submit" class="signupbtn" value ="enviar">-->
                </div>
            </div>
        </form>
        <form action="list_your_viewings" style="border:1px solid #ccc" method="post">
            <div class="containerform" id="viewings">
                <h2>List your viewings</h2>
                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" required>
                <div class="clearfix">

                    <button type="button" class="cancelbtn">Cancel</button>
                    <button type="submit" class="signupbtn">Send</button>
                    <br>
                    <br>
                    <br>
                </div>
            </div>
        </form>

        <form action="change_your_viewings" style="border:1px solid #ccc" method="post">
        <div class="containerform" id="change">
            <h2>Change your viewings</h2>
            <label for="psw"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw" required>
            <label for="id_prop"><b>Id Property</b></label>
            <input type="text" placeholder="Id Property" name="id_prop" required>
            <label for="id_visit"><b>Old visit</b></label>
            <input type="text" placeholder="ID Visit" name="id_visit" required>
            <label for="date"><b>New date</b></label>
            <input type="date" placeholder="New date" name="date" required>
            <br>
            <div class="clearfix">
                <button type="button" class="cancelbtn">Cancel</button>
                <button type="submit" class="signupbtn">Send</button>
            </div>
        </div>
    </form>

    <form action="delete_user" style="border:1px solid #ccc" method="post">
        <div class="containerform" id="delete_user">
            <h2>Delete User</h2>
            <label for="nombre"><b>Nombre</b></label>
            <input type="text" placeholder="Enter name" name="nombre" required>
            <label for="apellidos"><b>Apellidos</b></label>
            <input type="text" placeholder="Enter surname" name="apellidos" required>
            <label for="psw"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw" required>
            <div class="clearfix">
                <button type="button" class="cancelbtn">Cancel</button>
                <button type="submit" class="signupbtn">Delete</button>
            </div>
        </div>
    </form>
</body>
</html>