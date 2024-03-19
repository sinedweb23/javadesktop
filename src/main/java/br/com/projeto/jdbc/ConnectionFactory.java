package br.com.projeto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import br.com.projeto.jdbc.ConnectionFactory;


/**
 * Classe para criar conexões com o banco de dados MySQL.
 */
public class ConnectionFactory {
    
    /**
     * Obtém uma conexão com o banco de dados.
     * 
     * @return a conexão estabelecida
     * @throws RuntimeException se ocorrer um erro ao conectar ao banco de dados
     */
    public Connection getConnection() {
        try { 
            return DriverManager.getConnection("jdbc:mysql://localhost/bdvendas", "root", "");
        } catch (SQLException e) {
            // Imprime a pilha de rastreamento no console para diagnóstico
            e.printStackTrace();
            // Lança a exceção RuntimeException com a mensagem de erro original
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }

    /**
     * Fecha a conexão com o banco de dados.
     * 
     * @param connection a conexão a ser fechada
     */
    public void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // Imprime a pilha de rastreamento no console para diagnóstico
            e.printStackTrace();
        }
    }
}
