package Usuario;

import Conexao.Conexao;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@Named("usuario")
@SessionScoped
public class Usuario implements Serializable{
    String nome, email;
    
    public Usuario() {
        
    }
    
    public boolean Salvar() {
        int result = 0;
        
        String sql = "INSERT INTO usuario (nome, email) VALUES (?,?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, email);
            result = stmt.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e);
        }
        
        if(result == 1){
            return true;
        } else {
            return false;
        }        
    }
    
    public String submit() {
        if (this.Salvar()){
            return "resposta.xhtml";
        } else {
            return "index.xhtml";
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
