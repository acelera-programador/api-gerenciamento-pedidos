public class ValidarIdade {


    public static void main(String[] args) {
        int idade = 16;
        try {
            validarIdade(idade);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public static void validarIdade(int idade) {
        if(idade < 18){
            throw new IllegalArgumentException("Idade deve ser maior que 18");
        }
    }


}
