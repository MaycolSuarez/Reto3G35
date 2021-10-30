function agregar() {
    //Capturar valores de los campos en el documento html
    var datos = {
        idReservation: $("#numId").val(),
        startDate: $("#startDate").val(),
        devolutionDate: $("#devolutionDate").val(),
        client: { idClient: $("#client").val() },
        audience: { id: $("#audience").val() }
    }

    //Convertimos a JSON
    let datosPeticion = JSON.stringify(datos);

    //Hacemos petición Ajax
    $.ajax({
        url: "http://localhost:8080/api/Reservation/save",
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