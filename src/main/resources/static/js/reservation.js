var api = "http://localhost:9090/api/reservation" ;
var reservationTable;

function init(){
    console.log('inside reservation init' );

    // Add click event to button
    $("#create-reservation").click(function (){
        createReservation();
    });
    initReservationTable();

    // Get customers from backend and update DOM
    getReservations();

}

function initReservationTable() {
    console.log('inside initReservationTable' );
    // Create columns (with titles) for datatable: id, name, address, age
    columns = [
        { "title":  "Customer ID",
            "data": "id" },
        { "title":  "Name",
            "data": "name" },
        { "title":  "Date",
            "data": "nightStayedNum" },
        { "title": "Persons",
            "data": "personNum"}
//        { "title": "Seaview",
//            "data": "seaView"
//            "render": function(seaView,roomId){
//            if(seaView == true){
//            return "with sea view";
//            }else{
//            return "without sea view";}
//            }}
    ];
    // Define new table with above columns
    reservationTable = $("#reservationTable").DataTable( {
        "order": [[ 0, "asc" ]],
        "columns": columns
    });
}

function getReservations(){

    console.log('inside getReservations' );
    // http:/localhost:9090/api/reservation
    // json list of reservations
    $.ajax({
        url: api,
        type: "get",
        dataType: "json",
        contentType: "application/json; charset=UTF-8",
        success: function(reservations){
            // process the data (json) and modify the DOM

            console.log("Data..." + reservations);
                        if (reservations) {
                            reservationTable.clear();
                            reservationTable.rows.add(reservations);
                            reservationTable.columns.adjust().draw();
                        }
//            var html =
//            '<table class="table table-hover">' +
//            '<tr>' +
//            '<th>Reservation ID</th>' +
//            '<th>Name</th>' +
//            '<th>Persons</th>' +
//            '<th>Nights</th>' +
//            '</tr>';
//            $.each(reservations, function(index, reservation) {
//                html = html + '<tr>'+
//                '<td>'+ reservation.name + '</td>' +
//                '<td>'+ reservation.persons + '</td>' +
//                '<td>'+ reservation.nightsNum + '</td>' +
//                '</tr>'
//                console.log(reservation.name + ' did reservation and ' + reservation.persons + ' will stay' + reservation.nightsNum);
//            });
//
//            html = html + '</table>';
//
//            $("#reservations").html(html);

        },

        fail: function (error) {
            console.log('Error: ' + error);
        }

    });

}

function createReservation(){

    console.log('inside createReservation' );

    // Put reservation data from page in Javascript object --- SIMILAR TO JSON
    var reservationData = {
            name: $("#name").val(),
            persons: $("#persons").val(),
            nightsNum: $("#nightsNum").val()
    }

    // Transform Javascript object to json
    var reservationJSON = JSON.stringify(reservationData);

    console.log(reservationJSON);

    $.ajax({
        url: api,
        type: "post",
        data: reservationJSON,    // json for request body
        contentType: "application/json; charset=UTF-8",
        dataType: "json",
        success: function(reservation, textStatus, jqXHR){

          console.log(reservation);

          // Clear fields in page
          $("#name").val('');
          $("#nightsNum").val('');
          $("#persons").val('');

          // Refresh table data
          getReservations();

        },

        fail: function (error) {
          console.log('Error: ' + error);
        }

    });

}
