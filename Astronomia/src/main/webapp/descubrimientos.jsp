<%-- 
    Document   : descubrimientos
    Created on : 17 ene 2025, 22:55:23
    Author     : jl4ma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Página Descubrimientos - Jose Madero</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="resources/styles/general.css"/>
        <link rel="stylesheet" href="resources/styles/descubrimientos.css"/>

    </head>
    <body>
        <%@include file="./fragmentos/encabezado.xhtml"%>
        <div class="contenido">
            
            
        <div class="left-side">
            <%@include file="./fragmentos/navegador.xhtml"%>
        </div> 





            <div class="right-side">
                <div class="descubrimientosContenido">
                    
                    <div class="segundoPost">
                        <div class="postComun2">
                        <img src="resources/imgs/galaxia.webp" alt="galaxy"/>
                        <p class="userFecha">@JoseMadero 13/01/25</p>
                        <p class="tituloPost">Una nueva Galaxia a lado de Andromeda!!!</p>
                        <p class="comentarios">Comentarios: (?) </p>
                        
                    </div>
                        <div class="botones">
                            
                        <button class="desanclar">Desanclar</button>
                        <button class="eliminar">Eliminar</button>
                        </div>
                    </div>
                    <div class="primerPost">
                    <div class="postComun">
                        <img src="resources/imgs/galaxia.webp" alt="galaxy"/>
                        <p class="userFecha">@JoseMadero 13/01/25</p>
                        <p class="tituloPost">Una nueva Galaxia a lado de Andromeda!!!</p>
                        <p class="comentarios">Comentarios: (?) </p>
                        <div class="comentariosTodos">
                            <p class="coments">@kasdfad: Asombroso!!!</p>
                            <button>Eliminar</button>
                            <p class="coments">@kasffa: Me encanta!!!</p>
                            <button>Eliminar</button>
                            <p class="coments3">@asad: Si es asombroso.</p>
                            <button class="coments3">Eliminar</button>
                        </div>
                    </div>
                    <div class="botones">
                        <button class="anclar">Anclar</button>
                        <button class="eliminar">Eliminar</button>
                    </div>
                    </div>
                </div>

                <a href="postAdmin.html" > <img class="agregar" src="resources/imgs/agregar.jpg" alt="alt"/></a>
            </div>


        </div> 
</html>
