<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset=UTF-8">
    <title> Start Check in  </title>
</head>
<body>
<h2> Flights DEtails : </h2>

Airline : {reservation.flight.operatingAirlines}<br/>
flightNumber : {reservation.flight.flightNumber}<br/>
departureCity : {reservation.flight.departureCity}<br/>
arrivalCity : {reservation.flight.arrivalCity}<br/>
dateOfDeparture : {reservation.flight.dateOfDeparture}<br/>
estimatedDepartures : {reservation.flight.estimatedDepartures}<br/>


<h2> Passenger DEtails : </h2>

first name : {reservation.passenger.firstname}<br/>
last name : {reservation.passenger.lastname}<br/>
email : {reservation.passenger.email}<br/>
phone : {reservation.passenger.phone}<br/>


<form action="completeCheckIn"  method="post">
Enter the number of Bags you want to check in :<input type="text"  name="numberOfBags"/>
    <input type="hidden" value="${reservation.id}" name="reservationID"/>
    <input type="submit" value="CheckIn "/>

</form>
</body>
</html>