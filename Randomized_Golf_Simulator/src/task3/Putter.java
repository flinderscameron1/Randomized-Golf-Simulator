package task3;

/**
 * The Putter class represents a specific type of golf club used for putting.
 * It extends the GolfClub class and implements a method to calculate yards for a stroke.
 */
public class Putter extends GolfClub 
{

    /**
     * Constructs a Putter object with the specified club type and average yards per stroke.
     *
     * @param clubType         The type of the putter (e.g., "Standard Putter", "Mallet Putter").
     * @param avgYardsPerStroke The average yards a golfer can achieve with one stroke using this putter.
     */
    public Putter(String clubType, int avgYardsPerStroke) 
    {
        super(clubType, avgYardsPerStroke);
    }

    /**
     * Calculates the yards for the current stroke using the putter.
     * It adds one stroke to the golfer's total strokes and returns a random value between 1 and 10.
     *
     * @return The calculated yards for the stroke.
     */
    @Override
    public int calculateYards() 
    {
        Golfer.strokes++;
        return 1 + (int) (Math.random() * 10);
    }
}
