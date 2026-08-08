package TesteJ.ProdutoTest;

import TesteJ.IdentificadorMock;

import java.util.Objects;

public class ProdutoMock implements IdentificadorMock {
    Long id;
    String nome;
    String cor;
    Long preco;
    Long quantidade;

    public ProdutoMock(String id, String nome, String cor, String preco, String quantidade){
        this.id = Long.valueOf(id.trim());
        this.nome = nome;
        this.cor = cor;
        this.preco = Long.valueOf(preco.trim());
        this.quantidade = Long.valueOf(quantidade.trim());
        }

        public ProdutoMock() {

        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCor() {
            return cor;
        }

        public void setCor(String cor) {
            this.cor = cor;
        }

        public Long getPreco() {
            return preco;
        }

        public void setPreco(Long preco) {
            this.preco = preco;
        }

        public Long getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(Long quantidade) {
            this.quantidade = quantidade;
        }

        @Override
        public Long IdentificadorMock() {
            return this.id;
        }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoMock that = (ProdutoMock) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
        public String toString() {
            return "\n Produto{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", cor='" + cor + '\'' +
                    ", preco=" + preco +
                    ", quantidade=" + quantidade +
                    '}' + "\n";
        }
    }


