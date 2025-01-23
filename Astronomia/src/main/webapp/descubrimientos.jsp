<%-- 
    Document   : descubrimientos
    Created on : 17 ene 2025, 22:55:23
    Author     : jl4ma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Página Descubrimientos - Jose Madero</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="resources/styles/general.css"/>
        <link rel="stylesheet" href="resources/styles/descubrimientos.css"/>
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

                                        <form id="form-comentario-${comentario.id}" class="form-comentarioEliminarComentario">
                                            <input type="hidden" id="postId-${comentario.id}" name="postId" value="${comentario.id}">
                                            <button class="eliminar" type="submit">Eliminar</button>
                                        </form>
                                    </c:forEach>
                                </div>
                                <div class="botones">
                                    <form id="form-comentario-${post.id}" class="form-comentarioDesanclar">
                                        <input type="hidden" id="postId-${post.id}" name="postId" value="${post.id}">
                                        <button class="desanclar" type="submit">Desanclar</button>
                                    </form>
                                    <form id="form-comentario-${post.id}" class="form-comentarioEliminar">
                                        <input type="hidden" id="postId-${post.id}" name="postId" value="${post.id}">
                                        <button class="eliminar" type="submit">Eliminar</button>
                                    </form>
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
                                        <c:forEach items="${comentario.respuesta}" var="respuesta">
                                            <p class="coments">@${respuesta.nombreUsuario}: ${respuesta.contenido}</p>

                                            <!-- Vista de administrador: eliminar comentario -->
                                            <c:if test="${sessionScope.usuario.tipo == 'administrador'}">
                                                <form id="form-comentario-${respuesta.id}" class="form-comentarioEliminarComentarioRespuesta">
                                            <input type="hidden" id="postId-${respuesta.id}" name="postId" value="${respuesta.id}">
                                            <button class="eliminar" type="submit">Eliminar</button>
                                        </form>
                                            </c:if>
                                        </c:forEach>
                                        <!-- Vista de administrador: eliminar comentario -->
                                        <c:if test="${sessionScope.usuario.tipo == 'administrador'}">
                                            <form id="form-comentario-${comentario.id}" class="form-comentarioEliminarComentario">
                                            <input type="hidden" id="postId-${comentario.id}" name="postId" value="${comentario.id}">
                                            <button class="eliminar" type="submit">Eliminar</button>
                                        </form>
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


                                </div>
                                <!-- Vista de administrador -->
                                <c:if test="${sessionScope.usuario.tipo == 'administrador'}">
                                    <div class="botones">
                                        <form id="form-comentario-${post.id}" class="form-comentarioAnclar">
                                            <input type="hidden" id="postId-${post.id}" name="postId" value="${post.id}">
                                            <button class="anclar" type="submit">Anclar</button>
                                        </form>
                                        <form id="form-comentario-${post.id}" class="form-comentarioEliminar">
                                            <input type="hidden" id="postId-${post.id}" name="postId" value="${post.id}">
                                            <button class="eliminar" type="submit">Eliminar</button>
                                        </form>
                                    </div>
                                </c:if>
                            </c:if>
                        </c:forEach>
                        <%--<div class="segundoPost">
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
                        --%>
                    </div>

            </section>


        </main> 
        <script src="resources/js/AgregarComentario.js" type="application/javascript"></script>
        <script src="resources/js/AnclarPost.js" type="application/javascript"></script>
        <script src="resources/js/DesanclarPost.js" type="application/javascript"></script>
        <script src="resources/js/EliminarPost.js" type="application/javascript"></script>
        <script src="resources/js/EliminarComentario.js" type="application/javascript"></script>

        <footer>
            <a href="post.jsp" > <img class="agregar" src="resources/imgs/agregar.jpg" alt="alt"/></a>
        </footer>
</html>
