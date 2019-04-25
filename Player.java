
public class Player extends GVdie {
    private String name;
    private int score;
    private int subtotal;
    private int turns;

    public Player(String pName){
        name = pName;
    }

    public String getName(){
        //- returns player’s name.  
        return name;
    }

    public void setName(String n) {
        //- set player’s name.  
        System.out.println(name); 
    }

    public int getScore() { 
        //returns player’s score.  
        return score;
    }

    public void setScore(int s){ 
        //- set player’s score. 
        System.out.println(score);

    }

    public int getSubtotal(){ 
        //- returns player’s subtotal.  
        return subtotal;
    }

    public void setSubtotal(int s) {
        //- set player’s subtotal.  
        System.out.println(subtotal);
    }

    public int getTurns()  {
        //- returns player’s number of turns.  
        return turns;
    }

    public void setTurns(int t) {
        //- set player’s number of turns.  
        System.out.println(turns);
    }

    public void addToSubtotal(int amt) {

        subtotal = subtotal + amt ;  //– increase the player’s subtotal by the parameter amt. 
    }

    public void updateScore() {  
        score = score + subtotal; //– increase the player’s score by the subtotal and then set subtotal to zero.  Increment number of turns by one.  For example:
    }
    public void newGame(){
        score = 0;
        subtotal = 0;                  //– reset the player’s score, subtotal and number of turns to zero
    }


}