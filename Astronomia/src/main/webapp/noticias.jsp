<%-- 
    Document   : noticias
    Created on : 17 ene 2025, 22:48:03
    Author     : jl4ma
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
            <c:forEach items="${requestScope.posts}" var="post">
                        <!-- Post Anclado -->
                        <c:if test="${post.tipo == 'anclado'}">
                            <div class="anclado1">
                                <img src="${pageContext.request.contextPath}/resources/imgs/${post.imagen != null ? post.imagen : 'default.jpg'}" alt="galaxy" />
                                <p class="userFecha">@${post.usuario.nombreUsuario} ${post.fechaHoraCreacion.time}</p>
                                <p class="tituloPost">${post.titulo}</p>
                                <p class="comentarios">Comentarios: (${fn:length(post.comentarios)})</p>

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
                            </div>
                        </c:if>

                        <!-- Post Común -->
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
                                        <textarea class="comentarPost" id="comentar" name="responder"></textarea>
                                        <button class="comentarPost" onclick="location.href = '?id=${comentario.id}'">Responder</button>
                                        <!-- Vista de administrador: eliminar comentario -->
                                        <c:if test="${sessionScope.usuario.tipo == 'administrador'}">
                                            <button class="eliminar" onclick="location.href = 'EliminarComentario.jsp?id=${comentario.id}'">Eliminar</button>
                                        </c:if>
                                    </c:forEach>
                                </div>

                                <!-- Sección de comentar -->
                                <textarea class="comentarPost" id="comentar" name="comentar"></textarea>
                                <button class="comentarPost" onclick="location.href = 'ComentarPost.jsp?id=${post.id}'">Comentar Post</button>

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
            <%--<div class="noticiasContenido">
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
            --%>
            </div>
            <a href="post.jsp" > <img class="agregar" src="resources/imgs/agregar.jpg" alt="alt"/></a>
        </div>
            
            
            </div> 
    </body>
</html>
