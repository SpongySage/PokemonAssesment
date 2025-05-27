import ecs100.*;
import java.util.HashMap;
/**
 * CardBox is a collection of Cards.
 * CardBox has: HashMap, Default image, image location, found card, card id
 * CardBox does: Creates Cards, adds cards to hashmap, creates new ids, searches hashmap for card, 
 * sets image location, gets image location, displays card, prints all cards in hashmap
 *
 * @author Sage Ripley-Cornwell
 */

public class CardBox {
  // instance variables
  private HashMap<Integer, Card> box; // "Integer" is id, "Card" is the card
  private int cardId; // stores card id to add to new cards
  private Card foundCard; // stores searched card
  
  // constants
  static final String DEFAULT_IMAGE = "defaultImage.png"; // default image
    
  // image var
  private double imgBottom; // image bottom y
  private double imgRight; // image right x
   
  // var for displaying image
  private int imgLeft = 75; // image x start position
  private int imgTop = 75; // image y start position
  private double imgWidth = 245; // fixed image width
  private double imgHeight = 342; // fixed image height

  /**
   * Constructor for objects of class CardBox.
   */
  public CardBox() {
    // initialise instance variables
    box = new HashMap<Integer, Card>();
        
    cardId = 0; // sets card id to 0 so it is not null
        
    // add cards to collection
    addCard("Oricorio", 1.24, "oricorio.jpg");
    addCard("Quaxly", 64.93, "quaxly.jpg");
    addCard("Fletchling", 1.89, "fletchling.jpg");
    addCard("Horsea", 34.84, "horsea.jpg");
    addCard("Trubbish", 37.14, "trubbish.jpg");
    addCard("Murkrow", 1.99, "murkrow.jpg");
    addCard("Vanillite", 37.87, "vanillite.jpg");
    addCard("Feebas", 34.89, "feebas.jpg");
    addCard("Pawmi", 35.32, "pawmi.png");
    addCard("Wo-Chien", 8.49, "wo-chien.jpg");
        
    // initialize image location
    setImageLoc();
  }
    
  /**
   * sets image bottom and right.
   */
  public void setImageLoc() {
    imgBottom = imgTop + imgHeight;
    imgRight = imgLeft + imgWidth;
  }
    
  /**
   * increments cardId by 1 to add to new pokemon.
   */
  public void genNextId() {
    ++cardId;
  }
    
  /**
   * creates then adds new card to box.
   */
  public void addCard(String name, double value, String image) { //passed in String image
    genNextId();
    box.put(cardId, new Card(cardId, name, value, image));
  }
  
  public void addCard(String name, double value) { // String image not passed in
    genNextId();
    box.put(cardId, new Card(cardId, name, value, DEFAULT_IMAGE));  // sets image to default
  }

  /**
   * Print card name and value to Gui for all cards in collection.
   */
  public void printAllGui() {
    for (int cardKey : box.keySet()) {
      UI.println(cardKey + " Info: ");
      UI.println("Pokémon Name: " + box.get(cardKey).getName());
      UI.println("Card Value: $" + box.get(cardKey).getValue());
      UI.println();
    }
  }
    
  /**
   * Print card name and value to Console for all cards in collection.
   */
  public void printAllConsole() {
    for (int cardKey : box.keySet()) {
      System.out.println(cardKey + " Details: ");
      System.out.println(box.get(cardKey).getName() + " "
                  + box.get(cardKey).getValue());
    }
  }
    
  /**
   * check if card passed in is in the collection.
   * if card is in collection, returns true and sets "foundCard" to the card found
   */
  public boolean isCardInBox(String cardName) {
    for (int cardKey : box.keySet()) {
      if (box.get(cardKey).getName().toLowerCase().trim().equals(cardName)) {
        foundCard = box.get(cardKey);
        return true;
      }
    }
    return false;
  }
    
  /**
   * gets var foundCard.
   */
  public Card getFoundCard() {
    return foundCard;
  }
  
  /**
   * clears the found card var.
   */
  public void clearFoundCard() {
    foundCard = null;
  }
    
  /**
   * displays card information and image.
   */
  public void displayCard(Card card) {
    // prints name and value to text pane
    UI.println("Card Name: " + card.getName());
    UI.println("Card Value: $" + card.getValue());
       
    // displays image on graphics pane
    UI.drawImage(card.getImage(), imgLeft, imgTop, imgWidth, imgHeight);
  }
    
  /**
   * gets length of box HashMap.
   */
  public int getBoxLeng() {
    return box.size();
  }

  /**
   * gets image left x position.
   */
  public double getImgLeft() {
    return imgLeft;
  }
  
  /**
   * gets image right x position.
   */
  public double getImgRight() {
    return imgRight;
  }
  
  /**
   * gets image top y position.
   */
  public double getImgTop() {
    return imgTop;
  }
  
  /**
   * gets image bottom y position.
   */
  public double getImgBottom() {
    return imgBottom;
  }

  /**
   * Prints all current variable values.
   */
  public void printAllVar() {
    System.out.println("box: " + box);
    System.out.println("cardId: " + cardId);
    System.out.println("foundCard: " + foundCard);
    System.out.println("DEFAULT_IMAGE: " + DEFAULT_IMAGE);
    System.out.println("imgBottom: " + imgBottom);
    System.out.println("imgRight: " + imgRight);
    System.out.println("imgLeft: " + imgLeft);
    System.out.println("imgTop: " + imgTop);
    System.out.println("imgWidth: " + imgWidth);
    System.out.println("imgHeight: " + imgHeight);
  }
}