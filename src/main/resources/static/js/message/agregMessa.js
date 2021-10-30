function agregar() {
    //Capturar valores de los campos en el documento html
    var datos = {
        idMessage: $("#numId").val(),
        messageText: $("#messageText").val(),
        client: { idClient: $("#client").val() },
        audience: { id: $("#audience").val() }
    }

    //Convertimos a JSON
    let datosPeticion = JSON.stringify(datos);

    //Hacemos petición Ajax
    $.ajax({
        url: "http://localhost:8080/api/Message/save",
        data: datosPeticion,
        type: 'POST',
        contentType: "application/JSON",

        success: function(respuesta) {
            console.log("Insertado");
            listar();
        },

        error: function(xhr, status) {
            console.log(status);
        }
    });
}