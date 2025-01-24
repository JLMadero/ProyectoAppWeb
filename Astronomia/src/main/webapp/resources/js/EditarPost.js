/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
document.addEventListener("DOMContentLoaded", () => {
    // Seleccionamos todos los formularios de comentarios
    const formularios = document.querySelectorAll(".form-comentarioEditar");

    // Iteramos sobre cada formulario y añadimos un evento submit
    formularios.forEach(formulario => {
        formulario.addEventListener("submit", async (event) => {
            event.preventDefault(); // Evitamos el envío normal del formulario

            const postId = formulario.querySelector("input[name='postId']").value;

            try {
                const respuesta = await fetch("EditarPost", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify({ postId }),
                });

               
            } catch (error) {
                console.error("Error en el fetch:", error);
            }
        });
    });
});
document.addEventListener("DOMContentLoaded", () => {
    // Seleccionamos todos los formularios con la clase .form-comentarioEditar
    const formularios = document.querySelectorAll(".form-comentarioEditarPost");

    // Iteramos sobre cada formulario
    formularios.forEach(formulario => {
        formulario.addEventListener("submit", async (event) => {
            event.preventDefault(); // Evitamos el envío normal del formulario

            // Crear un objeto para recolectar los datos del formulario
            const formData = new FormData(formulario);
            const data = {};

            // Convertir FormData en un objeto JSON
            formData.forEach((value, key) => {
                data[key] = value; // Agregamos cada par clave-valor
            });

            try {
                // Enviar los datos al servlet EditarPost
                const respuesta = await fetch("EditarPost", {
                    method: "GET",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify(data), // Convertimos el objeto a JSON
                });

                // Manejar la respuesta del servidor
                if (respuesta.ok) {
                    const resultado = await respuesta.json();
                    alert("Post actualizado exitosamente.");
                    console.log("Respuesta del servidor:", resultado);
                } else {
                    console.error("Error en la respuesta:", respuesta.statusText);
                    alert("Hubo un error al actualizar el post.");
                }
            } catch (error) {
                console.error("Error en el fetch:", error);
                alert("Ocurrió un error al intentar actualizar el post.");
            }
        });
    });
});

