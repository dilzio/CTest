package com.tw.codingsubmission;

/**
 * A Rover implementation...
 * 
 * @author mtc
 * 
 */
public class BlueRover extends AbstractRover {

	public BlueRover(GridCoordinates gridPosition, Orientation direction,
			Grid grid) {
		super(gridPosition, direction, grid);
	}

	@Override
	public String type() {
		return "Blue Rover";
	}

}
