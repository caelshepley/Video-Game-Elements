package hw4;

import java.util.ArrayList;

/**
 * A BaseElement is an element with two distinctive behaviors. First, it can
 * be set up to move horizontally or vertically within a fixed set of boundaries. On reaching
 * a boundary, the x or y-component of its velocity is reversed. Second, it maintains
 * a list of <em>associated</em> elements whose basic motion all occurs relative
 * to the BaseElement.
 * 
 * @author Cael Shepley
 */

import api.AbstractElement;


public class BaseElement extends MovingElement{
	/**
	 * the minimum x or y-coordinate
	 */
	private double min;
	
	/**
	 * the maximum x or y-coordinate
	 */
    private double max;
    
    /**
     * the list of associated elements
     */
    private ArrayList<AbstractElement> associatedElements; 
    
    /**
	 * Constructs a new BaseElement. Initially the boundaries are
	 * <code>Double.NEGATIVE_INFINITY</code> and
	 * <code>Double.POSITIVE_INFINITY</code>, respectively.
	 * 
	 * @param x      x-coordinate of initial position of upper left corner
	 * @param y      y-coordinate of initial position of upper left corner
	 * @param width  object's width
	 * @param height object's height
	 */
	public BaseElement(double x, double y, int width, int height) {
		super(x, y, width, height); 
        min = Double.NEGATIVE_INFINITY;
        max = Double.POSITIVE_INFINITY;
        associatedElements = new ArrayList<>();
		
	}
	
	/**
     * Sets the boundaries for horizontal or vertical movement.
     * 
     * @param min the minimum x or y-coordinate
     * @param max the maximum x or y-coordinate
     */
    public void setBounds(double min, double max) {
        this.min = min;
        this.max = max;
    }
    
    /**
     * Gets the minimum x or y-coordinate boundary.
     * 
     * @return the minimum x or y-coordinate boundary
     */
    public double getMin() {
        return min;
    }

    /**
     * Gets the maximum x or y-coordinate boundary.
     * 
     * @return the maximum x or y-coordinate boundary
     */
    public double getMax() {
        return max;
    }
    
    /**
     * Gets the list of associated elements.
     * 
     * @return the list of associated elements
     */
    public ArrayList<AbstractElement> getAssociated() {
        return associatedElements;
    }
    
    /**
     * Adds an associated element to this BaseElement 
     * and sets this object to be the AttachedElement's base.
     * 
     * @param attached the AttachedElement to add
     */
    public void addAssociated(AttachedElement attached) {
    	attached.setBase(this);
        associatedElements.add(attached);
    }
    
    /**
     * Adds an associated element to this PlatformElement 
     * and sets this object to be the FollowerElement's base.
     * 
     * @param follower the FollowerElement to add
     */
    public void addAssociated(FollowerElement follower) {
    	follower.setBase(this);
        associatedElements.add(follower);
    }
    
    /**
     * Deletes marked associated elements from the list.
     */
    public void deleteMarkedAssociated() {
    	associatedElements.removeIf(AbstractElement::isMarked);
    }
}
