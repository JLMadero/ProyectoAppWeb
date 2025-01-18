<%-- 
    Document   : perfil
    Created on : 17 ene 2025, 22:48:13
    Author     : jl4ma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Perfil - Jose Madero</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/styles/general.css"/>
    <link rel="stylesheet" href="resources/styles/perfil.css"/>

    </head>
    <body>
        <%@include file="./fragmentos/encabezado.xhtml"%>
        <div class="contenido">
            
            
        <div class="left-side">
            <%@include file="./fragmentos/navegador.xhtml"%>
        </div> 
            
            
        
    
        
        <div class="right-side">
            <div class="avatar">
                <div>
                <img src="resources/imgs/galaxia.webp" alt="galaxy"/>
                </div>
                <div>
                <p class="user">@JoseMadero</p>
                <p class="locacion">Sonora, cajeme, Cd. Obregón</p>
                </div>
            </div>
            <p class="numero">Número de Posts (?):</p>
            <div class="post">
                
                <p class="tituloPost">ASFafsASFasfASFASFa</p>
                <img class="fotoPost" src="resources/imgs/galaxia.webp" alt="alt"/>
                <div>
                <button class="editar">Editar</button>
                <button class="eliminar">Eliminar</button>
                </div>
                <p class="tituloPost">asfFfFfsasfASFaf</p>
                <img class="fotoPost" src="resources/imgs/nebulosa.jpg" alt="alt"/>
                <div>
                <button class="editar">Editar</button>
                <button class="eliminar">Eliminar</button>
                </div>
                <p class="tituloPost">ASFasfAFAfASFAs</p>
                <img class="fotoPost" src="resources/imgs/nebulosa.jpg" alt="alt"/>
                <div>
                <button class="editar">Editar</button>
                <button class="eliminar">Eliminar</button>
                </div>
                
                
            </div>
        </div>
            
            
            </div> 
    </body>
</html>
