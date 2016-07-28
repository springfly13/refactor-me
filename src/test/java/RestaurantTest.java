import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Hugh Glykod
 */
public class RestaurantTest {

    @Test
    public void testDefaultOpeningHours() {

        Restaurant myRestaurant = new Restaurant();

        boolean isOpen = myRestaurant.isOpen(Restaurant.MONDAY);

        assertTrue(isOpen);
    }
}
