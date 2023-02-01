/**
 * Base_Station class will be used to update observer objects based on inputs from sensor objects.
 *
 * @author      Cem Doganay, James Howe
 * @version     1.0
 * @since       1.0
 */

import java.util.ArrayList;

public class Base_Station implements Subject{
    /**
     * <code>observers</code> variable list which stores all Observer objects this Base_Station needs to notify.
     * <code>sensors</code> variable list which stores all Sensor objects this Base_Station reads.
     * <code>patientName</code> variable String which stores patient name.
     */
    private ArrayList<Observer> observers;
    private ArrayList<Sensor> sensors;
    private String patientName;

    /**
     * Constructor for Base_Station with parameterized list.
     * @param sensors variable which assigns the ArrayList of sensors.
     */
    Base_Station(ArrayList<Sensor> sensors, String patientName){
        observers = new ArrayList<>();
        this.sensors = sensors;
        this.patientName = patientName;
    }

    /**
     * Registering an observer to this Base_Station.
     * @param observer variable passed for Base_Station to register.
     * @return boolean
     */
    public boolean registerObserver(Observer observer) {
        return observers.add(observer);
    }

    /**
     * Removing an observer from this Base_Station.
     * @param observer variable passed for Base_Station to search and remove.
     * @return boolean
     */
    public boolean removeObserver(Observer observer) {
        return observers.remove(observer);
    }

    /**
     * Calling the update() method of all Observer objects registered to this Base_Station.
     */
    public String notifyObservers() {
        for (Observer o: observers)
            o.update(sensors);

        /* Equivalent to the following:
        for (int i = 0; i < observers.size(); i++){
            Observer observer = observers.get(i);
            observer.update(sensors);
        }*/

        return patientName;
    }
}
