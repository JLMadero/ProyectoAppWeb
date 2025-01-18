<%-- 
    Document   : noticias
    Created on : 17 ene 2025, 22:48:03
    Author     : jl4ma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Página Noticias - Jose Madero</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/styles/general.css"/>
    <link rel="stylesheet" href="resources/styles/noticias.css"/>

    </head>
    <body>
        <%@include file="./fragmentos/encabezado.xhtml"%>
        <div class="contenido">
            
            
        <div class="left-side">
            <%@include file="./fragmentos/navegador.xhtml"%>
        </div> 
            
            
        
    
        
        <div class="right-side">
            <div class="noticiasContenido">
                <div class="anclado1">
                    <img src="resources/imgs/galaxia.webp" alt="galaxy"/>
                        <p class="userFecha">@JoseMadero 13/01/25</p>
                        <p class="tituloPost">Una nueva Galaxia a lado de Andromeda!!!</p>
                        <p class="comentarios">Comentarios: (?) </p>
                </div>   
                <div class="anclado1">
                    <img src="resources/imgs/galaxia.webp" alt="galaxy"/>
                        <p class="userFecha">@JoseMadero 13/01/25</p>
                        <p class="tituloPost">Una nueva Galaxia a lado de Andromeda!!!</p>
                        <p class="comentarios">Comentarios: (?) </p>
                </div>
                <div class="postComun">
                        <img src="resources/imgs/galaxia.webp" alt="galaxy"/>
                        <p class="userFecha">@JoseMadero 13/01/25</p>
                        <p class="tituloPost">Una nueva Galaxia a lado de Andromeda!!!</p>
                        <p class="comentarios">Comentarios: (?) </p>
                        <div class="comentariosTodos">
                            <p class="coments">@kasdfad: Asombroso!!!</p>
                            <textarea id="responder" name="responder"></textarea>
                            <button>Responder</button>
                            <p class="coments">@kasffa: Me encanta!!!</p>
                            <textarea id="responder" name="responder"></textarea>
                            <button>Responder</button>
                            <p class="coments3">@asad: Si es asombroso.</p>
                            <textarea class="coments3" id="responder" name="responder"></textarea>
                            <button class="coments3">Responder</button>
                            <textarea class="comentarPost" id="comentar" name="comentar"></textarea>
                            <button class="comentarPost">Comentar Post</button>
                        </div>
                    </div>
            </div>
            <a href="post.jsp" > <img class="agregar" src="resources/imgs/agregar.jpg" alt="alt"/></a>
        </div>
            
            
            </div> 
    </body>
</html>
