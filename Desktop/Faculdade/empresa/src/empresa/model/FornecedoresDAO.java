/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa.model;

import empresa.controller.Fornecedores;
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
public class FornecedoresDAO {
    
    private FornecedoresDAO() {
    }
    
    public static int create(Fornecedores fornecedor) {
        try {
            Statement stm = BancoDados.createConnection().createStatement();

            //INSERT INTO public.fornecedores( pk_fornecedor, nome, cpf) VALUES (?, ?, ?);
            String sql = "insert into forncedores(pk_fornecedor, nome, cpf) values (" + fornecedor.getPk_fornecedor() + ",'"
                    + fornecedor.getNome() + "','" + fornecedor.getCpf()+ "')";
            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            
            int key = rs.getInt(1);
            fornecedor.setPk_fornecedor(key);
            
           FornecedoresEnderecosDAO.create(fornecedor.getEndereco());
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public static Fornecedores retreave(int pkFornecedor){
        try {
            Statement stm = BancoDados.createConnection().createStatement();
            
            String sql = "select * from fornecedores where pk_fornecedor = "+ pkFornecedor;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            
            FornecedoresEnderecos endereco = FornecedoresEnderecosDAO.retreaveByfornecedor(pkFornecedor);
           
            
            return new Fornecedores(rs.getInt("pk_fornecedor"),rs.getString("nome"),rs.getString("cpf"), endereco);
        } catch (SQLException ex) {
            Logger.getLogger(FornecedoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    public static ArrayList <Fornecedores> retreaveALL(){
        
        try {
            Statement stm = BancoDados.createConnection().createStatement();
            String sql = "select * from fornecedores";
            ResultSet rs = stm.executeQuery(sql);
            
            ArrayList<Fornecedores> arrayFornecedores = new ArrayList<>();
            
            while(rs.next()){
                FornecedoresEnderecos endereco = FornecedoresEnderecosDAO.retreaveByfornecedor(rs.getInt("pk_fornecedor"));
                arrayFornecedores.add( new Fornecedores(rs.getInt("pk_fornecedor"), 
                        rs.getString("nome"), 
                        rs.getString("cpf"), 
                        endereco));
            }
            return arrayFornecedores;
        } catch (SQLException ex) {
            Logger.getLogger(FornecedoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
}
