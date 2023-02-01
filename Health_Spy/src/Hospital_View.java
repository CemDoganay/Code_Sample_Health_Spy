/**
 * Hospital_View class will be used to display the metrics stored in the sensors for the hospital. There is only one Hospital_View instance at any point in the execution.
 *
 * @author      Cem Doganay, James Howe
 * @version     1.0
 * @since       1.0
 */

import java.util.ArrayList;

public class Hospital_View implements Observer, Sensor_Iterator{
    /**
     * <code>baseStation</code> variable which stores the Base_Station this observes.
     * <code>sensorList</code> variable list which stores all Sensor objects this object displays.
     * <code>position</code> variable which keeps track of the current position in sensorList.
     */
    private volatile static Hospital_View uniqueView;
    private static ArrayList<Base_Station> baseStations;
    private ArrayList<Sensor> sensorList;
    private int position = 0;

    /**
     * Hidden default constructor to ensure a unique instance.
     */
    private Hospital_View() {}

    /**
     * Method used to instantiate the unique Hospital_View object.
     * @return uniqueView
     */
    public static Hospital_View getInstance() {
        if (uniqueView == null) {
            synchronized (Hospital_View.class) {
                if (uniqueView == null) {
                    uniqueView = new Hospital_View();
                    baseStations = new ArrayList<>();
                }
            }
        }
        else
            System.out.println("ERROR: You cannot have more than one Hospital_View instance!");
        return uniqueView;
    }

    /**
     * Method to add Base_Station objects that this object needs to be notified.
     * @param baseStation variable passed to add to list and register observer.
     */
    public void addBaseStation(Base_Station baseStation) {
        baseStations.add(baseStation);
        baseStation.registerObserver(this);
    }

    /**
     * Method to get the list of Base_Station objects.
     * @return baseStations
     */
    public ArrayList<Base_Station> getBaseStations() {
        return baseStations;
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
