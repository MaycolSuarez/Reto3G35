function borrar(numId) {

    var datos = {
        id: numId
    }

    let datosPeticion = JSON.stringify(datos);

    //Hacemos petición Ajax
    $.ajax({
        url: "https://g90f5e6e689aa70-retociclo3.adb.us-sanjose-1.oraclecloudapps.com/ords/admin/client/client",
        data: datosPeticion,
        type: 'DELETE',
        contentType: "application/JSON",

        success: function(respuesta) {
            console.log("BORRADO");
            listar();
        },

        error: function(xhr, status) {
            console.log(status);
        }
    });

}