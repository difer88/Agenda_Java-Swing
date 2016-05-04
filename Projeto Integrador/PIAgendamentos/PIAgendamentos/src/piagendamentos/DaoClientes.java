package piagendamentos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DaoClientes {

    
    private Connection con;
    private Statement statement;
    private Cliente cliente;

    
    
    public void salvarCliente(Cliente cliente) {

        Conexao conexao = new Conexao();
        con = conexao.abrirConexao();

        String query = "INSERT INTO clientes (nome, sexo, cpf, telefone) VALUES (?,?,?,?)";

        PreparedStatement stnt;

        try {

            stnt = con.prepareStatement(query);

            stnt.setString(1, cliente.getNome());
            stnt.setString(2, cliente.getSexo());
            stnt.setString(3, cliente.getCpf());
            stnt.setString(4, cliente.getTelFixo());

            stnt.executeUpdate();

            conexao.fecharConexao();

        } catch (SQLException ex) {
            System.out.println("Erro ao importar dados para o banco \nErro: " + ex.getMessage());
        }
    }

    
    
    public Cliente pesquisaCliente(String numeroCpf) {

        Conexao conexao = new Conexao();
        con = conexao.abrirConexao();

        String nome;
        String sexo;
        String telFixo;
        String cpf;

        try {
            PreparedStatement cmd;

            String query = "SELECT * from clientes WHERE Cpf like ?";

            cmd = con.prepareStatement(query);

            cmd.setString(1, numeroCpf);

            ResultSet rs = cmd.executeQuery();

            rs.next();

            nome = rs.getString("Nome");
            cpf = rs.getString("Cpf");
            sexo = rs.getString("Sexo");
            telFixo = rs.getString("Telefone");

            Cliente clienteTeste = new Cliente(nome, numeroCpf, sexo, telFixo);

            return clienteTeste;

        } catch (SQLException ex) {
            System.out.println("CPF nao encontrado");
            conexao.fecharConexao();
            return null;
        }
    }
    
    

    public boolean verificaDuplicidade(String numeroCpf) {

        boolean duplicidade = false;

        Conexao conexao = new Conexao();
        con = conexao.abrirConexao();

        PreparedStatement cmd;

        String query = "SELECT * from clientes WHERE Cpf like ?";

        try {
            
            cmd = con.prepareStatement(query);

            cmd.setString(1, numeroCpf);

            ResultSet rs = cmd.executeQuery();

            while (rs.next()) {

                if (rs.getString("Cpf").equals(numeroCpf)) {
                    duplicidade = true;
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexao.fecharConexao();

        return duplicidade;

    }
}
