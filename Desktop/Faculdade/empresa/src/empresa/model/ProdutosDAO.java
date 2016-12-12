/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa.model;

import empresa.controller.Produtos;
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
public class ProdutosDAO {
     private ProdutosDAO() {
    }
    
    public static int create(Produtos produtos){
        try {
            Statement stm =
                    BancoDados.createConnection().
                            createStatement();
                       

           // pk_produto, nome, estoque_minimo, qtd_estoque)
            String sql = 
              "insert into produtos (nome , estoque_minimo, qtd_estoque) values ('" +
                    produtos.getNome() + "','" +
                   produtos.getEstoqueMinimo() +"','" +
                   produtos.getQtdEstoque() + "')" ;
                  
                                
            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            produtos.setPk_produto(key);
            
           
            
            return key;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public static Produtos retreave( int pkProduto){
         try {
             Statement stm = BancoDados.createConnection().createStatement();
             String sql = "select * from produtos where pk_produto = " + pkProduto;
             ResultSet rs = stm.executeQuery(sql);
             rs.next();
             
             return new Produtos(rs.getInt("pk_produto"), 
                     rs.getString("nome"),
                     rs.getString("estoqueMinimo"), 
                     rs.getString("qtdEstoque"));
         } catch (SQLException ex) {
             Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return null;
    }
    
    public static ArrayList<Produtos> retreaveAll(){
         try {
             Statement stm = BancoDados.createConnection().createStatement();
             String sql = "select * from produtos";
             ResultSet rs = stm.executeQuery(sql);
             ArrayList<Produtos> arrayProdutos = new ArrayList<>();
             
             while(rs.next()){
                 arrayProdutos.add(new Produtos(rs.getInt("pk_produto"), 
                         rs.getString("nome"),
                         rs.getString("estoqueMinimo"), 
                         rs.getString("qtdEstoque")));
             }
             return arrayProdutos;
         } catch (SQLException ex) {
             Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
    }
    
}
