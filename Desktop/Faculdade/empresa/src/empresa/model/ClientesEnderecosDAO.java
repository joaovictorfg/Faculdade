/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa.model;

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
public class ClientesEnderecosDAO {

    public static int create(ClientesEnderecos endereco) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                    createStatement();
            //INSERT INTO clientes_enderecos(
            //pk_enderenco, fk_cliente, logradouro, bairro, cidade, estado, 
            //pais, cep)VALUES (?, ?, ?, ?, ?, ?, ?, ?);

            String sql
                    = "insert into clientes_enderecos (fk_cliente, logradouro, bairro, cidade, estado, pais, cep) values ("
                    + endereco.getFk_cliente() + ",'"
                    + endereco.getLogradouro() + "','"
                    + endereco.getBairro() + "','"
                    + endereco.getCidade() + "','"
                    + endereco.getEstado() + "','"
                    + endereco.getPais() + "','"
                    + endereco.getCep() + "')";

            System.out.println(sql);
            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            endereco.setPk_endereco(key);

            return key;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static ClientesEnderecos retreave(int pkEndereco) {
        try {
            Statement stm = BancoDados.createConnection().createStatement();//abrindo conexão no banco

            String sql = "Select * from clientes_enderecos where pk_enderenco = " + pkEndereco;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();

            return new ClientesEnderecos(rs.getString("logradouro"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("pais"),
                    rs.getString("cep"),
                    rs.getInt("pk_enderenco"),
                    rs.getInt("fk_cliente"));

        } catch (SQLException ex) {
            Logger.getLogger(ClientesEnderecosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 

        return null;
    }

    public static ClientesEnderecos retreaveByCliente(int fkCliente) {
        try {
            Statement stm = BancoDados.createConnection().createStatement();//abrindo conexão no banco

            String sql = "Select * from clientes_enderecos where fk_cliente =" + fkCliente;
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {

                return new ClientesEnderecos(rs.getString("logradouro"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("pais"),
                        rs.getString("cep"),
                        rs.getInt("pk_enderenco"),
                        rs.getInt("fk_cliente"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientesEnderecosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static ArrayList<ClientesEnderecos> retreaveAll() {
        try {
            Statement stm
                    = BancoDados.createConnection().
                    createStatement();

            String sql = "Select * from clientes_enderecos ";
            ResultSet rs = stm.executeQuery(sql);

            ArrayList<ClientesEnderecos> arrayEndereco = new ArrayList<>();

            while (rs.next()) {

                arrayEndereco.add(new ClientesEnderecos(
                        rs.getString("logradouro"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("pais"),
                        rs.getString("cep"),
                        rs.getInt("pk_enderenco"),
                        rs.getInt("fk_cliente")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClientesEnderecosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    public static void delete(ClientesEnderecos endereco){
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "delete from clientes_enderecos where pk_endereco" + endereco.getPk_endereco();
            stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ClientesEnderecosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public static void update(ClientesEnderecos endereco){
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "update clientes_enderecos set"
                    + "logradouro = " + endereco.getLogradouro()
                    + ",bairro = "+ endereco.getBairro()
                    + ",cidade = "+ endereco.getCidade()
                    +",estado ="+endereco.getEstado()
                    +",pais ="+endereco.getPais()
                    +",cep ="+ endereco.getCep()
                    + " where pk_endereco = " + endereco.getPk_endereco();
            stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ClientesEnderecosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
