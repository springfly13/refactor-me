import java.time.*;
import  java.util.*;


/**
 * @author Hugh Glykod
 * @author Inna Savelii
 */
public class Restaurant {
    Clock clock = Clock.systemDefaultZone();
    private HashMap<DayOfWeek, OpenCloseHours> timeTable = new HashMap<>();

    public Restaurant() {
        this.listConstruction();
    }

    private void listConstruction() {

        OpenCloseHours defaultHours = new OpenCloseHours("09:00", "18:00");

        timeTable.put(DayOfWeek.MONDAY, defaultHours);
        timeTable.put(DayOfWeek.TUESDAY, defaultHours);
        timeTable.put(DayOfWeek.WEDNESDAY, defaultHours);
        timeTable.put(DayOfWeek.THURSDAY, defaultHours);
        timeTable.put(DayOfWeek.FRIDAY, defaultHours);
        timeTable.put(DayOfWeek.SATURDAY, defaultHours);
        timeTable.put(DayOfWeek.SUNDAY, new OpenCloseHours("00:00", "00:00"));
    }

    public boolean isOpen(DayOfWeek DAY) {

            if (LocalTime.now(clock).isAfter(LocalTime.parse(timeTable.get(DAY).getOpen())) && LocalTime.now(clock).isBefore(LocalTime.parse(timeTable.get(DAY).getClose())))
                return true;
            else return false;

    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }

    public Clock getClock() {
        return clock;
    }
}



