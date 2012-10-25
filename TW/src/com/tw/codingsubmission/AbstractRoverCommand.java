package com.tw.codingsubmission;

/**
 * Something a rover can do!
 * @author mtc
 *
 */
public abstract class AbstractRoverCommand implements IRoverCommand {
	protected final IRover _roverRef;
	public AbstractRoverCommand(final IRover rover) {
		_roverRef = rover;
	}
	

}
