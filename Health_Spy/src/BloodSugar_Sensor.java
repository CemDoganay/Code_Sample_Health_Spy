/**
 * BloodSugar_Sensor class will be used to read and send the changes in the blood sugar.
 *
 * @author      Cem Doganay, James Howe
 * @version     1.0
 * @since       1.0
 */

public class BloodSugar_Sensor implements Sensor{
    /**
     * <code>bloodSugar</code> variable where blood sugar data will be stored.
     */
    private double bloodSugar;

    /**
     * readingChanged function will return the current blood sugar reading.
     * @return float
     */
    public double readingChanged() {
        return bloodSugar;
    }

    /**
     * set method to read the blood sugar data.
     * @param bloodSugar variable where blood sugar data will be stored.
     */
    public void setBloodSugar(double bloodSugar){
        this.bloodSugar = bloodSugar;
    }
}
