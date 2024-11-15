package com.verdeflor.verdeflor.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity (name = "funcionarios")

public class Funcionario implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ID")
    int id;

    @Column (name = "Nome")
    String nome;

    @Column (name = "CPF")
    String cpf;

    @Column (name = "Salario")
    double salario;

    @Column (name = "dtAdmissao")
    @Temporal(TemporalType.DATE)
    Date dtAdmissao;

    @Column (name = "estaAtivo")
    boolean estaAtivo;

    public Funcionario() {}

    public Funcionario(String nome, String cpf, double salario, Date dtAdmissao, boolean estaAtivo) {
        super();
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.dtAdmissao = dtAdmissao;
        this.estaAtivo = estaAtivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getDtAdmissao() {
        return dtAdmissao;
    }

    public void setDtAdmissao(Date dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }

    public boolean getEstaAtivo() {
        return estaAtivo;
    }

    public void setEstaAtivo(boolean estaAtivo) {
        this.estaAtivo = estaAtivo;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", salario=" + salario +
                ", dtAdmissao=" + dtAdmissao +
                '}';
    }
}
