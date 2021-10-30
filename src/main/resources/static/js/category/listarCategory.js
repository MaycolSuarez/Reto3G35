function listar() {
    $.ajax({
        url: "http://localhost:8080/api/Category/all",
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

    console.log(items);
    var tabla = `<table border="1">
                <tr>
                    <th>name</th>
                    <th>description</th>
                    <th>audiences</th>
                    <th colspan="2">Acciones</th>
                </tr>`;

    for (let i = 0; i < items.length; i++) {
        tabla += `<tr>
                    <td>${items[i].name} </td>
                    <td>${items[i].description} </td>
                    <td>${items[i].audiences} </td>
                    
                    <td><button onclick="editarRegistro(${items[i].id})">Editar</button> </td>
                    <td><button onclick="borrar(${items[i].id})">Borrar</button> </td>
                </tr>`;
    }

    tabla += `</table>`

    $("#listado").html(tabla)

}