/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa.model;

import empresa.controller.Funcionarios;
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
public class FuncionariosDAO {

    private FuncionariosDAO() {
    }
    
    public static int create(Funcionarios funcionario){
        try {
            Statement stm = BancoDados.createConnection().createStatement();
            
          //  INSERT INTO public.funcionarios( fk_cargo, nome, cpf)
    //        VALUES (?, ?, ?, ?);

            
            String sql = "insert into funcionarios(fk_cargo, nome, cpf)"
                    + " values("+ funcionario.getPk_cargo()+",'" +funcionario.getNome() + "','" + funcionario.getCpf() + "')";
            
            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            funcionario.setPk_funcionario(key);
            
            FuncionariosEnderecosDAO.create(funcionario.getEndereco());
            
            return key;
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public static Funcionarios retreave(int pkFuncionario){
        try {
            Statement stm = BancoDados.createConnection().createStatement();
            String sql = "select * from funcionarios where pk_funcionario ="+ pkFuncionario;
            
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            FuncionariosEnderecos endereco = FuncionariosEnderecosDAO.retreave(pkFuncionario);
            return new Funcionarios(rs.getInt("pk_funcionario"),
                    rs.getString("nome"), 
                    rs.getString("cpf"),
                    rs.getInt("fk_cargo"), 
                    endereco);
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static ArrayList<Funcionarios> retreaveAll(){
        try {
            Statement stm = BancoDados.createConnection().createStatement();
            String sql = "select * from funcionarios";
            ResultSet rs = stm.executeQuery(sql);
             ArrayList<Funcionarios> arrayFuncionarios = new ArrayList<>();
            while(rs.next()){
                
            FuncionariosEnderecos endereco = FuncionariosEnderecosDAO.retreaveByFuncionario(rs.getInt("pk_funcionario"));
               
                arrayFuncionarios.add(new Funcionarios(rs.getInt("pk_funcionario"),
                    rs.getString("nome"), 
                    rs.getString("cpf"),
                    rs.getInt("fk_cargo"), 
                    endereco));
            }
            return arrayFuncionarios;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
