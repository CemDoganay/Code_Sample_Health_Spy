/**
 * Sensor_Iterator interface will be used to create an iterator to traverse through all items of a list.
 *
 * @author      Cem Doganay, James Howe
 * @version     1.0
 * @since       1.0
 */

public interface Sensor_Iterator {
    /**
     * Indicates whether the ArrayList has an object in the next position.
     * @return boolean
     */
    boolean hasNext();

    /**
     * Returns the object at the current position and increments the position.
     * @return Object
     */
    Object next();

    /**
     * Sets the position back to 0 after going through the entire list.
     */
    void resetPosition();
}