function agregar() {
    //Capturar valores de los campos en el documento html
    var datos = {
        idClient: $("#numId").val(),
        name: $("#name").val(),
        email: $("#email").val(),
        password: $("#password").val(),
        age: $("#age").val()
    }

    //Convertimos a JSON
    let datosPeticion = JSON.stringify(datos);

    //Hacemos petición Ajax
    $.ajax({
        url: "http://localhost:8080/api/Client/save",
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