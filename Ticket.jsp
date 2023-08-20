<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*,booking.Calculation,booking.Ticket,booking.Passenger,booking.Passengers" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Booking Details</title>
    <style>
        .center {
            text-align: center;
        }
        table {
            width: 100%;
            border:none;
        }
        th, td {
            border:none;
            padding: 5px;
            text-align: center;
        }
    </style>
</head>
<body>
    <h3 class="center" style="color: green;">Your tickets are successfully booked</h3>
    
    <table>
        <tr>
            <th>BOOKED FROM</th>
            <th>Date</th>
            <th>TO</th>
        </tr>
        <tr>
            <td><%=((Ticket) request.getAttribute("ticket")).getFrom()%></td>
            <td><%=((Ticket) request.getAttribute("ticket")).getDate()%></td>
            <td><%=((Ticket) request.getAttribute("ticket")).getTo()%></td>
        </tr>
    </table>
    <br><br>
    <table>
        <tr>
            <th>PNR number</th>
            <th>Train Name</th>
            <th>CLASS</th>
        </tr>
        <tr>
            <td><%=((int) request.getAttribute("pnr"))%></td>
            <td><%=((Ticket) request.getAttribute("ticket")).getTrain()%></td>
            <td><%=((Ticket) request.getAttribute("ticket")).getClas()%></td>
        </tr>
    </table>
    
    <br><br>
    
    <h4 class="center">Passenger Details:</h4>
    <br>
    
    <table>
        <tr>
            <th>slno</th>
            <th>PassengerName</th>
            <th>Gender</th>
            <th>Age</th>
            <th>Berth</th>
        </tr>
        <%
        List<Passenger> pass = (List<Passenger>)request.getAttribute("passengers");
                                        if (pass != null) {
                                            for (Passenger p : pass) {
        %>
        <tr>
            <td><%= p.getSlno() %></td>
            <td><%= p.getName() %></td>
            <td><%= p.getGender() %></td>
            <td><%= p.getAge() %></td>
            <td><%= p.getBerth() %></td>
        </tr>
        <% }
        } %>
    </table>
</body>
</html>
