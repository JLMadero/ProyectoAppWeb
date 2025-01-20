<%-- 
    Document   : post
    Created on : 17 ene 2025, 22:48:29
    Author     : jl4ma
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Crear Post - Jose Madero</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="resources/styles/general.css"/>
        <link rel="stylesheet" href="resources/styles/post.css"/>

    </head>
    <body>
        <%@include file="./fragmentos/encabezado.xhtml"%>
        <div class="contenido">
            
            
        <div class="left-side">
            <%@include file="./fragmentos/navegador.xhtml"%>
        </div> 





            <div class="right-side">
                <div class="crearPost">
                    <h2>Nuevo Post:</h2>
                    <form action="CrearPost" method="post" enctype="multipart/form-data">
                        <label for="titulo">Titulo</label>
                        <input type="text" name="titulo" required>
                        <label for="contenido">Contenido</label>
                        <textarea id="contenido" name="contenido" required></textarea>
                        <div class="imgTipo">
                            <div>
                                <label for="imagen">Imagen</label>
                                <input type="file" name="imagenPost" accept="image/*" required>
                            </div>
                            <div>
                                <label for="tipoPost">Tipo</label>  
                                <select id="opciones" name="opciones" required>
                                    <option value="" disabled selected>Selecciona una opción</option>
                                    <option value="NOTICIAS">Noticias Astronómicas</option>
                                    <option value="FENOMENO">Fenómenos Celestiales</option>
                                    <option value="PLANETAS">Planetas</option>
                                    <option value="DESCUBRIMIENTOS">Descubrimientos</option>
                                </select>
                                
                            </div>
                            <div>
                                <c:if test="${sessionScope.usuario.tipo == 'administrador'}">
                                    <label for="anclado">Anclado</label>
                                <input type="checkbox" name="isAnclado" value="anclado">
                            </c:if>
                            </div>
                            
                        </div>
                        <div class="botones">
                            
                            <input type="submit" value="Postear">
                            <input type="reset" value="Limpiar">
                        </div>
                    </form>
                </div>
            </div>


        </div> 
    </body>
</html>

