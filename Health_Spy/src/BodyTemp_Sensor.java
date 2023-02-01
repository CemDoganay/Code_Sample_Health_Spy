/**
 * BodyTemp_Sensor class will be used to read and send the changes in the body temperature.
 *
 * @author      Cem Doganay, James Howe
 * @version     1.0
 * @since       1.0
 */

public class BodyTemp_Sensor implements Sensor{
    /**
     * <code>bodyTemperature</code> variable where body temperature data will be stored.
     */
    private double bodyTemperature;

    /**
     * readingChanged function will return the current body temperature reading.
     * @return double
     */
    public double readingChanged() {
        return bodyTemperature;
    }

    /**
     * set method to read the body temperature data.
     * @param bodyTemperature variable where body temperature data will be stored.
     */
    public void setBodyTemperature(double bodyTemperature){
        this.bodyTemperature = bodyTemperature;
    }
}
