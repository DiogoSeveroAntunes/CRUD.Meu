package TesteJ;

import TesteJ.ClienteMock.IClienteDAOMock;
import TesteJ.GenericTest.TipoCrudEscolhidoMock;
import TesteJ.ProdutoTest.IProdutoDAOMock;
import TesteJ.ProdutoTest.ProdutoLogicaMock;
import org.junit.jupiter.api.Test;


public class TestMain {
public IClienteDAOMock IClienteDao;
public IProdutoDAOMock IProdutoDao;

public ProdutoLogicaMock PL;


    @Test
    public void Test(){
        TipoCrudEscolhidoMock tce = new TipoCrudEscolhidoMock();
        tce.TipoDoCrudEscolhidoMock();
//        PL = new ProdutoLogicaMock();
//        PL.executandoLogicaProduto();

//        IClienteDao = new ClienteMap();
//        IProdutoDao = new ProdutoMapMock();
//        ProdutoMock produto = new ProdutoMock();
//        produto.setId(10L);
//        produto.setNome("macaco");
//        produto.setCor("azul");
//        produto.setPreco(1000L);
//        produto.setQuantidade(2L);
//        IProdutoDao.cadastrar(produto);
//        IProdutoDao.consultar(produto.getId());
//        IProdutoDao.buscarTodos();
//        ProdutoMock produto1 = new ProdutoMock();
//        produto.setNome("macaco2");
//        produto.setCor("azul3");
//        produto.setPreco(10002L);
//        produto.setQuantidade(22L);
//        IProdutoDao.modificar(produto);
//        IProdutoDao.excluir(produto.getId());

}
}


