<%-- 
    Document   : EditarPost
    Created on : 23 ene 2025, 19:31:07
    Author     : jl4ma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Post - Jose Madero</title>
        <link rel="stylesheet" href="resources/styles/general.css"/>
        <link rel="stylesheet" href="resources/styles/post.css"/>
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
                <div class="crearPost">
                    <h2>Nuevo Post:</h2>
                    <form class="form-comentarioEditarPost" enctype="multipart/form-data">
                        <label for="titulo">Titulo</label>
                        <input type="text" name="titulo" value="${posts.titulo}" required>
                        <label for="contenido">Contenido</label>
                        <textarea id="contenido" name="contenido" required>${posts.contenido}</textarea>
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
            </section>


        </main>
        
    </body>
</html>
