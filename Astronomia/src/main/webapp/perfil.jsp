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
                        <img class="fotoPost" src="${pageContext.request.contextPath}/resources/imgs/${post.getImagen()}" alt="alt"/>
                        <div>
                            <button class="editar" onclick="location.href = 'EditarPost.jsp?id=${post.getId()}'">Editar</button>
                            <button class="eliminar" onclick="location.href = 'EliminarPost.jsp?id=${post.getId()}'">Eliminar</button>
                        </div>
                    </c:forEach>
                </div>
                <a href="post.jsp" > <img class="agregar" src="resources/imgs/agregar.jpg" alt="alt"/></a>
            </div> 
        </div>
    </body>
</html>
