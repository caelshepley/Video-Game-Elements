package hw4;

/**
 * Moving element in which the vertical velocity is adjusted each frame by a
 * gravitational constant to simulate gravity. The element can be set to
 * "grounded", meaning gravity will no longer influence its velocity.
 * 
 * @author Cael Shepley
 */

public class FlyingElement extends MovingElement{
	/**
	 * gravitational constant to simulate gravity
	 */
	private double gravity;
	
	/**
	 * True if grounded, otherwise false
	 */
    private boolean grounded;
    
	/**
	 * Constructs a new FlyingElement. By default it should be grounded, meaning
	 * gravity does not influence its velocity.
	 * 
	 * @param x      x-coordinate of upper left corner
	 * @param y      y-coordinate of upper left corner
	 * @param width  element's width
	 * @param height element's height
	 */
	public FlyingElement(double x, double y, int width, int height) {
		super(x, y, width, height); 
        gravity = 0; 
        grounded = true; 
	}
	
	/**
     * Sets the gravitational constant for this flying element.
     * 
     * @param gravity the gravitational constant
     */
    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    /**
     * Sets whether this flying element is grounded or not.
     * 
     * @param grounded true if the element is grounded, false otherwise
     */
    public void setGrounded(boolean grounded) {
        this.grounded = grounded;
    }
    
    /**
     * Returns whether this flying element is grounded or not.
     * 
     * @return grounded true if the element is grounded, false otherwise
     */
    public boolean isGrounded() {
    	return grounded;
    }

    @Override
    public void update() {
    	super.update(); 
        if (!grounded) {
            setVelocity(getDeltaX(), getDeltaY() + gravity);
        }
    }

}
