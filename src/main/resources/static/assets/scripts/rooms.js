var baseUrl = "http://localhost:8080/api/rooms"


$(document).ready(function() {

        $('#dataTable').DataTable( {
                "order": [[ 0, "asc" ]],
                "ajax": {
                        url: baseUrl,
                        dataSrc: ''
                    },
                "columns": [
//                    { "data": "roomID" },
                    { "data": "roomNumber" },
                    { "data": "numberOfGuests" },
                    { "data": "price" }

                ]
         } );


    // Functionality for interaction when clicking on rows of the table (MODAL in HTML)
        $('#dataTable tbody').on( 'click', 'tr', function () {
            if ( $(this).hasClass('selected') ) {
                $(this).removeClass('selected');
            }
            else {
                deselect();
                $(this).addClass('selected');
                var table = $('#dataTable').DataTable();
                var data = table.row(this).data();
                apiGetSingleRoom(data.roomID);
                $('#myModal').modal('toggle');
            }
        });

} );

$("#addButton").click(function() {

            var jsonObject = {
                roomNumber: $("#roomNumber").val(),
                numberOfGuests: $("#numberOfGuests").val(),
                price: Number($("#price").val())

            };
             $.ajax({
                    contentType : "application/json",
                     // waar moet hij de request op uitvoeren
                     url : baseUrl,
                     // type actie
                     type : "post",
                     data: JSON.stringify(jsonObject),
                     // als de actie lukt, voer deze functie uit

                 });

                 location.reload();
          });


          $("#deleteButton").click(function() {
                      var roomID = Number($("#roomToDelete").val())

                       $.ajax({
                              contentType : "application/json",
                               // waar moet hij de request op uitvoeren
                               url : baseUrl+"/" + roomID,
                               // type actie
                               type : "delete",

                               // als de actie lukt, voer deze functie uit

                           });
                           location.reload();
                    });


                    $("#updateButton").click(function() {

                                var roomID = Number($("#roomToUpdate").val())

                                var jsonObject = {
                                    roomNumber: $("#updateRoomNumber").val(),
                                    numberOfGuests: $("#updateNumberOfGuests").val(),
                                    price: Number($("#updatePrice").val())

                                };
                                 $.ajax({
                                        contentType : "application/json",
                                         // waar moet hij de request op uitvoeren
                                         url : baseUrl+"/" + roomID,
                                         // type actie
                                         type : "put",
                                         data: JSON.stringify(jsonObject),
                                         // als de actie lukt, voer deze functie uit

                                     });
                                     location.reload();
                              });

     function apiGetSingleRoom(id){
         var api = baseUrl + "/" + id;
         $.get(api, function(data){
             if (data){
                 fillUpdateDiv(data);
             }
         });
     }

function fillUpdateDiv(room){

    console.log(room);
    $("#btndelete").attr('onclick', 'submitDelete(' + room.roomID + ');');
    $("#btnsubmit").attr('onclick', 'submitEdit(' + room.roomID + ');');
    document.getElementById("modal-title").innerHTML="Edit Room";
    $("#modalRoomNumber").val(room.roomNumber);
    $("#modalNumberOfGuests").val(room.numberOfGuests);
    $("#modalPrice").val(room.price);
     /*
    $("#postalCode").val(room.postalCode);
    $("#city").val(room.city);
    $("#country").val(room.country);
    $("#phoneNumber").val(room.phoneNumber);
    $("#mailAddress").val(room.mailAddress);
    */
    $("#confirmbutton").css('display', 'inline-block');
    deleteID = room.roomID;
    var elem = '<button type="button" class="btn btn-danger" onclick="submitDelete();">Confirm delete</button>';
    $('#confirmbutton').popover({
        animation:true,
        content:elem,
        html:true,
        container: myModal
    });
}

function deselect(){
    $('#dataTable tr.selected').removeClass('selected');
    // rloman dit moet straks terug. ik denk dat dit het modal form is
    document.getElementById("roomForm").reset();
}


function submitEdit(id){
// shortcut for filling the formData as a JavaScript object with the fields in the form
    console.log("Formdata");
    var formData = $("#roomForm").serializeArray().reduce(function(result, object){ result[object.name] = object.value; return result}, {});
    console.log(formData);

    for(var key in formData){
        if(formData[key] == "" || formData == null) delete formData[key];
    }
    $.ajax({
        url:baseUrl +"/" + id,
        type:"put",
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        success: getData,
        error: function(error){
            displayError(error);
        }
    });
    deselect();
    $('#myModal').modal('toggle');
}


function getData() {
      var api = baseUrl;
        $.get(api, function(data){
            if (data){
                setData(data);
            }
        });
}

function setData(data){
    $("#dataTable").DataTable().clear();
    $("#dataTable").DataTable().rows.add(data);
    $("#dataTable").DataTable().columns.adjust().draw();
}

function submitDelete(){
    console.log("Deleting");
    var formData = $("#roomForm").serializeArray().reduce(function(result, object){ result[object.name] = object.value; return result}, {});
    var guestNumber = deleteID;
    $.ajax({
        url:baseUrl + "/" + guestNumber,
        type:"delete",
        data: JSON.stringify(formData),
        success: getData,
        contentType: "application/json; charset=utf-8"
    });

    $('#myModal').modal('toggle');
    deselect();
}