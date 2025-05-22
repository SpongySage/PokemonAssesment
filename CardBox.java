import java.util.HashMap;
import ecs100.*;
/**
 * Write a description of class CardBox here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CardBox
{
    // instance variables - replace the example below with your own
    private HashMap<Integer, Card> box; // "Integer" is id, "Card" is the card
    private int cardId; // stores card id to add to new cards
    private Card foundCard;
    
    // constants
    static final String DEFAULTIMAGE = "defaultImage.png";
    
    // image var
    private double imgBottom;
    private double imgRight;
    
    private int imgLeft = 75; // image x start position
    private int imgTop = 75; // image y start position
    private double imgWidth = 250; // fixed image width
    private double imgHeight = 345; // fixed image height

    /**
     * Constructor for objects of class CardBox
     */
    public CardBox()
    {
        // initialise instance variables
        box = new HashMap<Integer, Card>();
        
        cardId = 0; // sets card id to 0 so it is not null
        
        
        addCard("Bulbasaur", 3);
        addCard("Squirtle", 6.98);
        addCard("Charmander", 8.09);
    }
    
    public void setImageLoc(){
        imgBottom = imgTop + imgHeight;
        imgRight = imgLeft + imgWidth;
    }
    
    /**
     * increments cardId by 1 to add to new pokemon
     */
    public void genNextId(){
        ++cardId;
    }
    
    /**
     * creates then adds new card to box
     */
    public void addCard(String name, double value, String image){ //passed in String image
        genNextId();
        box.put(cardId, new Card(cardId, name, value, image));
    }
    public void addCard(String name, double value){ // String image not passed in
        genNextId();
        box.put(cardId, new Card(cardId, name, value, DEFAULTIMAGE));  // sets image to default
    }

    public void printAllGUI(){
        for (int cardKey : box.keySet()){
            UI.println(cardKey + " Info: ");
            UI.println("Pokémon Name: " + box.get(cardKey).getName());
            UI.println("Card Value: $" + box.get(cardKey).getValue());
            UI.println();
        }
    }
    
    public void printAllConsole(){
        for (int cardKey : box.keySet()){
            System.out.println(cardKey + " Details: ");
            System.out.println(box.get(cardKey).getName() + " "
            + box.get(cardKey).getValue());        
        }
    }
    
    public Card getFoundCard(){
        return foundCard;
    }
    public void clearFoundCard(){ // clears the found card var
        foundCard = null;
    }
    
    public boolean isCardInBox(String cardName){
        for (int cardKey : box.keySet()){
            if (box.get(cardKey).getName().toLowerCase().trim().equals(cardName)){
                foundCard = box.get(cardKey);
                return true;
            }
        }
        return false;
    }
    
    public void displayCard(Card card){
        UI.println("Card Name: " + card.getName());
        UI.println("Card Value: $" + card.getValue());
        
        UI.drawImage(card.getImage(), imgLeft, imgTop, imgWidth, imgHeight);
    }
    
    public int getBoxLeng(){
        return box.size();
    }
}
