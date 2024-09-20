package hw4;

import api.AbstractElement;

/**
 * An element with two distinctive behaviors. First, it can be set up to move
 * vertically within a fixed set of boundaries. On reaching a boundary, the
 * y-component of its velocity is reversed. Second, it maintains a list of
 * <em>associated</em> elements whose basic motion all occurs relative to the
 * LiftElement.
 * 
 * @author Cael Shepley
 */

public class LiftElement extends BaseElement{

	/**
	 * Constructs a new Elevator. Initially the upper and lower boundaries are
	 * <code>Double.NEGATIVE_INFINITY</code> and
	 * <code>Double.POSITIVE_INFINITY</code>, respectively.
	 * 
	 * @param x      x-coordinate of initial position of upper left corner
	 * @param y      y-coordinate of initial position of upper left corner
	 * @param width  element's width
	 * @param height element's height
	 */
	public LiftElement(double x, double y, int width, int height) {
		super(x, y, width, height); 
	}

	@Override
    public void update() {
    	double oldX = getXReal();
    	// Calculate the next y-coordinate based on current velocity
        double newY = getYReal() + getDeltaY();
        
        // Call super to update frame counter
    	super.update();

    	// Ensure the new y-coordinate stays within the boundaries
    	if (newY > getMax() - getHeight()) {
    	    newY = getMax() - getHeight();
    	    setVelocity(getDeltaX(), -getDeltaY());
    	} else if (newY < getMin()) {
    	    newY = getMin();
    	    setVelocity(getDeltaX(), -getDeltaY());
    	}
        setPosition(oldX, newY);
        

        // Update associated elements
        for (AbstractElement element : getAssociated()) {
            element.update();
        }

        // Delete marked associated elements
        super.deleteMarkedAssociated();
    }

}