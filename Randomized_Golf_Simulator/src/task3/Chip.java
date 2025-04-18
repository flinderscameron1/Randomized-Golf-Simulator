package task3;
/**
 * The `Chip` class represents a golf club used for chipping shots.
 * It extends the `GolfClub` class and provides specific behavior for chip shots.
 */
public class Chip extends GolfClub 
{

    /**
     * Constructs a `Chip` object with the specified club type and average yards per stroke.
     *
     * @param clubType          the type of the golf club (e.g., "Sand Wedge", "Pitching Wedge")
     * @param avgYardsPerStroke the average yards covered per stroke with this club
     */
    public Chip(String clubType, int avgYardsPerStroke) 
    {
        super(clubType, avgYardsPerStroke);
    }
	
    /**
    * Calculates the yards covered by a chip shot.
    * If the shot is shanked, additional strokes are added to the golfer's score.
    *
    * @return the total yards covered by the chip shot
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
       return 10 + (int) (Math.random() * 30);
   }
}