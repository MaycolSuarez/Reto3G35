function agregar() {
    //Capturar valores de los campos en el documento html
    var datos = {
        name: $("#name").val(),
        owner: $("#owner").val(),
        capacity: $("#capacity").val(),
        description: $("#description").val(),
        category: { id: $("#category_id").val() }
    }

    //Convertimos a JSON
    let datosPeticion = JSON.stringify(datos);

    //Hacemos petición Ajax
    $.ajax({
        url: "http://localhost:8080/api/Audience/save",
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