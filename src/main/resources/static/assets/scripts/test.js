//$(document).ready(started);

// instead of started .. and mostly done ...

var baseUrl = "http://localhost:8080/api"

function showOurRooms() {

     $.ajax({
                    // waar moet hij de request op uitvoeren
                    url : baseUrl+"/rooms",
                    // type actie
                    type : "get", // zelfde commandos als in rest controller?
                    // als de actie lukt, voer deze functie uit
                    success: function(data){ // so the data is the bulb of the response of the Spring Boot REST controller

                    	roomList = "";

                    	$.each(data, function(index, current){ // index (the index starting from 0, current: the current object of the iterable

                    		roomList += createRoomString(current);

                    	});

                    	$("#roomList").html(roomList);
                    }
                });


}

$(document).ready(function() {
     console.log("Ready ... page loaded"); // check if connection works (inspect html page)



// what is this doing now????
     $("#addButton").click(function() {

            var jsonObject = {
                firstName: $("#firstName").val(),
                lastName: $("#lastName").val(),
                yearOfBirth: Number($("#yearOfBirth").val())
            };
             $.ajax({
                    contentType : "application/json",
                     // waar moet hij de request op uitvoeren
                     url : baseUrl+"persons",
                     // type actie
                     type : "post",
                     data: JSON.stringify(jsonObject),
                     // als de actie lukt, voer deze functie uit
                     success: function(data){ // so the data is the bulb of the response of the Spring Boot REST controller

                            $("#newId").html(data.id);
                            $("#newFirstName").html(data.firstName);
                            $("#newLastName").html(data.lastName);

                            $("#addedPerson").show(2000);

                            $("#addedPerson").hide(2000);

                          console.log(data);
                     }
                 });
          });
});


function createRoomString(room) {
 result = "<tr><td>"+room.roomID+"</td><td>"+room.roomNumber+"</td><td>"+room.price+"</td></tr>";

  return result;
}





