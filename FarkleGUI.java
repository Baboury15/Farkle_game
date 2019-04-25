import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.util.ArrayList;
//import java.awt.event.ActionListener;
public class FarkleGUI extends JFrame implements ActionListener { 

    private JRadioButton player1Radio, player2Radio, player3Radio;
    
    private JButton RollBtn = new JButton("Roll");
    private JButton PassBtn = new JButton("Pass");

    private JLabel player1TurnsLbl;
    private JLabel player1SubTotaLbl;
    private JLabel player1ScoreLbl;

    private JLabel playe2TurnsLbl;
    private JLabel player2SubTotaLbl;
    private JLabel player2ScoreLbl;

    private JLabel player3TurnsLbl;
    private JLabel player3SubTotaLbl;
    private JLabel player3ScoreLbl;

    
    private Farkle theGame;
    private Player curPlayer;

    JMenuItem  NewGameItem;
    JMenuItem BestScore;
    JMenuItem quitItem;

    public static void main(String args[]){
        FarkleGUI frame = new FarkleGUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }  

    public FarkleGUI(){  

       // theGame = new FarkleStub();
       theGame = new Farkle();
       PassBtn.setEnabled(false);
        
        player1TurnsLbl = new JLabel("Turns:");
        playe2TurnsLbl = new JLabel("Turns:");
        player3TurnsLbl = new JLabel("Turns:");
        
        player1SubTotaLbl= new JLabel("Subtotal:");
        player2SubTotaLbl= new JLabel("Subtotal:");
        player3SubTotaLbl = new JLabel("Subtotal:");
        
        player1ScoreLbl = new JLabel("Score:");
        player2ScoreLbl = new JLabel("Score:");
        player3ScoreLbl = new JLabel("Score:");
        
        theGame.setActivePlayer(1);
        curPlayer = theGame.getActivePlayer();
        player1Radio = new JRadioButton(curPlayer.getName(), false);
        theGame.setActivePlayer(2);
        curPlayer = theGame.getActivePlayer();
        player2Radio = new JRadioButton(curPlayer.getName(), false);
        theGame.setActivePlayer(3);
        curPlayer = theGame.getActivePlayer();
        player3Radio = new JRadioButton(curPlayer.getName(), false);

        player1Radio.addActionListener(this);
        player2Radio.addActionListener(this);
        player3Radio.addActionListener(this);

        setTitle("Farkle!");

        setupMenus();
        
        setLayout(new GridBagLayout());
        GridBagConstraints position = new GridBagConstraints();
        
        position.anchor = GridBagConstraints.LINE_START;
        position.insets = new Insets(3,3,3,5);
        
         // create radio buttons for size  Jpanel  to position player names
         // turns  subtotals and scores
       
                
        ArrayList<GVdie> theDice = theGame.getDice();
        
        RollBtn.addActionListener(this);
        PassBtn.addActionListener(this);
        
      //first I set my cordinate to their starting point (1,1)
        
        position.gridx = 1;
        position.gridy = 1;
        
      //Now I get the list of dies from the FarkeStub object and 
     // iterate through them one by one


        for (GVdie die: theGame.getDice()){
        	// add the dice to the JFrame
        	add(die,position);
        	
        	//I Increase the cordinate on the x axis by one, so that
        	// the dice aren't on top of eachother.
        	
        	position.gridx = position.gridx + 1;
        }

      

        
        position = new GridBagConstraints();
        position.gridy = 2;
        position.gridx = 2;
        add(RollBtn, position);
        position.gridx = 3;
        add(PassBtn, position);
        
        position.gridx = 4;//3
        position.gridy = 2; 
        add(player1Radio, position);
        position.gridy = 3;
        add(player1TurnsLbl, position);
        position.gridy = 4;
        add(player1SubTotaLbl, position);
        position.gridy = 5;
        add(player1ScoreLbl, position);

        position.gridx = 5;// 4
        position.gridy = 2; 
        add(player2Radio, position);
        position.gridy = 3;
        add(playe2TurnsLbl, position);
        position.gridy = 4;
        add(player2SubTotaLbl, position);
        position.gridy = 5;
        add(player2ScoreLbl, position);
        
        position.gridx = 6; //5
        position.gridy = 2; 
        add(player3Radio, position);
        position.gridy = 3;
        add(player3TurnsLbl, position);
        position.gridy = 4;
        add(player3SubTotaLbl, position);
        position.gridy = 5;
        add(player3ScoreLbl, position);
        
        for (GVdie die: theGame.getDice()){
        	
      }
        }
    public void actionPerformed(ActionEvent e) {
    
    	if(e.getSource() == NewGameItem){
            theGame.resetGame();
        }
    	
    	if(e.getSource() == quitItem){
    		System.exit(0);
        }
    	
    	if(e.getSource() == BestScore){
        	Player best = theGame.getBestPlayer();
            JOptionPane.showMessageDialog(this, "Name: " + best.getName() + "\nScore: " + best.getScore() + "\nTurns: " + best.getTurns());
        }
    	
    	
    	 if(e.getSource() == RollBtn){
             theGame.rollDice();
             player1Radio.setEnabled(false);
             player2Radio.setEnabled(false);
             player3Radio.setEnabled(false);
             if (theGame.PlayerFarkle()){
             	JOptionPane.showMessageDialog(this, theGame.getActivePlayer().getName() + " got a Farkle!");
             	theGame.passDice();
             	player1Radio.setEnabled(true);
             	player2Radio.setEnabled(true);
             	player3Radio.setEnabled(true);
                 theGame.PlayerFarkle();
             }
             
    	}
    	 if (e.getSource() == PassBtn){
             theGame.passDice();
             player1Radio.setEnabled(true);
             player2Radio.setEnabled(true);
             player3Radio.setEnabled(true);
         }
    	 if (e.getSource() == player1Radio){
         	player2Radio.setSelected(false);
         	player3Radio.setSelected(false);
             theGame.setActivePlayer(1);
             curPlayer = theGame.getActivePlayer();
         }

         if (e.getSource() == player2Radio){
         	player1Radio.setSelected(false);
         	player3Radio.setSelected(false);
             theGame.setActivePlayer(2);
             curPlayer = theGame.getActivePlayer();
         }

         if (e.getSource() == player3Radio){
         	player2Radio.setSelected(false);
         	player1Radio.setSelected(false);
             theGame.setActivePlayer(3);
             curPlayer = theGame.getActivePlayer();
         }
         if (player1Radio.isSelected()){
          player1TurnsLbl.setText("Turns: " + curPlayer.getTurns());
          player1SubTotaLbl.setText("Subtotal: " + curPlayer.getSubtotal());
          player1ScoreLbl.setText("Score: " + curPlayer.getScore());
         }
         
         if (player2Radio.isSelected()){
        	 playe2TurnsLbl.setText("Turns: " + curPlayer.getTurns());
        	 player2SubTotaLbl.setText("Subtotal: " + curPlayer.getSubtotal());
        	 player2ScoreLbl.setText("Score: " + curPlayer.getScore());
         }
         
         if (player3Radio.isSelected()){
        	 player3TurnsLbl.setText("Turns: " + curPlayer.getTurns());
        	 player3SubTotaLbl.setText("Subtotal: " +curPlayer.getSubtotal());
        	 player3ScoreLbl.setText("Score: " + curPlayer.getScore());
         }
         if (!theGame.okToRoll()){
         	RollBtn.setEnabled(false);
         }
         
         if (theGame.okToRoll()){
         	RollBtn.setEnabled(true);
         }
         
         if (!theGame.okToPass()){
         	PassBtn.setEnabled(false);
         }
         
         if (theGame.okToPass()){
         	PassBtn.setEnabled(true);
         }
         
         if (theGame.getActivePlayer().getScore() >= 10000){
         	JOptionPane.showMessageDialog(this, theGame.getActivePlayer().getName() + " Wins!");
         	newGame(); 
         	}
         }
         
         private void newGame() {
             theGame.resetGame();
             
             
         
             theGame.setActivePlayer(3);
             curPlayer = theGame.getActivePlayer();
             player3ScoreLbl.setText("Score: " + curPlayer.getScore());
             player3SubTotaLbl.setText("Sub Total: " + curPlayer.getSubtotal()); 
             player3TurnsLbl.setText("Turns: " + curPlayer.getTurns());

             theGame.setActivePlayer(2);
             curPlayer = theGame.getActivePlayer();
             player2ScoreLbl.setText("Score: " + curPlayer.getScore());
             player2SubTotaLbl.setText("Sub Total: " + curPlayer.getSubtotal()); 
             player2ScoreLbl.setText("Turns: " + curPlayer.getTurns());

             theGame.setActivePlayer(1);
             curPlayer = theGame.getActivePlayer();;
             player1ScoreLbl.setText("Score: " + curPlayer.getScore());
             player1SubTotaLbl.setText("Sub Total: " + curPlayer.getSubtotal()); 
             player1ScoreLbl.setText("Turns: " + curPlayer.getTurns());

         }
   
   private void setupMenus (){
    // create and display the menu bar
    JMenuBar menusBar = new JMenuBar();
    setJMenuBar(menusBar);

    // create a menu and add to the menubar
    JMenu fileMenu = new JMenu("File");
    menusBar.add(fileMenu);

    
    // create a menu item for Quit
    quitItem = new JMenuItem("Quit");
    fileMenu.add(quitItem);
    quitItem.addActionListener(this);  
 
    // create a menu item for New Game

    NewGameItem = new JMenuItem("New Game");
    fileMenu.add(NewGameItem);
    NewGameItem.addActionListener(this);  
   
    // create a menu item for Best score 

    BestScore = new JMenuItem("Best Score");
    fileMenu.add(BestScore);
    BestScore.addActionListener(this);  
    
   }
  }

    

    
