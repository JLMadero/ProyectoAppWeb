<%-- 
    Document   : index
    Created on : 17 ene 2025, 22:47:06
    Author     : jl4ma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Astronomia Blog - Jose Madero</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resources/styles/login.css"/>
        <link rel="icon" type="image/x-icon" href="resources/imgs/galaxia.webp">
    </head>
    <body>
        <header>
          <h1>ASTRONOMIA</h1>
        <p class="blog">BLOG</p>  
        </header>
        
        
        <main>
            <section>
        <form action="IniciarSesion" method="post">
                <div class="form-gruop">
                    <label class="correo" for="correo">CORREO:</label>
                <input type="email" name="correo" required>
                </div>
                <div class="form-gruop">
                    <label class="contra" for="contra">CONTRASEÑA:</label>
                <input type="password" name="contra" required>
                </div>
                <div class="form-gruop">
                <input type="submit" value="Ingresar">
                </div>
                
            </form>
            </section>
        </main>
        <footer>
            <p class="link">¿No tienes cuenta?, registrate <a href="registrarse.jsp">aquí.</a></p>
        </footer>
            
        
    </body>
</html>
