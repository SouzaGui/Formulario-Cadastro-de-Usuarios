<%-- 
    Document   : resultadoconsultarbyid
    Created on : 09/11/2023, 11:51:52
    Author     : Guilherme Souza
--%>

<%@page import="model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado Consultar By ID</title>
        <link rel="stylesheet" href="CSS/resultadobyid.css"/>
        <link rel="stylesheet" href="CSS/exibirtodos.css"/>
    </head>
<body>
    <h1>Resultado Consultar By ID</h1>

    <%
        Cliente clienteConsultado = (Cliente) request.getAttribute("bolinha");
        if (clienteConsultado != null) {
    %>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>Idade</th>
                    <th>Email</th>
                    <th>Celular</th>
                    <th>Genero</th>
                    <th>Cidade</th>
                    <th>Endereço</th>
                    <th>Status</th>
                </tr>
                <tr>
                    <td><%= clienteConsultado.getId() %></td>
                    <td><%= clienteConsultado.getNome() %></td>
                    <td><%= clienteConsultado.getCpf() %></td>
                    <td><%= clienteConsultado.getIdade() %></td>
                    <td><%= clienteConsultado.getEmail() %></td>
                    <td><%= clienteConsultado.getCelular() %></td>
                    <td><%= clienteConsultado.getGenero() %></td>
                    <td><%= clienteConsultado.getCidade() %></td>
                    <td><%= clienteConsultado.getEndereco() %></td>
                    <td><%= clienteConsultado.getStatus() %></td>
                </tr>
            </table>
    <%
        } else {
            out.println("Cliente não encontrado");
        }
    %>
</body>

</html>
