function listar() {
    $.ajax({
        url: "http://localhost:8080/api/Message/all",
        type: 'GET',
        dataType: 'json',

        success: function(respuesta) {
            console.log(respuesta);
            listarRespuesta(respuesta.items);
        },

        error: function(xhr, status) {
            console.log(status);
        }
    });
}

function listarRespuesta(items) {

    var tabla = `<table border="1">
                <tr>
                    <th>Calificacion</th>
                    <th>Mensaje</th>
                    <th colspan="2">Acciones</th>
                </tr>`;

    for (let i = 0; i < items.length; i++) {
        tabla += `<tr>
                    <td>${items[i].calificacion} </td>
                    <td>${items[i].mensaje} </td>
                    <td><button onclick="editarRegistro(${items[i].id})">Editar</button> </td>
                    <td><button onclick="borrar(${items[i].id})">Borrar</button> </td>
                </tr>`;
    }

    tabla += `</table>`

    $("#listado").html(tabla)

}