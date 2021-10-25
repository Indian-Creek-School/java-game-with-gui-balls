import java.util.ArrayList;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.AbstractButton;
import javax.swing.JButton;
// import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.xml.sax.SAXNotRecognizedException;

// import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
// import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.GridLayout;

public class BallsApp extends JPanel{
    //main class that will run

    //array lists for each of the players we are going to make
    private ArrayList<PG> pgProspects;
    private ArrayList<SG> sgProspects;
    private ArrayList<SF> sfProspects;
    private ArrayList<PF> pfProspects;
    private ArrayList<Center> centerProspects;

    //jcombo boxes for the dropdowns for the draft
    private JComboBox<String> pgs;
    private JComboBox<String> sgs;
    private JComboBox<String> sfs;
    private JComboBox<String> pfs;
    private JComboBox<String> centers;


    public BallsApp(){

        pgProspects = new ArrayList<PG>();
        sgProspects = new ArrayList<SG>();
        sfProspects = new ArrayList<SF>();
        pfProspects = new ArrayList<PF>();
        centerProspects = new ArrayList<Center>();
        //setting a JFrame
        this.setLayout(new GridLayout(1,5));

        //initializing JComboBoxes
        for(int i = 0; i < 5; i++){
            pgProspects.add(new PG());
            sgProspects.add(new SG());
            sfProspects.add(new SF());
            pfProspects.add(new PF());
            centerProspects.add(new Center());
        }

        String[] pgNames = new String[pgProspects.size()];
        for(int i = 0; i < pgProspects.size(); i++){
            pgNames[i] = pgProspects.get(i).toString();
        }

        String[] sgNames = new String[pgProspects.size()];
        for(int i = 0; i < sgProspects.size(); i++){
            sgNames[i] = sgProspects.get(i).toString();
        }

        String[] sfNames = new String[sfProspects.size()];
        for(int i = 0; i < sfProspects.size(); i++){
            sfNames[i] = sfProspects.get(i).toString();
        }

        String[] pfNames = new String[pfProspects.size()];
        for(int i = 0; i < pfProspects.size(); i++){
            pfNames[i] = pfProspects.get(i).toString();
        }

        String[] centerNames = new String[centerProspects.size()];
        for(int i = 0; i < centerProspects.size(); i++){
            centerNames[i] = centerProspects.get(i).toString();
        }

        pgs = new JComboBox<String>(pgNames);
        sgs = new JComboBox<String>(sgNames);
        sfs = new JComboBox<String>(sfNames);
        pfs = new JComboBox<String>(pfNames);
        centers = new JComboBox<String>(centerNames);

        this.add(pgs);
        this.add(sgs);
        this.add(sfs);
        this.add(pfs);
        this.add(centers);


    }

    public static void setUp(){
        JFrame frame = new JFrame("Balls App");
        frame.setTitle("2051-52 NBA Season Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BallsApp contentPane = new BallsApp();
        frame.setContentPane(contentPane);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.pack();   
        frame.setSize(800,800);    
        frame.setVisible(true);
    }

    public static void main(String args[]){
        // System.out.println(Random.newName());

        // PG bob = new PG();
        // System.out.println(bob.getOverall());
        // System.out.println(bob.getThree());
        // System.out.println(System.getProperty("user.dir"));
        // mainSeason m=new mainSeason();
        // m.SoundClipTest();

        setUp();

    }
}
