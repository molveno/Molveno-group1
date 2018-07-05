var baseUrl = "http://localhost:8080/api/rooms"


$(document).ready(function() {

        $('#dataTable').DataTable( {
                "order": [[ 0, "asc" ]],
                "ajax": {
                        url: baseUrl,
                        dataSrc: ''
                    },
                "columns": [
                    { "data": "roomID" },
                    { "data": "roomNumber" },
                    { "data": "numberOfGuests" },
                    { "data": "price" }

                ]
         } );


//    // Functionality for interaction when clicking on rows of the table
//        $('#dataTable tbody').on( 'click', 'tr', function () {
//            if ( $(this).hasClass('selected') ) {
//                $(this).removeClass('selected');
//            }
//            else {
//                deselect();
//                $(this).addClass('selected');
//                var table = $('#dataTable').DataTable();
//                var data = table.row(this).data();
//                apiGetSingleGuest(data.id);
//                $('#myModal').modal('toggle');
//            }
//        });

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
                              });