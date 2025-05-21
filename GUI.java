import ecs100.*;
import java.util.HashMap;
/**
 * Write a description of class GUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GUI
{
    // instance variables - replace the example below with your own
    private CardBox cardBox; // creates instance of CardBox
    private Card card;
    
    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        cardBox = new CardBox();
        
        UI.initialise();
        
        // Text Field, search bar
        UI.addTextField("Search Card:", this::searchCard);
        
        // sidebar buttons
        UI.addButton("Print All", cardBox::printAllGUI);
        /**
        
        UI.addButton("Clear", this::clearPanes);
        UI.addButton("Add Card", this::addCard);
        */
        UI.addButton("Quit", UI::quit);
    }
    
    /**
     * If the user's input isnt empty and char length is 1-100
     * Searches Box for a card
     * if card is found, prints card
     */
    public void searchCard(String cardSearch){
        int searchLeng = cardSearch.trim().length();
        if ((cardSearch.trim() != null) && (searchLeng > 0) && (searchLeng < 100)){
            if (cardBox.isCardInBox(cardSearch.toLowerCase().trim())){
                UI.println("Card found!");
                
                card = cardBox.getFoundCard();
                cardBox.clearFoundCard(); // clears found card, not used again
                
                cardBox.displayCard(card); // displays card info and image
            }else{
                UI.println("Card could not be found");
            }
        }
    }
}
