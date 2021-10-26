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
    private ArrayList<Player> draftedTeam;
    private ArrayList<Player> simTeam1;
    private ArrayList<Player> simTeam2;
    private ArrayList<Player> simTeam3;
    private ArrayList<Player> simTeam4;

    //jcombo boxes for the dropdowns for the draft
    private JComboBox<String> pgs;
    private JComboBox<String> sgs;
    private JComboBox<String> sfs;
    private JComboBox<String> pfs;
    private JComboBox<String> centers;

    public JButton b1;
    public JButton b2;
    public JButton b3;
    public JButton b4;
    public JButton b5;


    public BallsApp(){

        pgProspects = new ArrayList<PG>();
        sgProspects = new ArrayList<SG>();
        sfProspects = new ArrayList<SF>();
        pfProspects = new ArrayList<PF>();
        centerProspects = new ArrayList<Center>();
        //setting a JFrame
        this.setLayout(new GridLayout(5,2));

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
            pgNames[i] = pgProspects.get(i).toString() + ", " + pgProspects.get(i).getPos() + ", " + pgProspects.get(i).getOverall();
        }

        String[] sgNames = new String[pgProspects.size()];
        for(int i = 0; i < sgProspects.size(); i++){
            sgNames[i] = sgProspects.get(i).toString() + ", " + sgProspects.get(i).getPos() + ", " + sgProspects.get(i).getOverall();
        }

        String[] sfNames = new String[sfProspects.size()];
        for(int i = 0; i < sfProspects.size(); i++){
            sfNames[i] = sfProspects.get(i).toString() + ", " + sfProspects.get(i).getPos() + ", " + sfProspects.get(i).getOverall();
        }

        String[] pfNames = new String[pfProspects.size()];
        for(int i = 0; i < pfProspects.size(); i++){
            pfNames[i] = pfProspects.get(i).toString() + ", " + pfProspects.get(i).getPos() + ", " + pfProspects.get(i).getOverall();
        }

        String[] centerNames = new String[centerProspects.size()];
        for(int i = 0; i < centerProspects.size(); i++){
            centerNames[i] = centerProspects.get(i).toString() + ", " + centerProspects.get(i).getPos() + ", " + centerProspects.get(i).getOverall();
        }

        pgs = new JComboBox<String>(pgNames);
        sgs = new JComboBox<String>(sgNames);
        sfs = new JComboBox<String>(sfNames);
        pfs = new JComboBox<String>(pfNames);
        centers = new JComboBox<String>(centerNames);

        //initializing the draft buttons

        b1 = new JButton("Draft PG");
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING); 

        b2 = new JButton("Draft SG");
        b2.setVerticalTextPosition(AbstractButton.CENTER);
        b2.setHorizontalTextPosition(AbstractButton.LEADING); 

        b3 = new JButton("Draft SF");
        b3.setVerticalTextPosition(AbstractButton.CENTER);
        b3.setHorizontalTextPosition(AbstractButton.LEADING); 

        b4 = new JButton("Draft PF");
        b4.setVerticalTextPosition(AbstractButton.CENTER);
        b4.setHorizontalTextPosition(AbstractButton.LEADING); 

        b5 = new JButton("Draft C");
        b5.setVerticalTextPosition(AbstractButton.CENTER);
        b5.setHorizontalTextPosition(AbstractButton.LEADING); 

        //intializing user drafted arraylist
        draftedTeam = new ArrayList<Player>();

        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String playerSelected = pgs.getSelectedItem().toString();
                String playerName = "";
                int i = 0;
                while(!(playerSelected.charAt(i) == ' ')){
                    playerName += playerSelected.charAt(i);
                }


                Player selectedPlayer = new PG();
                for(int j = 0; j < pgProspects.size(); j++){
                    if(pgProspects.get(i).get)
                }

            }
        });

        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){


            }
        });

        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){


            }
        });

        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){


            }
        });

        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){


            }
        });


        this.add(pgs);
        this.add(b1);
        this.add(sgs);
        this.add(b2);
        this.add(sfs);
        this.add(b3);
        this.add(pfs);
        this.add(b4);
        this.add(centers);
        this.add(b5);


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
