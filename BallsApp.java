import java.util.ArrayList;
import java.awt.Font;
import java.awt.Color;
// import java.awt.Dimension;

import javax.swing.AbstractButton;
import javax.swing.JButton;
// import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
// import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
// import javax.swing.ImageIcon;

import javax.swing.JFrame;
// import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.awt.event.KeyEvent;
import java.awt.GridLayout;

public class BallsApp extends JPanel{
    //main class that will run

    //counts time a button runs
    private int timesRun;
    private int gameCount;
    private int finalsGameCount;

    //array lists which separates prospect players to be drafted by position
    private ArrayList<Player> pgProspects;
    private ArrayList<Player> sgProspects;
    private ArrayList<Player> sfProspects;
    private ArrayList<Player> pfProspects;
    private ArrayList<Player> centerProspects;
    //arraylist of players which will hold each teams drafted players
    private ArrayList<Player> draftedTeam;
    private ArrayList<Player> simTeam1;
    private ArrayList<Player> simTeam2;
    private ArrayList<Player> simTeam3;
    private ArrayList<Player> simTeam4;

    //arraylist of playoff teams
    private ArrayList<Team> playoffs;

    //teams to be used. Will have arraylist corresponding to one above.
    private Team team1;
    private Team team2;
    private Team team3;
    private Team team4;
    private Team userTeam;


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

    //continue buttons
    public JButton b6;
    public JButton b7;
    public JButton b8;
    public JButton b9;

    //end button
    public JButton b10;

    //semifinals play game button
    public JButton b11;

    //finals play game button
    public JButton b12;

    //semifinals record label
    public JLabel seriesScore = new JLabel("Semifinals");

    //finals record label
    public JLabel finalSeriesScore = new JLabel("Finals");

    //JLabel for showing team:
    public JLabel output;
    public JLabel record = new JLabel("record");
    public JLabel teamDisplay = new JLabel("User Team");
    public JLabel endLoseMessage = new JLabel("You lost");
    public JLabel teamDisplay2 = new JLabel("User Team 2");

    //end game message
    public JLabel endLoseSemisMessage = new JLabel("You Lost v2");
    public JLabel endLoseFinalsMessage = new JLabel("You Lost v3");
    public JLabel winMessage = new JLabel("Congratulations!");


    public BallsApp(){

        //declaring arraylists which hold prospect players to be drafted
        pgProspects = new ArrayList<Player>();
        sgProspects = new ArrayList<Player>();
        sfProspects = new ArrayList<Player>();
        pfProspects = new ArrayList<Player>();
        centerProspects = new ArrayList<Player>();

        //setting a JFrame
        GridLayout gridLayout = new GridLayout(6,2);
        this.setLayout(gridLayout);

        //initializing arraylists of prospect players by adding 8 of each correct type to
        //corresponding arraylist
        for(int i = 0; i < 8; i++){
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

        //initializing JComboBoxes for draft
        pgs = new JComboBox<String>(pgNames);
        sgs = new JComboBox<String>(sgNames);
        sfs = new JComboBox<String>(sfNames);
        pfs = new JComboBox<String>(pfNames);
        centers = new JComboBox<String>(centerNames);

        //initializing the draft buttons for draft
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

        b7 = new JButton("Start Regular Season!");
        b7.setVerticalTextPosition(AbstractButton.CENTER);
        b7.setHorizontalTextPosition(AbstractButton.LEADING); 

        b8 = new JButton("Continue");
        b8.setVerticalTextPosition(AbstractButton.CENTER);
        b8.setHorizontalTextPosition(AbstractButton.LEADING);

        b9 = new JButton("Continue");
        b9.setVerticalTextPosition(AbstractButton.CENTER);
        b9.setHorizontalTextPosition(AbstractButton.LEADING);

        b10 = new JButton("End");
        b10.setVerticalTextPosition(AbstractButton.CENTER);
        b10.setHorizontalTextPosition(AbstractButton.LEADING);

        b11 = new JButton("Play Game");
        b11.setVerticalTextPosition(AbstractButton.CENTER);
        b11.setHorizontalTextPosition(AbstractButton.LEADING);

        //button for finals:
        b12 = new JButton("Play Finals Game");
        b12.setVerticalTextPosition(AbstractButton.CENTER);
        b12.setHorizontalTextPosition(AbstractButton.LEADING);

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

        //JLabel that will display team as it gets drafted
        output = new JLabel("Team");
        Font font = new Font("Times New Roman", Font.BOLD, 12);
        output.setFont(font);
        output.setForeground(Color.BLACK);

        //adds jlabel followed by continue button to the layout
        this.add(output);
        this.add(b6);

        //intializing user drafted arraylist
        draftedTeam = new ArrayList<Player>();

        //initializing simulated teams (teams user does not draft)
        simTeam1 = new ArrayList<Player>();
        simTeam2 = new ArrayList<Player>();
        simTeam3 = new ArrayList<Player>();
        simTeam4 = new ArrayList<Player>();

        //making array list of all teams they are going to play to iterate through
        ArrayList<Team> league = new ArrayList<Team>();

        /**
         * All the actions listeners: Gets the selected player, turn it into a string of the players name,
         * Finds player object that matches with that players name, adds it to the
         * draftedTeam arraylist, and removes it from the JComboBox options.
         */

        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //gets player selected by user in the dropdown
                String playerSelected = pgs.getSelectedItem().toString();
                //isolates players name to be used to get the actual player object
                String playerName = "";
                int i = 0;
                while(!(playerSelected.charAt(i) == ',')){
                    playerName += playerSelected.charAt(i);
                    i++;
                }

                //finding the actual player object given its name
                for(int j = 0; j < pgProspects.size(); j++){
                    if(pgProspects.get(j).getName().equals(playerName)){
                        draftedTeam.add(pgProspects.get(j));
                        System.out.println(draftedTeam.toString());
                        pgs.removeItem(pgProspects.get(j).getName()+", "+pgProspects.get(j).getPos()+", "+pgProspects.get(j).getOverall());
                        pgProspects.remove(j);
                    }
                }

                //updating text displaying team:
                for(int k = 0; k < draftedTeam.size(); k++){
                    String result = "";
                    result += draftedTeam.get(k).toString()+", "+draftedTeam.get(k).getPos()+", "+draftedTeam.get(k).getOverall() + "\n";
                    output.setText(result);
                }
                repaint();

                //adding best overall players in other 4 positions to the sim teams
                Player.addPlayerToTeam(sgProspects, simTeam1, sgs);
                Player.addPlayerToTeam(sfProspects, simTeam2, sfs);
                Player.addPlayerToTeam(pfProspects, simTeam3, pfs);
                Player.addPlayerToTeam(centerProspects, simTeam4, centers);
            }
        });

        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //gets player selected by user in the dropdown
                String playerSelected = sgs.getSelectedItem().toString();
                //isolates players name to be used to get the actual player object
                String playerName = "";
                int i = 0;
                while(!(playerSelected.charAt(i) == ',')){
                    playerName += playerSelected.charAt(i);
                    i++;
                }

                //finding the actual player object given its name
                for(int j = 0; j < sgProspects.size(); j++){
                    if(sgProspects.get(j).getName().equals(playerName)){
                        draftedTeam.add(sgProspects.get(j));
                        System.out.println(draftedTeam.toString());
                        sgs.removeItem(sgProspects.get(j).getName()+", "+sgProspects.get(j).getPos()+", "+sgProspects.get(j).getOverall());
                        sgProspects.remove(j);
                    }
                }

                //updating text displaying team:
                for(int k = 0; k < draftedTeam.size(); k++){
                    String result = "";
                    result += draftedTeam.get(k).toString()+", "+draftedTeam.get(k).getPos()+", "+draftedTeam.get(k).getOverall() + "\n";
                    output.setText(result);
                }
                repaint();

                //adding best overall players in other 4 positions to the sim teams
                Player.addPlayerToTeam(centerProspects, simTeam1, centers);
                Player.addPlayerToTeam(pgProspects, simTeam2, pgs);
                Player.addPlayerToTeam(sfProspects, simTeam3, sfs);
                Player.addPlayerToTeam(pfProspects, simTeam4, pfs);
            }
        });

        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //gets player selected by user in the dropdown
                String playerSelected = sfs.getSelectedItem().toString();
                //isolates players name to be used to get the actual player object
                String playerName = "";
                int i = 0;
                while(!(playerSelected.charAt(i) == ',')){
                    playerName += playerSelected.charAt(i);
                    i++;
                }

                //finding the actual player object given its name
                for(int j = 0; j < sfProspects.size(); j++){
                    if(sfProspects.get(j).getName().equals(playerName)){
                        draftedTeam.add(sfProspects.get(j));
                        System.out.println(draftedTeam.toString());
                        sfs.removeItem(sfProspects.get(j).getName()+", "+sfProspects.get(j).getPos()+", "+sfProspects.get(j).getOverall());
                        sfProspects.remove(j);
                    }
                }

                //updating text displaying team:
                for(int k = 0; k < draftedTeam.size(); k++){
                    String result = "";
                    result += draftedTeam.get(k).toString()+", "+draftedTeam.get(k).getPos()+", "+draftedTeam.get(k).getOverall() + "\n";
                    output.setText(result);
                }
                repaint();

                //adding best overall players in other 4 positions to the sim teams
                Player.addPlayerToTeam(pfProspects, simTeam1, pfs);
                Player.addPlayerToTeam(centerProspects, simTeam2, centers);
                Player.addPlayerToTeam(pgProspects, simTeam3, pgs);
                Player.addPlayerToTeam(sgProspects, simTeam4, sgs);
            }
        });

        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //gets player selected by user in the dropdown
                String playerSelected = pfs.getSelectedItem().toString();
                //isolates players name to be used to get the actual player object
                String playerName = "";
                int i = 0;
                while(!(playerSelected.charAt(i) == ',')){
                    playerName += playerSelected.charAt(i);
                    i++;
                }

                //finding the actual player object given its name                
                for(int j = 0; j < pfProspects.size(); j++){
                    if(pfProspects.get(j).getName().equals(playerName)){
                        draftedTeam.add(pfProspects.get(j));
                        System.out.println(draftedTeam.toString());
                        pfs.removeItem(pfProspects.get(j).getName()+", "+pfProspects.get(j).getPos()+", "+pfProspects.get(j).getOverall());
                        pfProspects.remove(j);
                    }
                }

                //updating text displaying team:
                for(int k = 0; k < draftedTeam.size(); k++){
                    String result = "";
                    result += draftedTeam.get(k).toString()+", "+draftedTeam.get(k).getPos()+", "+draftedTeam.get(k).getOverall() + "\n";
                    output.setText(result);
                }
                repaint();

                //adding best overall players in other 4 positions to the sim teams
                Player.addPlayerToTeam(sfProspects, simTeam1, sfs);
                Player.addPlayerToTeam(sgProspects, simTeam2, sgs);
                Player.addPlayerToTeam(centerProspects, simTeam3, centers);
                Player.addPlayerToTeam(pgProspects, simTeam4, pgs);
            }
        });

        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //gets player selected by user in the dropdown
                String playerSelected = centers.getSelectedItem().toString();
                //isolates players name to be used to get the actual player object
                String playerName = "";
                int i = 0;
                while(!(playerSelected.charAt(i) == ',')){
                    playerName += playerSelected.charAt(i);
                    i++;
                }

                //finding the actual player object given its name
                for(int j = 0; j < centerProspects.size(); j++){
                    if(centerProspects.get(j).getName().equals(playerName)){
                        draftedTeam.add(centerProspects.get(j));
                        System.out.println(draftedTeam.toString());
                        centers.removeItem(centerProspects.get(j).getName()+", "+centerProspects.get(j).getPos()+", "+centerProspects.get(j).getOverall());
                        centerProspects.remove(j);
                        centers.removeItem(sfNames[j]);
                    }
                }

                //updating text displaying team:
                for(int k = 0; k < draftedTeam.size(); k++){
                    String result = "";
                    result += draftedTeam.get(k).toString()+", "+draftedTeam.get(k).getPos()+", "+draftedTeam.get(k).getOverall() + "\n";
                    output.setText(result);
                }
                repaint();

                //adding best overall players in other 4 positions to the sim teams
                Player.addPlayerToTeam(pgProspects, simTeam1, pgs);
                Player.addPlayerToTeam(pfProspects, simTeam2, pfs);
                Player.addPlayerToTeam(sgProspects, simTeam3, sgs);
                Player.addPlayerToTeam(sfProspects, simTeam4, sfs);
            }
        });

        //creates the teams to be used in regular season based on arraylist made during draft
        userTeam = new Team(draftedTeam);
        team1 = new Team(simTeam1);
        team2 = new Team(simTeam2);
        team3 = new Team(simTeam3);
        team4 = new Team(simTeam4);

        /**removes all items, sets new layout,
         * displays all teams drafted on a new screen.
         */
        b6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //defines new font
                Font font = new Font("Times New Roman", Font.BOLD, 15);

                //resets JFrame to remove all elements
                removeAll();
                validate();
                repaint();

                //redefines new gridlayout to display all teams
                setLayout(new GridLayout(1,5));

                //makes label that displays users team
                JLabel draftTeam = new JLabel("Drafted Team");
                draftTeam.setText("<html>" + "Your Team: " + "<br/>" + userTeam.toString());
                draftTeam.setForeground(Color.white);
                draftTeam.setFont(font);
                draftTeam.setVerticalAlignment(SwingConstants.CENTER);
                draftTeam.setHorizontalAlignment(SwingConstants.CENTER);
                add(draftTeam);

                //makes label that display sim team 1
                JLabel t1 = new JLabel("Severn Titanics");
                t1.setText("<html>" + "Severn Titanics: " + "<br/>" + team1.toString());
                t1.setForeground(Color.white);
                t1.setFont(font);
                t1.setHorizontalAlignment(SwingConstants.CENTER);
                t1.setVerticalAlignment(SwingConstants.CENTER);
                add(t1);

                //makes label that display sim team 2
                JLabel t2 = new JLabel("Indian Creek Eagles");
                t2.setText("<html>" + "Indian Creek Eagles: " + "<br/>" + team2.toString());
                t2.setForeground(Color.white);
                t2.setFont(font);
                t2.setHorizontalAlignment(SwingConstants.CENTER);
                t2.setVerticalAlignment(SwingConstants.CENTER);
                add(t2);

                //makes label that display sim team 3
                JLabel t3 = new JLabel("Key Submarines");
                t3.setText("<html>" + "Key Submarines: " + "<br/>" + team3.toString());
                t3.setFont(font);
                t3.setForeground(Color.white);
                t3.setHorizontalAlignment(SwingConstants.CENTER);
                t3.setVerticalAlignment(SwingConstants.CENTER);
                add(t3);

                //makes label that display sim team 4
                JLabel t4 = new JLabel("Saint Mary Devils");
                t4.setText("<html>" + "Saint Mary Devils: " + "<br/>" + team4.toString());
                t4.setFont(font);
                t4.setForeground(Color.white);
                t4.setHorizontalAlignment(SwingConstants.CENTER);
                t4.setVerticalAlignment(SwingConstants.CENTER);
                add(t4);
                validate();
                repaint();

                //adds continue to regular season button
                add(b7);
            }
        });

        //continue to regular season button
        b7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //resets JFrame to remove all elements
                removeAll();
                validate();
                repaint();

                System.out.println(team1.getTeamOverall());
                System.out.println(team2.getTeamOverall());
                System.out.println(team3.getTeamOverall());
                System.out.println(team4.getTeamOverall());
                System.out.println(userTeam.getTeamOverall());

                //redefines new gridlayout to display all teams
                setLayout(new GridLayout(1,3));

                //makes new JLabel to display users record
                Font font2 = new Font("Times New Roman", Font.BOLD, 30);
                record.setFont(font2);
                record.setForeground(Color.white);
                record.setHorizontalAlignment(SwingConstants.CENTER);
                record.setVerticalAlignment(SwingConstants.CENTER);

                //sets text of JLabel to display team
                teamDisplay.setFont(font);
                teamDisplay.setForeground(Color.white);
                teamDisplay.setHorizontalAlignment(SwingConstants.CENTER);
                teamDisplay.setVerticalAlignment(SwingConstants.CENTER);
                teamDisplay.setText(userTeam.toString());

                //adds all to layout and updates layout
                add(b8);
                add(record);
                add(teamDisplay);
                validate();
                repaint();

                //sets text of record to current record
                String currRecord = userTeam.getRecord();
                record.setText(currRecord);

                //adds all teams to league which will be used to loop through and sim games
                league.add(team1);
                league.add(team2);
                league.add(team3);
                league.add(team4);
            
                /**Simming first 8 games of season based on overall of team
                 * Also displays the overall, lineup, and current record following sim
                 */
                for(int i = 0; i < 2; i++){
                    for(int j = 0; j < 4; j++){
                        //if true user wins game, if false user loses
                        Boolean win = mainSeason.simGame(userTeam, league.get(j));

                        //updates record according to boolean value
                        if(win) {
                            userTeam.wins += 1;
                            league.get(j).losses += 1;
                        } else {
                            userTeam.losses += 1;
                            league.get(j).wins += 1;
                        }
                        //updates record and GUI text
                        currRecord = userTeam.getRecord();
                        record.setText(currRecord);
                        validate();
                        repaint();
                    }
                }

                //sims cpu v cpu games
                for(int i = 0; i < 4; i++) {
                    for(int j = 0; j < 4; j++){
                        //sims games of cpu teams
                        if(league.get(i) != league.get(j)){
                            Boolean simGame = mainSeason.simGame(league.get(i), league.get(j));

                            //updates their record according to value of boolean
                            if(simGame){
                                league.get(i).wins += 1;
                                league.get(j).losses += 1;
                            } else {
                                league.get(i).losses += 1;
                                league.get(j).wins += 1;
                            }
                        }
                    }
                }
            }
        });


        //button counter variable that counts how many times it has been run
        timesRun = 0;
        b8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //updates times run
                timesRun = timesRun + 1;

                //runs folloiwng code that sims regular season games as long as it is less than 8 times
                if(timesRun < 8) {
                    //random player gets a disease, just an easter egg
                    int x = Random.getRandomInt(0,8);
                    if(x==0){
                        System.out.println(Random.aids(userTeam));
                    }

                    //generates random team that will be used in trade
                    Team randomTeam = mainSeason.generateRandomTeam(team1, team2, team3, team4);

                    //generates random player on random team
                    Player tradingFor = mainSeason.getPlayerTradingFor(randomTeam);

                    //generates index of random player user is trading
                    int intOfPlayerTrading = (int)(Math.random()*8);
                    Player playerTrading = userTeam.team.get(intOfPlayerTrading);

                    //pop up options menu that returns 0 if yes and 1 if no in regards to the trade
                    int returnValue = JOptionPane.showConfirmDialog(null, "A team has proposed trading " +  tradingFor.toString() + ", " + tradingFor.getPos() + ", " + tradingFor.getOverall()+ " " +
                    "for your player "  +  playerTrading.toString() + ", " + playerTrading.getPos() + ", " + playerTrading.getOverall(), "Trade Proposal", JOptionPane.YES_NO_OPTION);
                    // System.out.println(returnValue);

                    //updates a boolean value based on user's input in pop up menu
                    Boolean tradeAccepted = false;
                    if(returnValue == 0){
                        tradeAccepted = true;
                    } else if(returnValue == 1) {
                        tradeAccepted = false;
                    }

                    //algorithm that runs the trade based on boolean tradeAccepted
                    mainSeason.trade(tradeAccepted, playerTrading, tradingFor, userTeam, randomTeam);
                    // System.out.println(userTeam.toString());

                    //updates team text
                    teamDisplay.setText(userTeam.toString());
                    validate();
                    repaint();

                    //sims next 8 user games
                    for(int i = 0; i < 2; i++){
                        for(int j = 0; j < 4; j++){
                            Boolean win = mainSeason.simGame(userTeam, league.get(j));
                            if(win) {
                                userTeam.wins += 1;
                                league.get(j).losses += 1;
                            } else {
                                userTeam.losses += 1;
                                league.get(j).wins += 1;
                            }
                            String currRecord = userTeam.getRecord();
                            record.setText(currRecord);
                            validate();
                            repaint();
                        }
                    }

                    //sims cpu v cpu games
                    for(int i = 0; i < 4; i++) {
                        for(int j = 0; j < 4; j++){
                            if(league.get(i) != league.get(j)){
                                Boolean simGame = mainSeason.simGame(league.get(i), league.get(j));
                                if(simGame){
                                    league.get(i).wins += 1;
                                    league.get(j).losses += 1;
                                } else {
                                    league.get(i).losses += 1;
                                    league.get(j).wins += 1;
                                }
                            }
                        }
                    }

                    // System.out.println(team1.getRecord());
                    // System.out.println(team2.getRecord());
                    // System.out.println(team3.getRecord());
                    // System.out.println(team4.getRecord());
                    // System.out.println(userTeam.getRecord());
                } else {
                    //runs when regular season is done
                    removeAll();
                    validate();
                    repaint();
                    setLayout(new GridLayout(2,1));
                    playoffs = mainSeason.setPlayoffs(userTeam, team1, team2, team3, team4);
                    //checking if user made playoffs
                    Boolean userInPlayoffs = null;
                    for(Team t : playoffs){
                        if(t.equals(userTeam)){
                            userInPlayoffs = true;
                        } else {
                            userInPlayoffs = false;
                        }
                    }
                    System.out.println(userInPlayoffs);
                    if(userInPlayoffs) {
                        removeAll();
                        validate();
                        repaint();
                        setLayout(new GridLayout(3,1));

                        //Semifinals screen setup
                        seriesScore.setFont(font);
                        seriesScore.setForeground(Color.white);
                        seriesScore.setHorizontalAlignment(SwingConstants.CENTER);
                        seriesScore.setVerticalAlignment(SwingConstants.CENTER);
                        teamDisplay.setText(userTeam.toString());
                        add(b11);
                        add(seriesScore);
                        add(teamDisplay);
                        validate();
                        repaint();
                    } else {
                        //sets lose message to GUI if user loses 
                        endLoseMessage.setText("Congratulations! You missed the playoffs and earned the number one overall pick! (aka, you lose)");
                        endLoseMessage.setFont(font);
                        endLoseMessage.setForeground(Color.white);
                        endLoseMessage.setHorizontalAlignment(SwingConstants.CENTER);
                        endLoseMessage.setVerticalAlignment(SwingConstants.CENTER);
                        add(endLoseMessage);
                        add(b10);
                        validate();
                        repaint();
                    }
                }
            }
        });

        //end button that closes GUI
        b10.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        gameCount = 0;
        b11.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int seedOfUser = 0;
                int counter = userTeam.finalWs;
                if(gameCount < 3 && counter <= 2){

                    //finding which seed users team is:
                    for(int i = 0; i < playoffs.size(); i++){
                        if(playoffs.get(i) == userTeam){
                            seedOfUser = i;
                        }
                    }
                
                    System.out.println(seedOfUser);

                    //if loop where within prompts will be shown to user for gametime decisions
                    int decision = 0;
                    if(gameCount == 0){
                        int returnValue = JOptionPane.showConfirmDialog(null, "The opposing team's point guard has a turnover issue. Should you (yes) switch to a zone defense or (no) stick to man?", "Game 1 Strategy", JOptionPane.YES_NO_OPTION);
                        if(returnValue == 0){
                            decision = -2;
                        } else {
                            decision = 2;
                        }
                    } else if(gameCount == 1){
                        int returnValue = JOptionPane.showConfirmDialog(null, "Your starting small forward is injured. Should you (yes) play a backup in his place or (no) have him push through", "Game 2 Strategy", JOptionPane.YES_NO_OPTION);
                        if(returnValue == 0){
                            decision = 2;
                        } else {
                            decision = -2;
                        }
                    } else if (gameCount == 2){
                        int returnValue = JOptionPane.showConfirmDialog(null, "This is it. Your last game. Your shooting guard has been cold all series long. Should you (yes) keep starting him or (no) start the backup", "Game 3 Strategy", JOptionPane.YES_NO_OPTION);
                        if(returnValue == 0){
                            decision = -5;
                        } else {
                            decision = 5;
                        }
                    }

                    //sims semifinals game based on user seed
                    if(seedOfUser == 0){
                        Playoffs.simSemisPlayoffGame(playoffs.get(0), playoffs.get(3), decision);
                        Playoffs.simSemisPlayoffGame(playoffs.get(1), playoffs.get(2), 0);
                    } else if(seedOfUser == 1){
                        Playoffs.simSemisPlayoffGame(playoffs.get(1), playoffs.get(2), decision);
                        Playoffs.simSemisPlayoffGame(playoffs.get(0), playoffs.get(3), 0);
                    } else if(seedOfUser == 2){
                        Playoffs.simSemisPlayoffGame(playoffs.get(2), playoffs.get(1), decision);
                        Playoffs.simSemisPlayoffGame(playoffs.get(3), playoffs.get(0), 0);
                    } else if(seedOfUser == 3){
                        Playoffs.simSemisPlayoffGame(playoffs.get(3), playoffs.get(0), decision);
                        Playoffs.simSemisPlayoffGame(playoffs.get(1), playoffs.get(2), 0);
                    }

                    //updates GUI
                    seriesScore.setText(userTeam.semiWs + " - " + userTeam.semiLs);
                    validate();
                    repaint();
                    gameCount++;
                    counter = userTeam.semiWs;
                } else {
                    //runs after semifinals series is over and checks if they won
                    if(userTeam.semiWs > userTeam.semiLs){
                        removeAll();
                        validate();
                        repaint();
                        //removing losing teams from playoffs
                        if(seedOfUser == 0){
                            playoffs.remove(3);
                            if(playoffs.get(1).semiWs > playoffs.get(2).semiWs) {
                                playoffs.remove(2);
                            } else {
                                playoffs.remove(1);
                            }
                        } else if(seedOfUser == 3){
                            playoffs.remove(0);
                            if(playoffs.get(1).semiWs > playoffs.get(2).semiWs) {
                                playoffs.remove(2);
                            } else {
                                playoffs.remove(1);
                            }
                        } else if(seedOfUser == 1){
                            playoffs.remove(2);
                            if(playoffs.get(0).semiWs > playoffs.get(3).semiWs) {
                                playoffs.remove(3);
                            } else {
                                playoffs.remove(0);
                            }
                        } else if(seedOfUser == 2){
                            playoffs.remove(1);
                            if(playoffs.get(0).semiWs > playoffs.get(3).semiWs) {
                                playoffs.remove(3);
                            } else {
                                playoffs.remove(0);
                            }
                        }

                        //updating GUI to finals
                        add(b12);
                        add(finalSeriesScore);
                        add(teamDisplay);
                        validate();
                        repaint();
                    } else {
                        removeAll();
                        validate();
                        repaint();
                        setLayout(new GridLayout(2,1));
                        endLoseSemisMessage.setFont(font);
                        endLoseSemisMessage.setForeground(Color.white);
                        endLoseSemisMessage.setHorizontalAlignment(SwingConstants.CENTER);
                        endLoseSemisMessage.setVerticalAlignment(SwingConstants.CENTER);
                        endLoseSemisMessage.setText("You lost and you didn't get the first overall pick. Sucks to suck!");
                        add(b10);
                    }
                }
            }
        });

        //button that will control finals series
        finalsGameCount = 0;
        b12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //vairable that stores user finals wins
                int counter = userTeam.finalWs;
                //if statement that checks if series is over (max games or max number of wins/losses)
                if(finalsGameCount < 7 && counter < 4) {

                    /**series of if statements and pop ups that ask users to make game strategy decisons
                     * Depending on response, variable decision is altered to add to user team's overall
                     * in determining whether they won or not
                     */
                    int decision = 0;
                    if(finalsGameCount == 0){
                        int returnValue = JOptionPane.showConfirmDialog(null, "Your opponent likes to play with a fast pace. Should you slow it down on offense (yes) or push the ball on offense (no).", "Game 1 Strategy", JOptionPane.YES_NO_OPTION);
                        if(returnValue == 0){
                            decision = 2;
                        } else {
                            decision = -2;
                        }
                    } else if(finalsGameCount == 1){
                        int returnValue = JOptionPane.showConfirmDialog(null, "Before the big game your team wants to go out to a party. Should you let them to increase morale (yes) or tell them no (no)", "Game 2 Strategy", JOptionPane.YES_NO_OPTION);
                        if(returnValue == 0){
                            decision = -2;
                        } else {
                            decision = 2;
                        }
                    } else if (finalsGameCount == 2){
                        int returnValue = JOptionPane.showConfirmDialog(null, "Your starting PF was caught out of his room after curfew. Should you (yes) bench him or start him (no)", "Game 3 Strategy", JOptionPane.YES_NO_OPTION);
                        if(returnValue == 0){
                            decision = 3;
                        } else {
                            decision = -3;
                        }
                    } else if(finalsGameCount == 3) {
                        int returnValue = JOptionPane.showConfirmDialog(null, "Your team is struggling to figure out the opponent's scheme. Should you (no) continue with your normal pre day routines or (yes) have your team watch film.", "Game 4 Strategy", JOptionPane.YES_NO_OPTION);
                        if(returnValue == 0){
                            decision = -3;
                        } else {
                            decision = 3;
                        }
                    } else if(finalsGameCount == 4){
                        int returnValue = JOptionPane.showConfirmDialog(null, "One of your players was caught playing BallsApp.java. Should you (yes) bench him or (no) start him?", "Game 5 Strategy", JOptionPane.YES_NO_OPTION);
                        if(returnValue == 0){
                            decision = -4;
                        } else {
                            decision = 4;
                        }
                    } else if(finalsGameCount == 5){
                        int returnValue = JOptionPane.showConfirmDialog(null, "This is a pivotal game. Should you (yes) feed have a pizza party before the game or (no) have them rest in their rooms?", "Game 6 Strategy", JOptionPane.YES_NO_OPTION);
                        if(returnValue == 0){
                            decision = 1;
                        } else {
                            decision = -1;
                        }
                    } else if(finalsGameCount == 6){
                        int returnValue = JOptionPane.showConfirmDialog(null, "Game 7. This is where legends are made. Are you a legend?", "Game 7 Strategy", JOptionPane.YES_NO_OPTION);
                        if(returnValue == 0){
                            decision = 9;
                        } else {
                            decision = -9;
                        }
                    }

                    //finding index of non-user playoff team
                    int index = 0;
                    for(int i = 0; i < playoffs.size(); i++){
                        if(!playoffs.get(i).equals(userTeam)){
                            index = i;
                        }
                    }

                    //sims finals game
                    Playoffs.simFinalsPlayoffGame(userTeam, playoffs.get(index), decision);

                    //updates GUI
                    finalSeriesScore.setText(userTeam.finalWs + " - " + userTeam.finalLs);
                    finalSeriesScore.setFont(font);
                    finalSeriesScore.setForeground(Color.white);
                    finalSeriesScore.setHorizontalAlignment(SwingConstants.CENTER);
                    finalSeriesScore.setVerticalAlignment(SwingConstants.CENTER);
                    validate();
                    repaint();

                    //iterates game count and updates user teams wins
                    finalsGameCount++;
                    counter = userTeam.finalWs;

                //when series is over, this code runs and is an exit path from the game
                } else {
                    //checks if they won
                    if(userTeam.finalWs > userTeam.finalLs) {
                        //removes all GUI components
                        removeAll();
                        validate();
                        repaint();
                        setLayout(new GridLayout(2,1));

                        //adds new win GUI
                        winMessage.setText("Congratulations! You won the finals!");
                        winMessage.setFont(font);
                        winMessage.setForeground(Color.white);
                        winMessage.setHorizontalAlignment(SwingConstants.CENTER);
                        winMessage.setVerticalAlignment(SwingConstants.CENTER);
                        add(winMessage);
                        add(b10);
                        validate();
                        repaint();
                    } else {
                        //removes GUI components
                        removeAll();
                        validate();
                        repaint();
                        setLayout(new GridLayout(2,1));

                        //sets new GUI to lose finals message
                        endLoseFinalsMessage.setText("Congratulations! You're the biggest loser!");
                        endLoseFinalsMessage.setFont(font);
                        endLoseFinalsMessage.setForeground(Color.white);
                        endLoseFinalsMessage.setHorizontalAlignment(SwingConstants.CENTER);
                        endLoseFinalsMessage.setVerticalAlignment(SwingConstants.CENTER);
                        add(endLoseFinalsMessage);
                        add(b10);
                        validate();
                        repaint();
                    } 
                }
            }
        });
    }

    //method sets up and establishes JFrame for GUI
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
        setUp();
    }
}
