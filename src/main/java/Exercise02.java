import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Exercise02 {

    // LocalTime
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    // 1. return the current time as a LocalTime
    LocalTime getNow() {
        return LocalTime.now();
    }

    // 2. return 4PM (tea time!) as a LocalTime.
    LocalTime getTeaTime() {
        return LocalTime.of(16, 0);
    }

    // 3. add 12 hours to the time parameter and return the value
    LocalTime add12Hours(LocalTime time) {
        return time.plus(12, ChronoUnit.HOURS);
    }

    // 4. given a time parameter, return a list of the next 4
    // quarter-hour appointments available after the time.
    // appointment times should not include seconds even if the time parameter does.
    // ignore seconds.
    // Examples:
    // time == 16:07:32
    // appointments == 16:15, 16:30, 16:45, 17:00
    //
    // time == 03:00:01
    // appointments == 03:00, 03:15, 03:30, 03:45
    //
    // time == 04:30:00
    // appointments == 04:30, 04:45, 05:00, 05:15
    List<LocalTime> getQuarterHourAppointments(LocalTime time) {
        ArrayList<LocalTime> appointments = new ArrayList<>();
        LocalTime appointment = LocalTime.of(time.getHour(), 0);
        ;

        if (time.getMinute() == 0) {
            appointment = LocalTime.of(time.getHour(), 0);
            appointments.add(appointment);
            for (int i = 1; i < 4; i++) {
                appointments.add(appointment.plusMinutes(15 * i));
            }

        } else if (time.getMinute() < 15) {
            for (int i = 1; i < 5; i++) {
                appointments.add(appointment.plusMinutes(15 * i));
            }
        } else if (time.getMinute() <= 15) {
            appointment = LocalTime.of(time.getHour(), 15);
            appointments.add(appointment);
            for (int i = 1; i < 4; i++) {
                appointments.add(appointment.plusMinutes(15 * i));
            }
        } else if (time.getMinute() <= 30) {
            appointment = LocalTime.of(time.getHour(), 30);
            appointments.add(appointment);
            for (int i = 1; i < 4; i++) {
                appointments.add(appointment.plusMinutes(15 * i));
            }
        } else if (time.getMinute() <= 45) {
            appointment = LocalTime.of(time.getHour(), 45);
            appointments.add(appointment);
            for (int i = 1; i < 4; i++) {
                appointments.add(appointment.plusMinutes(15 * i));
            }
        } else {
            appointment = LocalTime.of(time.getHour() + 1, 0);
            appointments.add(appointment);
            for (int i = 1; i < 4; i++) {
                appointments.add(appointment.plusMinutes(15 * i));
            }
        }

        return appointments;
    }
}
