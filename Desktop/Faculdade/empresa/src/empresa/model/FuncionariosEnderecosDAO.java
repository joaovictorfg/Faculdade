/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa.model;

import empresa.controller.FuncionariosEnderecos;
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
public class FuncionariosEnderecosDAO {

    public static int create(FuncionariosEnderecos funcionarioEndereco) {
        try {
            Statement stm;
            stm = BancoDados.createConnection().createStatement();

            //  INSERT INTO public.funcionarios_enderecos
            //(pk_endereco, fk_funcionario, logadouro, bairro, cidade, estado, 
            //pais, cep) VALUES (?, ?, ?, ?, ?, ?,?, ?);
            String sql = "insert into funcionarios_enderecos "
                    + "(fk_funcionario, logadouro, bairro, cidade, estado, pais, cep)"
                    + "values (" + funcionarioEndereco.getPk_funcionario() + ",'"
                    + funcionarioEndereco.getLogradouro() + "','"
                    + funcionarioEndereco.getBairro() + "','"
                    + funcionarioEndereco.getCidade() + "','"
                    + funcionarioEndereco.getEstado() + ""
                    + funcionarioEndereco.getPais() + "','"
                    + funcionarioEndereco.getCep() + "')";

            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            funcionarioEndereco.setPk_funcionario(key);

            return key;

        } catch (SQLException ex) {
            Logger.getLogger(FuncionariosEnderecosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static FuncionariosEnderecos retreave(int pkEndereco) {

        try {
            Statement stm = BancoDados.createConnection().createStatement();
            String sql = "select * from funcionarios_enderecos where pk_endereco = " + pkEndereco;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();

            return new FuncionariosEnderecos(rs.getString("logradouro"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("pais"),
                    rs.getString("cep"),
                    rs.getInt("pk_endereco"),
                    rs.getInt("pk_funcionario"));
        } catch (SQLException ex) {
            Logger.getLogger(FuncionariosEnderecosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    public static FuncionariosEnderecos retreaveByFuncionario( int pk_funcionario){
        try {
            Statement stm = BancoDados.createConnection().createStatement();
            String sql = "select * from funcionarios_enderecos where fk_funcionario = "+ pk_funcionario;
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()){
                return new FuncionariosEnderecos(rs.getString("logradouro"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("pais"),
                    rs.getString("cep"),
                    rs.getInt("pk_endereco"),
                    rs.getInt("pk_funcionario"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionariosEnderecosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static ArrayList<FuncionariosEnderecos> retreaveAll(){
        try {
            Statement stm = BancoDados.createConnection().createStatement();
            String sql = "select * from funcionarios_enderecos";
            ResultSet rs = stm.executeQuery(sql);
            ArrayList<FuncionariosEnderecos> arrayFuncionariosEndereco = new ArrayList<>();
            while(rs.next()){ 
                arrayFuncionariosEndereco.add(new FuncionariosEnderecos(rs.getString("logradouro"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("pais"),
                    rs.getString("cep"),
                    rs.getInt("pk_endereco"),
                    rs.getInt("pk_funcionario")));
            }
            return arrayFuncionariosEndereco;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionariosEnderecosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return null;
    }
}
