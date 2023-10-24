package Funcionarios;

import javax.persistence.*;

@Entity
@Table(name = "Funcionarios")
public class Funcionario {
    @Id
    private String cpf;
    private String cargo;
    private float salario;
    private String departamento;

    public Funcionario(){

    }
    public Funcionario(String cargo, float salario, String cpf, String departamento) {
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


    public String getCpf() {
        return cpf;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getDepartamento() {
        return departamento;
    }


    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

}
