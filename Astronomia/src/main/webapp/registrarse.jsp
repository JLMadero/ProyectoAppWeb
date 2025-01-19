<%-- 
    Document   : registrarse
    Created on : 17 ene 2025, 22:48:37
    Author     : jl4ma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registrarse - Jose Madero</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="resources/styles/registrarse.css"/>
    </head>
    <body>
        <div class="left-side"></div> 
    
        
        <div class="right-side">
            <h1>REGISTRARSE:</h1>
            <form action="RegistrarUsuario" enctype="multipart/form-data" method="POST">
                
                <div class="column">
                    <div class="fila">
                 <label class="nombre" for="nombre">Nombres:</label>
                 <input type="text" name="nombre" required>   
                </div>
                <div class="fila">
                 <label class="apellidoP" for="apellidoP">Apellido Paterno:</label>
                 <input type="text" name="paterno" required>     
                </div>
                <div class="fila">
                <label class="apellidoM" for="apellidoM">Apellido Materno:</label>
                 <input type="text" name="materno" required>  
                </div>
                    
                </div>
                
                <div class="column">
                    <div class="fila">
                        <label class="correo" for="correo">Usuario:</label>
                        <input type="text" name="usuario" required>  
                    </div>
                    <div class="fila">
                        <label class="correo" for="correo">Correo:</label>
                        <input type="email" name="correo" required>  
                    </div>
                    <div class="fila">
                        <label class="telefono" for="telefono">Telefono:</label>
                 <input type="number" name="telefono" required>  
                    </div>
                </div>
                
                
                <div class="column"> 
                    <div class="fila">
                        <label class="ciudad" for="ciudad">Ciudad:</label>
                 <input type="text" name="ciudad" required>  
                    </div>
                    <div class="fila">
                        <label class="estado" for="estado">Estado:</label>
                 <input type="text" name="estado" required>  
                    </div>
                    <div class="fila">
                        <label class="municipio" for="municipio">Municipio:</label>
                 <input type="text" name="municipio" required>  
                    </div>
                </div>
                
                
                <div class="column">
                    <div class="fila">
                        <label class="genero" for="genero">Genero:</label>
                 <input type="text" name="ciudad" required>  
                    </div>
                    <div class="fila">
                        <label class="avatar" for="avatar">Avatar:</label>
                        <input type="file" name="avatar" accept="image/*" required>  
                    </div>
                    <div class="fila">
                        <label class="fechaN" for="fechaN">Fecha Nacimiento:</label>
                        <input type="date" name="fechaN" required>  
                    </div>
                </div>
                <div class="column">
                    <div class="fila">
                        <label class="contra" for="contra">Contraseña:</label>
                        <input type="password" name="contra" required>  
                    </div>
                    <div class="fila">
                        <label class="confirmar" for="confirmar">Confirmar Contraseña:</label>
                 <input type="password" name="confirmar" required>  
                    </div>
                </div>
                <div class="column">
                    <div class="fila">
                        <input type="submit" value="Registrarse">
                    </div>
                    <div class="fila">
                        <input type="reset" value="Limpiar">
                    </div>
                    </div>
                
            </form>
            <p>Si ya tienes una cuenta, inicia sesion <a href="index.jsp" target="target">aqui</a></p>

        </div> 
        
    </body>
</html>
