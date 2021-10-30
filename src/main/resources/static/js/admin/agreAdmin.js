function agregar() {
    //Capturar valores de los campos en el documento html
    var datos = {
        idAdmin: $("#numId").val(),
        name: $("#name").val(),
        email: $("#email").val(),
        password: $("#password").val()
    }

    //Convertimos a JSON
    let datosPeticion = JSON.stringify(datos);

    //Hacemos petición Ajax
    $.ajax({
        url: "http://localhost:8080/api/Admin/save",
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