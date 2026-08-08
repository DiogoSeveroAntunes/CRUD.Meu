package br.com.diogoAntunes.Client;

import br.com.diogoAntunes.InterfaceGenerica.GenericMap;

import java.util.HashMap;
import java.util.Map;

public class ClienteMap extends GenericMap<Cliente> implements IClienteDAO {

    public ClienteMap(){
        super();
        Map<Long, Cliente> mapaInterno = this.map.get(tipoDaClasse());
        if(mapaInterno == null){
            mapaInterno = new HashMap<>();
            this.map.put(tipoDaClasse(), mapaInterno);
        }
    }

    @Override
    public Class<Cliente> tipoDaClasse() {
        return Cliente.class;
    }


//    private Map<Long, Cliente> map;
//
//    public ClienteMap() {
//        this.map = new HashMap<>();
//    }
//
//    @Override
//    public Boolean cadastrar(Cliente cliente) {
//        if(this.map.containsKey(cliente.getCpf())){
//            return false;
//        }this.map.put(cliente.getCpf(), cliente);
//        return true;
//    }
//
//    @Override
//    public Cliente consultar(Long cpf) {
//        return this.map.get(cpf);
//    }
//
//    @Override
//    public void modificar(Cliente cliente) {
//        Cliente clienteCadastrado = this.map.get(cliente.getCpf());
//        if(clienteCadastrado != null){
//            clienteCadastrado.setNome(cliente.getNome());
//            clienteCadastrado.setCpf(cliente.getCpf());
//            clienteCadastrado.setEstado(cliente.getEstado());
//            clienteCadastrado.setCidade(cliente.getCidade());
//            clienteCadastrado.setEndereco(cliente.getEndereco());
//            clienteCadastrado.setTelefone(cliente.getTelefone());
//        }
//    }
//
//    @Override
//    public void excluir(Long cpf) {
//    Cliente clienteCadastrado = this.map.get(cpf);
//       if(clienteCadastrado!= null){
//           this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
//    }
//    }
//
//    @Override
//    public Collection<Cliente> todosClientes(Cliente cliente) {
//        return this.map.values();
//    }
}