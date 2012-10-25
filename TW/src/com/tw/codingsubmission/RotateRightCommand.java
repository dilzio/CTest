package com.tw.codingsubmission;

public class RotateRightCommand extends AbstractRoverCommand {

	public RotateRightCommand(IRover rover) {
		super(rover);
	}

	@Override
	public void doCommand() {
		_roverRef.rotateRight();

	}

}
