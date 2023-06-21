/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    // Nome do seu usuário mysql
    private static final String USERNAME = "root";

    // Senha do seu banco mysql
    private static final String PASSWORD = "mulinhas";

    // "Caminho//Porta/Nome do seu banco de dados"
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/academia";

    /*
        Conexão com o banco de dados
     */
    public static Connection createConnectionToMySql() throws ClassNotFoundException, SQLException {
        // Faz com que a classe seja carregada pela JMV
        String driverName = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverName);

        // Cria a conexão com o banco de dados
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        return connection;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Recuperar uma conexão com o banco de dados caso haja
        Connection con = createConnectionToMySql();

        // Testar se conexão é nula
        if (con != null) {
            System.out.println("Conexão bem sucedida!");
            con.close();
        }
    }
}
