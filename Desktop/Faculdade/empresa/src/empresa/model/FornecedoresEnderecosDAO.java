/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa.model;

import empresa.controller.FornecedoresEnderecos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brunn
 */
public class FornecedoresEnderecosDAO {

    public static int create(FornecedoresEnderecos fornecedorEndereco) {
        try {
            Statement stm = BancoDados.createConnection().createStatement();
            // INSERT INTO public.fornecedores_enderecos(pk_endereco, fk_fornecedor, logradouro, bairro, cidade, estado, pais, cep)
            //VALUES (?, ?, ?, ?, ?, ?, ?, ?);

            String sql = "insert into fornecedores_enderecos(pk_fornecedor, logradouro, bairro, cidade, estado, pais, cep) "
                    + "values (" + fornecedorEndereco.getFk_fornecedor() + ",'"
                    + fornecedorEndereco.getLogradouro() + "','"
                    + fornecedorEndereco.getBairro() + "','"
                    + fornecedorEndereco.getCidade() + "','"
                    + fornecedorEndereco.getEstado() + "','"
                    + fornecedorEndereco.getPais() + "','"
                    + fornecedorEndereco.getCep() + "')";

            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            fornecedorEndereco.setPk_endereco(key);
            return key;
        } catch (SQLException ex) {
            Logger.getLogger(FornecedoresEnderecosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static FornecedoresEnderecos retreave(int pkEndereco) {
        try {
            Statement stm = BancoDados.createConnection().createStatement();
            String sql = "select * from fornecedores_enderecos where pk_endereco = " + pkEndereco;

            ResultSet rs = stm.executeQuery(sql);
            rs.next();

            return new FornecedoresEnderecos(rs.getString("logradouro"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("pais"),
                    rs.getString("cep"),
                    rs.getInt("pk_endereco"),
                    rs.getInt("pk_fornecedor"));

        } catch (SQLException ex) {
            Logger.getLogger(FornecedoresEnderecosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static FornecedoresEnderecos retreaveByfornecedor( int pk_fornecedor){
        try {
            Statement stm = BancoDados.createConnection().createStatement();
            String sql = "select * from fornecedores_enderecos where pk_fornecedor =" + pk_fornecedor;
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                return new FornecedoresEnderecos(rs.getString("logradouro"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("pais"),
                    rs.getString("cep"),
                    rs.getInt("pk_endereco"),
                    rs.getInt("pk_fornecedor"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FornecedoresEnderecosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static ArrayList<FornecedoresEnderecos> retreaveAll(){
        try {
            Statement stm = BancoDados.createConnection().createStatement();
            String sql = "select * from fornecedores_enderecos";
            
            ResultSet rs = stm.executeQuery(sql);
            
            ArrayList<FornecedoresEnderecos> arrayFornecedores = new ArrayList<>();
            while(rs.next()){
                arrayFornecedores.add( new FornecedoresEnderecos(rs.getString("logradouro"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("pais"),
                    rs.getString("cep"),
                    rs.getInt("pk_endereco"),
                    rs.getInt("pk_fornecedor")));
            }
            return arrayFornecedores;
        } catch (SQLException ex) {
            Logger.getLogger(FornecedoresEnderecosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
