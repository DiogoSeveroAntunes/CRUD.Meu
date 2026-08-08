package TesteJ.GenericTest;

import TesteJ.IdentificadorMock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class GenericMapMock<T extends IdentificadorMock> implements IGenericDAOMock<T> {
    protected Map<Class, Map<Long, T>> map;
    public abstract Class<T> tipoDaClasse();

    public GenericMapMock(){
        if(this.map == null){
            this.map = new HashMap<>();
        }
    }
    @Override
    public Boolean cadastrar(T entity) {
        Map<Long, T> mapaInterno = this.map.get(tipoDaClasse());
        if(this.map.containsKey(entity.IdentificadorMock())){
            return false;
        }mapaInterno.put(entity.IdentificadorMock(), entity);
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
            if(mapaInterno.containsKey(entity.IdentificadorMock())){
                mapaInterno.put(entity.IdentificadorMock(), entity);
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
