/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
    function fetchComments(postId) {
        fetch(`ComentarioServlet?postId=${postId}`)
            .then(response => response.json())
            .then(data => {
                const comentariosDiv = document.getElementById('comentarios');
                comentariosDiv.innerHTML += `<p class="coments">@${data.usuario.nombreUsuario}: ${data.contenido}</p>`;
            })
            .catch(error => console.error('Error fetching comments:', error));
    }

    document.addEventListener('DOMContentLoaded', function() {
         form.addEventListener('submit', function(e) {
            e.preventDefault();
            const postId = form.querySelector('[id^="postId"]').value;
            const contenido = form.querySelector('[id^="contenido"]').value;

            fetch(`ComentarioServlet`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ contenido: contenido, postId: postId })
            })
            .then(response => response.json())
            .then(data => {
                const comentariosDiv = document.getElementById(`comentarios${postId}`);
                comentariosDiv.innerHTML += `<p class="coments">@${data.usuario.nombreUsuario}: ${data.contenido}</p>`;
                form.querySelector('[id^="contenido"]').value = ''; // Limpiar el textarea
            })
            .catch(error => console.error('Error posting comment:', error));
    });
    });


