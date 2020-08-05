<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset=UTF-8">
    <title> Register User </title>
</head>
<body>
<H2>Flights</H2>
<table>
    <tr><th>AirLines</th>
    <th>Departure City</th>
    <th>Arrvial City</th>
    <th>DEparture time</th>

    </tr>
</table>

<c:forEach items="${flights}" var="flight">
<tr>
    <td>${flight.operatingAirlines}</td>
    <td>${flight.departureCity}</td>
    <td>${flight.arrivalCity}</td>
    <td>${flight.estimatedDepartureTime}</td>
    <td><a href="showCompleteReservation?flightId=${flight.id}">Select</a></td>
</tr>
</c:forEach>
</form>
</body>
</html>