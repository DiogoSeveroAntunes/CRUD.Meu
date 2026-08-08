package TesteJ.ClienteMock;

import br.com.diogoAntunes.InterfaceGenerica.TipoCrudEscolhido;

import javax.swing.*;
import java.util.Collection;

public class ClienteLogicaMock {
    private IClienteDAOMock IClienteDao;

    public void executarLogicaCliente() {
        TipoCrudEscolhido tce = new TipoCrudEscolhido();
        IClienteDao = new ClienteMapMock();
        String opcao = JOptionPane.showInputDialog(null,
                "digite 1 para cadastrar,2 consultar,3 modificar,4 excluir, 5 sair, 6 todos os clientes e 7 para trocar o tipo de CRUD.",
                "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoValida(opcao)) {
            if("".equals(opcao)){
                JOptionPane.showMessageDialog(null, "Opção inválida, selecione novamente");
                opcao = JOptionPane.showInputDialog(null,
                        "digite 1 para cadastrar,2 consultar,3 modificar,4 excluir, 5 sair, 6 todos os clientes e 7 para trocar o tipo de CRUD",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            }else JOptionPane.showMessageDialog(null, "Opção inválida");
            opcao = JOptionPane.showInputDialog(null,
                    "digite 1 para cadastrar,2 consultar,3 modificar,4 excluir e 5 sair.",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }
        while (isOpcaoValida(opcao)) {
            if (isOpcaoCadastrar(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "digite o seu Nome, Cpf, Estado, Cidade, Endereço e telefone, nessa ordem e todos separados por (,)",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            } else if (isOpcaoConsultar(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "digite o CPF que desejas buscar:",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);
            } else if (isOpcaoModificar(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "digite o CPF que desejas modificar:",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                modificar(dados);

            } else if (isOpcaoExcluir(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "digite o CPF que desejas excluir:",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                excluir(dados);
            } else if (isOpcaoSair(opcao)) {
                sair();
            } else if(isOpcaoBuscarTodos(opcao)){
                todosClientes();
            }else if (isOpcaoTrocarCrud(opcao)) {
                tce.TipoDoCrudEscolhido();
            }
            opcao = JOptionPane.showInputDialog(null,
                    "digite 1 para cadastrar,2 consultar,3 modificar,4 excluir e 5 sair.",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private Boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) ||
                "4".equals(opcao) || "5".equals(opcao) || "6".equals(opcao) || "7".equals(opcao)) {
            return true;
        }return false;
    }
    private boolean isOpcaoCadastrar(String opcao) {
        if ("1".equals(opcao)) {
            return true;
        }return false;
    }
    private boolean isOpcaoConsultar(String opcao) {
        if ("2".equals(opcao)) {
            return true;
        }return false;
    }
    private boolean isOpcaoModificar(String opcao) {
        if ("3".equals(opcao)) {
            return true;
        }return false;
    }private boolean isOpcaoExcluir(String opcao) {
        if("4".equals(opcao)){
            return true;
        }return false;
    }
    private boolean isOpcaoSair(String opcao) {
        if ("5".equals(opcao)) {
            return true;
        }return false;
    }
    private boolean isOpcaoBuscarTodos(String opcao) {
        if ("6".equals(opcao)) {
            return true;
        }return false;
    }
    private boolean isOpcaoTrocarCrud(String opcao) {
        if ("7".equals(opcao)) {
            return true;
        }return false;
    }

    private void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        ClienteMock cliente = new ClienteMock(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3], dadosSeparados[4], dadosSeparados[5]);
        Boolean podeCadastrar = IClienteDao.cadastrar(cliente);
        if (podeCadastrar) {
            JOptionPane.showMessageDialog(null, "O cliente foi cadastrado com sucesso!");
        }else JOptionPane.showMessageDialog(null, "O cliente já está cadastrado!");
    }
    private void consultar(String dados){
        Long cpf = Long.parseLong(dados);
        ClienteMock cliente = IClienteDao.consultar(cpf);
        if(cliente != null){
            JOptionPane.showMessageDialog(null, "O cliente foi encontrado: " + cliente.toString());
        }else JOptionPane.showMessageDialog(null, "O cliente não foi encontrado!" );
    }
    private void modificar(String dados) {
        Long cpf = Long.parseLong(dados);
        ClienteMock cliente = IClienteDao.consultar(cpf);
        if(cliente !=null){
            String novosDados = JOptionPane.showInputDialog(null,
                    "digite o seu Nome, Cpf, Estado, Cidade, Endereço e telefone, nessa ordem e todos separados por (,)",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            String[] dadosSeparados = novosDados.split(",");
            ClienteMock clienteAtualizado = new ClienteMock(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3], dadosSeparados[4], dadosSeparados[5]);
            IClienteDao.modificar(clienteAtualizado);
            JOptionPane.showMessageDialog(null, "cliente atualizado com sucesso!");
        }
    }
    private void excluir(String dados){
        Long cpf = Long.parseLong(dados);
        ClienteMock cliente = IClienteDao.consultar(cpf);
        if(cliente !=null){
            IClienteDao.excluir(cpf);
            JOptionPane.showMessageDialog(null,"O cliente foi excluído com sucesso!");
        }else JOptionPane.showMessageDialog(null, "Não foi possível achar o Cliente com esse cpf!");
    }
    private void todosClientes() {
        Collection<ClienteMock> clientes = IClienteDao.buscarTodos();
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "\n Clientes Cadastrados" + clientes.toString(), "Clientes Cadastrados", JOptionPane.INFORMATION_MESSAGE);
    }
    private void sair() {
        JOptionPane.showMessageDialog(null, "Saindo", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
