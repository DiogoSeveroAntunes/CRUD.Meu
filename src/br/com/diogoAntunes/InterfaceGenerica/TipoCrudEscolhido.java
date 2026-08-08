package br.com.diogoAntunes.InterfaceGenerica;

import br.com.diogoAntunes.Client.ClienteLogica;
import br.com.diogoAntunes.Product.ProdutoLogica;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class TipoCrudEscolhido {


    public void TipoDoCrudEscolhido() {
        ProdutoLogica pl = new ProdutoLogica();
        ClienteLogica cl = new ClienteLogica();

        String opcao = JOptionPane.showInputDialog(null, "Digite 1 para entrar no crud de Cliente e 2 para o de Produto, ou se quiser sair, digite 3.");
        while (!isOpcaoValida(opcao)) {
            JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente");
            opcao = JOptionPane.showInputDialog(null, "Digite 1 para entrar no crud de Cliente e 2 para o de Produto ou 3 para Sair.");
        }
        while(isOpcaoValida(opcao)){
            if (opcao.equals("1")) {
                cl.executarLogicaCliente();
            } else if (opcao.equals("2")) {
                pl.executandoLogicaProduto();
            }else if(opcao.equals("3")){
                sair();
            }
            else opcao = JOptionPane.showInputDialog(null, "Digite 1 para entrar no crud de Cliente e 2 para o de Produto ou 3 para Sair.");
        }

    }

    private void sair() {
        JOptionPane.showMessageDialog(null,"Saindo do sistema!", "Saindo", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private boolean isOpcaoValida(String opcao) {
        List<String> valida = Arrays.asList("1","2","3");
        return valida.contains(opcao);
    }
}
