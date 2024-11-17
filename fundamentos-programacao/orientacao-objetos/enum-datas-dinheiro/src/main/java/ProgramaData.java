import java.time.*;
import java.time.format.DateTimeFormatter;

public class ProgramaData {

    public static void main(String[] args) {

        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(dataAtual.format(formatter));

        LocalTime horaAtual = LocalTime.now();
        DateTimeFormatter formatterParaHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("Hora atual: " + horaAtual.format(formatterParaHora));

        LocalDateTime dataEHora = LocalDateTime.now();
        DateTimeFormatter formatterParaDataEHora = DateTimeFormatter.ofPattern("dd/MM HH:mm");
        System.out.println("Data e hora: " + dataEHora.format(formatterParaDataEHora));

        LocalDate dataNascimento = LocalDate.of(1989, 7, 17);

        Period period = Period.between(dataNascimento, dataAtual);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());


    }

}
