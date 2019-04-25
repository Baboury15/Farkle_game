
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList; 
import java.util.Scanner;

import javax.swing.*;
import java.util.Random;
import java.util.Set;

public class Farkle {
    private Random rand = new Random();
    private boolean firstRoll;
    private static  boolean wrongFarkle ;
    private Player thePlayer;
    private ArrayList<GVdie> myDice;
    private final int  NUM_DICE = 6;
    private int tally [] ;

    private Player[] players = new Player[3];
    private final int STRAIGHT = 1000;
    private final int WINNING_SCORE = 10000;
    private final int THREE_PAIRS = 1000;
    private final int  ONES = 100;
    private final int FIVES = 50;
    private int THREE_OF_A_KIND;
    private int FOUR_OF_A_KIND;
    private int FIVE_OF_A_KIND;
    private int SIX_OF_A_KIND;
    private boolean okToRoll;
    private boolean okToPass;

	
    public Farkle (){
        myDice = new ArrayList<GVdie>();
        tally  = new int [7];

        this.players[0] = new Player("Ibrahim");
        this.players[1] = new Player("Malick");
        this.players[2] = new Player("Amadou");
        this.thePlayer = this.players[0];
        for (int i = 1; i <= 6; i++) {
            this.myDice.add(new GVdie(90));

			
        }
        this.resetGame();

		
    }
    public Player getActivePlayer(){
        return thePlayer;
    }

    public boolean gameOver(){
        if (thePlayer.getScore() >= 10000){
            return true;
        }
        return false;

    }
    public ArrayList <GVdie> getDice () {
        return myDice;
    }
    ////////////////////////////////////////////
    private void tallySelectedDice() {

        // clear array
        for (int i=1; i<tally.length; i++){
            tally[i] = 0;
        }

        // update tally for each selected GVdie 
        for (GVdie d : myDice){
            if(d.isSelected()){
                int val = d.getValue();
                tally[val]++;
            }

        }
        //	this.getDice();

    }

    public void tallyUnscoredDice(){
        for (int i=1; i<tally.length; i++){
            tally[i] = 0;
        }

        // update tally for each selected GVdie 
        for (GVdie d : myDice){
            if(!d.isSelected()){
                int val = d.getValue();
                tally[val]++;
            }
        }

    }
    ///////////////////////////////////////////////////////

    private boolean hasStraight() {
        for (int i = 1 ; i < tally.length;i++){
            if (tally[i] != 1){

            }
            return false;
        }
        return true;
    }

    private boolean hasThreePairs() {
        int count = 0;
        for (int i = 1 ; i < tally.length;i++){
            if (tally[i] == 2){
                if(count == 3)
                    return true;
            }
            count++;
        }
        return false;		
    }

    private void nextTurn(){
        for (GVdie d: this.myDice){
            d.setSelected(false);
            d.setScored(false);
            d.setBlank();
        }
        this.okToRoll = true;
        this.okToPass = false;
        this.firstRoll = true;

    }

    public void resetGame(){
        for (Player p: this.players){
            p.newGame();
        }
        this.nextTurn();
    }

    public void scoreSelectedDice(){
        this.tallySelectedDice();
        int num = 1;
        //Random rn = new Random();
        if (hasStraight()){
            thePlayer.addToSubtotal(STRAIGHT);
        }

        else if (hasThreePairs() ){
            thePlayer.addToSubtotal(THREE_PAIRS);

        }else { 	for (int i = 1 ; i < tally.length;i++){
        	System.out.println(x);
                if (tally[i]== 1){
                    thePlayer.addToSubtotal(ONES);
                    }

                else if (tally[i]== 5){
                        thePlayer.addToSubtotal(50);
                    }

                }
            }
      //  }

        // Three of a kIND
        for (int i = 1 ; i < tally.length;i++){
        
        	if (tally[i]==3 && i == 1 ){
                num = num*1000;
                thePlayer.addToSubtotal(num);
            }

            if (tally[i]== 3 && i == 2 ) {
                num = 2*100;
                thePlayer.addToSubtotal(num);
            }

            /*else*/ if (tally[i]== 3 && i == 3){
                num = 3*100;
                thePlayer.addToSubtotal(num);
            }
            /*else*/ if (tally[i]==3 && i == 4){
                num = 4*100;
                thePlayer.addToSubtotal(num);
            }
            /*else*/ if (tally[i]==3 && i == 5 ){
                num = 5*100;
                thePlayer.addToSubtotal(num);
            }

           /* else*/ if (tally[i]==3 && i == 6 ){
                num = 6*100;
                thePlayer.addToSubtotal(num);
            }
            

	
            // FOUR OF A KIND 
            else if (tally[i]== 4 && i == 2 ) {
                num = 2*200;
                thePlayer.addToSubtotal(num);
            }

            else if (tally[i]== 4 && i == 3){
                num = 3*200;
                thePlayer.addToSubtotal(num);
            }
            else if (tally[i]== 4 && i == 4){
                num = 4*200;
                thePlayer.addToSubtotal(num);
            }
            else if (tally[i]==4 && i == 5 ){
                num = 5*200;
                thePlayer.addToSubtotal(num);
            }

            else if (tally[i]==4 && i == 6 ){
                num = 6*200;
                thePlayer.addToSubtotal(num);
            }
            else if (tally[i]==4 && i == 1 ){
                num = 1*2000;
                thePlayer.addToSubtotal(num);
            }

	
            // FIVE OF A KIND 
           
           if (tally[i]==5 && i == 1 ){
               num = 1*3000;
               thePlayer.addToSubtotal(num);
           }

            /*else*/ if (tally[i]== 5 && i == 2 ) {
                num = 2*300;
                thePlayer.addToSubtotal(num);
            }

         if (tally[i]== 5 && i == 3){
                num = 3*300;
                thePlayer.addToSubtotal(num);
            }
           if (tally[i]==5 && i == 4){
                num = 4*300;
                thePlayer.addToSubtotal(num);
            }
            if (tally[i]==5 && i == 5 ){
                num = 5*300;
                thePlayer.addToSubtotal(num);
            }

            if (tally[i]==5 && i == 6 ){
                num = 6*300;
                thePlayer.addToSubtotal(num);
            }
          

            // SIX of A KIND
            else if (tally[i]== 6 && i == 2 ) {
                num = 2*400;
                thePlayer.addToSubtotal(num);
            }

            else if (tally[i]== 6 && i == 3){
                num = 3*400;
                thePlayer.addToSubtotal(num);
            }
            else if (tally[i]==6 && i == 4){
                num = 4*400;
                thePlayer.addToSubtotal(num);
            }
            else if (tally[i]==6 && i == 5 ){
                num = 5*400;
                thePlayer.addToSubtotal(num);
            }

            else if (tally[i]==6 && i == 6 ){
                num = 6*400;
                thePlayer.addToSubtotal(num);
            }
            else if (tally[i]==6 && i == 1 ){
                num = 1*4000;
                thePlayer.addToSubtotal(num);
            }
            for (GVdie d: myDice){

                if (d.isSelected())
                    d.setScored(true);
            }
        }	

    }	

    ////////////////////////////
    public void rollDice(){

        if ( this.firstRoll || !this.noDiceSelected()) {

            this.firstRoll = false;
            this.okToPass = true;
            this.scoreSelectedDice();
            this.resetIfAllDiceScored();
            for (GVdie d : this.myDice) {
                if (!d.isSelected() && !d.isScored());
                d.roll();
            }

            //boolean bl = this.wrongFarkle = this.rand.nextInt(10) <= 2;
            if (this.PlayerFarkle()) {
                this.thePlayer.setSubtotal(0);
                this.okToRoll = false;

            }
        }

	  
    }

    public void passDice() {
        this.scoreSelectedDice();
        this.thePlayer.updateScore();
        this.nextTurn();
    }

    private void resetIfAllDiceScored() {
        int scored = 0;
        for (GVdie d : this.myDice) {
            if (!d.isScored());
            ++scored;
        }
        if (scored == 6) {
            for (GVdie d : this.myDice) {
                d.setSelected(false);
                d.setScored(false);
            }
        }

    }

    public boolean okToRoll() {
        return this.okToRoll;
    }

    public boolean okToPass() {
        return this.okToPass;
    }

    private boolean noDiceSelected() {
        for (GVdie d: myDice){
            if (!d.isSelected()){
                return true;
            }
        }

        return false;
    }

    public boolean PlayerFarkle() {
        this.tallyUnscoredDice();;
        int num = 1;
       
            if (hasStraight() ){
                return false;

            }
            else if (hasThreePairs()){
                return false;
            }
            else {

                for (int i = 1 ; i < tally.length;i++){
                    if (tally[i]== 1){

                        if (tally[i]== 5){
                            thePlayer.addToSubtotal(FIVES);
                            return false;
                        

                    }
                }

		   
            }		

		
	    	
        }
        // Three of a kIND
        for (int i = 1 ; i < tally.length;i++){

            if (tally[i]== 3 && i == 2 ) {
                num = 2*100;
                return false;

            }

            else if (tally[i]== 3 && i == 3){
                num = 3*100;
                return false;

            }
            else if (tally[i]==3 && i == 4){
                num = 4*100;
                return false;

            }
            else if (tally[i]==3 && i == 5 ){
                num = 5*100;
                return false;

            }

            else if (tally[i]==3 && i == 6 ){
                num = 6*100;
                return false;
            }
            else if (tally[i]==3 && i == 1 ){
                num = num*1000;

                return false;
            }

		
            // FOUR OF A KIND 
            else if (tally[i]== 4 && i == 2 ) {
                num = 2*200;
                return false;
            }

            else if (tally[i]== 4 && i == 3){
                num = 3*200;
                return false;
            }
            else if (tally[i]== 4 && i == 4){
                num = 4*200;
                return false;
            }
            else if (tally[i]==4 && i == 5 ){
                num = 5*200;
                return false;
            }

            else if (tally[i]==4 && i == 6 ){
                num = 6*200;
                return false;
            }
            else if (tally[i]==4 && i == 1 ){
                num = 1*2000;
                return false;
            }

		
            // FIVE OF A KIND 

            else if (tally[i]== 5 && i == 2 ) {
                num = 2*300;
                return false;
            }

            else if (tally[i]== 5 && i == 3){
                num = 3*300;
                return false;
            }
            else if (tally[i]==5 && i == 4){
                num = 4*300;
                return false;
            }
            else if (tally[i]==5 && i == 5 ){
                num = 5*300;
                return false;
            }

            else if (tally[i]==5 && i == 6 ){
                num = 6*300;
                return false;
            }
            else if (tally[i]==5 && i == 1 ){
                num = 1*3000;
                return false;
            }

            // SIX of A KIND
            else if (tally[i]== 6 && i == 2 ) {
                num = 2*400;
                return true;
            }

            else if (tally[i]== 6 && i == 3){
                num = 3*400;
                return true;
            }
            else if (tally[i]==6 && i == 4){
                num = 4*400;
                return true;
            }
            else if (tally[i]==6 && i == 5 ){
                num = 5*400;
                return true;
            }

            else if (tally[i]==6 && i == 6 ){
                num = 6*400;
                return true;
            }
            else if (tally[i]==6 && i == 1 ){
                num = 1*4000;
                return true;
            }
            for (GVdie d: myDice){

                if (d.isSelected())
                    d.setScored(true);
            }
        }	

        return false;
    }	
		
		
		
	

		    		
    public void setActivePlayer(int id) {
        this.thePlayer = this.players[id - 1];
    }

    public Player getBestPlayer (){

        return this.thePlayer;
    }

    public void setcheckBestScore(Player p){

    }
 
    public void setAllDice(int []values){
        values = new int [6];
        for (GVdie d: myDice){
            if (d.getValue() != 6)
                d.roll();

        }
    }

    public void selectDie(int id){

    	myDice.get(id-1).setSelected(true);
    }
    public void setBestPlayer (Player P){
  Player p = this.getBestPlayer(); 
    	
    }
  private void checkBestScore(){
	  
	 
  }
public void saveBestPayer(){
  
  try{ 

      // open the text file and use a Scanner to read the text
      FileInputStream fileByteStream = new FileInputStream("bestplayer.txt");
      Scanner scnr = new Scanner(fileByteStream);
      scnr.useDelimiter("[,\r\n]+");

      // keep reading as long as there is more data
      while(scnr.hasNext()) {

          // FIX ME: read the firstName, lastName and email
          String firstName = scnr.next();
          
          
          
          // discarding the data found in the file after the email - IT is not needed
          scnr.nextLine();
          
          // FIX ME: instantiate a Customer object and add it to the ArrayList
          // You could do this with one or two lines of code.

      }
      fileByteStream.close();
  }
  catch(IOException e) {
  //    System.out.println("Failed to read the data file: " + bestplayer.txt);
  }

}
}




	
	
		

  


