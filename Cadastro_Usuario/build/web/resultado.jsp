<%@ page import="java.util.List" %>
<%@ page import="model.Cliente" %>
<%@ page import="DAO.ClienteDAO" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
        <link rel="stylesheet" href="CSS/exibirtodos.css"/>
    </head>
    
        <h1>
              <h2>Resultado da Consulta dos Clientes</h2>


<table>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>CPF</th>
        <th>Idade</th>
        <th>Email</th>
        <th>Celular</th>
        <th>Genero</th>
        <th>Cidade</th>
        <th>Endereco</th>
        <th>Status</th>
    </tr>
    
    <%
    List<Cliente> clientes = (List<Cliente>) request.getAttribute("exibirtodos");
    %>

    <%
    if (clientes != null) {
        for (model.Cliente cliente : clientes) {
    %>

    <tr>
        <td><%= cliente.getId() %></td>
        <td><%= cliente.getNome() %></td>
        <td><%= cliente.getCpf() %></td>
        <td><%= cliente.getIdade() %></td>
        <td><%= cliente.getEmail() %></td>
        <td><%= cliente.getCelular() %></td>
        <td><%= cliente.getGenero() %></td>
        <td><%= cliente.getCidade() %></td>
        <td><%= cliente.getEndereco() %></td>
        <td><%= cliente.getStatus() %></td>
    </tr>
    <% }
    } %>
</table>
    
</html>
