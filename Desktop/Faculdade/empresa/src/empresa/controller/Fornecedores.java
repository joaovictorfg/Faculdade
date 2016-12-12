/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa.controller;

/**
 *
 * @author brunn
 */
public class Fornecedores {
    private int pk_fornecedor;
    private String nome;
    private String cpf;
    
   
    private  FornecedoresEnderecos endereco;

    public Fornecedores(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Fornecedores(int pk_fornecedor, String nome, String cpf, FornecedoresEnderecos endereco) {
        this.pk_fornecedor = pk_fornecedor;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public int getPk_fornecedor() {
        return pk_fornecedor;
    }

    public void setPk_fornecedor(int pk_fornecedor) {
        this.pk_fornecedor = pk_fornecedor;
         this.endereco.setFk_fornecedor(pk_fornecedor);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public FornecedoresEnderecos getEndereco() {
        return endereco;
    }

    public void setEndereco(FornecedoresEnderecos endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Fornecedores{" + "pk_fornecedor=" + pk_fornecedor + ", nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + '}';
    }

    

  
   
}
