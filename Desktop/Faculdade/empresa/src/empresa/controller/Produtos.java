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
public class Produtos {
    private int pk_produto;
    private String nome;
    private String estoqueMinimo;
    private String qtdEstoque;

    public Produtos(String nome, String estoqueMinimo, String qtdEstoque) {
        this.nome = nome;
        this.estoqueMinimo = estoqueMinimo;
        this.qtdEstoque = qtdEstoque;
    }

    public Produtos(int pk_produto, String nome, String estoqueMinimo, String qtdEstoque) {
        this.pk_produto = pk_produto;
        this.nome = nome;
        this.estoqueMinimo = estoqueMinimo;
        this.qtdEstoque = qtdEstoque;
    }

    public int getPk_produto() {
        return pk_produto;
    }

    public void setPk_produto(int pk_produto) {
        this.pk_produto = pk_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(String estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public String getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(String qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    @Override
    public String toString() {
        return "Produtos{" + "pk_produto=" + pk_produto + ", nome=" + nome + ", estoqueMinimo=" + estoqueMinimo + ", qtdEstoque=" + qtdEstoque + '}';
    }

 
   
    
    
}
