package br.com.diogoAntunes.InterfaceGenerica;

import br.com.diogoAntunes.domain.IdentificadorDasClasses;

import java.util.*;

public abstract class GenericMap<T extends IdentificadorDasClasses> implements IGenericDAO<T> {
    protected Map<Class, Map<Long, T>> map;
    public abstract Class<T> tipoDaClasse();

    public GenericMap(){
        if(this.map == null){
            this.map = new HashMap<>();
        }
    }
    @Override
    public Boolean cadastrar(T entity) {
        Map<Long, T> mapaInterno = this.map.get(tipoDaClasse());
        if(this.map.containsKey(entity.identificador())){
            return false;
        }mapaInterno.put(entity.identificador(), entity);
            return true;
    }
    @Override
    public T consultar(Long key) {
        Map<Long, T> mapaInterno = this.map.get(tipoDaClasse());
        return mapaInterno.get(key);
    }
    @Override
    public void modificar(T entity) {
        Map<Long, T> mapaInterno = this.map.get(tipoDaClasse());
        if(mapaInterno != null){
            if(mapaInterno.containsKey(entity.identificador())){
                mapaInterno.put(entity.identificador(), entity);
            }
        }
    }
    @Override
    public void excluir(Long key) {
        Map<Long, T> mapaInterno = this.map.get(tipoDaClasse());
        if(mapaInterno != null){
            T entidadeCadastrada = mapaInterno.get(key);
        if(entidadeCadastrada != null){
            mapaInterno.remove(key, entidadeCadastrada);
        }}
    }
    @Override
    public Collection<T> buscarTodos() {
        Map<Long, T> mapaInterno = this.map.get(tipoDaClasse());
        if(mapaInterno != null){
            return mapaInterno.values();
        } return new ArrayList<>();
    }
}
