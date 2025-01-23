/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
document.addEventListener("DOMContentLoaded", () => {
    // Seleccionamos todos los formularios de comentarios
    const formularios = document.querySelectorAll(".form-comentario");

    // Iteramos sobre cada formulario y añadimos un evento submit
    formularios.forEach(formulario => {
        formulario.addEventListener("submit", async (event) => {
            event.preventDefault(); // Evitamos el envío normal del formulario

            const postId = formulario.querySelector("input[name='postId']").value;
            const comentario = formulario.querySelector("textarea[name='comentario']").value;

            try {
                const respuesta = await fetch("ComentarPost", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify({ postId, comentario }),
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
//    document.addEventListener('DOMContentLoaded', function () {
//    const form = document.getElementById('form-comentario');
//    form.addEventListener('submit', async function (event) {
//        event.preventDefault(); // Evita el envío tradicional del formulario
//
//        // Capturar los datos del formulario
//        const comentario = document.getElementById('comentario').value;
//        const postId = document.getElementById('postId').value;
//
//        // Crear el objeto JSON con los datos
//        const data = {
//            comentario: comentario,
//            postId: postId
//        };
//
//        try {
//            // Enviar la solicitud al servlet ComentarPost
//            const response = await fetch('ComentarPost', {
//                method: 'POST',
//                headers: {
//                    'Content-Type': 'application/json'
//                },
//                body: JSON.stringify(data)
//            });
//
//            if (response.ok) {
//                // Redirigir al servlet Descubrimientos para actualizar la página
//                window.location.href = 'Descubrimientos';
//            } else {
//                console.error('Error al procesar el comentario:', response.statusText);
//            }
//        } catch (error) {
//            console.error('Error en la solicitud:', error);
//        }
//    });
//});


