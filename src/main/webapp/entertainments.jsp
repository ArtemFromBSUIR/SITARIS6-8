<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.ProductService.Entertainment" %>
<%@ page import="com.example.ProductService.EntertainmentService" %>

<%
    EntertainmentService entertainmentService = (EntertainmentService) request.getAttribute("entertainmentService");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Список мероприятий</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff9f9;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #fdc2c2;
            font-weight: bold;
        }

        p.total-cost {
            font-size: 20px;
            font-weight: bold;
            text-align: right;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Мероприятия</h1>
    <table>
        <tr>
            <th>Имя</th>
            <th>Категория</th>
            <th>Описание</th>
            <th>Цена билета</th>
            <th>Адрес</th>
        </tr>
        <% for (Entertainment entertainment : entertainmentService.getAllEntertainments()) { %>
        <tr>
            <td><%= entertainment.getName() %></td>
            <td><%= entertainment.getCategory() %></td>
            <td><%= entertainment.getDescription() %></td>
            <td><%= entertainment.getPrice() %></td>
            <td><%= entertainment.getPlace() %></td>
        </tr>
        <% } %>
    </table>
    <p class="total-cost">Общая стоимость: <%= entertainmentService.calculateTotalCost() %></p>
</div>
</body>
</html>