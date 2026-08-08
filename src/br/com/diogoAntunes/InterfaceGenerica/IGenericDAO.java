package br.com.diogoAntunes.InterfaceGenerica;

import java.util.Collection;

public interface IGenericDAO<T> {
    Boolean cadastrar(T entity);
    T consultar(Long key);
    void modificar(T entity);
    void excluir(Long key);
    Collection<T> buscarTodos();
}
