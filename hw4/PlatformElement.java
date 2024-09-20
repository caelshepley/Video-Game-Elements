package hw4;

import api.AbstractElement;

/**
 * A PlatformElement is an element with two distinctive behaviors. First, it can
 * be set up to move horizontally within a fixed set of boundaries. On reaching
 * a boundary, the x-component of its velocity is reversed. Second, it maintains
 * a list of <em>associated</em> elements whose basic motion all occurs relative
 * to the PlatformElement.
 * 
 * @author Cael Shepley
 */

public class PlatformElement extends BaseElement {
	/**
	 * Constructs a new PlatformElement. Initially the left and right boundaries are
	 * <code>Double.NEGATIVE_INFINITY</code> and
	 * <code>Double.POSITIVE_INFINITY</code>, respectively.
	 * 
	 * @param x      x-coordinate of initial position of upper left corner
	 * @param y      y-coordinate of initial position of upper left corner
	 * @param width  object's width
	 * @param height object's height
	 */
	public PlatformElement(double x, double y, int width, int height) {
		super(x, y, width, height); 
	}

    @Override
    public void update() {
    	double oldY = getYReal();
    	// Calculate the next x-coordinate based on current velocity
        double newX = getXReal() + getDeltaX();
        
        // Call super to update frame counter
    	super.update();

        // Ensure the new x-coordinate stays within the boundaries
        newX = Math.max(getMin(), Math.min(newX, getMax() - getWidth()));
        setPosition(newX, oldY);
        
    	// Check boundaries
        if (getXReal() <= getMin() || getXReal() + getWidth() >= getMax()) {
            setVelocity(-getDeltaX(), getDeltaY()); // Reverse velocity on reaching boundary
        }

        // Update associated elements
        for (AbstractElement element : getAssociated()) {
            element.update();
        }

        // Delete marked associated elements
        super.deleteMarkedAssociated();
    }

}
