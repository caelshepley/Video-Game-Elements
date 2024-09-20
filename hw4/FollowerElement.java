package hw4;

import api.AbstractElement;

/**
 * A follower element is one that is associated with another "base" element such
 * as a PlatformElement or LiftElement. Specifically, the follower element's
 * movement is determined by the movement of the base element, when the base
 * move up 10 pixels, the follower moves up 10 pixels. However, the follower may
 * not always be at a fixed location relative to the base. When the horizontal
 * velocity of the follower is set to a non-zero value, the follower will
 * oscillate between the left and right edges of the PlatformElement or
 * LiftElement it is associated with.
 * 
 * @author Cael Shepley
 */

public class FollowerElement extends AssociatedElement {
	/**
	 * the minimum x or y-coordinate
	 */
	private double max;
	
	/**
	 * the maximum x or y-coordinate
	 */
	private double min;

	/**
	 * Constructs a new FollowerElement. Before being added to a "base" element such
	 * as a PlatformElement or LiftElement, the x and y coordinates are zero. When a
	 * base element is set, the initial x-coordinate becomes the base's
	 * x-coordinate, plus the given offset, and the y-coordinate becomes the base's
	 * y-coordinate, minus this element's height.
	 * 
	 * @param width         element's width
	 * @param height        element's height
	 * @param initialOffset when added to a base, this amount will be added to the
	 *                      bases's x-coordinate to calculate this element's initial
	 *                      x-coordinate
	 */
	public FollowerElement(int width, int height, int initialOffset) {
		super(width, height, initialOffset);
	}

	/**
	 * Sets the boundaries for horizontal movement.
	 * 
	 * @param min the minimum x-coordinate
	 * @param max the maximum x-coordinate
	 */
	public void setBounds(double min, double max) {
		this.min = min;
		this.max = max;
	}

	/**
	 * Gets the minimum x-coordinate boundary.
	 * 
	 * @return the minimum x-coordinate boundary
	 */
	public double getMin() {
		return min;
	}

	/**
	 * Gets the maximum x-coordinate boundary.
	 * 
	 * @return the maximum x-coordinate boundary
	 */
	public double getMax() {
		return max;
	}

	@Override
	public void setBase(AbstractElement baseElement) {
		super.setBase(baseElement);
		setPosition(baseElement.getXReal() + getOffset(), baseElement.getYReal() - this.getHeight());
		setBounds(baseElement.getXReal(), baseElement.getXReal() + baseElement.getWidth());
	}

	@Override
	public void update() {
		double oldY = getYReal();
		double newX = getXReal() + getDeltaX();
		super.update();
		
		 // Ensure the new x stays within the boundaries
		newX = Math.max(getMin(), Math.min(newX, getMax() - getWidth()));
		
		// If the base element and follower element are moving
		if ((getBase().getXReal() != min || getBase().getDeltaY() != 0) && getDeltaX() != 0) {
			setPosition(newX + getBase().getDeltaX(), getBase().getYReal() - this.getHeight());
			setBounds(getBase().getXReal(), getBase().getXReal() + getBase().getWidth());
		}
		// If just the base element is moving
		else if (getBase().getXReal() != min || getBase().getDeltaY() != 0) {
			setBase(getBase());
		}
		// If just the follower element is moving
		else {
			setPosition(newX, oldY);
		}

		// Check boundaries and reverse velocity if needed
		if (getXReal() <= getMin() || getXReal() + getWidth() >= getMax()) {
			setVelocity(-getDeltaX(), getDeltaY());
		}
	}
}
