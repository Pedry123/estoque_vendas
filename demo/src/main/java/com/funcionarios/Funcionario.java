package com.funcionarios;

public class Funcionario {
    private String cargo;
    private float salario;
    private int cpf;
    private String departamento;

    
    public Funcionario(String cargo, float salario, int cpf, String departamento) {
        this.cargo = cargo;
        this.salario = salario;
        this.cpf = cpf;
        this.departamento = departamento;
    }


    public String getCargo() {
        return cargo;
    }


    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    public float getSalario() {
        return salario;
    }


    public void setSalario(float salario) {
        this.salario = salario;
    }


    public int getCpf() {
        return cpf;
    }


    public void setCpf(int cpf) {
        this.cpf = cpf;
    }


    public String getDepartamento() {
        return departamento;
    }


    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    

}
