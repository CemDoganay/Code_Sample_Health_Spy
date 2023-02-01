/**
 * Observer interface will be used to create displays that show sensor data.
 *
 * @author      Cem Doganay, James Howe
 * @version     1.0
 * @since       1.0
 */

import java.util.ArrayList;

public interface Observer {
    /**
     * Updating sensorList and displaying it to the screen.
     * @param sensors variable passed with the updated sensors.
     */
    void update (ArrayList<Sensor> sensors);
}