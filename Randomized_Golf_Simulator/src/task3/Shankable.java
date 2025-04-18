package task3;

/**
 * The Shankable interface represents the behavior of a golf club that can be shanked.
 * It defines methods to check if a shot is shanked and to calculate the number of added strokes.
 */
public interface Shankable 
{

    /**
     * Checks if the shot is shanked.
     *
     * @return true if the shot is shanked, false otherwise.
     */
    public boolean isShanked();

    /**
     * Calculates the number of added strokes due to mishits or shanks.
     *
     * @return The number of added strokes.
     */
    public int addedStrokes();
}
