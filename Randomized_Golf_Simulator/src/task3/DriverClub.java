package task3;

/**
 * The DriverClub class represents a specific type of golf club used for driving off the tee.
 * It extends the GolfClub class and implements a method to calculate yards for a stroke.
 */
public class DriverClub extends GolfClub 
{

    /**
     * Constructs a DriverClub object with the specified club type and average yards per stroke.
     *
     * @param clubType          The type of the driver (e.g., "Driver", "Big Bertha").
     * @param avgYardsPerStroke The average yards a golfer can achieve with one stroke using this driver.
     */
    public DriverClub(String clubType, int avgYardsPerStroke) 
    {
        super(clubType, avgYardsPerStroke);
    }

    /**
     * Calculates the yards for the current stroke using the driver.
     * It handles shanking behavior, adds strokes accordingly, and returns a random value between 200 and 350.
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
        return 200 + (int) (Math.random() * 150);
    }
}
