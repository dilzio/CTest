package com.tw.codingsubmission;

/**
 * State and behavior pertaining to a given orientation
 * @author mtc
 *
 */
public class Orientation {

	private static final int NORTHCODE = 0;
	private static final int EASTCODE = 1;
	private static final int SOUTHCODE = 2;
	private static final int WESTCODE = 3;
	private final Object _rotateMutex = new Object();
	
	private int _currentOrientation;
	
	public Orientation(OrientationEnum direction) {
		if (null == direction){
				throw new IllegalArgumentException("Failed to create Orientation object - null direction parameter");
		}
		
		_currentOrientation = resolveEnumToInternal(direction);	
	}


	public OrientationEnum getCurrentOrientation(){
		return resolveInternalToEnum(_currentOrientation);
	}
	
	public OrientationEnum turnRight() {
		synchronized (_rotateMutex){
			if (WESTCODE == _currentOrientation){
				_currentOrientation = NORTHCODE;
			}else{
				_currentOrientation++;	
			}
			return resolveInternalToEnum(_currentOrientation);
		}
	}

	public OrientationEnum turnLeft() {
		synchronized (_rotateMutex){
			if (NORTHCODE == _currentOrientation){
				_currentOrientation = WESTCODE;
			}else{
				_currentOrientation--;	
			}
			return resolveInternalToEnum(_currentOrientation);
		}
	}
	
	private int resolveEnumToInternal(OrientationEnum direction){
		switch (direction){
		case NORTH:
			return NORTHCODE;
		case SOUTH:
			return SOUTHCODE;
		case EAST:
			return EASTCODE;
		case WEST:
			return WESTCODE;
		default:
			throw new IllegalStateException("unknown orientation enum value: " + direction);
		}

	}

	private OrientationEnum resolveInternalToEnum(int code) {
		switch (code){
		case NORTHCODE:
			return OrientationEnum.NORTH;
		case SOUTHCODE:
			return OrientationEnum.SOUTH;
		case EASTCODE:
			return OrientationEnum.EAST;
		case WESTCODE:
			return OrientationEnum.WEST;
		default:
			throw new IllegalStateException("unknown internal orientation value: " + code);
		}
	}

}
