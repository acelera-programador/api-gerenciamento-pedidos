public enum DiaDaSemana {
    SEGUNDA("Segunda Feira"),
    TERCA("Terça Feira"),
    QUARTA("Quarta Feira"),
    QUINTA("Quinta Feira"),
    SEXTA("Sexta Feira"),
    SABADO("Sabado"),
    DOMINGO("Domingo");


    DiaDaSemana(String diaFormatado){
        this.diaFormatado = diaFormatado;
    }

    private String diaFormatado;

    public String getDiaFormatado() {
        return diaFormatado;
    }

}
