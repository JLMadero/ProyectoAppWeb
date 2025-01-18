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
    </head>
    <body>
        <h1>ASTRONOMIA</h1>
        <p class="blog">BLOG</p>
        
        
            <form action="inicio.jsp">
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
            <p class="link">¿No tienes cuenta?, registrate <a href="registrarse.jsp">aquí.</a></p>
        
    </body>
</html>
