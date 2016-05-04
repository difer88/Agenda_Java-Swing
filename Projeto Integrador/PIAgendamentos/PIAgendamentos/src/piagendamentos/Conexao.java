package piagendamentos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private Connection con;

    
    public Connection abrirConexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/db_rankuspelus", "root", "123456");
            System.out.println("Conexão efetuada com sucesso");
            return con;
        } catch (Exception e) {
            System.out.println("Erro ao abrir conexão com banco \nErro: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void fecharConexao() {
        try {
            con.close();
            System.out.println("Conexão finalizada com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao fechar conexão com o banco \nErro: " + e.getMessage());
        }
    }
}
