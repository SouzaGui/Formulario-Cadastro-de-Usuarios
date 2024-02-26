package controller;

import DAO.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cliente;

/**
 *
 * @author Guilherme Souza
 */
@WebServlet(name = "operacoes", urlPatterns = {"/operacoes"})
public class operacoes extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String op = request.getParameter("op");

            
           if (op.equals("CADASTRAR")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                String nome = request.getParameter("txtnome");
                String cpf = request.getParameter("txtcpf");
                int idade = Integer.parseInt(request.getParameter("txtidade"));
                String email = request.getParameter("txtemail");
                String celular = request.getParameter("txtcelular");
                String genero = request.getParameter("txtgenero");
                String cidade = request.getParameter("txtcidade");
                String endereco = request.getParameter("txtendereco");
                String status = request.getParameter("txtstatus");
                
                Cliente cliente1 = new Cliente();
                ClienteDAO clienteDAO = new ClienteDAO();
                
                cliente1.setId(id);
                cliente1.setNome(nome);
                cliente1.setCpf(cpf);
                cliente1.setIdade(idade);
                cliente1.setEmail(email);
                cliente1.setCelular(celular);
                cliente1.setGenero(genero);
                cliente1.setCidade(cidade);
                cliente1.setEndereco(endereco);
                cliente1.setStatus(status);
                
                
                try {
                    clienteDAO.cadastrar(cliente1);
             //       String mensagem = "Cadastro realizado com sucesso!";
                    String contextPath = request.getContextPath();
                    response.sendRedirect(contextPath + "/index.jsp?op=" + op );
                    
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }
                

            } else if (op.equals("DELETAR")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                Cliente Cliente1 = new Cliente();
                ClienteDAO ClienteDeleteDAO = new ClienteDAO();
                Cliente1.setId(id);
                try {
                    ClienteDeleteDAO.deletar(Cliente1);
                    String contextPath = request.getContextPath();
                    response.sendRedirect(contextPath + "/index.jsp?op=" + op );
                    
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }
            } else if (op.equals("ATUALIZAR")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                String nome = request.getParameter("txtnome");
                String cpf = request.getParameter("txtcpf");
                int idade = Integer.parseInt(request.getParameter("txtidade"));
                String email = request.getParameter("txtemail");
                String celular = request.getParameter("txtcelular");
                String genero = request.getParameter("txtgenero");
                String cidade = request.getParameter("txtcidade");
                String endereco = request.getParameter("txtendereco");
                String status = request.getParameter("txtstatus");
                
                Cliente clienteAtualizado = new Cliente();
                ClienteDAO clienteAtualizadoDAO = new ClienteDAO();
                
                clienteAtualizado.setId(id);
                clienteAtualizado.setNome(nome);
                clienteAtualizado.setCpf(cpf);
                clienteAtualizado.setIdade(idade);
                clienteAtualizado.setEmail(email);
                clienteAtualizado.setCelular(celular);
                clienteAtualizado.setGenero(genero);
                clienteAtualizado.setCidade(cidade);
                clienteAtualizado.setEndereco(endereco);
                clienteAtualizado.setStatus(status);
                
                try {
                    clienteAtualizadoDAO.atualizar(clienteAtualizado);
                    String contextPath = request.getContextPath();
                    response.sendRedirect(contextPath + "/index.jsp?op=" + op );
                    
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }
                
            } else if (op.equals("CONSULTAR BY ID")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                Cliente Cliente1 = new Cliente();
                ClienteDAO ClienteExibirDAO = new ClienteDAO();
                Cliente1.setId(id);
                try {
                Cliente clienteresultado = ClienteExibirDAO.consultarById(Cliente1);
                    
                    request.setAttribute("bolinha", clienteresultado);
                    request.getRequestDispatcher("resultadoconsultarbyid.jsp").forward(request, response);
                    
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }

                
                
            } else if (op.equals("CONSULTAR TODOS")) {
                try {
                           // Criar uma instância da classe DAO
                           ClienteDAO clienteDAO = new ClienteDAO();

                           // Chamar o método consultarTodos
                           List<Cliente> clientes = clienteDAO.consultarTodos();

                           // Definir a lista de clientes como atributo da requisição
                           request.setAttribute("exibirtodos", clientes);

                           // Encaminhar para a página resultado.jsp
                           request.getRequestDispatcher("resultado.jsp").forward(request, response);
                       } catch (ClassNotFoundException | SQLException e) {
                           // Lide com exceções conforme necessário
                       }
                           }

            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
