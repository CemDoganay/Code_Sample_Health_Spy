/**
 * HeartRate_Sensor class will be used to read and send the changes in the heart rate.
 *
 * @author      Cem Doganay, James Howe
 * @version     1.0
 * @since       1.0
 */
public class HeartRate_Sensor implements Sensor {
    /**
     * <code>heartRate</code> variable where heart rate data will be stored.
     */
    private double heartRate;

    /**
     * readingChanged function will return the current heart rate reading.
     * @return float
     */
    public double readingChanged() {
        return heartRate;
    }

    /**
     * set method to read the heart rate data.
     * @param heartRate variable where heart rate data will be stored.
     */
    public void setHeartRate(double heartRate){
        this.heartRate = heartRate;
    }
}
