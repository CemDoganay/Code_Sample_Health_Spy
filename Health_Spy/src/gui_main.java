import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class gui_main {
    /**
     * Main method to test Health_Spy in a console format.
     * @param args default parameter for Java main code.
     */
    public static void main(String[] args) {
        // BEGIN OBJECT/VARIABLE INSTANTIATIONS
        HeartRate_Sensor hrs1 = new HeartRate_Sensor();
        BodyTemp_Sensor bts1 = new BodyTemp_Sensor();
        BloodSugar_Sensor bss1 = new BloodSugar_Sensor();
        ArrayList<Sensor> sensorArrayList1 = new ArrayList<>();
        sensorArrayList1.add(hrs1);
        sensorArrayList1.add(bts1);
        sensorArrayList1.add(bss1);

        HeartRate_Sensor hrs2 = new HeartRate_Sensor();
        BodyTemp_Sensor bts2 = new BodyTemp_Sensor();
        BloodSugar_Sensor bss2 = new BloodSugar_Sensor();
        ArrayList<Sensor> sensorArrayList2 = new ArrayList<>();
        sensorArrayList2.add(hrs2);
        sensorArrayList2.add(bts2);
        sensorArrayList2.add(bss2);

        Base_Station baseStation1 = new Base_Station(sensorArrayList1, "James Hiroki Howe");
        Base_Station baseStation2 = new Base_Station(sensorArrayList2, "Cem Doganay");

        Home_View hv1 = new Home_View(baseStation1);
        User_View uv1 = new User_View(baseStation1);
        Home_View hv2 = new Home_View(baseStation2);
        User_View uv2 = new User_View(baseStation2);
        Hospital_View hospital = Hospital_View.getInstance();
        hospital.addBaseStation(baseStation1);
        hospital.addBaseStation(baseStation2);

        int heart1, heart2;
        int temp1, temp2;
        int sugar1, sugar2;
        int counter;
        int columnSize = 4;
        final int sleepTime = 1000;
        // END OBJECT/VARIABLE INSTANTIATIONS

        JFrame userFrame1 = new JFrame(baseStation1.notifyObservers() + " User View");
        userFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel userMainPanel1 = new JPanel();
        userMainPanel1.setLayout(new BoxLayout(userMainPanel1, BoxLayout.Y_AXIS));
        JPanel userPanelHeart1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JTextArea heartReading_p1_user = new JTextArea("Heart Rate (BPM):");
        JTextField heartReading1_p1_user = new JTextField(columnSize);
        JTextField heartReading2_p1_user = new JTextField(columnSize);
        JTextField heartReading3_p1_user = new JTextField(columnSize);
        JTextField heartReading4_p1_user = new JTextField(columnSize);
        JTextField heartReading5_p1_user = new JTextField(columnSize);
        heartReading_p1_user.setEditable(false);
        heartReading1_p1_user.setEditable(false);
        heartReading2_p1_user.setEditable(false);
        heartReading3_p1_user.setEditable(false);
        heartReading4_p1_user.setEditable(false);
        heartReading5_p1_user.setEditable(false);
        userPanelHeart1.add(heartReading_p1_user);
        userPanelHeart1.add(heartReading1_p1_user);
        userPanelHeart1.add(heartReading2_p1_user);
        userPanelHeart1.add(heartReading3_p1_user);
        userPanelHeart1.add(heartReading4_p1_user);
        userPanelHeart1.add(heartReading5_p1_user);
        JPanel userPanelTemp1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JTextArea tempReading_p1_user = new JTextArea("Temperature (°C):");
        JTextField tempReading1_p1_user = new JTextField(columnSize);
        JTextField tempReading2_p1_user = new JTextField(columnSize);
        JTextField tempReading3_p1_user = new JTextField(columnSize);
        JTextField tempReading4_p1_user = new JTextField(columnSize);
        JTextField tempReading5_p1_user = new JTextField(columnSize);
        tempReading_p1_user.setEditable(false);
        tempReading1_p1_user.setEditable(false);
        tempReading2_p1_user.setEditable(false);
        tempReading3_p1_user.setEditable(false);
        tempReading4_p1_user.setEditable(false);
        tempReading5_p1_user.setEditable(false);
        userPanelTemp1.add(tempReading_p1_user);
        userPanelTemp1.add(tempReading1_p1_user);
        userPanelTemp1.add(tempReading2_p1_user);
        userPanelTemp1.add(tempReading3_p1_user);
        userPanelTemp1.add(tempReading4_p1_user);
        userPanelTemp1.add(tempReading5_p1_user);
        JPanel userPanelSugar1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JTextArea sugarReading_p1_user = new JTextArea("Blood Sugar Rate (mg/dL):");
        JTextField sugarReading1_p1_user = new JTextField(columnSize);
        JTextField sugarReading2_p1_user = new JTextField(columnSize);
        JTextField sugarReading3_p1_user = new JTextField(columnSize);
        JTextField sugarReading4_p1_user = new JTextField(columnSize);
        JTextField sugarReading5_p1_user = new JTextField(columnSize);
        sugarReading_p1_user.setEditable(false);
        sugarReading1_p1_user.setEditable(false);
        sugarReading2_p1_user.setEditable(false);
        sugarReading3_p1_user.setEditable(false);
        sugarReading4_p1_user.setEditable(false);
        sugarReading5_p1_user.setEditable(false);
        userPanelSugar1.add(sugarReading_p1_user);
        userPanelSugar1.add(sugarReading1_p1_user);
        userPanelSugar1.add(sugarReading2_p1_user);
        userPanelSugar1.add(sugarReading3_p1_user);
        userPanelSugar1.add(sugarReading4_p1_user);
        userPanelSugar1.add(sugarReading5_p1_user);
        userMainPanel1.add(userPanelHeart1);
        userMainPanel1.add(userPanelTemp1);
        userMainPanel1.add(userPanelSugar1);
        userFrame1.add(userMainPanel1);


        JFrame homeFrame1 = new JFrame(baseStation1.notifyObservers() +" Home View");

        homeFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel homeMainPanel1 = new JPanel();
        homeMainPanel1.setLayout(new BoxLayout(homeMainPanel1, BoxLayout.Y_AXIS));
        JPanel homePanelHeart1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JTextArea heartReading_p1_home = new JTextArea("Heart Rate (BPM):");
        JTextField heartReading1_p1_home = new JTextField(columnSize);
        JTextField heartReading2_p1_home = new JTextField(columnSize);
        JTextField heartReading3_p1_home = new JTextField(columnSize);
        JTextField heartReading4_p1_home = new JTextField(columnSize);
        JTextField heartReading5_p1_home = new JTextField(columnSize);
        heartReading_p1_home.setEditable(false);
        heartReading1_p1_home.setEditable(false);
        heartReading2_p1_home.setEditable(false);
        heartReading3_p1_home.setEditable(false);
        heartReading4_p1_home.setEditable(false);
        heartReading5_p1_home.setEditable(false);
        homePanelHeart1.add(heartReading_p1_home);
        homePanelHeart1.add(heartReading1_p1_home);
        homePanelHeart1.add(heartReading2_p1_home);
        homePanelHeart1.add(heartReading3_p1_home);
        homePanelHeart1.add(heartReading4_p1_home);
        homePanelHeart1.add(heartReading5_p1_home);
        JPanel homePanelTemp1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JTextArea tempReading_p1_home = new JTextArea("Temperature (°C):");
        JTextField tempReading1_p1_home = new JTextField(columnSize);
        JTextField tempReading2_p1_home = new JTextField(columnSize);
        JTextField tempReading3_p1_home = new JTextField(columnSize);
        JTextField tempReading4_p1_home = new JTextField(columnSize);
        JTextField tempReading5_p1_home = new JTextField(columnSize);
        tempReading_p1_home.setEditable(false);
        tempReading1_p1_home.setEditable(false);
        tempReading2_p1_home.setEditable(false);
        tempReading3_p1_home.setEditable(false);
        tempReading4_p1_home.setEditable(false);
        tempReading5_p1_home.setEditable(false);
        homePanelTemp1.add(tempReading_p1_home);
        homePanelTemp1.add(tempReading1_p1_home);
        homePanelTemp1.add(tempReading2_p1_home);
        homePanelTemp1.add(tempReading3_p1_home);
        homePanelTemp1.add(tempReading4_p1_home);
        homePanelTemp1.add(tempReading5_p1_home);
        JPanel homePanelSugar1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JTextArea sugarReading_p1_home = new JTextArea("Blood Sugar Rate:");
        JTextField sugarReading1_p1_home = new JTextField(columnSize);
        sugarReading_p1_home.setEditable(false);
        sugarReading1_p1_home.setEditable(false);
        homePanelSugar1.add(sugarReading_p1_home);
        homePanelSugar1.add(sugarReading1_p1_home);
        homeMainPanel1.add(homePanelHeart1);
        homeMainPanel1.add(homePanelTemp1);
        homeMainPanel1.add(homePanelSugar1);
        homeFrame1.add(homeMainPanel1);



        JFrame userFrame2 = new JFrame(baseStation2.notifyObservers() +" User View");
        userFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel userMainPanel2 = new JPanel();
        userMainPanel2.setLayout(new BoxLayout(userMainPanel2, BoxLayout.Y_AXIS));
        JPanel userPanelHeart2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JTextArea heartReading_p2_user = new JTextArea("Heart Rate (BPM):");
        JTextField heartReading1_p2_user = new JTextField(columnSize);
        JTextField heartReading2_p2_user = new JTextField(columnSize);
        JTextField heartReading3_p2_user = new JTextField(columnSize);
        JTextField heartReading4_p2_user = new JTextField(columnSize);
        JTextField heartReading5_p2_user = new JTextField(columnSize);
        heartReading_p2_user.setEditable(false);
        heartReading1_p2_user.setEditable(false);
        heartReading2_p2_user.setEditable(false);
        heartReading3_p2_user.setEditable(false);
        heartReading4_p2_user.setEditable(false);
        heartReading5_p2_user.setEditable(false);
        userPanelHeart2.add(heartReading_p2_user);
        userPanelHeart2.add(heartReading1_p2_user);
        userPanelHeart2.add(heartReading2_p2_user);
        userPanelHeart2.add(heartReading3_p2_user);
        userPanelHeart2.add(heartReading4_p2_user);
        userPanelHeart2.add(heartReading5_p2_user);
        JPanel userPanelTemp2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JTextArea tempReading_p2_user = new JTextArea("Temperature (°C):");
        JTextField tempReading1_p2_user = new JTextField(columnSize);
        JTextField tempReading2_p2_user = new JTextField(columnSize);
        JTextField tempReading3_p2_user = new JTextField(columnSize);
        JTextField tempReading4_p2_user = new JTextField(columnSize);
        JTextField tempReading5_p2_user = new JTextField(columnSize);
        tempReading_p2_user.setEditable(false);
        tempReading1_p2_user.setEditable(false);
        tempReading2_p2_user.setEditable(false);
        tempReading3_p2_user.setEditable(false);
        tempReading4_p2_user.setEditable(false);
        tempReading5_p2_user.setEditable(false);
        userPanelTemp2.add(tempReading_p2_user);
        userPanelTemp2.add(tempReading1_p2_user);
        userPanelTemp2.add(tempReading2_p2_user);
        userPanelTemp2.add(tempReading3_p2_user);
        userPanelTemp2.add(tempReading4_p2_user);
        userPanelTemp2.add(tempReading5_p2_user);
        JPanel userPanelSugar2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JTextArea sugarReading_p2_user = new JTextArea("Blood Sugar Rate (mg/dL):");
        JTextField sugarReading1_p2_user = new JTextField(columnSize);
        JTextField sugarReading2_p2_user = new JTextField(columnSize);
        JTextField sugarReading3_p2_user = new JTextField(columnSize);
        JTextField sugarReading4_p2_user = new JTextField(columnSize);
        JTextField sugarReading5_p2_user = new JTextField(columnSize);
        sugarReading_p2_user.setEditable(false);
        sugarReading1_p2_user.setEditable(false);
        sugarReading2_p2_user.setEditable(false);
        sugarReading3_p2_user.setEditable(false);
        sugarReading4_p2_user.setEditable(false);
        sugarReading5_p2_user.setEditable(false);
        userPanelSugar2.add(sugarReading_p2_user);
        userPanelSugar2.add(sugarReading1_p2_user);
        userPanelSugar2.add(sugarReading2_p2_user);
        userPanelSugar2.add(sugarReading3_p2_user);
        userPanelSugar2.add(sugarReading4_p2_user);
        userPanelSugar2.add(sugarReading5_p2_user);
        userMainPanel2.add(userPanelHeart2);
        userMainPanel2.add(userPanelTemp2);
        userMainPanel2.add(userPanelSugar2);
        userFrame2.add(userMainPanel2);

        JFrame homeFrame2 = new JFrame(baseStation2.notifyObservers() + " Home View");
        homeFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel homeMainPanel2 = new JPanel();
        homeMainPanel2.setLayout(new BoxLayout(homeMainPanel2, BoxLayout.Y_AXIS));
        JPanel homePanelHeart2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JTextArea heartReading_p2_home = new JTextArea("Heart Rate (BPM):");
        JTextField heartReading1_p2_home = new JTextField(columnSize);
        JTextField heartReading2_p2_home = new JTextField(columnSize);
        JTextField heartReading3_p2_home = new JTextField(columnSize);
        JTextField heartReading4_p2_home = new JTextField(columnSize);
        JTextField heartReading5_p2_home = new JTextField(columnSize);
        heartReading_p2_home.setEditable(false);
        heartReading1_p2_home.setEditable(false);
        heartReading2_p2_home.setEditable(false);
        heartReading3_p2_home.setEditable(false);
        heartReading4_p2_home.setEditable(false);
        heartReading5_p2_home.setEditable(false);
        homePanelHeart2.add(heartReading_p2_home);
        homePanelHeart2.add(heartReading1_p2_home);
        homePanelHeart2.add(heartReading2_p2_home);
        homePanelHeart2.add(heartReading3_p2_home);
        homePanelHeart2.add(heartReading4_p2_home);
        homePanelHeart2.add(heartReading5_p2_home);
        JPanel homePanelTemp2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JTextArea tempReading_p2_home = new JTextArea("Temperature (°C):");
        JTextField tempReading1_p2_home = new JTextField(columnSize);
        JTextField tempReading2_p2_home = new JTextField(columnSize);
        JTextField tempReading3_p2_home = new JTextField(columnSize);
        JTextField tempReading4_p2_home = new JTextField(columnSize);
        JTextField tempReading5_p2_home = new JTextField(columnSize);
        tempReading_p2_home.setEditable(false);
        tempReading1_p2_home.setEditable(false);
        tempReading2_p2_home.setEditable(false);
        tempReading3_p2_home.setEditable(false);
        tempReading4_p2_home.setEditable(false);
        tempReading5_p2_home.setEditable(false);
        homePanelTemp2.add(tempReading_p2_home);
        homePanelTemp2.add(tempReading1_p2_home);
        homePanelTemp2.add(tempReading2_p2_home);
        homePanelTemp2.add(tempReading3_p2_home);
        homePanelTemp2.add(tempReading4_p2_home);
        homePanelTemp2.add(tempReading5_p2_home);
        JPanel homePanelSugar2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JTextArea sugarReading_p2_home = new JTextArea("Blood Sugar Rate:");
        JTextField sugarReading1_p2_home = new JTextField(columnSize);
        sugarReading_p2_home.setEditable(false);
        sugarReading1_p2_home.setEditable(false);
        homePanelSugar2.add(sugarReading_p2_home);
        homePanelSugar2.add(sugarReading1_p2_home);
        homeMainPanel2.add(homePanelHeart2);
        homeMainPanel2.add(homePanelTemp2);
        homeMainPanel2.add(homePanelSugar2);
        homeFrame2.add(homeMainPanel2);

        JFrame hospitalFrame = new JFrame("Hospital View");
        hospitalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel superPanel = new JPanel();
        superPanel.setLayout(new BoxLayout(superPanel, BoxLayout.Y_AXIS));
        JPanel p1MainPanel = new JPanel();
        p1MainPanel.setLayout(new BoxLayout(p1MainPanel, BoxLayout.Y_AXIS));
        JPanel p1NamePanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JTextArea p1Name = new JTextArea();
        p1Name.setEditable(false);
        p1NamePanel.add(p1Name);
        JPanel p1PanelHeart = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JTextArea heartReading_p1 = new JTextArea("Heart Rate (BPM):");
        JTextField heartReading1_p1 = new JTextField(columnSize);
        JTextField heartReading2_p1 = new JTextField(columnSize);
        JTextField heartReading3_p1 = new JTextField(columnSize);
        JTextField heartReading4_p1 = new JTextField(columnSize);
        JTextField heartReading5_p1 = new JTextField(columnSize);
        heartReading_p1.setEditable(false);
        heartReading1_p1.setEditable(false);
        heartReading2_p1.setEditable(false);
        heartReading3_p1.setEditable(false);
        heartReading4_p1.setEditable(false);
        heartReading5_p1.setEditable(false);
        p1PanelHeart.add(heartReading_p1);
        p1PanelHeart.add(heartReading1_p1);
        p1PanelHeart.add(heartReading2_p1);
        p1PanelHeart.add(heartReading3_p1);
        p1PanelHeart.add(heartReading4_p1);
        p1PanelHeart.add(heartReading5_p1);
        JPanel p1PanelTemp = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JTextArea tempReading_p1 = new JTextArea("Temperature (°C):");
        JTextField tempReading1_p1 = new JTextField(columnSize);
        JTextField tempReading2_p1 = new JTextField(columnSize);
        JTextField tempReading3_p1 = new JTextField(columnSize);
        JTextField tempReading4_p1 = new JTextField(columnSize);
        JTextField tempReading5_p1 = new JTextField(columnSize);
        tempReading_p1.setEditable(false);
        tempReading1_p1.setEditable(false);
        tempReading2_p1.setEditable(false);
        tempReading3_p1.setEditable(false);
        tempReading4_p1.setEditable(false);
        tempReading5_p1.setEditable(false);
        p1PanelTemp.add(tempReading_p1);
        p1PanelTemp.add(tempReading1_p1);
        p1PanelTemp.add(tempReading2_p1);
        p1PanelTemp.add(tempReading3_p1);
        p1PanelTemp.add(tempReading4_p1);
        p1PanelTemp.add(tempReading5_p1);
        JPanel p1PanelSugar = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JTextArea sugarReading_p1 = new JTextArea("Blood Sugar Rate (mg/dL):");
        JTextField sugarReading1_p1 = new JTextField(columnSize);
        JTextField sugarReading2_p1 = new JTextField(columnSize);
        JTextField sugarReading3_p1 = new JTextField(columnSize);
        JTextField sugarReading4_p1 = new JTextField(columnSize);
        JTextField sugarReading5_p1 = new JTextField(columnSize);
        sugarReading_p1.setEditable(false);
        sugarReading1_p1.setEditable(false);
        sugarReading2_p1.setEditable(false);
        sugarReading3_p1.setEditable(false);
        sugarReading4_p1.setEditable(false);
        sugarReading5_p1.setEditable(false);
        p1PanelSugar.add(sugarReading_p1);
        p1PanelSugar.add(sugarReading1_p1);
        p1PanelSugar.add(sugarReading2_p1);
        p1PanelSugar.add(sugarReading3_p1);
        p1PanelSugar.add(sugarReading4_p1);
        p1PanelSugar.add(sugarReading5_p1);
        p1MainPanel.add(p1NamePanel);
        p1MainPanel.add(p1PanelHeart);
        p1MainPanel.add(p1PanelTemp);
        p1MainPanel.add(p1PanelSugar);
        JPanel p2MainPanel = new JPanel();
        p2MainPanel.setLayout(new BoxLayout(p2MainPanel, BoxLayout.Y_AXIS));
        JPanel p2NamePanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JTextArea p2Name = new JTextArea();
        p2Name.setEditable(false);
        p2NamePanel.add(p2Name);
        JPanel p2PanelHeart = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JTextArea heartReading_p2 = new JTextArea("Heart Rate (BPM):");
        JTextField heartReading1_p2 = new JTextField(columnSize);
        JTextField heartReading2_p2 = new JTextField(columnSize);
        JTextField heartReading3_p2 = new JTextField(columnSize);
        JTextField heartReading4_p2 = new JTextField(columnSize);
        JTextField heartReading5_p2 = new JTextField(columnSize);
        heartReading_p2.setEditable(false);
        heartReading1_p2.setEditable(false);
        heartReading2_p2.setEditable(false);
        heartReading3_p2.setEditable(false);
        heartReading4_p2.setEditable(false);
        heartReading5_p2.setEditable(false);
        p2PanelHeart.add(heartReading_p2);
        p2PanelHeart.add(heartReading1_p2);
        p2PanelHeart.add(heartReading2_p2);
        p2PanelHeart.add(heartReading3_p2);
        p2PanelHeart.add(heartReading4_p2);
        p2PanelHeart.add(heartReading5_p2);
        JPanel p2PanelTemp = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JTextArea tempReading_p2 = new JTextArea("Temperature (°C):");
        JTextField tempReading1_p2 = new JTextField(columnSize);
        JTextField tempReading2_p2 = new JTextField(columnSize);
        JTextField tempReading3_p2 = new JTextField(columnSize);
        JTextField tempReading4_p2 = new JTextField(columnSize);
        JTextField tempReading5_p2 = new JTextField(columnSize);
        tempReading_p2.setEditable(false);
        tempReading1_p2.setEditable(false);
        tempReading2_p2.setEditable(false);
        tempReading3_p2.setEditable(false);
        tempReading4_p2.setEditable(false);
        tempReading5_p2.setEditable(false);
        p2PanelTemp.add(tempReading_p2);
        p2PanelTemp.add(tempReading1_p2);
        p2PanelTemp.add(tempReading2_p2);
        p2PanelTemp.add(tempReading3_p2);
        p2PanelTemp.add(tempReading4_p2);
        p2PanelTemp.add(tempReading5_p2);
        JPanel p2PanelSugar = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JTextArea sugarReading_p2 = new JTextArea("Blood Sugar Rate (mg/dL):");
        JTextField sugarReading1_p2 = new JTextField(columnSize);
        JTextField sugarReading2_p2 = new JTextField(columnSize);
        JTextField sugarReading3_p2 = new JTextField(columnSize);
        JTextField sugarReading4_p2 = new JTextField(columnSize);
        JTextField sugarReading5_p2 = new JTextField(columnSize);
        sugarReading_p2.setEditable(false);
        sugarReading1_p2.setEditable(false);
        sugarReading2_p2.setEditable(false);
        sugarReading3_p2.setEditable(false);
        sugarReading4_p2.setEditable(false);
        sugarReading5_p2.setEditable(false);
        p2PanelSugar.add(sugarReading_p2);
        p2PanelSugar.add(sugarReading1_p2);
        p2PanelSugar.add(sugarReading2_p2);
        p2PanelSugar.add(sugarReading3_p2);
        p2PanelSugar.add(sugarReading4_p2);
        p2PanelSugar.add(sugarReading5_p2);
        p2MainPanel.add(p2NamePanel);
        p2MainPanel.add(p2PanelHeart);
        p2MainPanel.add(p2PanelTemp);
        p2MainPanel.add(p2PanelSugar);
        superPanel.add(p1MainPanel);
        superPanel.add(p2MainPanel);
        hospitalFrame.add(superPanel);


        userFrame1.setSize(500, 200);
        userFrame1.setLocation(100, 100);
        userFrame1.setVisible(true);
        homeFrame1.setSize(500, 200);
        homeFrame1.setLocation(900, 100);
        homeFrame1.setVisible(true);
        userFrame2.setSize(500, 200);
        userFrame2.setLocation(100, 400);
        userFrame2.setVisible(true);
        homeFrame2.setSize(500, 200);
        homeFrame2.setLocation(900, 400);
        homeFrame2.setVisible(true);
        hospitalFrame.setSize(500, 400);
        hospitalFrame.setLocation(500, 700);
        hospitalFrame.setVisible(true);

        ArrayList<JTextField> p1UserReadings = new ArrayList<>();
        p1UserReadings.add(heartReading1_p1_user);
        p1UserReadings.add(tempReading1_p1_user);
        p1UserReadings.add(sugarReading1_p1_user);

        ArrayList<JTextField> p1HomeReadings = new ArrayList<>();
        p1HomeReadings.add(heartReading1_p1_home);
        p1HomeReadings.add(tempReading1_p1_home);
        p1HomeReadings.add(sugarReading1_p1_home);

        ArrayList<JTextField> p2UserReadings = new ArrayList<>();
        p2UserReadings.add(heartReading1_p2_user);
        p2UserReadings.add(tempReading1_p2_user);
        p2UserReadings.add(sugarReading1_p2_user);

        ArrayList<JTextField> p2HomeReadings = new ArrayList<>();
        p2HomeReadings.add(heartReading1_p2_home);
        p2HomeReadings.add(tempReading1_p2_home);
        p2HomeReadings.add(sugarReading1_p2_home);

        ArrayList<JTextField> hospitalReadings = new ArrayList<>();
        hospitalReadings.add(heartReading1_p1);
        hospitalReadings.add(tempReading1_p1);
        hospitalReadings.add(sugarReading1_p1);
        hospitalReadings.add(heartReading1_p2);
        hospitalReadings.add(tempReading1_p2);
        hospitalReadings.add(sugarReading1_p2);

        homePanelHeart1.setBackground(new Color(74, 101, 114));
        homePanelTemp1.setBackground(new Color(74, 101, 114));
        homePanelSugar1.setBackground(new Color(74, 101, 114));

        userPanelHeart1.setBackground(new Color(74, 101, 114));
        userPanelTemp1.setBackground(new Color(74, 101, 114));
        userPanelSugar1.setBackground(new Color(74, 101, 114));

        homePanelHeart2.setBackground(new Color(74, 101, 114));
        homePanelTemp2.setBackground(new Color(74, 101, 114));
        homePanelSugar2.setBackground(new Color(74, 101, 114));

        userPanelHeart2.setBackground(new Color(74, 101, 114));
        userPanelTemp2.setBackground(new Color(74, 101, 114));
        userPanelSugar2.setBackground(new Color(74, 101, 114));

        p1NamePanel.setBackground(new Color(74, 101, 114));
        p1PanelHeart.setBackground(new Color(74, 101, 114));
        p1PanelTemp.setBackground(new Color(74, 101, 114));
        p1PanelSugar.setBackground(new Color(74, 101, 114));

        p2NamePanel.setBackground(new Color(74, 101, 114));
        p2PanelHeart.setBackground(new Color(74, 101, 114));
        p2PanelTemp.setBackground(new Color(74, 101, 114));
        p2PanelSugar.setBackground(new Color(74, 101, 114));



        while (true) {
            heartReading5_p1_user.setText(heartReading4_p1_user.getText());
            heartReading4_p1_user.setText(heartReading3_p1_user.getText());
            heartReading3_p1_user.setText(heartReading2_p1_user.getText());
            heartReading2_p1_user.setText(heartReading1_p1_user.getText());
            tempReading5_p1_user.setText(tempReading4_p1_user.getText());
            tempReading4_p1_user.setText(tempReading3_p1_user.getText());
            tempReading3_p1_user.setText(tempReading2_p1_user.getText());
            tempReading2_p1_user.setText(tempReading1_p1_user.getText());
            sugarReading5_p1_user.setText(sugarReading4_p1_user.getText());
            sugarReading4_p1_user.setText(sugarReading3_p1_user.getText());
            sugarReading3_p1_user.setText(sugarReading2_p1_user.getText());
            sugarReading2_p1_user.setText(sugarReading1_p1_user.getText());
            heartReading5_p1_home.setText(heartReading4_p1_home.getText());
            heartReading4_p1_home.setText(heartReading3_p1_home.getText());
            heartReading3_p1_home.setText(heartReading2_p1_home.getText());
            heartReading2_p1_home.setText(heartReading1_p1_home.getText());
            tempReading5_p1_home.setText(tempReading4_p1_home.getText());
            tempReading4_p1_home.setText(tempReading3_p1_home.getText());
            tempReading3_p1_home.setText(tempReading2_p1_home.getText());
            tempReading2_p1_home.setText(tempReading1_p1_home.getText());

            heartReading5_p2_user.setText(heartReading4_p2_user.getText());
            heartReading4_p2_user.setText(heartReading3_p2_user.getText());
            heartReading3_p2_user.setText(heartReading2_p2_user.getText());
            heartReading2_p2_user.setText(heartReading1_p2_user.getText());
            tempReading5_p2_user.setText(tempReading4_p2_user.getText());
            tempReading4_p2_user.setText(tempReading3_p2_user.getText());
            tempReading3_p2_user.setText(tempReading2_p2_user.getText());
            tempReading2_p2_user.setText(tempReading1_p2_user.getText());
            sugarReading5_p2_user.setText(sugarReading4_p2_user.getText());
            sugarReading4_p2_user.setText(sugarReading3_p2_user.getText());
            sugarReading3_p2_user.setText(sugarReading2_p2_user.getText());
            sugarReading2_p2_user.setText(sugarReading1_p2_user.getText());
            heartReading5_p2_home.setText(heartReading4_p2_home.getText());
            heartReading4_p2_home.setText(heartReading3_p2_home.getText());
            heartReading3_p2_home.setText(heartReading2_p2_home.getText());
            heartReading2_p2_home.setText(heartReading1_p2_home.getText());
            tempReading5_p2_home.setText(tempReading4_p2_home.getText());
            tempReading4_p2_home.setText(tempReading3_p2_home.getText());
            tempReading3_p2_home.setText(tempReading2_p2_home.getText());
            tempReading2_p2_home.setText(tempReading1_p2_home.getText());

            heartReading5_p1.setText(heartReading4_p1.getText());
            heartReading4_p1.setText(heartReading3_p1.getText());
            heartReading3_p1.setText(heartReading2_p1.getText());
            heartReading2_p1.setText(heartReading1_p1.getText());
            tempReading5_p1.setText(tempReading4_p1.getText());
            tempReading4_p1.setText(tempReading3_p1.getText());
            tempReading3_p1.setText(tempReading2_p1.getText());
            tempReading2_p1.setText(tempReading1_p1.getText());
            sugarReading5_p1.setText(sugarReading4_p1.getText());
            sugarReading4_p1.setText(sugarReading3_p1.getText());
            sugarReading3_p1.setText(sugarReading2_p1.getText());
            sugarReading2_p1.setText(sugarReading1_p1.getText());
            heartReading5_p2.setText(heartReading4_p2.getText());
            heartReading4_p2.setText(heartReading3_p2.getText());
            heartReading3_p2.setText(heartReading2_p2.getText());
            heartReading2_p2.setText(heartReading1_p2.getText());
            tempReading5_p2.setText(tempReading4_p2.getText());
            tempReading4_p2.setText(tempReading3_p2.getText());
            tempReading3_p2.setText(tempReading2_p2.getText());
            tempReading2_p2.setText(tempReading1_p2.getText());
            sugarReading5_p2.setText(sugarReading4_p2.getText());
            sugarReading4_p2.setText(sugarReading3_p2.getText());
            sugarReading3_p2.setText(sugarReading2_p2.getText());
            sugarReading2_p2.setText(sugarReading1_p2.getText());

            heart1 = getSimMeasurement(50, 250);
            temp1 = getSimMeasurement(30, 45);
            sugar1 = getSimMeasurement(30, 300);

            heart2 = getSimMeasurement(50, 250);
            temp2 = getSimMeasurement(30, 45);
            sugar2 = getSimMeasurement(30, 300);

            //  BEGIN MEASUREMENTS
            hrs1.setHeartRate(heart1);
            bts1.setBodyTemperature(temp1);
            bss1.setBloodSugar(sugar1);

            hrs2.setHeartRate(heart2);
            bts2.setBodyTemperature(temp2);
            bss2.setBloodSugar(sugar2);
            // END MEASUREMENTS

            // Notify observers and get patient's name
            String name1 = baseStation1.notifyObservers();
            String name2 = baseStation2.notifyObservers();

            // BEGIN PATIENT 1
            // Patient 1 User View
            counter = 0;
            while(uv1.hasNext()) {
                Sensor sensor = (Sensor) uv1.next();
                double reading = sensor.readingChanged();
                p1UserReadings.get(counter).setText(String.valueOf(reading));
                switch (counter) {
                    case 0:
                        if (reading > 180 || reading < 70) {
                            heartReading_p1_user.setBackground(Color.RED);
                        } else {
                            heartReading_p1_user.setBackground(Color.GREEN);
                        }
                        break;
                    case 1:
                        if (reading > 37.5 || reading < 33) {
                            tempReading_p1_user.setBackground(Color.RED);
                        } else {
                            tempReading_p1_user.setBackground(Color.GREEN);
                        }
                        break;
                    case 2:
                        if (reading > 140 || reading < 80) {
                            sugarReading_p1_user.setBackground(Color.RED);
                        } else {
                            sugarReading_p1_user.setBackground(Color.GREEN);
                        }
                        break;
                    default:
                        break;
                }
                counter++;
            }

            // Patient 1 Home View
            counter = 0;
            while(hv1.hasNext()) {
                Sensor sensor = (Sensor)hv1.next();
                double reading = sensor.readingChanged();
                p1HomeReadings.get(counter).setText(String.valueOf(reading));
                switch (counter) {
                    case 0:
                        if (reading > 180 || reading < 70) {
                            heartReading_p1_home.setBackground(Color.RED);
                        } else {
                            heartReading_p1_home.setBackground(Color.GREEN);
                        }
                        break;
                    case 1:
                        if (reading > 37.5 || reading < 33) {
                            tempReading_p1_home.setBackground(Color.RED);
                        } else {
                            tempReading_p1_home.setBackground(Color.GREEN);
                        }
                        break;
                    case 2:
                        if (reading > 140 || reading < 80) {
                            sugarReading_p1_home.setBackground(Color.RED);
                            sugarReading1_p1_home.setText("ALERT");
                        } else {
                            sugarReading_p1_home.setBackground(Color.GREEN);
                            sugarReading1_p1_home.setText("GOOD");
                        }
                        break;
                    default:
                        break;
                }
                counter++;
            }
            // END PATIENT 1

            // BEGIN PATIENT 2
            // Patient 2 User View
            counter = 0;
            while(hv2.hasNext()) {
                Sensor sensor = (Sensor)hv2.next();
                double reading = sensor.readingChanged();
                p2UserReadings.get(counter).setText(String.valueOf(reading));
                switch (counter) {
                    case 0:
                        if (reading > 180 || reading < 70) {
                            heartReading_p2_user.setBackground(Color.RED);
                        } else {
                            heartReading_p2_user.setBackground(Color.GREEN);
                        }
                        break;
                    case 1:
                        if (reading > 37.5 || reading < 33) {
                            tempReading_p2_user.setBackground(Color.RED);
                        } else {
                            tempReading_p2_user.setBackground(Color.GREEN);
                        }
                        break;
                    case 2:
                        if (reading > 140 || reading < 80) {
                            sugarReading_p2_user.setBackground(Color.RED);
                        } else {
                            sugarReading_p2_user.setBackground(Color.GREEN);
                        }
                        break;
                    default:
                        break;
                }
                counter++;
            }

            // Patient 2 Home View
            counter = 0;
            while(uv2.hasNext()) {
                Sensor sensor = (Sensor)uv2.next();
                double reading = sensor.readingChanged();
                p2HomeReadings.get(counter).setText(String.valueOf(reading));
                switch (counter) {
                    case 0:
                        if (reading > 180 || reading < 70) {
                            heartReading_p2_home.setBackground(Color.RED);
                        } else {
                            heartReading_p2_home.setBackground(Color.GREEN);
                        }
                        break;
                    case 1:
                        if (reading > 37.5 || reading < 33) {
                            tempReading_p2_home.setBackground(Color.RED);
                        } else {
                            tempReading_p2_home.setBackground(Color.GREEN);
                        }
                        break;
                    case 2:
                        if (reading > 140 || reading < 80) {
                            sugarReading_p2_home.setBackground(Color.RED);
                            sugarReading1_p2_home.setText("ALERT");
                        } else {
                            sugarReading_p2_home.setBackground(Color.GREEN);
                            sugarReading1_p2_home.setText("GOOD");
                        }
                        break;
                    default:
                        break;
                }
                counter++;
            }
            // END PATIENT 2

            // Hospital View for all patients
            counter = 0;
            for  (Base_Station b: hospital.getBaseStations()) {
                // Notify observers again to get corresponding name and measurements
                String n = b.notifyObservers();


                // While there are sensors left to iterate
                while (hospital.hasNext()) {
                    Sensor sensor = (Sensor)hospital.next();
                    double reading = sensor.readingChanged();
                    hospitalReadings.get(counter).setText(String.valueOf(reading));
                    switch (counter) {
                        case 0:
                            p1Name.setText(n);
                            if (reading > 180 || reading < 70) {
                                heartReading_p1.setBackground(Color.RED);
                            } else {
                                heartReading_p1.setBackground(Color.GREEN);
                            }
                            break;
                        case 1:
                            if (reading > 37.5 || reading < 33) {
                                tempReading_p1.setBackground(Color.RED);
                            } else {
                                tempReading_p1.setBackground(Color.GREEN);
                            }
                            break;
                        case 2:
                            if (reading > 140 || reading < 80) {
                                sugarReading_p1.setBackground(Color.RED);
                            } else {
                                sugarReading_p1.setBackground(Color.GREEN);
                            }
                            break;
                        case 3:
                            p2Name.setText(n);
                            if (reading > 180 || reading < 70) {
                                heartReading_p2.setBackground(Color.RED);
                            } else {
                                heartReading_p2.setBackground(Color.GREEN);
                            }
                            break;
                        case 4:
                            if (reading > 37.5 || reading < 33) {
                                tempReading_p2.setBackground(Color.RED);
                            } else {
                                tempReading_p2.setBackground(Color.GREEN);
                            }
                            break;
                        case 5:
                            if (reading > 140 || reading < 80) {
                                sugarReading_p2.setBackground(Color.RED);
                            } else {
                                sugarReading_p2.setBackground(Color.GREEN);
                            }
                            break;
                        default:
                            break;
                    }
                    counter++;
                }

                // Resetting positions for hospital here as the traversals occur within its own loop.
                hospital.resetPosition();
            }

            // Resetting positions to be able to list all measurements
            hv1.resetPosition();
            uv1.resetPosition();
            hv2.resetPosition();
            uv2.resetPosition();
            counter = 0;


            // Wait for a certain time
            try {
                Thread.sleep(sleepTime);
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
