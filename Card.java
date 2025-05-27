/**
 * Class Card.
 * Card has: id, name, value, image
 * card has getters for each variable
 *
 * @author Sage Ripley-Cornwell
 */
public class Card {
  // instance variables
  private int id;
  private String name;
  private double value;
  private String image;
        
  /** 
   * Constructor for objects of class Cards.
   * Used when String img IS passed in
   */
  public Card(int key, String nm, double val, String img) {
    // initialise instance variables
    id = key;
    name = nm;
    value = val;
    image = img;
  }
  
  /** 
   * Gets id.
   */
  public int getId() {
    return id;
  }
  
  /** 
   * Gets name.
   */
  public String getName() {
    return name;
  }
  
  /** 
   * Gets value.
   */
  public double getValue() {
    return value;
  }
  
  /** 
   * Gets image.
   */
  public String getImage() {
    return image;
  }
}
