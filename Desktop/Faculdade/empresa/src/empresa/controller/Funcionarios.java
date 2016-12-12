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
public class Funcionarios {

    private int pk_funcionario;
    private String nome;
    private String cpf;

    private int pk_cargo;
    private FuncionariosEnderecos endereco;

    public Funcionarios(int pk_cargo, String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.pk_cargo = pk_cargo;
    }

    public Funcionarios(int pk_funcionario, String nome, String cpf, int pk_cargo, FuncionariosEnderecos endereco) {
        this.pk_funcionario = pk_funcionario;
        this.nome = nome;
        this.cpf = cpf;
        this.pk_cargo = pk_cargo;
        this.endereco = endereco;
    }

    public int getPk_funcionario() {
        return pk_funcionario;
    }

    public void setPk_funcionario(int pk_funcionario) {
        this.pk_funcionario = pk_funcionario;
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

    public int getPk_cargo() {
        return pk_cargo;
    }

    public void setPk_cargo(int pk_cargo) {
        this.pk_cargo = pk_cargo;
    }

    public FuncionariosEnderecos getEndereco() {
        return endereco;
    }

    public void setEndereco(FuncionariosEnderecos endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Funcionarios{" + "pk_funcionario=" + pk_funcionario + ", nome=" + nome + ", cpf=" + cpf + ", pk_cargo=" + pk_cargo + ", endereco=" + endereco + '}';
    }

    
}
