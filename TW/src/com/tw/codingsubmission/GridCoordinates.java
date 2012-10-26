package com.tw.codingsubmission;

/**
 * Holds grid coordinates...threadsafe;
 * 
 * @author mtc
 * 
 */
public class GridCoordinates {
	private int _xcoord;
	private int _ycoord;
	private final Object _readWriteMutex = new Object();

	public GridCoordinates(int x, int y) {
		_xcoord = x;
		_ycoord = y;
	}

	public int getX() {
		synchronized (_readWriteMutex) {
			return _xcoord;
		}

	}

	public int getY() {
		synchronized (_readWriteMutex) {
			return _ycoord;
		}
	}

	public void set(int targetX, int targetY) {
		synchronized (_readWriteMutex) {
			_xcoord = targetX;
			_ycoord = targetY;
		}
	}

	@Override
	public String toString() {
		synchronized (_readWriteMutex) {
			return ("(" + _xcoord + "," + _ycoord + ")");
		}
	}

}
