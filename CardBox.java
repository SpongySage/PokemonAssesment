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
    
    // constants
    static final String DEFAULTIMAGE = "defaultImage.png";

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
        
        printCardBoxToConsole();
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
    
    public void printCardBoxToConsole(){
        for (int cardKey : box.keySet()){
            System.out.println(cardKey + " Details: ");
            System.out.println(box.get(cardKey).getName() + " "
            + box.get(cardKey).getValue());        
        }
    }
}
