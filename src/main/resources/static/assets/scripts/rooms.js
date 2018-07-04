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
                    { "data": "price" },
                    { "data": "numberOfGuests" }
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