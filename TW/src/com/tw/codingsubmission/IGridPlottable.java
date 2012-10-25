package com.tw.codingsubmission;

/**
 * Something that can be added to a grid
 * @author mtc
 *
 */
public interface IGridPlottable {
	public final static int NORTH = 0;
	public final static int EAST = 1;
	public final static int SOUTH = 2;
	public final static int WEST = 3;
	
	int getX();

	int getY();

	OrientationEnum getOrientation();

	OrientationEnum rotateRight();

	OrientationEnum rotateLeft();

}
