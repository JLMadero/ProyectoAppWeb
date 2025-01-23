/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
document.addEventListener("DOMContentLoaded", () => {
    // Seleccionamos todos los formularios de comentarios
    const formularios = document.querySelectorAll(".form-comentarioEliminarComentario");

    // Iteramos sobre cada formulario y añadimos un evento submit
    formularios.forEach(formulario => {
        formulario.addEventListener("submit", async (event) => {
            event.preventDefault(); // Evitamos el envío normal del formulario
            // Mostrar mensaje de confirmación al usuario
            const confirmacion = confirm("¿Estás seguro de que deseas eliminar este comentario?");
            
            if (!confirmacion) {
                // Si el usuario cancela, salimos de la función
                return;
            }

            const postId = formulario.querySelector("input[name='postId']").value;

            try {
                const respuesta = await fetch("EliminarComentario", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify({ postId }),
                });

                if (respuesta.ok) {
                    // Recargar la página (puedes cambiar esto para actualizar solo una sección si prefieres)
                    window.location.reload();
                } else {
                    console.error("Error al enviar el comentario");
                }
            } catch (error) {
                console.error("Error en el fetch:", error);
            }
        });
    });
});

