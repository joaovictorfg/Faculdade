/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa.model;

import empresa.controller.Cargos;
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
public class CargosDAO {
    
     private CargosDAO() {
    }
    
    public static int create(Cargos cargos){
        try {
            Statement stm =
                    BancoDados.createConnection().
                            createStatement();
                        

            
            String sql = 
              "insert into clientes (nome, descricao) values ('" +
                    cargos.getNome() + "','" +
                    cargos.getDescricao()+"')";
                                
            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            cargos.setPk_cargos(key);
            
            
            
            return key;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public static Cargos retreave(int pkCargo){
         try {
             Statement stm = BancoDados.createConnection().createStatement();
             String sql = "select * from cargos where pk_cargos = " + pkCargo;
             ResultSet rs = stm.executeQuery(sql);
             
             rs.next();
             
             return new Cargos(rs.getInt("pk_cargo"),
                     rs.getString("nome"),
                     rs.getString("descricao"));
                     
         } catch (SQLException ex) {
             Logger.getLogger(CargosDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return null;
    }
public static ArrayList<Cargos> retreaveAll(){
         try {
             Statement stm = BancoDados.createConnection().createStatement();
             String sql = "select * from cargos";
             ResultSet rs = stm.executeQuery(sql);
             
             ArrayList<Cargos> arrayCargos = new ArrayList<>();
             while(rs.next()){
                 arrayCargos.add(new Cargos(rs.getInt("pk_cargo"),
                     rs.getString("nome"),
                     rs.getString("descricao")));
                 
             }
             return arrayCargos;
         } catch (SQLException ex) {
             Logger.getLogger(CargosDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
    
            
    return null;
}
    
    
}
