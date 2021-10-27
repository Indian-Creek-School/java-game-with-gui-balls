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

    //array lists for each of the players we are going to make
    private ArrayList<Player> pgProspects;
    private ArrayList<Player> sgProspects;
    private ArrayList<Player> sfProspects;
    private ArrayList<Player> pfProspects;
    private ArrayList<Player> centerProspects;
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

    //JButtons to be used for drafting
    public JButton b1;
    public JButton b2;
    public JButton b3;
    public JButton b4;
    public JButton b5;

    //continue button
    public JButton b6;

    //JLabel for showing team:
    public JLabel output;


    public BallsApp(){

        pgProspects = new ArrayList<Player>();
        sgProspects = new ArrayList<Player>();
        sfProspects = new ArrayList<Player>();
        pfProspects = new ArrayList<Player>();
        centerProspects = new ArrayList<Player>();

        //setting a JFrame
        this.setLayout(new GridLayout(6,2));

        //initializing JComboBoxes
        for(int i = 0; i < 5; i++){
            pgProspects.add(new PG());
            sgProspects.add(new SG());
            sfProspects.add(new SF());
            pfProspects.add(new PF());
            centerProspects.add(new Center());
        }

        //defining new string arrays to set JComboBoxes to that include players name, position, and overall
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

        //initializing JComboBoxes
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

        b6 = new JButton("Continue");
        b6.setVerticalTextPosition(AbstractButton.CENTER);
        b6.setHorizontalTextPosition(AbstractButton.LEADING); 


        //intializing user drafted arraylist
        draftedTeam = new ArrayList<Player>();

        //JLabel that will display team as it gets drafted
        output = new JLabel("Team");
        output.setText(draftedTeam.toString());
        Font font = new Font("Times New Roman", Font.BOLD, 12);
        output.setFont(font);
        output.setForeground(Color.BLACK);

        /**
         * All the actions listeners: Gets the selected player, turn it into a string of the players name,
         * Finds player object that matches with that players name, adds it to the
         * draftedTeam arraylist, and removes it from the JComboBox options.
         */

        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String playerSelected = pgs.getSelectedItem().toString();
                // System.out.println(playerSelected);
                String playerName = "";
                int i = 0;
                while(!(playerSelected.charAt(i) == ',')){
                    playerName += playerSelected.charAt(i);
                    i++;
                }
                // System.out.println(playerName);

                for(int j = 0; j < pgProspects.size(); j++){
                    if(pgProspects.get(j).getName().equals(playerName)){
                        draftedTeam.add(pgProspects.get(j));
                        System.out.println(draftedTeam.toString());
                        pgProspects.remove(j);
                        pgs.removeItem(pgNames[j]);
                    }
                }
                // System.out.println(pgProspects.toString());

                //updating text:
                for(int k = 0; k < draftedTeam.size(); k++){
                    output.setText(draftedTeam.get(k).toString()+", "+draftedTeam.get(k).getPos()+", "+draftedTeam.get(k).getOverall());
                }
                repaint();


                // //adds best available shooting guard to team 1
                // Player selectedSG = Player.highestOvrPlayer(sgProspects);
                // simTeam1.add(selectedSG);
                // sgProspects.remove(selectedSG);
                // sgs.removeItem(selectedSG);

                // //adds best available small forward to team 2
                // Player selectedSF = Player.highestOvrPlayer(sfProspects);
                // simTeam1.add(selectedSF);
                // sfProspects.remove(selectedSF);
                // sfs.removeItem(selectedSF);

                // //adds best available power forward to team 3
                // Player selectedPF = Player.highestOvrPlayer(pfProspects);
                // simTeam1.add(selectedPF);
                // sgProspects.remove(selectedPF);
                // pfs.removeItem(selectedPF);

                // //adds best available center to team 4
                // Player selectedCenter = Player.highestOvrPlayer(centerProspects);
                // simTeam1.add(selectedCenter);
                // centerProspects.remove(selectedCenter);
                // centers.removeItem(selectedCenter);


                simTeam1 = new ArrayList<Player>();
                simTeam2 = new ArrayList<Player>();
                simTeam3 = new ArrayList<Player>();
                simTeam4 = new ArrayList<Player>();
                Player.addPlayerToTeam(sgProspects, simTeam1, sgs);
                Player.addPlayerToTeam(sfProspects, simTeam2, sfs);
                Player.addPlayerToTeam(pfProspects, simTeam3, pfs);
                Player.addPlayerToTeam(centerProspects, simTeam4, centers);
            }
        });

        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String playerSelected = sgs.getSelectedItem().toString();
                // System.out.println(playerSelected);
                String playerName = "";
                int i = 0;
                while(!(playerSelected.charAt(i) == ',')){
                    playerName += playerSelected.charAt(i);
                    i++;
                }
                // System.out.println(playerName);

                for(int j = 0; j < sgProspects.size(); j++){
                    if(sgProspects.get(j).getName().equals(playerName)){
                        draftedTeam.add(sgProspects.get(j));
                        System.out.println(draftedTeam.toString());
                        sgProspects.remove(j);
                        sgs.removeItem(sgNames[j]);
                    }
                }
                for(int k = 0; k < draftedTeam.size(); k++){
                    output.setText(draftedTeam.get(k).toString()+", "+draftedTeam.get(k).getPos()+", "+draftedTeam.get(k).getOverall());
                }
                repaint();

                Player.addPlayerToTeam(sgProspects, simTeam4, sgs);
                Player.addPlayerToTeam(sfProspects, simTeam1, sfs);
                Player.addPlayerToTeam(pfProspects, simTeam2, pfs);
                Player.addPlayerToTeam(centerProspects, simTeam3, centers);
            }
        });

        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String playerSelected = sfs.getSelectedItem().toString();
                // System.out.println(playerSelected);
                String playerName = "";
                int i = 0;
                while(!(playerSelected.charAt(i) == ',')){
                    playerName += playerSelected.charAt(i);
                    i++;
                }
                // System.out.println(playerName);

                for(int j = 0; j < sfProspects.size(); j++){
                    if(sfProspects.get(j).getName().equals(playerName)){
                        draftedTeam.add(sfProspects.get(j));
                        System.out.println(draftedTeam.toString());
                        sfProspects.remove(j);
                        sfs.removeItem(sfNames[j]);
                    }
                }
                for(int k = 0; k < draftedTeam.size(); k++){
                    output.setText(draftedTeam.get(k).toString()+", "+draftedTeam.get(k).getPos()+", "+draftedTeam.get(k).getOverall());
                }
                repaint();

                Player.addPlayerToTeam(sgProspects, simTeam3, sgs);
                Player.addPlayerToTeam(sfProspects, simTeam4, sfs);
                Player.addPlayerToTeam(pfProspects, simTeam1, pfs);
                Player.addPlayerToTeam(centerProspects, simTeam2, centers);
            }
        });

        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String playerSelected = pfs.getSelectedItem().toString();
                // System.out.println(playerSelected);
                String playerName = "";
                int i = 0;
                while(!(playerSelected.charAt(i) == ',')){
                    playerName += playerSelected.charAt(i);
                    i++;
                }
                // System.out.println(playerName);

                for(int j = 0; j < pfProspects.size(); j++){
                    if(pfProspects.get(j).getName().equals(playerName)){
                        draftedTeam.add(pfProspects.get(j));
                        System.out.println(draftedTeam.toString());
                        pfProspects.remove(j);
                        pfs.removeItem(pfNames[j]);
                    }
                }
                for(int k = 0; k < draftedTeam.size(); k++){
                    output.setText(draftedTeam.get(k).toString()+", "+draftedTeam.get(k).getPos()+", "+draftedTeam.get(k).getOverall());
                }
                repaint();

                Player.addPlayerToTeam(sgProspects, simTeam2, sgs);
                Player.addPlayerToTeam(sfProspects, simTeam3, sfs);
                Player.addPlayerToTeam(pfProspects, simTeam4, pfs);
                Player.addPlayerToTeam(centerProspects, simTeam1, centers);
            }
        });

        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String playerSelected = centers.getSelectedItem().toString();
                // System.out.println(playerSelected);
                String playerName = "";
                int i = 0;
                while(!(playerSelected.charAt(i) == ',')){
                    playerName += playerSelected.charAt(i);
                    i++;
                }
                // System.out.println(playerName);

                for(int j = 0; j < centerProspects.size(); j++){
                    if(centerProspects.get(j).getName().equals(playerName)){
                        draftedTeam.add(centerProspects.get(j));
                        System.out.println(draftedTeam.toString());
                        centerProspects.remove(j);
                        centers.removeItem(sfNames[j]);
                    }
                }
                for(int k = 0; k < draftedTeam.size(); k++){
                    output.setText(draftedTeam.get(k).toString()+", "+draftedTeam.get(k).getPos()+", "+draftedTeam.get(k).getOverall());
                }
                repaint();

                Player.addPlayerToTeam(sgProspects, simTeam1, sgs);
                Player.addPlayerToTeam(sfProspects, simTeam2, sfs);
                Player.addPlayerToTeam(pfProspects, simTeam3, pfs);
                Player.addPlayerToTeam(centerProspects, simTeam4, centers);
            }
        });

        b6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });

        //adding elements to grid layout
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
        this.add(output);
        this.add(b6);
        repaint();

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
