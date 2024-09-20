package hw4;

/**
 * An element in which the <code>update</code> method updates the position each
 * frame according to a <em>velocity</em> vector (deltaX, deltaY). The units are
 * assumed to be "pixels per frame".
 * 
 * @author Cael Shepley
 */
public class MovingElement extends SimpleElement{
	/**
	 * velocity in the x direction
	 */
	private double deltaX;
	
	/**
	 * velocity in the y direction
	 */
    private double deltaY;
    
	/**
	 * Constructs a MovingElement with a default velocity of zero in both
	 * directions.
	 * 
	 * @param x      x-coordinate of upper left corner
	 * @param y      y-coordinate of upper left corner
	 * @param width  object's width
	 * @param height object's height
	 */
	public MovingElement(double x, double y, int width, int height) {
		super(x, y, width, height); 
        deltaX = 0.0;
        deltaY = 0.0;
	}

	 /**
     * Sets the velocity of this moving element.
     * 
     * @param deltaX  velocity in the x direction 
     * @param deltaY  velocity in the y direction 
     */
    public void setVelocity(double deltaX, double deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }
    
    /**
     * Gets the velocity in the x direction.
     * 
     * @return the velocity in the x direction 
     */
    public double getDeltaX() {
        return deltaX;
    }
    
    /**
     * Gets the velocity in the y direction.
     * 
     * @return the velocity in the y direction 
     */
    public double getDeltaY() {
        return deltaY;
    }
    
    @Override
    public void update() {
    	super.update();
        setPosition(getXReal() + deltaX, getYReal() + deltaY);
    }

}
