package hw4;

import api.AbstractElement;

/**
 * An associated element is one that is associated with another "base" element
 * such as a PlatformElement or a LiftElement. Specifically, the attached
 * element's movement is determined by the movement of the base element.
 * 
 * @author Cael Shepley
 */

public class AssociatedElement extends MovingElement {
	/**
	 * The base element that this element is associated with
	 */
	private AbstractElement base;
	
	/**
	 * Amount added to the base elements x-coordinate 
	 * to calculate this element's x-coordinate
	 */
	private int offset;

	/**
	 * Constructs a new AssociatedElement. Before being added to an associated "base"
	 * element such as a PlatformElement or LiftElement, the x and y coordinates are
	 * initialized to zero. 
	 * 
	 * @param width  element's width
	 * @param height element's height
	 * @param offset when added to a base object, this amount will be added to the
	 *               other object's x-coordinate to calculate this element's
	 *               x-coordinate
	 */
	public AssociatedElement(int width, int height, int offset) {
		super(0, 0, width, height);
		this.offset = offset;
	}

	/**
	 * Sets this element's base element.
	 * 
	 * @param baseElement the base element to attach to
	 */
	public void setBase(AbstractElement baseElement) {
		base = baseElement;
	}
		

	/**
	 * Gets this element's offset.
	 * 
	 * @return offset
	 */
	public int getOffset() {
		return offset;
	}

	
	/**
	 * Gets this element's base element.
	 * 
	 * @return base the base element 
	 */
	public BaseElement getBase() {
		return (BaseElement) base;
	}
}