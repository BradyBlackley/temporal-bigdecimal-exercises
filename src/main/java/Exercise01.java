import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Exercise01 {

    // LocalDate
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    // 1. return today's date
    LocalDate getToday() {
        return LocalDate.now();
    }

    // 2. return December 17, 1903 as a LocalDate
    LocalDate getFirstFlightDate() {
        return LocalDate.of(1903, 12, 17);
    }

    // 3. if parameter is in the future, return null.
    // Otherwise, add 5 days to the parameter and return the result.
    LocalDate makeFutureNullShiftThePast(LocalDate date) {

        if (date.isAfter(getToday())) {
            return null;
        }

        return date.plusDays(5);
    }

    // 4. return the fifth Friday from the parameter date.
    // if the date is Friday, don't count it.
    LocalDate fiveFridaysFromDate(LocalDate date) {
        switch (date.getDayOfWeek()) {
            case SUNDAY:
                return date.plusDays(40); //35 - 2
            case MONDAY:
                return date.plusDays(39); //35 - 3
            case TUESDAY:
                return date.plusDays(38);
            case WEDNESDAY:
                return date.plusDays(37);
            case THURSDAY:
                return date.plusDays(36);
            case FRIDAY:
                return date.plusDays(35);
            case SATURDAY:
                return date.plusDays(34);
        }

        return null;
    }

    // 5. given a date and a count,
    // return a list of the next `fridayCount` Fridays after the date.
    // if the date is Friday, don't include it.
    List<LocalDate> getNextFridays(LocalDate date, int fridayCount) {
        ArrayList<LocalDate> fridays = new ArrayList<>();

        for(int i = 0; i < fridayCount; i++) {
            switch (date.getDayOfWeek()) {
                case SUNDAY:
                    fridays.add(date.plusDays(5 + (i * 7)));
                    break;
                case MONDAY:
                    fridays.add(date.plusDays(4 + (i * 7)));
                    break;
                case TUESDAY:
                    fridays.add(date.plusDays(3 + (i * 7)));
                    break;
                case WEDNESDAY:
                    fridays.add(date.plusDays(2 + (i * 7)));
                    break;
                case THURSDAY:
                    fridays.add(date.plusDays(1 + (i * 7)));
                    break;
                case FRIDAY:
                    fridays.add(date.plusDays(((i + 1) * 7)));
                    break;
                case SATURDAY:
                    fridays.add(date.plusDays(6 + (i * 7)));
                    break;
            }
        }
        return fridays;
    }

    // 6. return the absolute value of the days between two dates.
    // one may be before two, two may be before one, but neither will be null
    int getDaysBetween(LocalDate one, LocalDate two) {

        int days = (int)ChronoUnit.DAYS.between(one, two);
        return Math.abs(days);

    }

}
