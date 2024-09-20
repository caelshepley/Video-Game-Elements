package hw4;

import java.awt.Rectangle;

import api.AbstractElement;

/**
 * I decided to first organize the hierarchy of elements by whether they were moving
 * elements or not. For example, VanishingElement directly implements SimpleElement
 * while all the other elements implement MovingElement. I then decided to break up 
 * the different types of moving elements. I made a class called BaseElement because
 * the two base elements (PlatformElement and LiftElement) share common methods.
 * I used the same idea for the two associated elements (AttachedElement and FollowerElement)
 * for making an AssociatedElement class.
 * 
 */

/**
 * Minimal concrete extension of AbstractElement. The <code>update</code> method
 * in this implementation just increments the frame count.
 * 
 * @author Cael Shepley
 */
public class SimpleElement extends AbstractElement{
	/**
	 * x-coordinate of upper left corner
	 */
	private double x;
	
	/**
	 * y-coordinate of upper left corner
	 */
    private double y;
    
    /**
     * element's width
     */
    private int width;
    
    /**
     * element's height
     */
    private int height;
    
    /**
     * The number of frames elapsed since the element's creation
     */
    private int frameCount;
    
    /**
     * A flag indicating whether the element is marked for deletion.
     */
    private boolean markedForDeletion;
	
	
	/**
	 * Constructs a new SimpleElement.
	 * 
	 * @param x      x-coordinate of upper left corner
	 * @param y      y-coordinate of upper left corner
	 * @param width  element's width
	 * @param height element's height
	 */
	public SimpleElement(double x, double y, int width, int height) {
		super(); 
        setPosition(x, y);
        this.width = width;
        this.height = height;
	}

	@Override
    public void setPosition(double newX, double newY) {
        this.x = newX;
        this.y = newY;
    }

    @Override
    public double getXReal() {
        return x;
    }

    @Override
    public double getYReal() {
        return y;
    }

    @Override
    public void update() {
        frameCount++;
    }

    @Override
    public int getFrameCount() {
        return frameCount;
    }

    @Override
    public boolean isMarked() {
        return markedForDeletion;
    }

    @Override
    public void markForDeletion() {
    	markedForDeletion = true;
    }

    @Override
    public boolean collides(AbstractElement other) {
    	// Check if this element's bounding rectangle intersects with the given element's bounding rectangle
        Rectangle thisRect = new Rectangle((int) getXReal(), (int) getYReal(), getWidth(), getHeight());
        Rectangle otherRect = new Rectangle((int) other.getXReal(), (int) other.getYReal(), other.getWidth(), other.getHeight());
        return thisRect.intersects(otherRect);
    }

    @Override
    public int getXInt() {
        return (int) Math.round(getXReal());
    }

    @Override
    public int getYInt() {
        return (int) Math.round(getYReal());
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

	@Override
	public Rectangle getRect() {
		return new Rectangle(getXInt(), getYInt(), width, height);
	}
}
