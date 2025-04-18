package task3;

/**
 * The Iron class represents a specific type of golf club used for iron shots.
 * It extends the GolfClub class and implements a method to calculate yards for a stroke.
 */
public class Iron extends GolfClub 
{

    /**
     * Constructs an Iron object with the specified club type and average yards per stroke.
     *
     * @param clubType          The type of the iron (e.g., "3 Iron", "7 Iron").
     * @param avgYardsPerStroke The average yards a golfer can achieve with one stroke using this iron.
     */
    public Iron(String clubType, int avgYardsPerStroke) 
    {
        super(clubType, avgYardsPerStroke);
    }

    /**
     * Calculates the yards for the current stroke using the iron.
     * It handles shanking behavior, adds strokes accordingly, and returns a random value between 100 and 200.
     *
     * @return The calculated yards for the stroke.
     */
    @Override
    public int calculateYards() 
    {
        int addedStrokes;
        if (isShanked()) 
        {
            addedStrokes = addedStrokes();
            System.out.println("You shanked it! It added " + addedStrokes + " strokes");
            Golfer.strokes += addedStrokes;
        } 
        else 
        {
            Golfer.strokes++;
        }
        return 100 + (int) (Math.random() * 100);
    }
}
