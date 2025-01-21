<%-- 
    Document   : inicio
    Created on : 17 ene 2025, 22:47:54
    Author     : jl4ma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Página de Inicio - Jose Madero</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="resources/styles/general.css"/>
        <link rel="stylesheet" href="resources/styles/inicio.css"/>
        <link rel="icon" type="image/x-icon" href="resources/imgs/galaxia.webp">

    </head>
    <body>
        <header> 
        <%@include file="./fragmentos/encabezado.xhtml"%>
        </header>
        <main class="contenido">
            
            
        <div class="left-side">
            <%@include file="./fragmentos/navegador.xhtml"%>
        </div> 
 
        <div class="right-side">
            <h2>Nuestro Blog:</h2>
            <div class="introduccion">
                <p class="intro">Nuestro blog trata de la maravillosidad de la astronomia, en este blog podras encontrar todo tipo de informacion acerca de los fenomonemos celestiales, sobre las noticias astronpomicas, los diferentes planetas y tambien sobre nuevos descubrimientos, y lo sorprendete es que si tu tambien quieres aportar a esta informacion, lo puedes hacer aportando con una nueva publicacion en cualquiera de nuestros apartados</p>  
                
            </div>
            
        </div>
            </main> 
    </body>
</html>
