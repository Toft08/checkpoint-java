import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProjectTime {
    private String startTime;
    private String endTime;
    private long hoursLogged; // store total hours

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public ProjectTime(String start, String end) {
        this.startTime = start;
        this.endTime = end;
        updateHoursLogged();
    }

    // --- Setters ---
    public void setStartTime(String start) {
        this.startTime = start;
        updateHoursLogged();
    }

    public void setEndTime(String end) {
        this.endTime = end;
        updateHoursLogged();
    }

    // --- Getters ---
    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getHoursLogged() {
        if (hoursLogged == -1) {
            return "-1"; // error
        }

        // Apply the same threshold logic as before
        long minutes = hoursLogged * 60;
        if (minutes < 120) {
            return minutes + " m";
        } else if (hoursLogged < 120) {
            return hoursLogged + " h";
        } else {
            long days = hoursLogged / 24;
            if (days < 120) {
                return days + " d";
            } else {
                long months = days / 30; // rough estimate
                return months + " mo";
            }
        }
    }

    // --- Helper ---
    private void updateHoursLogged() {
        try {
            LocalDateTime start = LocalDateTime.parse(startTime, formatter);
            LocalDateTime end = LocalDateTime.parse(endTime, formatter);

            if (end.isBefore(start)) {
                hoursLogged = -1; // invalid
                return;
            }

            Duration diff = Duration.between(start, end);
            hoursLogged = diff.toHours();
        } catch (Exception e) {
            hoursLogged = -1; // parsing or format error
        }
    }
}
