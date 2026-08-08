package TesteJ.ProdutoTest;

import TesteJ.GenericTest.GenericMapMock;

import java.util.HashMap;
import java.util.Map;

public class ProdutoMapMock extends GenericMapMock<ProdutoMock> implements IProdutoDAOMock {

    public ProdutoMapMock(){
        super();
        Map<Long, ProdutoMock> mapaInterno = this.map.get(tipoDaClasse());
        if(mapaInterno == null){
            mapaInterno = new HashMap<>();
            this.map.put(tipoDaClasse(), mapaInterno);
        }
    }

    @Override
    public Class<ProdutoMock> tipoDaClasse() {
        return ProdutoMock.class;
    }
}
