package TesteJ.ProdutoTest;

import br.com.diogoAntunes.InterfaceGenerica.TipoCrudEscolhido;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ProdutoLogicaMock {
    public IProdutoDAOMock IProdutoDAOMock;

    public void executandoLogicaProduto(){
       IProdutoDAOMock = new ProdutoMapMock();
       TipoCrudEscolhido tce = new TipoCrudEscolhido();
       String opcao = JOptionPane.showInputDialog(null, "Digite 1 para cadastrar, 2 consultar, 3 modificar, 4 excluir, 5 sair, 6 todos produtos e 7 para trocar tipo CRUD.",
               "OPÇÕES", JOptionPane.INFORMATION_MESSAGE);
       while(!isOpcaoValida(opcao)){
           JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente");
           opcao = JOptionPane.showInputDialog(null, "Digite 1 para cadastrar, 2 consultar, 3 modificar, 4 excluir," +
                           " 5 sair, 6 todos produtos e 7 para trocar tipo CRUD.",
                   "OPÇÕES", JOptionPane.INFORMATION_MESSAGE);
       }

       while(isOpcaoValida(opcao)){
           if(isOpcaoCadastro(opcao)){
                String dados = JOptionPane.showInputDialog(null, "digite as informações do produto nessa ordem: " +
                        "id, nome, cor, preco e quantidade, todos separados por(,)");
           cadastrar(dados);
           }else if (isOpcaoConsultar(opcao)){
               String dados = JOptionPane.showInputDialog(null, "Digite o ID do produto que queres consultar:");
               consultar(dados);
           }else if (isOpcaoModificar(opcao)){
               String dados = JOptionPane.showInputDialog(null, "Digite o ID do produto que queres modificar:");
               modificar(dados);
           }else if (isOpcaoExcluir(opcao)){
               String dados = JOptionPane.showInputDialog(null, "Digite o ID do produto que queres excluir:");
               excluir(dados);
           }else if (isOpcaoBuscarTodosProdutos(opcao)){
               todosProdutos();
           }else if (isOpcaoSair(opcao)){
               sair();
           }else if (isOpcaoTrocarCrud(opcao)){
               tce.TipoDoCrudEscolhido();
           }opcao = JOptionPane.showInputDialog(null, "Digite 1 para cadastrar, 2 consultar, 3 modificar, " +
                           "4 excluir, 5 sair, 6 todos produtos e 7 para trocar tipo CRUD.",
                   "OPÇÕES", JOptionPane.INFORMATION_MESSAGE);
       }
    }

    private void todosProdutos() {
        Collection<ProdutoMock> produtos = IProdutoDAOMock.buscarTodos();
        if(produtos.isEmpty()){
            JOptionPane.showMessageDialog(null, "Não existem produtos cadastrados");
        }else JOptionPane.showMessageDialog(null, "Produtos cadastrados:"+ produtos.toString());

    }

    private boolean isOpcaoValida(String opcao) {
        List<String> opcoesValidas = Arrays.asList("1","2","3","4","5","6","7");
        return opcoesValidas.contains(opcao);
    }
    private boolean isOpcaoCadastro(String opcao) {
        return "1".equals(opcao);
    }
    private boolean isOpcaoConsultar(String opcao) {
        return "2".equals(opcao);
    }
    private boolean isOpcaoModificar(String opcao) {
        return "3".equals(opcao);
    }
    private boolean isOpcaoExcluir(String opcao) {
        return "4".equals(opcao);
    }
    private boolean isOpcaoSair(String opcao) {
        return "5".equals(opcao);
    }
    private boolean isOpcaoBuscarTodosProdutos(String opcao) {
        return "6".equals(opcao);
    }
    private boolean isOpcaoTrocarCrud(String opcao) {
        return "7".equals(opcao);
    }

    private void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        ProdutoMock produto = new ProdutoMock(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],dadosSeparados[4]);
        Boolean cadastravel = IProdutoDAOMock.cadastrar(produto);
        if(cadastravel){
            JOptionPane.showMessageDialog(null, "O produto foi cadastrado com sucesso!");
        }else JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o produto!");
    }
    private void consultar(String dados) {
        Long id = Long.parseLong(dados);
        ProdutoMock consultar = IProdutoDAOMock.consultar(id);
        if(consultar != null){
            JOptionPane.showMessageDialog(null, "O produto com o id: " + consultar.getId() + " foi encontrado: " + consultar.toString());
        }else JOptionPane.showMessageDialog(null, "Produto não encontrado", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }
    private void modificar(String dados) {
        Long id = Long.parseLong(dados);
        ProdutoMock verificarId = IProdutoDAOMock.consultar(id);
        if(verificarId != null){
            String nova = JOptionPane.showInputDialog(null, "digite as informações do produto nessa ordem: " +
                    "id, nome, cor, preco e quantidade, todos separados por(,)");
            String[] dadosSeparados = nova.split(",");
            ProdutoMock produtoNovo = new ProdutoMock(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],dadosSeparados[4]);
            IProdutoDAOMock.modificar(produtoNovo);
            JOptionPane.showMessageDialog(null, "O produto foi atualizado com sucesso!");
        }
    }
    private void excluir(String dados) {
        Long id = Long.parseLong(dados);
        ProdutoMock verificarId = IProdutoDAOMock.consultar(id);
        if(verificarId != null){
            IProdutoDAOMock.excluir(id);
            JOptionPane.showMessageDialog(null,"O produto foi excluído com sucesso!");
        }else JOptionPane.showMessageDialog(null, "Não foi possível achar o Produto com esse ID!");
    }

    private void sair() {
        JOptionPane.showMessageDialog(null, "Saindo", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
