<%-- 
    Document   : planetas
    Created on : 17 ene 2025, 22:48:22
    Author     : jl4ma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Página Planetas - Jose Madero</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/styles/general.css"/>
    <link rel="stylesheet" href="resources/styles/planetas.css"/>

    </head>
    <body>
        <%@include file="./fragmentos/encabezado.xhtml"%>
        <div class="contenido">
            
            
        <div class="left-side">
            <%@include file="./fragmentos/navegador.xhtml"%>
        </div> 
            
            
        
    
        
        <div class="right-side">
            <div class="planetasContenido">
                
            </div>
            <a href="post.jsp" > <img class="agregar" src="resources/imgs/agregar.jpg" alt="alt"/></a>
        </div>
            
            
            </div> 
    </body>
</html>
