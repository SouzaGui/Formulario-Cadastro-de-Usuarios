
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Guilherme Souza
 */
public class CadastroConexao {
    
    public static Connection getConexao() throws ClassNotFoundException, SQLException {

        // O método forName carrega e inicia o driver passado por parâmetro
        Class.forName("com.mysql.cj.jdbc.Driver");
        String URL = "jdbc:mysql://localhost:3306/projetoPedro";
        String USER = "root";
        String PASSWORD = "admin";
        // Estabelecendo a conexão
        return DriverManager.getConnection(URL, USER, PASSWORD);
        

    }
}
