package com.tw.codingsubmission;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * IRover base implementation
 * 
 * @author mtc
 * 
 */
public abstract class AbstractRover implements IRover {

	protected final GridCoordinates _gridPosition;
	private final Orientation _orientation;
	private final Grid _grid;
	private final Queue<IRoverCommand> _commandQueue = new ArrayDeque<IRoverCommand>();
	private final Object _queueMutex = new Object();

	public abstract String type();

	protected AbstractRover(GridCoordinates coord, Orientation orientation,
			Grid grid) {
		if (null == coord) {
			throw new IllegalArgumentException(
					"Cannot Construct Rover with null Grid Position");
		}
		if (null == orientation) {
			throw new IllegalArgumentException(
					"Cannot Construct Rover with null Orientation");
		}
		if (null == grid) {
			throw new IllegalArgumentException(
					"Cannot Construct Rover with null Grid");
		}

		if (!grid.isValidCoordinate(coord.getX(), coord.getY())) {
			throw new IllegalArgumentException("Coordinates "
					+ coord.toString() + " not valid for provided Grid.");
		}
		_gridPosition = coord;
		_orientation = orientation;
		_grid = grid;
	}

	public void move() {
		int targetX = getX();
		int targetY = getY();

		switch (_orientation.getCurrentOrientation()) {
		case NORTH:
			targetY = targetY + 1;
			break;
		case SOUTH:
			targetY = targetY - 1;
			break;
		case EAST:
			targetX = targetX + 1;
			break;
		case WEST:
			targetX = targetX - 1;
			break;
		default:
			throw new IllegalStateException("bad orientation for move: "
					+ _orientation.getCurrentOrientation());
		}

		if (_grid.isValidCoordinate(targetX, targetY)) {
			_gridPosition.set(targetX, targetY);
		} else {
			System.out.println("Coordinate: (" + targetX + "," + targetY
					+ ") is not a valid grid coordinate. Not moving Rover.");
		}

	}

	public String getPositionAndHeading() {
		return getX() + " " + getY() + " "
				+ getOrientation().toString().charAt(0);
	}

	@Override
	public void pushCommand(IRoverCommand command) {
		if (null == command) {
			throw new IllegalArgumentException("tried to add null command");
		}
		synchronized (_queueMutex) {
			_commandQueue.add(command);

		}
	}

	@Override
	public void executeCommands() {
		synchronized (_queueMutex) { // right now we make push and exec mutually
										// exclusive...ok for now but could
										// possibly be a problem if there is a
										// long running command
			while (null != _commandQueue.peek()) {

				IRoverCommand cmd = _commandQueue.poll();
				try {
					cmd.doCommand();
				} catch (Exception e) {
					System.out.println("Exception whild running command");
					throw new RuntimeException(e);
				}
			}
		}
	}

	@Override
	public int getX() {
		return _gridPosition.getX();
	}

	@Override
	public int getY() {
		return _gridPosition.getY();
	}

	@Override
	public OrientationEnum getOrientation() {
		return _orientation.getCurrentOrientation();
	}

	@Override
	public OrientationEnum rotateRight() {
		return _orientation.turnRight();

	}

	@Override
	public OrientationEnum rotateLeft() {
		return _orientation.turnLeft();
	}

}
