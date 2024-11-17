public class Principal {

    public static void main(String[] args) {

        Produto produto = new Produto();
        produto.setNome("Arroz");
        produto.setPreco(20.0);

        Produto produto2 = produto;
        produto2.setNome("Feijao");

        System.out.println(produto.getNome());
        System.out.println(produto2.getNome());
    }
}
