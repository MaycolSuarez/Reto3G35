function listar() {
    $.ajax({
        url: "http://localhost:8080/api/Reservation/all",
        type: 'GET',
        dataType: 'json',

        success: function(respuesta) {
            console.log(respuesta);
            listarRespuesta(respuesta);
        },

        error: function(xhr, status) {
            console.log(status);
        }
    });
}

function listarRespuesta(items) {

    var tabla = `<table border="1">
                <tr>
                    <th>startDate</th>
                    <th>Devolution Date</th>
                    <th>status</th>
                    <th>Audience</th>
                    <th>Client</th>
                    <th>Score</th>
                    <th colspan="2">Acciones</th>
                </tr>`;

    for (let i = 0; i < items.length; i++) {
        tabla += `<tr>
                    <td>${items[i].startDate} </td>
                    <td>${items[i].devolutionDate} </td>
                    <td>${items[i].status} </td>
                    <td>${items[i].client.name} </td>
                    <td>${items[i].audience.name} </td>
                    <td>${items[i].score} </td>
                    <td><button onclick="editarRegistro(${items[i].id})">Editar</button> </td>
                    <td><button onclick="borrar(${items[i].id})">Borrar</button> </td>
                </tr>`;
    }

    tabla += `</table>`

    $("#listado").html(tabla)

}