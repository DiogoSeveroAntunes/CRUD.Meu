package br.com.diogoAntunes.Product;

import br.com.diogoAntunes.InterfaceGenerica.GenericMap;

import java.util.HashMap;
import java.util.Map;

public class ProdutoMap extends GenericMap<Produto> implements IProdutoDAO {

    public ProdutoMap(){
        super();
        Map<Long, Produto> mapaInterno = this.map.get(tipoDaClasse());
        if(mapaInterno == null){
            mapaInterno = new HashMap<>();
            this.map.put(tipoDaClasse(), mapaInterno);
        }
    }

    @Override
    public Class<Produto> tipoDaClasse() {
        return Produto.class;
    }
}
