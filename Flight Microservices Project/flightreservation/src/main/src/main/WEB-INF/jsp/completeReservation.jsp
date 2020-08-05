<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset=UTF-8">
    <title> Complete Resevation </title>
</head>
<body>
<h2>Complete Reservation </h2>
AirLine: ${flight.operatingAirline}<br/>
departureCity: ${flight.departureCity}<br/>
arrivalCity: ${flight.arrivalCity}<br/>

<form  action="completeReservation" method="post">
        <pre>
        <h2>Passenger Detail:</h2>
        First Name:<input type="text" name="passengerFirstName"/>
        Last Name:<input type="text" name="passengerLastName"/>
        Email:<input type="text" name="passengerEmail"/>
        Phone:<input type="text" name="passengerPhone"/>


        <h2>Card Details </h2>
        Name on the Card:<input type="text" name="nameOnTheCard"/>
        Card no:<input type="text" name="cardNumber"/>
        Expiry Date:<input type="text" name="expirationDate"/>
        Three Digit:<input type="text" name="securityCode"/>
        </pre>
</form>

<input type="hidden" name="flightId" value="${flight.id}"/>
<input type="submit"  value="confirm"/>
</form>
</body>
</html>