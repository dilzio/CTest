package com.tw.codingsubmission;

/**
 * Rover public API
 * 
 * @author mtc
 * 
 */
public interface IRover extends IGridPlottable {

	public void move();

	public String getPositionAndHeading();

	public int getX();

	public int getY();

	public String type();

	public OrientationEnum getOrientation();

	public OrientationEnum rotateRight();

	public OrientationEnum rotateLeft();

	public void pushCommand(IRoverCommand command);

	public void executeCommands();
}
