/**
 * Sensor interface will be used to create unique sensors that monitor different body measurements.
 *
 * @author      Cem Doganay, James Howe
 * @version     1.0
 * @since       1.0
 */

public interface Sensor {
    /**
     * readingChanged function will return the current reading of the sensor.
     * @return float
     */
    double readingChanged();
}