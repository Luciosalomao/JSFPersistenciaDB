package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
        public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/projetodb", 
                "root", 
                "Senha123*" 
            );
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver não encontrado!", e);
        }
    }
}
