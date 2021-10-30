$(document).ready(function() {
    $("#btnGuardar").hide();


})

function editarRegistro(numId) {
    $("#btnGuardar").show();
    $("#btnAgregar").hide();
    $("#btnListar").hide();
    $("#numId").prop('disabled', true);
    $("#nombre").focus();


    var datos = {
        id: numId
    }

    let datosPeticion = JSON.stringify(datos);

    $.ajax({
        url: "https://g90f5e6e689aa70-retociclo3.adb.us-sanjose-1.oraclecloudapps.com/ords/admin/client/client/" + numId,
        type: 'GET',
        dataType: 'json',

        success: function(respuesta) {
            var items = respuesta.items;

            $("#numId").val(items[0].id);
            $("#name").val(items[0].name);
            $("#email").val(items[0].email);
            $("#age").val(items[0].age);
            console.log(items);
        },

        error: function(xhr, status) {
            console.log(status);
        }
    });



}

function actualizar() {
    var datos = {
        id: $("#numId").val(),
        name: $("#name").val(),
        email: $("#email").val(),
        age: $("#age").val()
    }

    $("#btnGuardar").hide();
    $("#btnAgregar").show();
    $("#btnListar").show();
    $("#numId").prop('disabled', false);
    $("#numId").focus();

    //Convertimos a JSON
    let datosPeticion = JSON.stringify(datos);

    //Hacemos petición Ajax
    $.ajax({
        url: "https://g90f5e6e689aa70-retociclo3.adb.us-sanjose-1.oraclecloudapps.com/ords/admin/client/client",
        data: datosPeticion,
        type: 'PUT',
        contentType: "application/JSON",

        success: function(respuesta) {
            console.log("Actualizado");
            listar();
        },

        error: function(xhr, status) {
            console.log(status);
        }
    });
}