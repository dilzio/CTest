package com.tw.codingsubmission;

public class RotateLeftCommand extends AbstractRoverCommand {

	public RotateLeftCommand(IRover rover) {
		super(rover);
	}

	@Override
	public void doCommand() {
		_roverRef.rotateLeft();

	}

}
