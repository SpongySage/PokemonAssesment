import ecs100.*;
import java.util.HashMap;
/**
 * GUI class
 * GUI has buttons and a search bar
 * a graphics and text pane
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
        UI.addButton("Clear", this::clearPanes);
        UI.addButton("Add Card", this::addCard);
        UI.addButton("Quit", UI::quit);
        
        // mouse listener
        UI.setMouseListener(this::doMouse);
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
                UI.println();
            }else{
                UI.println("Card could not be found");
            }
        }
    }
    
    public void clearPanes(){
        UI.clearText();
        UI.clearGraphics();
    }
    
    public void addCard(){
        final int MAX_LENGTH = 50; // max amount of obj in hashmap
        final int MAX_VALUE = 5275000; // max pokemon card value based on highest value card
        double value;
        
        // ask user for card info
        String name = UI.askString("Pokémon Name: ");
        do {
            value = UI.askDouble("Value Of Card: $");
            if (value <= 0){
                UI.println("Card value must be higher than 0");
            }else if (value > MAX_VALUE){
                UI.println("Card value must be below $" + MAX_VALUE);
            }
        }while (value < 0 || value > MAX_VALUE);
        String imageFile = UIFileChooser.open("Select Image: ");
        
        cardBox.addCard(name, value, imageFile);
        UI.println();
        UI.println(name + " has been added");
        UI.println();
    }
    
    public void doMouse(String action, double xPos, double yPos){
        
    }
}
