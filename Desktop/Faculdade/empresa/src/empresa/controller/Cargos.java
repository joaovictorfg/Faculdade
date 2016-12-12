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
public class Cargos {
    private int pk_cargos ;
    private String nome;
    private String descricao;

    public Cargos(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Cargos(int pk_cargos, String nome, String descricao) {
        this.pk_cargos = pk_cargos;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getPk_cargos() {
        return pk_cargos;
    }

    public void setPk_cargos(int pk_cargos) {
        this.pk_cargos = pk_cargos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Cargos{" + "pk_cargos=" + pk_cargos + ", nome=" + nome + ", descricao=" + descricao + '}';
    }
    
    
    
}
