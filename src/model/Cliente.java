/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

public class Cliente {

    private int id;
    private String cpf;
    private String nome;
    private Date dataNascimento;
    private double altura;
    private double peso;

//    public Cliente(int id, String cpf, String nome, Date dataNascimento, double altura, double peso) {
//        this.id = id;
//        this.cpf = cpf;
//        this.nome = nome;
//        this.dataNascimento = dataNascimento;
//        this.altura = altura;
//        this.peso = peso;
//    }

    public Cliente() {        
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double calcularImc() {
        double imc = this.peso / Math.pow(this.altura, 2);
        imc = Math.round(imc * 100) / 100;
        System.out.println(imc);
        return imc;
    }

    public String pesoIdealAdulto(Cliente cliente) {
        double imc = cliente.calcularImc();

        if (imc < 16) {
            return "Seu IMC é de " + imc + ", o que configura 'Magreza grau III'.";
        } else if (imc >= 16 && imc < 16.9) {
            return "Seu IMC é de " + imc + ", o que configura 'Magreza Grau II'.";
        } else if (imc >= 17 && imc < 18.4) {
            return "Seu IMC é de " + imc + ", o que configura 'Magreza Grau I'.";
        } else if (imc >= 18.5 && imc < 24.9) {
            return "Seu IMC é de " + imc + ", o que configura 'Eutrofia'.";
        } else if (imc >= 25 && imc < 29.9) {
            return "Seu IMC é de " + imc + ", o que configura 'Sobrepeso'.";
        } else if (imc >= 30 && imc < 34.9) {
            return "Seu IMC é de " + imc + ", o que configura 'Obesidade Grau I'.";
        } else if (imc >= 35 && imc < 40) {
            return "Seu IMC é de " + imc + ", o que configura 'Obesidade Grau II'.";
        } else if (imc > 40) {
            return "Seu IMC é de " + imc + ", o que configura 'Obesidade Grau III'.";
        } else {
            return "Não foi possível calcular o IMC.";
        }
    }
}
