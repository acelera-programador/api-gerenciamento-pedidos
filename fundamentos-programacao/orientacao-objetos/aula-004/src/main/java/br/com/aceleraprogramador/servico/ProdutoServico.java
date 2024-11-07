package br.com.aceleraprogramador.servico;

import br.com.aceleraprogramador.modelo.Produto;

public class ProdutoServico {

    public void aplicarDesconto(Produto produto, float desconto){
        float novoPreco = produto.getPreco() * (1 - desconto / 100);
        produto.setPreco(novoPreco);
    }

}
