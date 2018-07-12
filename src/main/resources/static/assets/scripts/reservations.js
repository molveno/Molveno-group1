var baseUrl = "http://localhost:8080/api/reservations"

guests = {


};

rooms = {};

$(document).ready(function() {

        $('#dataTable').DataTable( {
                "order": [[ 0, "asc" ]],
                "ajax": {
                        url: baseUrl,
                        dataSrc: 'reservations'
                    },
                "columns": [

                    { "data": "allGuestsByFirstNameAndLastName" },
                    { "data": "allRoomsByRoomNumber" },
                    { "data": "checkInDate" },
                    {"data": "checkOutDate"},
                    {"data": "comments"},
                    {"data": "checkInStatus"}


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
                apiGetSingleReservation(data.reservationID); // NOOIT VARIABLEN MET HOOFDLETTERS!!!!!!
                $('#myModal').modal('toggle');
            }
        });


        getData();

} );



$("#addReservation").click(function() {

            var jsonObject = {
                guests: [{"guestID": $("#guest").val()}],
                rooms: [{"roomID": $("#room").val()}],
                checkInDate: Number($("#checkInDate").val()), // TODO
                checkOutDate: $("#checkOutDate").val(),
                comments: $("#comments").val(),
                checkInStatus: $("#checkInStatus").val()


            };




             $.ajax({
                    contentType : "application/json",
                     // waar moet hij de request op uitvoeren
                     url : baseUrl,
                     // type actie
                     type : "post",
                     data: JSON.stringify(jsonObject),
                     // als de actie lukt, voer deze functie uit
                     success: function(data) {
                        console.log(data);
                     }

                 });

//                 location.reload();
          });


     function apiGetSingleReservation(id){
         var api = baseUrl + "/" + id;
         $.get(api, function(data){
             if (data){
                 fillUpdateDiv(data);
             }
         });
     }

function fillUpdateDiv(reservation){

    console.log("Hallo?")

    console.log(reservation);
    $("#btndelete").attr('onclick', 'submitDelete(' + reservation.reservationID + ');');
    $("#btnsubmit").attr('onclick', 'submitEdit(' + reservation.reservationID + ');');
    document.getElementById("modal-title").innerHTML="Edit Reservation";


//    $("#modalGuest").val({"guestID": $("#guest")}]);
//    $("#modalRoom").val([{"roomID": $("#room")}]);
    fillGuestsInModal(guests);
    fillRoomsInModal(rooms);
//    $("#modalGuest").val(reservation.guests[0].guestFirstAndLastName);
//    $("#modalRoom").val(reservation.rooms[0].roomNumber);
    $("#modalCheckInDate").val(reservation.checkInDate);
    $("#modalCheckOutDate").val(reservation.checkOutDate);
    $("#modalComments").val(reservation.comments);
    $("#modalCheckInStatus").val(reservation.checkInStatus);

    $("#confirmbutton").css('display', 'inline-block');
    deleteID = reservation.reservationID;
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
    document.getElementById("reservationForm").reset();
}


function submitEdit(id){
// shortcut for filling the formData as a JavaScript object with the fields in the form
    console.log("Formdata");
    var formData = $("#reservationForm").serializeArray().reduce(function(result, object){ result[object.name] = object.value; return result}, {});
    console.log(formData);

    for(var key in formData){
        if(formData[key] == "" || formData == null) delete formData[key];
    }
    $.ajax({
        url:baseUrl +"/" + id,
//        dataSrc: 'reservations',
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
                // setData(data.reservations);
                $("#dataTable").dataTable().api().ajax.reload();

                guests = data.guests;
                rooms = data.rooms;

                fillGuests(data.guests);
                fillRooms(data.rooms);
            }
        });
}

function fillGuestsInModal(guests) {

    var r = "";

    guests.forEach(function(guest){
        console.log(guest)
        r+= "<option value='"+guest.guestID+"'>"+guest.guestFirstAndLastName+"</option>";
    });

    console.log(r);

    $("#modalGuest").html(r);

}

function fillRoomsInModal(rooms) {

    var r = "";

   rooms.forEach(function(room){
        console.log(room)
        r+= "<option value='"+room.roomID+"'>"+room.roomNumber+"</option>";
    });

    console.log(r);

    $("#modalRoom").html(r);

}

function fillGuests(guests) {

//    for(var guest in guests){
//        console.log(guest);
//    }

    var r = "";

    guests.forEach(function(guest){
        console.log(guest)
        r+= "<option value='"+guest.guestID+"'>"+guest.guestFirstAndLastName+"</option>";
    });

    console.log(r);

    $("#guest").html(r);

}

function fillRooms(rooms) {

    var r = "";

    rooms.forEach(function(room){
        console.log(room)
        r+= "<option value='"+room.roomID+"'>"+room.roomNumber+"</option>";
    });

    console.log(r);

    $("#room").html(r);

}



function setData(data){
    $("#dataTable").DataTable().clear();
    $("#dataTable").DataTable().rows.add(data);
    $("#dataTable").DataTable().columns.adjust().draw();
}

function submitDelete(){
    console.log("Deleting");
    var formData = $("#reservationForm").serializeArray().reduce(function(result, object){ result[object.name] = object.value; return result}, {});
    $.ajax({
        url:baseUrl + "/" + deleteID,
        type:"delete",
        data: JSON.stringify(formData),
        success: getData,
        contentType: "application/json; charset=utf-8"
    });

    $('#myModal').modal('toggle');
    deselect();
}

