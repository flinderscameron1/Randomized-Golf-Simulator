package task3;

import java.util.HashMap;
import java.util.Map;

/**
 * The Golfer class represents a golfer with a name, handicap, and a collection of golf clubs.
 */
public class Golfer 
{

    /** A map containing the golfer's golf clubs, with the club type as the key. */
    public Map<String, GolfClub> clubs = new HashMap<String, GolfClub>();

    /** The name of the golfer. */
    private String name;

    /** The handicap of the golfer. */
    private int handicap;

    /** The total number of strokes the golfer has taken. */
    public static int strokes = 0;

    /**
     * Constructs a Golfer object with the specified name and handicap.
     * Initializes the golfer's collection of golf clubs.
     *
     * @param name     The name of the golfer.
     * @param handicap The handicap of the golfer.
     */
    public Golfer(String name, int handicap) 
    {
        this.name = name;
        this.handicap = handicap;

        // Create and add golf clubs to the golfer's collection
        GolfClub wedge = new Wedge("wedge", 75);
        GolfClub putter = new Putter("putter", 5);
        GolfClub driver = new DriverClub("driver", 275);
        GolfClub iron = new Iron("iron", 150);
        GolfClub chip = new Chip("chip", 20);
        
        clubs.put(wedge.getClubType(), wedge);
        clubs.put(iron.getClubType(), iron);
        clubs.put(putter.getClubType(), putter);
        clubs.put(driver.getClubType(), driver);
        clubs.put(chip.getClubType(), chip);
    }

    /**
     * Retrieves the name of the golfer.
     *
     * @return The name of the golfer.
     */
    public String getName() 
    {
        return name;
    }

    /**
     * Sets the name of the golfer.
     *
     * @param name The name of the golfer.
     */
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
     * Retrieves the handicap of the golfer.
     *
     * @return The handicap of the golfer.
     */
    public int getHandicap() 
    {
        return handicap;
    }

    /**
     * Sets the handicap of the golfer.
     *
     * @param handicap The handicap of the golfer.
     */
    public void setHandicap(int handicap) 
    {
        this.handicap = handicap;
    }

    /**
     * Returns a string representation of the golfer, including their name and handicap.
     *
     * @return A string representation of the golfer.
     */
    @Override
    public String toString() 
    {
        return "Golfer " + name + " has a " + handicap + " handicap";
    }
}