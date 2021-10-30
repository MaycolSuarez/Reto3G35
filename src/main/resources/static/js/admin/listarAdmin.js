function listar() {
    $.ajax({
        url: "http://localhost:8080/api/Admin/all",
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
                    <th>name</th>
                    <th>email</th>
                    <th>password</th>
                    <th colspan="2">Acciones</th>
                </tr>`;

    for (let i = 0; i < items.length; i++) {
        tabla += `<tr>
                    <td>${items[i].name} </td>
                    <td>${items[i].email} </td>
                    <td>${items[i].password} </td>
                    <td><button onclick="editarRegistro(${items[i].idAdmin})">Editar</button> </td>
                    <td><button onclick="borrar(${items[i].idAdmin})">Borrar</button> </td>
                </tr>`;
    }

    tabla += `</table>`

    $("#listado").html(tabla)

}