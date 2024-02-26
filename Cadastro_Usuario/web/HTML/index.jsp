<%-- 
    Document   : index
    Created on : 3 de dez de 2023, 14:12:23
    Author     : Guilherme Souza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Cadastrar Usuário</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../CSS/style.css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@10/dist/sweetalert2.min.css">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </head>
    <body>
       
        <form name="f1" action="operacoes" method="GET">
            <h1>Gerenciamento de Usuários</h1>
            ID: <input type="text" name="txtid"><BR><BR>
            NOME: <input type="text" name="txtnome"><BR><BR>
            EMAIL: <input type="text" name="txtemail"><BR><BR>
            CPF: <input type="text" name="txtcpf">
            IDADE: <input type="text" name="txtidade"><BR><BR>
            CELULAR: <input type="text" name="txtcelular">
            GÊNERO: <input type="text" name="txtgenero"><BR><BR>
            CIDADE: <input type="text" name="txtcidade"><BR><BR>
            ENDEREÇO: <input type="text" name="txtendereco"><BR><BR>
            STATUS: <input type="text" name="txtstatus"><BR><BR>
            
            
            
            <input type="submit" name="op" value="CADASTRAR">
            <input type="submit" name="op" value="ATUALIZAR">
            <input type="submit" name="op" value="CONSULTAR BY ID">
            <input type="submit" name="op" value="CONSULTAR TODOS">
            <input type="submit" name="op" value="DELETAR">
        </form> 
        
      
        

<%
    // Lógica para obter a operação da URL
    String operacao = request.getParameter("op");

    if (operacao != null && !operacao.isEmpty()) {
        if (operacao.equals("CADASTRAR")) {
%>
            <script>
                // SweetAlert para inserção
                Swal.fire({
                    icon: 'success',
                    title: 'Inserção realizada com sucesso!',
                    showConfirmButton: false,
                    timer: 1500
                });
                
                var urlSemOp = window.location.href.split('?')[0];
                window.history.replaceState({}, document.title, urlSemOp);
            </script>
<%
        } else if (operacao.equals("ATUALIZAR")) {
%>
            <script>
                // SweetAlert para atualização
                Swal.fire({
                    icon: 'success',
                    title: 'Atualização realizada com sucesso!',
                    showConfirmButton: false,
                    timer: 1500
                });
                
                var urlSemOp = window.location.href.split('?')[0];
                window.history.replaceState({}, document.title, urlSemOp);
            </script>
<%
        } else if (operacao.equals("DELETAR")) {
%>
            <script>
                // SweetAlert para exclusão
                Swal.fire({
                    icon: 'success',
                    title: 'Exclusão realizada com sucesso!',
                    showConfirmButton: false,
                    timer: 1500
                });
                
                var urlSemOp = window.location.href.split('?')[0];
                window.history.replaceState({}, document.title, urlSemOp);
            </script>
<%
        }
    }
%>


</body>
</html>