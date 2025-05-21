
/**
 * Write a description of class Cards here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Card
{
    // instance variables - replace the example below with your own
    private int id;
    private String name;
    private double value;
    private String image;
    
    // constants
    static final String DEFAULTIMAGE = "defaultImage.png";
        
    /**
     * Constructor for objects of class Cards
     * Used when String img IS passed in
     */
    public Card(int key, String nm, double val, String img)
    {
        // initialise instance variables
        id = key;
        name = nm;
        value = val;
        image = img;
    }
    
    /**
     * Gets id
     */
    public int getId(){
        return id;
    }
    /**
     * Gets name
     */
    public String getName(){
        return name;
    }    
    /**
     * Gets value
     */
    public double getValue(){
        return value;
    }
    /**
     * Gets image
     */
    public String getImage(){
        return image;
    }
}
