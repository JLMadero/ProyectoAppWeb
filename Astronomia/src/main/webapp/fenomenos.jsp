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

    </head>
    <body>
        <%@include file="./fragmentos/encabezado.xhtml"%>
        <div class="contenido">


            <div class="left-side">
                <%@include file="./fragmentos/navegador.xhtml"%>
            </div>





            <div class="right-side">
                <div class="descubrimientosContenido">
                    <!-- Bloque para posts anclados -->
                    <c:forEach items="${requestScope.posts}" var="post">
                        <c:if test="${post.tipo == 'anclado'}">
                            <div class="anclado1">
                                <img src="${pageContext.request.contextPath}/resources/imgs/${post.imagen != null ? post.imagen : 'default.jpg'}" alt="galaxy" />
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
                        <c:if test="${post.tipo != 'anclado'}">
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
                                        <!-- Vista de administrador: eliminar comentario -->
                                        <c:if test="${sessionScope.usuario.tipo == 'administrador'}">
                                            <button class="eliminar" onclick="location.href = 'EliminarComentario.jsp?id=${comentario.id}'">Eliminar</button>
                                        </c:if>

                                        <!-- Vista de usuario común: solo responder -->
                                        <c:if test="${sessionScope.usuario.tipo != 'administrador'}">
                                            <textarea class="comentarPost" id="comentar" name="responder"></textarea>
                                            <button class="comentarPost" onclick="location.href = '?id=${comentario.id}'">Responder</button>
                                        </c:if>
                                    </c:forEach>
                                    <c:if test="${sessionScope.usuario.tipo != 'administrador'}">
                                        <textarea class="comentarPost" id="comentar" name="comentar"></textarea>
                                        <button class="comentarPost" onclick="location.href = 'ComentarPost.jsp?id=${post.id}'">Comentar Post</button>
                                    </c:if>
                                </div>

                                <!-- Vista de administrador -->
                                <c:if test="${sessionScope.usuario.tipo == 'administrador'}">
                                    <div class="botones">
                                        <button class="anclar" onclick="location.href = 'AnclarPost.jsp?id=${post.id}'">Anclar</button>
                                        <button class="eliminar" onclick="location.href = 'EliminarPost.jsp?id=${post.id}'">Eliminar</button>
                                    </div>
                                </c:if>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>


                <a href="post.jsp" > <img class="agregar" src="resources/imgs/agregar.jpg" alt="alt"/></a>
            </div>


        </div> 
    </body>
</html>
