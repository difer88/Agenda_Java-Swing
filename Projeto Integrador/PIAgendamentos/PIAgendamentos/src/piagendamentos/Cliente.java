
package piagendamentos;

import javax.swing.JOptionPane;


public class Cliente 
{
    
    
    private String nome;
    private String sexo;
    private String cpf;
    private String telefoneFixo;
    
    

    public Cliente(String nome, String cpf, String sexo, String telefone){
        
        this.nome = nome;
        this.telefoneFixo = telefone;
        this.sexo = sexo;
        this.cpf = cpf;
        
    }
    
    
    //Setters
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }
    
    public void setSexo(String sexo)
    {
        this.sexo = sexo;
    }
    
    public void setTelFixo(String telFixo)
    {
        this.telefoneFixo = telFixo;
    }
    
    
    // Getters
    
    
    public String getNome()
    {
        return nome;
    }
    
    public String getCpf()
    {
        return cpf;
    }
    
    public String getSexo()
    {
        return sexo;
    }
    
    public String getTelFixo()
    {
        return telefoneFixo;
    }

}
