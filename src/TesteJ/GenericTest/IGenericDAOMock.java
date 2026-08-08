package TesteJ.GenericTest;

import java.util.Collection;

public interface IGenericDAOMock<T> {
    Boolean cadastrar(T entity);
    T consultar(Long key);
    void modificar(T entity);
    void excluir(Long key);
    Collection<T> buscarTodos();
}
