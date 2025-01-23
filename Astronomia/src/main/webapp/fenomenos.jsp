<%-- 
    Document   : fenomenos
    Created on : 17 ene 2025, 22:47:44
    Author     : jl4ma
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Página Fenómenos- Jose Madero</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="resources/styles/general.css"/>
        <link rel="stylesheet" href="resources/styles/fenomenos.css"/>
        <link rel="icon" type="image/x-icon" href="resources/imgs/galaxia.webp">

    </head>
    <body>
        <header>
            <%@include file="./fragmentos/encabezado.xhtml"%>  
        </header>

        <main class="contenido">


            <section class="left-side">
                <%@include file="./fragmentos/navegador.xhtml"%>
            </section>





            <section class="right-side">
                <div class="descubrimientosContenido">
                    <!-- Bloque para posts anclados -->
                    <!-- Bloque para posts anclados -->
                    <c:forEach items="${requestScope.posts}" var="post">
                        <c:if test="${post.tipoPost == 'anclado'}">
                            <div class="anclado1">
                                <img src="./resources/${post.imagen != null ? post.imagen : 'default.jpg'}" alt="galaxy" />
                                <p class="userFecha">@${post.usuario.nombreUsuario} ${post.fechaHoraCreacion.time}</p>
                                <p class="tituloPost">${post.titulo}</p>
                                <p class="comentarios">Comentarios: (${fn:length(post.comentarios)})</p>
                            </div>
                            <!-- Vista de administrador -->
                            <c:if test="${sessionScope.usuario.tipo == 'administrador'}">
                                <div class="comentariosTodos">
                                    <c:forEach items="${post.comentarios}" var="comentario">
                                        <p class="coments">@${comentario.nombreUsuario}: ${comentario.contenido}</p>
                                        <button class="eliminar" onclick="location.href = 'EliminarComentario.jsp?id=${comentario.id}'">Eliminar</button>
                                    </c:forEach>
                                </div>
                                <div class="botones">
                                    <button class="desanclar" onclick="location.href = 'DesanclarPost.jsp?id=${post.id}'">Desanclar</button>
                                    <button class="eliminar" onclick="location.href = 'EliminarPost.jsp?id=${post.id}'">Eliminar</button>
                                </div>
                            </c:if>

                        </c:if>
                    </c:forEach>

                    <!-- Bloque para posts comunes -->
                    <c:forEach items="${requestScope.posts}" var="post">
                        <c:if test="${post.tipoPost != 'anclado'}">
                            <div class="postComun">
                                <img src="./resources/${post.imagen != null ? post.imagen : 'default.jpg'}" alt="galaxy" />
                                <p class="userFecha">@${post.usuario.nombreUsuario} ${post.fechaHoraCreacion.time}</p>
                                <p class="tituloPost">${post.titulo}</p>
                                <p class="categoriaPost">${post.contenido}</p>
                                <p class="comentarios">Comentarios: (${fn:length(post.comentarios)})</p>

                                <!-- Comentarios y acciones para usuarios comunes -->
                                <div class="comentariosTodos">
                                    <c:forEach items="${post.comentarios}" var="comentario">
                                        <p class="coments">@${comentario.nombreUsuario}: ${comentario.contenido}</p>
                                        <div id="comentarios">
                                            <!-- Aquí se cargarán los comentarios a través de JavaScript y Fetch -->
                                        </div>
                                        <!-- Vista de administrador: eliminar comentario -->
                                        <c:if test="${sessionScope.usuario.tipo == 'administrador'}">
                                            <button class="eliminar" onclick="location.href = 'EliminarComentario.jsp?id=${comentario.id}'">Eliminar</button>
                                        </c:if>

                                        <!-- Vista de usuario común: solo responder -->
                                        <c:if test="${sessionScope.usuario.tipo != 'administrador'}">
                                            <form id="comentarioForm${post.id}">
                                                <textarea id="contenido${post.id}" name="contenido" placeholder="Escribe una respuesta..." required></textarea>
                                                <input type="hidden" id="postId${post.id}" name="postId" value="${post.id}">
                                                <button type="submit">Responder</button>
                                            </form>
                                        </c:if>
                                    </c:forEach>
                                    <c:if test="${sessionScope.usuario.tipo != 'administrador'}">
                                        <form id="form-comentario-${post.id}" class="form-comentario">
                                            <textarea name="comentario" id="comentario-${post.id}" class="texto" placeholder="Escribe un comentario..." required></textarea>
                                            <input type="hidden" id="postId-${post.id}" name="postId" value="${post.id}">
                                            <button type="submit">Comentar</button>
                                        </form>
                                    </c:if>

                                    <!-- Vista de administrador -->
                                    
                                </div>
                                <c:if test="${sessionScope.usuario.tipo == 'administrador'}">
                                        <div class="botones">
                                            <button class="anclar" onclick="location.href = 'AnclarPost.jsp?id=${post.id}'">Anclar</button>
                                            <button class="eliminar" onclick="location.href = 'EliminarPost.jsp?id=${post.id}'">Eliminar</button>
                                        </div>
                                    </c:if>
                            </c:if>
                        </c:forEach>
                </div>



            </section>


        </main> 
            <script src="resources/js/AgregarComentario.js" type="application/javascript"></script>
        <footer>
            <a href="post.jsp" > <img class="agregar" src="resources/imgs/agregar.jpg" alt="alt"/></a>  
        </footer>
    </body>
</html>
