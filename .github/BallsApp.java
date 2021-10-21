import java.util.ArrayList;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.AbstractButton;
import javax.swing.JButton;
// import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
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
    private ArrayList<PG> pgProspects;
    private ArrayList<SG> sgProspects;
    private ArrayList<SF> sfProspects;
    private ArrayList<PF> pfProspects;
    private ArrayList<Center> centerProspects;
    private JComboBox<PG> pgs;
    private JComboBox<SG> sgs;
    private JComboBox<SF> sfs;
    private JComboBox<PF> pfs;
    private JComboBox<Center> centers;


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
        System.out.println(Random.newName());

        PG bob = new PG();
        System.out.println(bob.getOverall());
        System.out.println(bob.getThree());
    }
}
