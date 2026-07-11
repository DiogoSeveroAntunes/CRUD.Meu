package br.com.diogoAntunes.Interface;

import br.com.diogoAntunes.domain.Cliente;

import java.util.Collection;

public interface IClienteDAO {
    public Boolean cadastrar(Cliente cliente);
    public Cliente consultar(Long cpf);
    public void modificar(Cliente cliente);
    public void excluir(Long cpf);
    public Collection<Cliente> todosClientes(Cliente cliente);
}
