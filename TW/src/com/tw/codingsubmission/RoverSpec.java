package com.tw.codingsubmission;

/**
 * Object Representation of Rover line in input file
 * 
 * @author mtc
 * 
 */
public class RoverSpec {
	private final int _x;
	private final int _y;
	private final char _direction;
	private final String _commandString;

	public RoverSpec(char x, char y, char direction, String commands) {
		_x = Integer.parseInt(x + "");
		_y = Integer.parseInt(y + "");
		_direction = direction;
		_commandString = commands;
	}

	public int x() {
		return _x;
	}

	public int y() {
		return _y;
	}

	public char direction() {
		return _direction;
	}

	public String commands() {
		return _commandString;
	}
}
