package com.tw.codingsubmission;

/**
 * Construct a Rover impl
 * @author mtc
 *
 */
public class RoverBuilder {
	public IRover build(Grid grid, RoverSpec spec){
		try{
			char orientationDirection = spec.direction();
			Orientation orientation = null;
			switch(orientationDirection){
				case 'N':
					orientation = new Orientation(OrientationEnum.NORTH);
					break;
				case 'S':
					orientation = new Orientation(OrientationEnum.SOUTH);
					break;
				case 'E':
					orientation = new Orientation(OrientationEnum.EAST);
					break;
				case 'W':
					orientation = new Orientation(OrientationEnum.WEST);
					break;
				default:
					throw new RuntimeException("Unknown Orientation for value: " + orientationDirection);
			}
			GridCoordinates startingCoordinates = new GridCoordinates(spec.x(), spec.y());
			IRover rover = new BlueRover(startingCoordinates, orientation, grid);
			for(int i=0; i<spec.commands().length(); i++){
				char commandCode = spec.commands().charAt(i);
				switch(commandCode){
					case('L'):
						rover.pushCommand(new RotateLeftCommand(rover));
						break;
					case('R'):
						rover.pushCommand(new RotateRightCommand(rover));
						break;
					case('M'):
						rover.pushCommand(new MoveCommand(rover));
						break;
					default:
						throw new RuntimeException("Unknown Command Code: " + commandCode);
				}
			}
			return rover;
		}catch (Exception e){
			throw new RuntimeException("failed to construct Rover");
		}
		
		
	}
}
