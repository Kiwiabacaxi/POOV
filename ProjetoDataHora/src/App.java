import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);

        // formatar a data - padrao brasileiro
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate hoje = LocalDate.now();
        System.out.println(hoje.format(formatador));

        LocalDate natal = LocalDate.of(2023, Month.DECEMBER, 25);
        System.out.println(natal.format(formatador));

        LocalDate agora = LocalDate.now();
        System.out.println(agora);

        /*
         * System.out.print("Digite a data  (dd/mm/aaaa): ");
         * String dataTexto = teclado.nextLine();
         * LocalDate data = LocalDate.parse(dataTexto, formatador);
         * System.out.println(data.format(formatador));
         */

        // Periodo
        Period periodo = Period.of(2, 3, 10);

        // LocalDate hoje = LocalDate.now();
        LocalDate amanha = hoje.plusDays(1);
        LocalDate daqui3Semanas = hoje.plusWeeks(3);
        LocalDate daqui3Meses = hoje.plusMonths(3);
        LocalDate daqui3Anos = hoje.plusYears(3);
        LocalDate daqui2Anos3Meses10Dias = hoje.plus(periodo);

        System.out.println("Hoje: " + hoje.format(formatador));
        System.out.println("Amanhã: " + amanha.format(formatador));
        System.out.println("Daqui 3 semanas: " + daqui3Semanas.format(formatador));
        System.out.println("Daqui 3 meses: " + daqui3Meses.format(formatador));
        System.out.println("Daqui a 3 anos: " + daqui3Anos.format(formatador));
        System.out.println("Daqui a 2 anos, 3 meses e 10 dias: " + daqui2Anos3Meses10Dias.format(formatador));

        // mais coisas estranhas
        LocalDate ontem = hoje.minusDays(1);
        LocalDate tresSemanasAtras = hoje.minusWeeks(3);
        LocalDate tresMesesAtras = hoje.minusMonths(3);
        LocalDate tresAnosAtras = hoje.minusYears(3);
        LocalDate doisAnos3Meses10DiasAtras = hoje.minus(periodo);

        LocalDate dia10MesAtual = hoje.withDayOfMonth(10);
        LocalDate diaHojeMesAbril = hoje.withMonth(4);
        LocalDate diaHojeMesAbril2 = hoje.withMonth(Month.APRIL.getValue());
        LocalDate diaHojeAno2014 = hoje.withYear(2014);

        int dia = hoje.getDayOfMonth();
        int mes = hoje.getMonthValue();
        int ano = hoje.getYear();
        int diaSemana = hoje.getDayOfWeek().getValue();
//        String textoDiaSemana = hoje.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("pt", "br"));
        String textoDiaSemana = hoje.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.JAPAN);
        System.out.println(textoDiaSemana);
        textoDiaSemana = hoje.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.JAPAN);
        System.out.println(textoDiaSemana);
        textoDiaSemana = hoje.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ITALY);
        System.out.println(textoDiaSemana);

        if (hoje.isLeapYear()) {
            System.out.println("Ano Bissexto");
        } else {
            System.out.println("Ano Não Bissexto");
        }

        TemporalAdjuster primeiroDiaMesTA = TemporalAdjusters.firstDayOfMonth();
        TemporalAdjuster primeiroDiaProximoMesTA = TemporalAdjusters.firstDayOfNextMonth();
        TemporalAdjuster primeiroDiaProximoAnoTA = TemporalAdjusters.firstDayOfNextYear();
        TemporalAdjuster primeiroDiaAnoTA = TemporalAdjusters.firstDayOfYear();
        TemporalAdjuster primeira2aDoMesTA = TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY);
        TemporalAdjuster ultimoDiaMesTA = TemporalAdjusters.lastDayOfMonth();
        TemporalAdjuster ultimoDiaAnoTA = TemporalAdjusters.lastDayOfYear();
        TemporalAdjuster ultima2aDoMesTA = TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY);
        TemporalAdjuster proxima2aTA = TemporalAdjusters.next(DayOfWeek.MONDAY);
        TemporalAdjuster proximaOuAtual2aTA = TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY);
        TemporalAdjuster segundaAnteriorTA = TemporalAdjusters.previous(DayOfWeek.MONDAY);
        TemporalAdjuster segundaAnteriorOuAtualTA = TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY);
        TemporalAdjuster terceira5aDoMesTA = TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.THURSDAY);

    }
}
