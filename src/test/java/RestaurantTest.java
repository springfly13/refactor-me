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
       Clock clockHour = Clock.fixed(Instant.parse("2016-07-28T15:00:00Z"), ZoneId.systemDefault());
       myRestaurant.setClock(clockHour);
       assertTrue(myRestaurant.isOpen(DayOfWeek.FRIDAY ));
    }

    @Test
    public void testDefaultOpeningHoursFalseDay() {
        Restaurant myRestaurant = new Restaurant();
        assertNotNull( myRestaurant.getClock() );
        Clock clockHour = Clock.fixed(Instant.parse("2016-07-29T15:00:00Z"), ZoneId.systemDefault());
        myRestaurant.setClock(clockHour);
        assertFalse(myRestaurant.isOpen(DayOfWeek.SUNDAY));
    }

    @Test
    public void testDefaultOpeningHoursEvening() {
        Restaurant myRestaurant = new Restaurant();
        assertNotNull( myRestaurant.getClock() );
        Clock clockHour = Clock.fixed(Instant.parse("2016-07-28T18:30:00Z"), ZoneId.systemDefault());
        myRestaurant.setClock(clockHour);
        assertFalse(myRestaurant.isOpen(DayOfWeek.TUESDAY));
    }

    @Test
    public void testDefaultOpeningHoursMorning() {
        Restaurant myRestaurant = new Restaurant();
        assertNotNull( myRestaurant.getClock() );
        Clock clockHour = Clock.fixed(Instant.parse("2016-07-28T06:30:00Z"), ZoneId.systemDefault());
        myRestaurant.setClock(clockHour);
        assertFalse(myRestaurant.isOpen(DayOfWeek.WEDNESDAY ));
    }
}
