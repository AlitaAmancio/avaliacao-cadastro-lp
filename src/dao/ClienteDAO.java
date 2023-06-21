/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import factory.ConnectionFactory;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import model.Cliente;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAO {

    // Formata a data e hora para o padrão BR
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    /*
    CRUD
    C - CREATE
    R - READ
    U - UPDATE
    D - DELETE
     */
    public void cadastrar(Cliente cliente) {
        String sql = "INSERT INTO clientes(cpf, nome, dataNascimento, altura, peso) VALUES (?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // Cria uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySql();

            // Cria uma PreparedStatement para executar uma query
            pstm = conn.prepareStatement(sql);

            // Adicionar valores esperados pela query
            pstm.setString(1, cliente.getCpf());
            pstm.setString(2, cliente.getNome());
            pstm.setDate(3, new Date(cliente.getDataNascimento().getTime()));
            pstm.setDouble(4, cliente.getAltura());
            pstm.setDouble(5, cliente.getPeso());

            // Executar a query
            pstm.execute();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);

        } finally {
            // Fecha conexões abertas
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void update(Cliente cliente) {
        String sql = "UPDATE clientes SET cpf = ?, nome = ?, dataNascimento = ?, altura = ?, peso = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // Criar conexão com o banco
            conn = ConnectionFactory.createConnectionToMySql();

            // Criar classe para executar a query
            pstm = conn.prepareStatement(sql);

            // Adicionar os valores para atualizar
            pstm.setString(1, cliente.getCpf());
            pstm.setString(2, cliente.getNome());
            pstm.setDate(3, new Date(cliente.getDataNascimento().getTime()));
            pstm.setDouble(4, cliente.getAltura());
            pstm.setDouble(5, cliente.getPeso());

            // Identificando o Id do registro que será atualizado
            pstm.setInt(6, cliente.getId());

            // Executar a query
            pstm.execute();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public List<Cliente> getClientes() throws SQLException {
        String sql = "SELECT * FROM clientes";
        List<Cliente> clientes = new ArrayList<Cliente>();

        Connection conn = null;
        PreparedStatement pstm = null;

        // Classe que irá recuperar os dados do banco
        ResultSet rset = null;
        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while (rset.next()) {
                Cliente cliente = new Cliente();

                // Recuperar id
                cliente.setId(rset.getInt("id"));
                // Recuperar cpf
                cliente.setCpf(rset.getString("cpf"));
                //Recuperar nome
                cliente.setNome(rset.getString("nome"));
                //Recuperar data de nascimento
                cliente.setDataNascimento(rset.getDate("dataNascimento"));
                //Recuperar altura
                cliente.setAltura(rset.getDouble("altura"));
                //Recuperar peso
                cliente.setPeso(rset.getDouble("peso"));

                // Comando que adiciona o cliente na lista
                clientes.add(cliente);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return clientes;
    }

    public Cliente getClientePorId(int id) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        // Classe que irá recuperar os dados do banco
        ResultSet rset = null;
        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);

            rset = pstm.executeQuery();

            Cliente cliente = new Cliente();

            while (rset.next()) {
                // Recuperar id
                cliente.setId(rset.getInt("id"));
                // Recuperar cpf
                cliente.setCpf(rset.getString("cpf"));
                //Recuperar nome
                cliente.setNome(rset.getString("nome"));
                //Recuperar data de nascimento
                cliente.setDataNascimento(rset.getDate("dataNascimento"));
                //Recuperar altura
                cliente.setAltura(rset.getDouble("altura"));
                //Recuperar peso
                cliente.setPeso(rset.getDouble("peso"));
            }

            // Comando que retorna o cliente encontrado
            System.out.println("Cliente encontrado pelo id: " + cliente.getId());
            return cliente;

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void deleteById(int id) throws SQLException {
        String sql = "DELETE FROM clientes WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);

            pstm.execute();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public List<Cliente> getClientePorNome(String nome) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE nome LIKE ?";
        List<Cliente> clientesPorNome = new ArrayList<Cliente>();

        Connection conn = null;
        PreparedStatement pstm = null;

        // Classe que irá recuperar os dados do banco
        ResultSet rset = null;
        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, "%" + nome + "%");

            rset = pstm.executeQuery();

            while (rset.next()) {
                Cliente cliente = new Cliente();

                // Recuperar id
                cliente.setId(rset.getInt("id"));
                // Recuperar cpf
                cliente.setCpf(rset.getString("cpf"));
                //Recuperar nome
                cliente.setNome(rset.getString("nome"));
                //Recuperar data de nascimento
                cliente.setDataNascimento(rset.getDate("dataNascimento"));
                //Recuperar altura
                cliente.setAltura(rset.getDouble("altura"));
                //Recuperar peso
                cliente.setPeso(rset.getDouble("peso"));

                // Comando que adiciona o cliente na lista
                clientesPorNome.add(cliente);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return clientesPorNome;
    }

    public boolean clienteExiste(String cpf) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE cpf = ?";
        boolean existe = false;

        Connection conn = null;
        PreparedStatement pstm = null;

        // Classe que irá recuperar os dados do banco
        ResultSet rset = null;
        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cpf);

            rset = pstm.executeQuery();

            Cliente cliente = new Cliente();

            while (rset.next()) {
                // Altera o booleano caso o cliente já esteja cadastrado
                existe = true;
            }

            // Comando que retorna o cliente encontrado
            System.out.println("Cliente encontrado pelo id: " + cliente.getId());
            return existe;

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    // Método que salva as informações + imc do cliente em um arquivo de texto no desktop
    public void baixarInformacoes(int id) throws ParseException, IOException, SQLException {
        Cliente cliente = new ClienteDAO().getClientePorId(id);

        //Verifique corretamente o caminho
        // Realize substituições como "Área de Trabalho" para "Desktop" caso seu sistema esteja em Ingês
        String caminho = System.getProperty("user.home") + "/OneDrive/Área de Trabalho";

        String nome = cliente.getNome();
        LocalDateTime now = LocalDateTime.now();
        String hoje = String.valueOf(LocalDate.now());
        String filePath = caminho + "/relatorio " + nome + " " + hoje + ".txt";
        String relatorio = "RELATÓRIO DE PROGRESSO" + "\n"
                + "==============================================================================" + "\n"
                + "Cpf: " + cliente.getCpf() + "\n"
                + "Nome: " + nome + "\n"
                + "Data de Nascimento: " + sdf.format(cliente.getDataNascimento()) + "\n"
                + "Peso: " + cliente.getPeso() + "\n"
                + "Altura: " + cliente.getAltura() + "\n"
                + "Índice de Massa Corporal (IMC) no momento do cálculo : " + cliente.calcularImc() + "\n"
                + "Parecer sobre IMC: " + cliente.pesoIdealAdulto(cliente) + "\n"
                + "==============================================================================" + "\n"
                + "Emitido em: " + dtf.format(now);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(relatorio);
            JOptionPane.showMessageDialog(null, "O relatório de " + nome + " foi salvo na área de trabalho.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao tentar salvar o arquivo: " + e.getMessage());
        }
    }
}
