/**
 * Sensor interface will be used to create unique sensors that monitor different body measurements.
 *
 * @author      Cem Doganay, James Howe
 * @version     1.0
 * @since       1.0
 */

public interface Subject {
    /**
     * Registering an observer to Subject class.
     * @param observer variable passed for registration.
     * @return boolean
     */
    boolean registerObserver (Observer observer);

    /**
     * Removing an observer from Subject class.
     * @param observer variable passed for removal.
     * @return boolean
     */
    boolean removeObserver (Observer observer);

    /**
     * Calling the update() method of all Observer objects registered.
     * @return String
     */
    String notifyObservers();
}
