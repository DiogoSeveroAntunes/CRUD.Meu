package br.com.diogoAntunes.domain;

import br.com.diogoAntunes.Interface.ClienteMap;
import br.com.diogoAntunes.Interface.IClienteDAO;


import javax.swing.*;
import java.util.Collection;

public class App {
    private static IClienteDAO IClienteDao;

    public static void main(String[] args) {
        IClienteDao = new ClienteMap();
        String opcao = JOptionPane.showInputDialog(null,
                "digite 1 para cadastrar,2 consultar,3 modificar,4 excluir e 5 sair.",
                "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoValida(opcao)) {
            if("".equals(opcao)){
                JOptionPane.showMessageDialog(null, "Opção inválida");
                opcao = JOptionPane.showInputDialog(null,
                        "digite 1 para cadastrar,2 consultar,3 modificar,4 excluir e 5 sair.",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            }else JOptionPane.showMessageDialog(null, "Opção inválida");
            opcao = JOptionPane.showInputDialog(null,
                    "digite 1 para cadastrar,2 consultar,3 modificar,4 excluir e 5 sair.",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        }
        while (isOpcaoValida(opcao)) {
            if (isOpcaoCadastrar(opcao)) {
                String dados = opcao = JOptionPane.showInputDialog(null,
                        "digite o seu Nome, Cpf, Estado, Cidade, Endereço e telefone, nessa ordem e todos separados por (,)",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            } else if (isOpcaoConsultar(opcao)) {
                String dados = opcao = JOptionPane.showInputDialog(null,
                        "digite o CPF que desejas buscar:",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);
            } else if (isOpcaoModificar(opcao)) {
                String dados = opcao = JOptionPane.showInputDialog(null,
                        "digite o CPF que desejas modificar:",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                modificar(dados);

            } else if (isOpcaoExcluir(opcao)) {
                String dados = opcao = JOptionPane.showInputDialog(null,
                        "digite o CPF que desejas excluir:",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                excluir(dados);
            } else if (isOpcaoSair(opcao)) {
                sair();
            }
                opcao = JOptionPane.showInputDialog(null,
                        "digite 1 para cadastrar,2 consultar,3 modificar,4 excluir e 5 sair.",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    private static Boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) ||
                "4".equals(opcao) || "5".equals(opcao)) {
            return true;
        }return false;
    }

    private static boolean isOpcaoCadastrar(String opcao) {
        if ("1".equals(opcao)) {
            return true;
        }return false;
    }
    private static boolean isOpcaoConsultar(String opcao) {
        if ("2".equals(opcao)) {
            return true;
        }return false;
    }
    private static boolean isOpcaoModificar(String opcao) {
        if ("3".equals(opcao)) {
            return true;
        }return false;
    }private static boolean isOpcaoExcluir(String opcao) {
        if("4".equals(opcao)){
            return true;
        }return false;
    }
    private static boolean isOpcaoSair(String opcao) {
        if ("5".equals(opcao)) {
            return true;
        }return false;
    }




    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        Cliente cliente = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3], dadosSeparados[4], dadosSeparados[5]);
        Boolean podeCadastrar = IClienteDao.cadastrar(cliente);
        if (podeCadastrar) {
            JOptionPane.showMessageDialog(null, "O cliente foi cadastrado com sucesso!");
        }else JOptionPane.showMessageDialog(null, "O cliente já está cadastrado!");
    }
    private static void consultar(String dados){
        Long cpf = Long.parseLong(dados);
        Cliente cliente = IClienteDao.consultar(cpf);
        if(cliente != null){
            JOptionPane.showMessageDialog(null, "O cliente foi encontrado: " + cliente.toString());
        }else JOptionPane.showMessageDialog(null, "O cliente não foi encontrado!" );
    }
    private static void modificar(String dados) {
        Long cpf = Long.parseLong(dados);
        Cliente cliente = IClienteDao.consultar(cpf);
        if(cliente !=null){
           String novosDados = JOptionPane.showInputDialog(null,
                    "digite o seu Nome, Cpf, Estado, Cidade, Endereço e telefone, nessa ordem e todos separados por (,)",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);
           String[] dadosSeparados = novosDados.split(",");
           Cliente clienteAtualizado = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3], dadosSeparados[4], dadosSeparados[5]);
           IClienteDao.modificar(clienteAtualizado);
           JOptionPane.showMessageDialog(null, "cliente atualizado com sucesso!");
        }
    }
    private static void excluir(String dados){
        Long cpf = Long.parseLong(dados);
        Cliente cliente = IClienteDao.consultar(cpf);
        if(cliente !=null){
            IClienteDao.excluir(cpf);
            JOptionPane.showMessageDialog(null,"O cliente foi excluído com sucesso!");
        }else JOptionPane.showMessageDialog(null, "Não foi possível achar o Cliente com esse cpf!");
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Saindo", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}