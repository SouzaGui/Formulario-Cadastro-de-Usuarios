package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import util.CadastroConexao;

/**
 *
 * @author Guilherme Souza
 */
public class ClienteDAO {
    
    public void cadastrar(Cliente cliente) throws ClassNotFoundException, SQLException {
        try (Connection con = CadastroConexao.getConexao()) {
            PreparedStatement comando = con.prepareStatement("INSERT INTO Cliente (id_cliente, nomecliente, cpfcliente, idadecliente, emailcliente, celularcliente, generocliente, cidade, enderecocliente, statuscliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            comando.setInt(1, cliente.getId());
            comando.setString(2, cliente.getNome());
            comando.setString(3, cliente.getCpf());
            comando.setInt(4, cliente.getIdade());
            comando.setString(5, cliente.getEmail());
            comando.setString(6, cliente.getCelular());
            comando.setString(7, cliente.getGenero());
            comando.setString(8, cliente.getCidade());
            comando.setString(9, cliente.getEndereco());
            comando.setString(10, cliente.getStatus());
            
            comando.execute();
        }
    }
    
    
    public void atualizar(Cliente cliente) throws ClassNotFoundException, SQLException {
    Connection con = CadastroConexao.getConexao();
    String sql = "UPDATE Cliente SET nomecliente=?, cpfcliente=?, idadecliente=?, emailcliente=?, "
            + "celularcliente=?, generocliente=?, cidade=?, enderecocliente=?, statuscliente=? "
            + "WHERE id_cliente=?";
    
    try (PreparedStatement comando = con.prepareStatement(sql)) {
        comando.setString(1, cliente.getNome());
        comando.setString(2, cliente.getCpf());
        comando.setInt(3, cliente.getIdade());
        comando.setString(4, cliente.getEmail());
        comando.setString(5, cliente.getCelular());
        comando.setString(6, cliente.getGenero());
        comando.setString(7, cliente.getCidade());
        comando.setString(8, cliente.getEndereco());
        comando.setString(9, cliente.getStatus());
        comando.setInt(10, cliente.getId());
        
        comando.execute();
    } finally {
        con.close();
    }
}
    
    
    
    public void deletar(Cliente Cliente1) throws ClassNotFoundException, SQLException {
        Connection con = CadastroConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("delete from Cliente where id_cliente = ?");
        comando.setInt(1, Cliente1.getId());
        comando.execute();
        con.close();
    }
    
public Cliente consultarById(Cliente cliente) throws ClassNotFoundException, SQLException {
    try (Connection con = CadastroConexao.getConexao();
         PreparedStatement comando = con.prepareStatement("select * from Cliente where id_cliente = ?")) {

        comando.setInt(1, cliente.getId());
        ResultSet rs = comando.executeQuery();

        Cliente p = new Cliente();
        if (rs.next()) {
            p.setId(rs.getInt("id_cliente"));
            p.setNome(rs.getString("nomecliente"));
            p.setCpf(rs.getString("cpfcliente"));
            p.setIdade(rs.getInt("idadecliente"));
            p.setEmail(rs.getString("emailcliente"));
            p.setCelular(rs.getString("celularcliente"));
            p.setGenero(rs.getString("generocliente"));
            p.setCidade(rs.getString("cidade"));
            p.setEndereco(rs.getString("enderecocliente"));
            p.setStatus(rs.getString("statuscliente"));
        }

        return p;

    } catch (SQLException e) {
        System.out.println("Erro ao consultar cliente por ID: " + e.getMessage());
        throw e; // Propagar a exceção para o código que chama este método
    } catch (ClassNotFoundException e) {
        System.out.println("Erro: Driver JDBC não encontrado");
        throw e; // Propagar a exceção para o código que chama este método
    }
}


    public List<Cliente> consultarTodos() throws ClassNotFoundException, SQLException {
        

        Connection con = CadastroConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from Cliente");
        ResultSet rs = comando.executeQuery();
        List<Cliente> lcliente = new ArrayList();
        while (rs.next()) {
            Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nomecliente"));
                cliente.setCpf(rs.getString("cpfcliente"));
                cliente.setIdade(rs.getInt("idadecliente"));
                cliente.setEmail(rs.getString("emailcliente"));
                cliente.setCelular(rs.getString("celularcliente"));
                cliente.setGenero(rs.getString("generocliente"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEndereco(rs.getString("enderecocliente"));
                cliente.setStatus(rs.getString("statuscliente"));
            lcliente.add(cliente);
        }
        return lcliente;
    }
}
