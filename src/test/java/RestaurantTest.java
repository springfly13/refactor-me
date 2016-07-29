import org.junit.Test;
import java.time.Instant;
import java.time.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Hugh Glykod
 * @author Inna Savelii
 */
public class RestaurantTest {

   @Test
    public void testDefaultOpeningHoursValidTimeValidDay() {
       Restaurant myRestaurant = new Restaurant();
       assertNotNull( myRestaurant.getClock() );
       Clock clockHour = Clock.fixed(Instant.parse("2016-07-28T15:01:00Z"), ZoneId.of("UTC+0"));
       myRestaurant.setClock(clockHour);
       assertTrue(myRestaurant.isOpen(DayOfWeek.FRIDAY ));
    }

    @Test
    public void testDefaultOpeningHoursFalseDay() {
        Restaurant myRestaurant = new Restaurant();
        assertNotNull( myRestaurant.getClock() );
        Clock clockHour = Clock.fixed(Instant.parse("2016-07-29T15:00:00Z"), ZoneId.of("UTC+0"));
        myRestaurant.setClock(clockHour);
        assertFalse(myRestaurant.isOpen(DayOfWeek.SUNDAY));
    }

    @Test
    public void testDefaultOpeningHoursEvening() {
        Restaurant myRestaurant = new Restaurant();
        assertNotNull( myRestaurant.getClock() );
        Clock clockHour = Clock.fixed(Instant.parse("2016-07-28T18:01:00Z"), ZoneId.of("UTC+0"));
        myRestaurant.setClock(clockHour);
        assertFalse(myRestaurant.isOpen(DayOfWeek.TUESDAY));
    }

    @Test
    public void testDefaultOpeningHoursEvening2() {
        Restaurant myRestaurant = new Restaurant();
        assertNotNull( myRestaurant.getClock() );
        Clock clockHour = Clock.fixed(Instant.parse("2016-07-28T17:59:00Z"), ZoneId.of("UTC+0"));
        myRestaurant.setClock(clockHour);
        assertTrue(myRestaurant.isOpen(DayOfWeek.TUESDAY));
    }

    @Test
    public void testDefaultOpeningHoursMorning() {
        Restaurant myRestaurant = new Restaurant();
        assertNotNull( myRestaurant.getClock() );
        Clock clockHour = Clock.fixed(Instant.parse("2016-07-28T08:59:00Z"), ZoneId.of("UTC+0"));
        myRestaurant.setClock(clockHour);
        assertFalse(myRestaurant.isOpen(DayOfWeek.WEDNESDAY ));
    }

    public void testDefaultOpeningHoursMorning2() {
        Restaurant myRestaurant = new Restaurant();
        assertNotNull( myRestaurant.getClock() );
        Clock clockHour = Clock.fixed(Instant.parse("2016-07-28T09:01:00Z"), ZoneId.of("UTC+0"));
        myRestaurant.setClock(clockHour);
        assertTrue(myRestaurant.isOpen(DayOfWeek.WEDNESDAY ));
    }
}
