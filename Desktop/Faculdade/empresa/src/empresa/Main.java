/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa;

import empresa.controller.Cliente;
import empresa.controller.ClientesEnderecos;
import empresa.model.ClientesDAO;

import empresa.model.ClientesEnderecosDAO;
import empresa.view.TelaControleClientes;
import java.util.ArrayList;

/**
 *
 * @author L
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Cliente c = new Cliente("Batista", "6633613");
        
       // ClientesEnderecos e = new ClientesEnderecos("Rua das bolinhas", "Bairro Feliz", "Mhos", "GO", "BR", "75650000");
        //c.setEndereco(e);
        
      //  ClientesDAO.create(c);
        
    //    Funcionarios f = new Funcionarios(1, "Lucas", "121212");
     //    FuncionariosEnderecos fe = new FuncionariosEnderecos("Rua das Kriptonitas", "Pedrinhas", "Morrinhos", "GO", "Brasil", "75650000");
     //    f.setEndereco(fe);
     //    FuncionariosDAO.create(f);
     //    System.out.println(f.getEndereco());
     
        
           
          // Cliente cliente = ClientesDAO.retreave(5);
           //System.out.println(cliente);
           
       //    ArrayList<Cliente> arrayCliente = ClientesDAO.retreaveAll();
         //  for(Cliente cliente:arrayCliente){
           //    System.out.println(cliente);
         //  }
         new TelaControleClientes().setVisible(true);
    }
    
}
