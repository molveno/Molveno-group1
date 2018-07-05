var baseUrl = "http://localhost:8080/api/guests"


$(document).ready(function() {

        $('#guestTable').DataTable( {
                "order": [[ 0, "asc" ]],
                "ajax": {
                        url: baseUrl,
                        dataSrc: ''
                    },
                "columns": [
                    { "data": "guestID" },
                    { "data": "firstName" },
                    { "data": "lastName" },
                    { "data": "address" },
                    { "data": "postalCode" },
                    { "data": "city" },
                    { "data": "country" },
                    { "data": "telephoneNumber" },
                    { "data": "emailAddress" }

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

$("#addGuestButton").click(function() {

            var jsonObject = {
                guestID: $("#guestID").val(),
                firstName: $("#firstName").val(),
                lastName: $("#lastName").val(),
                address: $("#address").val(),
                postalCode: $("#postalCode").val(),
                city: $("#city").val(),
                country: $("#country").val(),
                telephoneNumber: $("#telephoneNumber").val(),
                emailAddress: $("#emailAddress").val()

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


          $("#deleteGuestButton").click(function() {
                      var guestID = Number($("#guestToDelete").val())

                       $.ajax({
                              contentType : "application/json",
                               // waar moet hij de request op uitvoeren
                               url : baseUrl+"/" + guestID,
                               // type actie
                               type : "delete",

                               // als de actie lukt, voer deze functie uit

                           });
                           location.reload();
                    });


                    $("#updateGuestButton").click(function() {

                                var roomID = Number($("#guestToUpdate").val())

                                var jsonObject = {

                                    firstName: $("#updateFirstName").val(),
                                    lastName: $("#updateLastName").val(),
                                    address: $("#updateAddress").val(),
                                    postalCode: $("#updatePostalCode").val(),
                                    city: $("#updateCity").val(),
                                    country: $("#updateCountry").val(),
                                    telephoneNumber: $("#updateTelephoneNumber").val(),
                                    emailAddress: $("#updateEmailAddress").val()

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