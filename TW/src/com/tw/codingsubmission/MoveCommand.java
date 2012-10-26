package com.tw.codingsubmission;

public class MoveCommand extends AbstractRoverCommand {
	public MoveCommand(final IRover rover) {
		super(rover);
	}

	@Override
	public void doCommand() {
		_roverRef.move();
	}

}
