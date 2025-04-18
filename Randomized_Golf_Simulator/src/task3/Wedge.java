package task3;

/**
 * The Wedge class represents a specific type of golf club, which extends the GolfClub class.
 * It includes methods to calculate yards for a stroke and handles shanking behavior specific to wedges.
 */
public class Wedge extends GolfClub 
{

    /**
     * Constructs a Wedge object with the specified club type and average yards per stroke.
     *
     * @param clubType The type of the wedge (e.g., "Sand Wedge", "Pitching Wedge").
     * @param avgYardsPerStroke The average yards a golfer can achieve with one stroke using this wedge.
     */
    public Wedge(String clubType, int avgYardsPerStroke) 
    {
        super(clubType, avgYardsPerStroke);
    }

    /**
     * Calculates the yards for the current stroke using the wedge.
     * It handles shanking behavior and adds strokes accordingly.
     *
     * @return The calculated yards for the stroke.
     */
    @Override
    public int calculateYards() 
    {
        int addedStrokes;
        if (isShanked()) {
            addedStrokes = addedStrokes();
            System.out.println("You shanked it! It added " + addedStrokes + " strokes");
            Golfer.strokes += addedStrokes;
        } 
        else 
        {
            Golfer.strokes++;
        }
        return 50 + (int) (Math.random() * 50);
    }
}
