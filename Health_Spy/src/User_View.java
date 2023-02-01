/**
 * User_View class will be used to display the metrics stored in the sensors for patients.
 *
 * @author      Cem Doganay, James Howe
 * @version     1.0
 * @since       1.0
 */

import java.util.ArrayList;

public class User_View implements Observer, Sensor_Iterator{
    /**
     * <code>baseStation</code> variable which stores the Base_Station this observes.
     * <code>sensorList</code> variable list which stores all Sensor objects this object displays.
     * <code>position</code> variable which keeps track of the current position in sensorList.
     */
    private Base_Station baseStation;
    private ArrayList<Sensor> sensorList;
    private int position = 0;

    /**
     * Constructor for Base_Station with parameterized list.
     * @param baseStation variable that assigns the Base_Station this object refers to.
     */
    public User_View(Base_Station baseStation) {
        this.baseStation = baseStation;
        baseStation.registerObserver(this);
    }

    /**
     * Updating sensorList and displaying it to the screen.
     * @param sensors variable passed with the updated sensors.
     */
    @Override
    public void update(ArrayList<Sensor> sensors) {
        this.sensorList = sensors;
        // Update the GUI
    }

    /**
     * Indicates whether the sensorList has an object in the next position.
     * @return boolean
     */
    @Override
    public boolean hasNext() {
        if (position >= sensorList.size() || sensorList.get(position).equals(null))
            return false;
        else
            return true;
    }

    /**
     * Returns the object (Observer in this case) at the current position and increments the position.
     * @return Object
     */
    @Override
    public Object next() {
        Sensor sensorItem = sensorList.get(position);
        position++;
        return sensorItem;
    }

    /**
     * Sets the position back to 0 after going through the entire list.
     */
    @Override
    public void resetPosition() {
        position = 0;
    }
}
