/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.jdbc;

import javax.swing.JOptionPane;
import br.com.projeto.jdbc.ConnectionFactory;


/**
 *
 * @author Denis Augusto
 */
public class TestaConexao {
    
    public static void main(String[] args) {
        try {
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Connectado com Sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ops aconteceu o erro: "+ e);
        } 
    }
    
}
