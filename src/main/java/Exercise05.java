import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Exercise05 {

    // THE GODMOTHER
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    // 1. Your Godmother gives you $10 every other Friday throughout the year.
    // Payments start on the first Friday of the year.
    // Given a date, calculate payments expected from that date until the end of the year.
    BigDecimal calculateGiftsTilEndOfYear(LocalDate date) {

        BigDecimal total = BigDecimal.ZERO;

        if(date == null){
            return BigDecimal.ONE;
        }

        int year = date.getYear();

        LocalDate giftDate = LocalDate.of(year, 1, 1);

        while(giftDate.getDayOfWeek() != DayOfWeek.FRIDAY){
            giftDate = giftDate.plusDays(1);
        }

        do{
            if(giftDate.getYear() == year && (giftDate.isAfter(date) || giftDate.equals(date))){
                total = total.add(BigDecimal.TEN);
            }
            giftDate = giftDate.plusWeeks(2);
        }while(giftDate.getYear() == year);

        return total;
    }

    // 2. Your Godmother is getting quirky. She adjusted her payment schedule.
    // She still pays every other Friday throughout the year, starting on the first Friday of the year.
    // But now, she pays a number of dollars equal to the day of the month.
    // Examples
    // Jan 31 == $31
    // Mar 1 == $1
    // July 12 == $12
    // Given a date, calculate payments expected from that date until the end of the year.
    BigDecimal calculateQuirkyGiftsTilEndOfYear(LocalDate date) {
        BigDecimal total = BigDecimal.ZERO;

        if(date == null){
            return BigDecimal.ZERO;
        }

        int year = date.getYear();

        LocalDate giftDate = LocalDate.of(year, 1, 1);

        while(giftDate.getDayOfWeek() != DayOfWeek.FRIDAY){
            giftDate = giftDate.plusDays(1);
        }

        do{
            if(giftDate.getYear() == year && (giftDate.isAfter(date) || giftDate.equals(date))){
                total = total.add(BigDecimal.valueOf(giftDate.getDayOfMonth()));
            }
            giftDate = giftDate.plusWeeks(2);
        }while(giftDate.getYear() == year);


        return total;
    }

}
