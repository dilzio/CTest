package com.tw.codingsubmission;

import java.util.List;

/**
 * Entry Point for Mars Rover Demo. arg[0] is path to input file
 * 
 * @author mtc
 * 
 */
public class Main {
	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			System.err
					.println("Error on startup: Input file parameter not defined...exiting");
			System.exit(-1);
		}
		InputFileParser parser = new InputFileParser(args[0]);
		Grid grid = new Grid(parser.getGridMaxCoordinates());
		List<RoverSpec> specList = parser.getRoverSpecs();
		RoverBuilder builder = new RoverBuilder();

		for (RoverSpec spec : specList) {
			IRover rover = builder.build(grid, spec);
			rover.executeCommands();
			System.out.println(rover.getPositionAndHeading());
		}
	}
}
