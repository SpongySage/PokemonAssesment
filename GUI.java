import ecs100.*;
import java.util.HashMap;
/**
 * GUI class
 * GUI has buttons and a search bar
 * a graphics and text pane
 * GUI does: search for a card using textField, clear UI panes, add card, take mouse input
 * 
 * @author Sage Ripley-Cornwell
 */
public class GUI
{
    // instance variables
    private CardBox cardBox; // creates instance of CardBox
    private Card card; // creates instance of Card
    private boolean cardDisplayed; // t/f is card image displayed
    
    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        cardBox = new CardBox();
        cardDisplayed = false;
        
        // initialise GUI
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
        
        // testing button, change to different methods as needed
        UI.addButton("Test", this::printAllVar);
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
                
                card = cardBox.getFoundCard(); // gets card info of card that was found
                cardBox.clearFoundCard(); // clears found card, so not used again
                
                cardBox.displayCard(card); // displays card info and image
                cardDisplayed = true;
                UI.println();
            }else{
                UI.println("Card could not be found");
            }
        }
    }
    
    /**
     * clears text and graphics pane
     * sets cardDisplayed to false as panes are now clear
     */
    public void clearPanes(){
        UI.clearText();
        UI.clearGraphics();
        cardDisplayed = false;
    }
    
    /**
     * Adds card
     * prompts user to enter card details - name, value, image
     * if hashmap leng is larger than max, doesnt add card
     * user must enter valid value between 0 and max
     */
    public void addCard(){
        final int MAX_LENGTH = 50; // max amount of obj in hashmap
        final int MAX_VALUE = 5275000; // max pokemon card value based on highest value card
        double value;
        
        if (cardBox.getBoxLeng() <= MAX_LENGTH){
            // ask user for card info
            String name = UI.askString("Pokémon Name: ");
            
            // stops user from entering value more than max or less than 0
            do {
                value = UI.askDouble("Value Of Card: $");
                if (value <= 0){
                    UI.println("Card value must be higher than 0");
                }else if (value > MAX_VALUE){
                    UI.println("Card value must be below $" + MAX_VALUE);
                }
            }while (value < 0 || value > MAX_VALUE);
            // prompts user to select image
            String imageFile = UIFileChooser.open("Select Image: ");
            
            // adds card to hashmap
            cardBox.addCard(name, value, imageFile);
            UI.println();
            UI.println(name + " has been added");
            UI.println();
        }else{
            UI.println("Sorry, your collection is full.");
            UI.println("No more cards can be added.");
            UI.println();
        }
    }
        
    /**
     * Mouse input
     * if the mouse is clicked and the card image is displayed,
     * checks mouse loc is in image loc, if it is, clears panes
     */
    public void doMouse(String action, double x, double y){
        if (action.equals("clicked") && cardDisplayed){
            if ((x > cardBox.getImgLeft()) && (x < cardBox.getImgRight()) && (y > cardBox.getImgTop()) && (y < cardBox.getImgBottom())){
                clearPanes();
            }
        }
    }
    
    
    /**
     * Testing methods
     */
    /**
     * tests mouse input handling
     * prints results to console
     */
    public void doMouseTest(String action, double x, double y){
        if (action.equals("clicked")){
            System.out.println("clicked");
            if (cardDisplayed){
                System.out.println("Clicked + card visable");
                if ((x > cardBox.getImgLeft()) && (x < cardBox.getImgRight()) && (y > cardBox.getImgTop()) && (y < cardBox.getImgBottom())){
                    System.out.println("Image Clicked");
                }else{
                    System.out.println("missed!");
                }
            }
        }
    }
    /**
     * prints all values of current variables
     */
    public void printAllVar(){
        System.out.println();
        System.out.println("______________________________");
        System.out.println("GUI Class Var:");
        System.out.println("cardDisplayed: " + cardDisplayed);
        System.out.println();
        
        System.out.println("CardBox Class Var:");
        cardBox.printAllVar();
    }
}
