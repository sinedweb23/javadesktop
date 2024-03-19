/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import br.com.projeto.jdbc.ConnectionFactory;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Denis Augusto
 */
public class ClientesDAO {
   
    private Connection con;
    
    public ClientesDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    // Método para cadastrar um cliente
    public void cadastrarCliente(Clientes obj) {
        try {
            // Comando SQL para inserção
            String sql = "INSERT INTO tb_clientes(nome, rg, cpf, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            // Preparação do comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            
            // Definição dos parâmetros
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());
            
            // Execução do comando SQL
            stmt.executeUpdate();
            
            // Fechamento do PreparedStatement
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + e.getMessage());
        }
        
        
       
    }
    
    // Outros métodos para alterar e excluir clientes podem ser adicionados aqui
     public void alterarCliente(Clientes obj){
         
          try {
            // Comando SQL para inserção
            String sql = "update tb_clientes set nome=?, rg=?, cpf=?, email=?, telefone=?, celular=?, cep=?,"
                    + " endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id =?";
                        
            
            // Preparação do comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            
            // Definição dos parâmetros
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());
            stmt.setInt(14, obj.getId());
            
            // Execução do comando SQL
            stmt.executeUpdate();
            
            // Fechamento do PreparedStatement
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao "
                    + "Alterar cliente: " + e.getMessage());
        }
            
        }
     public void excluirCliente(Clientes obj){
         
          try {
            // Comando SQL para inserção
            String sql = "delete from tb_clientes where id = ?";
            
            // Preparação do comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            
            // Definição dos parâmetros
            stmt.setInt(1, obj.getId());
            
            
            // Execução do comando SQL
            stmt.executeUpdate();
            
            // Fechamento do PreparedStatement
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + e.getMessage());
        }
         
     }
     
     //Metodo listar todos os clientes
     
     public List<Clientes> listarClientes(){
         
         try {
             
             // 1 criar a lista
             List<Clientes> lista = new ArrayList<>();
             
             //2 criar o comando organizar e executar
             String sql = "select * from tb_clientes";
             PreparedStatement stmt =con.prepareStatement(sql);
             
             ResultSet rs = stmt.executeQuery();
             
             while(rs.next()){
                 Clientes obj = new Clientes();
                 obj.setId(rs.getInt("id"));
                 obj.setNome(rs.getString("nome"));
                 obj.setRg(rs.getString("rg"));
                 obj.setCpf(rs.getString("cpf"));
                 obj.setEmail(rs.getString("email"));
                 obj.setTelefone(rs.getString("telefone"));
                 obj.setCelular(rs.getString("celular"));
                 obj.setCep(rs.getString("cep"));
                 obj.setEndereco(rs.getString("endereco"));
                 obj.setNumero(rs.getInt("numero"));
                 obj.setComplemento(rs.getString("complemento"));
                 obj.setBairro(rs.getString("bairro"));
                 obj.setCidade(rs.getString("cidade"));
                 obj.setUf(rs.getString("estado"));
                 
                 
                 lista.add(obj);
             }
             return lista;
             
             
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Erro:" + e);
             return null;
         }
         
     }
}
