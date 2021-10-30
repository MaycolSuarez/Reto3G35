function listar() {
    $.ajax({
        url: "http://localhost:8080/api/Client/all",
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
                    <th>Name</th>
                    <th>Email</th>
                    <th>Age</th>
                    <th>messages</th>
                    <th>reservations</th>
                </tr>`;

    for (let i = 0; i < items.length; i++) {
        tabla += `<tr>
                    <td>${items[i].name} </td>
                    <td>${items[i].email} </td>
                    <td>${items[i].age} </td>
                    <td>${items[i].messages} </td>
                    <td>${items[i].reservations} </td>
                    <td><button onclick="editarRegistro(${items[i].idClient})">Editar</button> </td>
                    <td><button onclick="borrar(${items[i].idClient})">Borrar</button> </td>
                </tr>`;
    }

    tabla += `</table>`

    $("#listado").html(tabla)

}