import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class MonthlyPeriod {
    public String calculatePeriod(String startDate, String endDate) {
        try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);

        int months = Period.between(start, end).getMonths();
        int years = Period.between(start, end).getYears();

        if (years == 0) {
            return "Period: " + months + "months";
        } else {
            return "Period: " + years + "years and " + months + "months";
        }
    } catch (Exception e) {
        return "Error";
    }
    }
}