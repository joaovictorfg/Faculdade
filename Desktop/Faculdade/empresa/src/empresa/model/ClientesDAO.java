/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa.model;

import empresa.controller.Cliente;
import empresa.controller.ClientesEnderecos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author L
 */
public class ClientesDAO {

    public static int create(Cliente cliente) throws SQLException {

        Statement stm
                = BancoDados.createConnection().
                createStatement();
        //inset into clientes (nome, cpf) values ('joao','999')

        String sql
                = "insert into clientes (nome, cpf) values ('"
                + cliente.getNome() + "','"
                + cliente.getCpf() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        cliente.setPk_cliente(key);

        ClientesEnderecosDAO.create(cliente.getEndereco());

        return key;

    }

    public static Cliente retreave(int pk_cliente) {

        try {
            Statement stm
                    = BancoDados.createConnection().
                    createStatement();
            String sql = "select * from clientes where pk_cliente = " + pk_cliente;

            ResultSet rs = stm.executeQuery(sql);
            rs.next();

            ClientesEnderecos endereco = ClientesEnderecosDAO.retreaveByCliente(pk_cliente);
            return new Cliente(pk_cliente,
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    endereco);

        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static ArrayList<Cliente> retreaveAll() {
        try {
            Statement stm
                    = BancoDados.createConnection().
                    createStatement();

            String sql = "select * from clientes";

            ResultSet rs = stm.executeQuery(sql);

            ArrayList<Cliente> arrayClientes = new ArrayList<>();

            while (rs.next()) {
                ClientesEnderecos endereco = ClientesEnderecosDAO.retreaveByCliente(rs.getInt("pk_cliente"));

                arrayClientes.add(
                        new Cliente(
                                rs.getInt("pk_cliente"),
                                rs.getString("nome"),
                                rs.getString("cpf"),
                                endereco));
            }
            return arrayClientes;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
