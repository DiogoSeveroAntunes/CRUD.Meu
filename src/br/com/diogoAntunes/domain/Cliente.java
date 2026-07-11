package br.com.diogoAntunes.domain;

import java.util.Objects;

public class Cliente {
    public String nome;
    public Long cpf;
    public String estado;
    public Long telefone;
    public String cidade;
    public String endereco;

    public Cliente(String nome, String cpf, String estado, String cidade, String endereco, String telefone ){
        this.nome = nome.trim();
        this.cpf = Long.valueOf(cpf.trim());
        this.estado = estado.trim();
        this.cidade = cidade.trim();
        this.endereco = endereco.trim();
        this.telefone = Long.valueOf(telefone.trim());

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", estado='" + estado + '\'' +
                ", telefone=" + telefone +
                ", cidade='" + cidade + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
