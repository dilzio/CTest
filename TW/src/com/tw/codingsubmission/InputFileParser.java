package com.tw.codingsubmission;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Reads in the input file and marshals info for later use.  Currently respects file format defined in problem which is:
 * 
 * line 1 - defines size of grid  e.g.: 5 5
 * lines 2-3, 4-5, etc... groups of two lines, each group has info for one rover.  First line is starting coordinats and heading (e.g.: 1 1 N), 
 * second line is command string (e.g., LRMMLLMR)
 * @author mtc
 *
 */
public class InputFileParser {
	
	private final GridCoordinates _maxGridCoordinates;
	private final List<RoverSpec> _roverSpecList = new ArrayList<RoverSpec>();
	
	public InputFileParser(String path) throws IOException{
		try {
//			BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(path)));
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

			String line;
			char x; 
			char y;
			char direction;
			String commands;
			line = br.readLine();

			_maxGridCoordinates = new GridCoordinates(Integer.parseInt(line.charAt(0)+""), Integer.parseInt(line.charAt(2)+""));
			
			while ((line = br.readLine()) != null){
				x = line.charAt(0);
				y = line.charAt(2);
				direction = line.charAt(4);
				line = br.readLine();
				if (null == line){
					throw new IllegalStateException("no command list found for rover entry");
				}
				commands = line;
				_roverSpecList.add(new RoverSpec(x, y, direction, commands));
			}

			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IllegalArgumentException("unable to parse input file.");
		}
	}
	
	public GridCoordinates getGridMaxCoordinates() {
		return _maxGridCoordinates;
	}

	public List<RoverSpec> getRoverSpecs() {
		return Collections.unmodifiableList(_roverSpecList);
	}
}
