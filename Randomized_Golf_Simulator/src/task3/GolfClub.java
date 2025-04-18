package task3;

import java.util.Random;


/**
 * The GolfClub class represents an abstract golf club used by a golfer.
 * It includes attributes and methods related to the golf club's type, average yards per stroke,
 * and its behavior such as shanking and calculating yards.
 */
public abstract class GolfClub implements Shankable 
{

    /** Random object used for generating random values. */
    private Random random = new Random();

    /** The type of the golf club (e.g., "Driver", "Putter"). */
    private String clubType;

    /** The average yards a golfer can achieve with one stroke using this club. */
    private int avgYardsPerStroke;

    /**
     * Constructs a GolfClub object with the specified club type and average yards per stroke.
     *
     * @param clubType The type of the golf club (e.g., "Driver", "Putter").
     * @param avgYardsPerStroke The average yards a golfer can achieve with one stroke using this club.
     */
    public GolfClub(String clubType, int avgYardsPerStroke) 
    {
        this.clubType = clubType;
        this.avgYardsPerStroke = avgYardsPerStroke;
    }

    /**
     * Retrieves the type of the golf club.
     *
     * @return The type of the golf club.
     */
    public String getClubType() 
    {
        return clubType;
    }

    /**
     * Sets the type of the golf club.
     *
     * @param clubType The type of the golf club.
     */
    public void setClubType(String clubType) {
        this.clubType = clubType;
    }

    /**
     * Retrieves the average yards a golfer can achieve with one stroke using this club.
     *
     * @return The average yards per stroke.
     */
    public int getAvgYardsPerStroke() {
        return avgYardsPerStroke;
    }

    /**
     * Abstract method to calculate the yards for the current stroke using this club.
     * This method should be implemented by subclasses.
     *
     * @return The calculated yards for the stroke.
     */
    public abstract int calculateYards();

    /**
     * Checks if the golfer has shanked the shot.
     *
     * @return true if the shot is shanked, false otherwise.
     */
    @Override
    public boolean isShanked() {
        return random.nextBoolean();
    }

    /**
     * Generates the number of added strokes due to mishits or shanks.
     *
     * @return The number of added strokes.
     */
    @Override
    public int addedStrokes() {
        return 1 + random.nextInt(3);
    }

    /**
     * Returns a string representation of the golf club, including its type and average yards per stroke.
     *
     * @return A string representation of the golf club.
     */
    @Override
    public String toString() {
        return "Club: " + clubType + "\nAverage Yards: " + avgYardsPerStroke;
    }
}
