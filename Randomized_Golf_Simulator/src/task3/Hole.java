package task3;

/**
 * The Hole class represents a golf course hole with specific attributes
 * such as yards to the pin, par value, and hole number.
 */
public class Hole 
{

    /** The distance in yards from the tee to the pin. */
    private int yardsToPin;

    /** The number of strokes a skilled golfer is expected to need to complete the hole. */
    private int par;

    /** The unique number assigned to the golf course hole. */
    private int holeNum;
    
    /** The number of strokes counted per hole. */
    private int strokes;

    /**
     * Constructs a Hole object with the specified yards to the pin, par value, and hole number.
     *
     * @param yardsToPin The distance in yards from the tee to the pin.
     * @param par        The number of strokes a skilled golfer is expected to need to complete the hole.
     * @param holeNum    The unique number assigned to the golf course hole.
     */
    public Hole(int yardsToPin, int par, int holeNum) 
    {
        this.yardsToPin = yardsToPin;
        this.par = par;
        this.holeNum = holeNum;
    }

    /**
     * Retrieves the distance in yards from the tee to the pin.
     *
     * @return The yards to the pin.
     */
    public int getYardsToPin()
    {
        return yardsToPin;
    }

    /**
     * Sets the distance in yards from the tee to the pin.
     *
     * @param yardsToPin The yards to the pin.
     */
    public void setYardsToPin(int yardsToPin) 
    {
        this.yardsToPin = yardsToPin;
    }

    /**
     * Retrieves the par value of the hole.
     *
     * @return The par value.
     */
    public int getPar() 
    {
        return par;
    }

    /**
     * Sets the par value of the hole.
     *
     * @param par The par value.
     */
    public void setPar(int par) 
    {
        this.par = par;
    }

    /**
     * Retrieves the unique number assigned to the golf course hole.
     *
     * @return The hole number.
     */
    public int getHoleNum() 
    {
        return holeNum;
    }

    /**
     * Sets the unique number assigned to the golf course hole.
     *
     * @param holeNum The hole number.
     */
    public void setHoleNum(int holeNum) 
    {
        this.holeNum = holeNum;
    }
    
    public void addStroke()
    {
    	strokes ++;
    }
    public int getStrokes() 
    {
    	return strokes;
    }
    /**
     * Returns a string representation of the golf course hole,
     * including its hole number, par value, yards to the pin, and the number of strokes for the current hole.
     *
     * @return A string representation of the golf course hole.
     */
    @Override
    public String toString() 
    {
        return "Hole Number: " + holeNum + "\nPar: " + par + "\nYards to the pin: " + yardsToPin + "\nStrokes for this hole: " + strokes;
    }
    
    /**
     * Returns a string representation of the golf course hole,
     * including its hole number, par value, yards to the pin.
     *
     * @return A string representation of the golf course hole.
     */
    public String toString1() 
    {
        return "Hole Number: " + holeNum + "\nPar: " + par + "\nYards to the pin: " + yardsToPin + "\nStrokes for this hole: " + strokes;
    }
}
