package model.dao;

import connection.MyConnection;
import model.bean.Cliente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class ClienteDAO {
    private String tabela = "Clientes";
    private Connection connection;
    private String query;

    public boolean inserirCliente(Cliente cliente){
       connection = MyConnection.getConexaoMysql();
       query = "INSERT INTO " + tabela + " (NOME, TELEFONE, EMAIL, SENHA) VALUES (?,?,?,?)";
       try {
           PreparedStatement stmt = connection.prepareStatement(query);
           stmt.setString(1,cliente.getNome());
           stmt.setString(2,cliente.getTelefone());
           stmt.setString(3,cliente.getEmail());
           stmt.setString(4,cliente.getSenha());

           stmt.execute();
           stmt.close();
           return TRUE;

       } catch (SQLException e) {
           e.printStackTrace();
       }
        return FALSE;
    }
    public boolean atualizarCliente(Cliente cliente){
        connection = MyConnection.getConexaoMysql();
        query = "UPDATE " + tabela + " SET NOME = ?, TELEFONE = ?, EMAIL = ?, SENHA = ? WHERE ID = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2,cliente.getTelefone());
            stmt.setString(3,cliente.getEmail());
            stmt.setString(4,cliente.getSenha());
            stmt.setInt(5,cliente.getId());

            stmt.executeUpdate();
            return TRUE;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FALSE;
    }
    public boolean deletarCliente(Cliente cliente){
        connection = MyConnection.getConexaoMysql();
        query = "DELETE FROM " + tabela + " WHERE ID = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, cliente.getId());

            stmt.executeUpdate();
            return TRUE;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return FALSE;
    }
    public ArrayList<Cliente> selecionaTodosRegistros(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        connection = MyConnection.getConexaoMysql();
        query = "SELECT ID, NOME, TELEFONE, EMAIL, SENHA FROM " + tabela;
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
               clientes.add(new Cliente(rs.getInt(1), rs.getString(2),
                       rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  clientes;
    }
    public Cliente selecionaPeloId(int id){
        Cliente cliente = new Cliente();
        connection = MyConnection.getConexaoMysql();
        query = "SELECT ID, NOME, TELEFONE, EMAIL, SENHA FROM " + tabela + " WHERE ID = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                cliente.setId(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setTelefone(rs.getString(3));
                cliente.setEmail(rs.getString(4));
                cliente.setSenha(rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }
}
