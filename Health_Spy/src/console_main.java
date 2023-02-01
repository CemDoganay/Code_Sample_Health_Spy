import java.util.ArrayList;
import java.util.Random;

public class console_main {
    /**
     * Main method to test Health_Spy in a console format.
     * @param args default parameter for Java main code.
     */
    public static void main(String[] args) {
        // BEGIN OBJECT/VARIABLE INSTANTIATIONS
        HeartRate_Sensor hrs = new HeartRate_Sensor();
        BodyTemp_Sensor bts = new BodyTemp_Sensor();
        BloodSugar_Sensor bss = new BloodSugar_Sensor();
        ArrayList<Sensor> sensorArrayList = new ArrayList<>();
        sensorArrayList.add(hrs);
        sensorArrayList.add(bts);
        sensorArrayList.add(bss);

        HeartRate_Sensor hrs1 = new HeartRate_Sensor();
        BodyTemp_Sensor bts1 = new BodyTemp_Sensor();
        BloodSugar_Sensor bss1 = new BloodSugar_Sensor();
        ArrayList<Sensor> sensorArrayList1 = new ArrayList<>();
        sensorArrayList1.add(hrs1);
        sensorArrayList1.add(bts1);
        sensorArrayList1.add(bss1);

        Base_Station baseStation = new Base_Station(sensorArrayList, "James Hiroki Howe");
        Base_Station baseStation1 = new Base_Station(sensorArrayList1, "Cem Doganay");

        Home_View hv = new Home_View(baseStation);
        User_View uv = new User_View(baseStation);
        Home_View hv1 = new Home_View(baseStation1);
        User_View uv1 = new User_View(baseStation1);
        Hospital_View hospital = Hospital_View.getInstance();
        hospital.addBaseStation(baseStation);
        hospital.addBaseStation(baseStation1);

        int heart, heart1;
        int temp, temp1;
        int sugar, sugar1;
        // END OBJECT/VARIABLE INSTANTIATIONS

        // Infinite loop that iterates forever.
        while (true) {
            heart = getSimMeasurement(50, 250);
            temp = getSimMeasurement(30, 45);
            sugar = getSimMeasurement(10, 210);

            heart1 = getSimMeasurement(50, 250);
            temp1 = getSimMeasurement(30, 45);
            sugar1 = getSimMeasurement(10, 210);

            //  BEGIN MEASUREMENTS
            hrs.setHeartRate(heart);
            bts.setBodyTemperature(temp);
            bss.setBloodSugar(sugar);

            hrs1.setHeartRate(heart1);
            bts1.setBodyTemperature(temp1);
            bss1.setBloodSugar(sugar1);
            // END MEASUREMENTS

            // Notify observers and get patient's name
            String name = baseStation.notifyObservers();
            String name1 = baseStation1.notifyObservers();

            // BEGIN PATIENT 1
            // Patient 1 Home View
            System.out.println("This is the Home View for " + name);
            while(hv.hasNext()) {
                Sensor sensor = (Sensor)hv.next();
                System.out.println(sensor.readingChanged());
            }
            System.out.println();

            // Patient 1 User View
            System.out.println("This is the User View for " + name);
            while(uv.hasNext()) {
                Sensor sensor = (Sensor)uv.next();
                System.out.println(sensor.readingChanged());
            }
            System.out.println();
            // END PATIENT 1

            // BEGIN PATIENT 2
            // Patient 2 Home View
            System.out.println("This is the Home View for " + name1);
            while(hv1.hasNext()) {
                Sensor sensor = (Sensor)hv1.next();
                System.out.println(sensor.readingChanged());
            }
            System.out.println();

            // Patient 2 User View
            System.out.println("This is the User View for " + name1);

            // While there are sensors left to iterate
            while(uv1.hasNext()) {
                Sensor sensor = (Sensor)uv1.next();
                System.out.println(sensor.readingChanged());
            }
            System.out.println();
            // END PATIENT 2

            // Hospital View for all patients
            for  (Base_Station b: hospital.getBaseStations()) {
                // Notify observers again to get corresponding name and measurements
                String n = b.notifyObservers();
                System.out.println("This is the Hospital View for " + n);

                // While there are sensors left to iterate
                while (hospital.hasNext()) {
                    Sensor sensor = (Sensor)hospital.next();
                    System.out.println(sensor.readingChanged());
                }
                System.out.println();

                // Resetting positions for hospital here as the traversals occur within its own loop.
                hospital.resetPosition();
            }

            // Resetting positions to be able to list all measurements
            hv.resetPosition();
            uv.resetPosition();
            hv1.resetPosition();
            uv1.resetPosition();
            System.out.println();


            // Wait for a certain time (10 seconds)
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Generate random measurements within the range.
     * @param min the integer value for minimum range.
     * @param max the integer value for maximum range.
     * @return <code>int</code> the random integer generated from the boundaries.
     */
    private static int getSimMeasurement (int min, int max) {
        Random sim = new Random();
        return sim.nextInt(max - min + 1) + min;
    }
}
