package br.com.aceleraprogramador.executor;

import br.com.aceleraprogramador.modelo.Produto;
import br.com.aceleraprogramador.util.ValidadorUtil;
import br.com.aceleraprogramador.servico.ProdutoServico;

public class Principal {

    public static void main(String[] args) {
        Produto produto = new Produto();
        produto.setNome("Produto 1");
        produto.setPreco(1500f);


        if(ValidadorUtil.precoValido(produto.getPreco())){
            ProdutoServico servico = new ProdutoServico();
            servico.aplicarDesconto(produto, 10f);
            System.out.println("Produto " + produto.getNome() + " com desconto tem valor de " + produto.getPreco());
        }else{
            System.out.println("Preco invalido");
        }



    }

}
