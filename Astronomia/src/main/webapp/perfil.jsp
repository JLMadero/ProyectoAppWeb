<%-- 
    Document   : perfil
    Created on : 17 ene 2025, 22:48:13
    Author     : jl4ma
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String referer = request.getHeader("referer");
    if (referer != null && !referer.isEmpty()) {
        session.setAttribute("returnTo", referer);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Perfil - Jose Madero</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="resources/styles/general.css"/>
        <link rel="stylesheet" href="resources/styles/perfil.css"/>
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
                <div class="avatar">
                    <div>
                        <img src="${pageContext.request.contextPath}/${sessionScope.usuario.getAvatar()}" alt="avatar"/>
                    </div>
                    <div>
                        <p class="user">@${sessionScope.usuario.getNombreUsuario()}</p>
                        <p class="locacion">${sessionScope.usuario.getCiudad()}</p>
                    </div>
                </div>

                <p class="numero">Número de Posts (${fn:length(requestScope.listaPosts)}):</p>

                <div class="post">
                    <c:forEach items="${requestScope.listaPosts}" var="post">
                        <p class="tituloPost">${post.getTitulo()}</p>
                        <img class="fotoPost" src="./resources/${post.getImagen()}" alt="alt"/>
                        <c:if test="${sessionScope.usuario.tipo == 'administrador'}">
                            <form id="form-comentario-${post.id}" class="form-comentarioEditar">
                                <input type="hidden" id="postId-${post.id}" name="postId" value="${post.id}">
                                <button class="editar" type="submit">Editar</button>
                            </form>
                            <form id="form-comentario-${post.id}" class="form-comentarioEliminar">
                                <input type="hidden" id="postId-${post.id}" name="postId" value="${post.id}">
                                <button class="eliminar" type="submit">Eliminar</button>
                            </form>

                        </c:if>
                        <div>
                            <c:if test="${sessionScope.usuario.tipo != 'administrador'}">
                                <form id="form-comentario-${post.id}" class="form-comentarioEditar">
                                    <input type="hidden" id="postId-${post.id}" name="postId" value="${post.id}">
                                    <button class="editar" type="submit">Editar</button>
                                </form>
                            </c:if>
                        </div>
                    </c:forEach>
                </div>
                <a href="post.jsp" > <img class="agregar" src="resources/imgs/agregar.jpg" alt="alt"/></a>  
            </section> 
        </main>
        <script src="resources/js/EliminarPost.js" type="application/javascript"></script>
        <script src="resources/js/EditarPost.js" type="application/javascript"></script>

    </body>
</html>
