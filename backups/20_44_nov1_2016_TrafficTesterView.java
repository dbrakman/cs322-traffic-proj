// Added carParameters list of lists
// Programmer: Arthur Charlesworth  (c) Copyright 2016
// Modified by GOATS team: Alex David Rex Tom Zihao
// *****************************************************************************
// *****************************************************************************
// **** TrafficTesterView 
// *****************************************************************************
// *****************************************************************************


// NOTE: A lane has the same coordinates as the intersection the lane aims at.
//   Throughout the rest of the semester, make sure that 
//   intersections of a grid are processed in exactly the following order:
//     row 1 intersections, from left to right
//     row 2 intersections, from left to right, etc, for all rows.
//   In an actual simulation, that process should be repeated (in that specific
//   order) as many times as necessary for the desired length of the simulation.
//   But, for simplicity, the initial tester software students build should 
//   only show the first iteration of the above process, that is, only one 
//   processing of each of the intersections.
// 
//   The format of the data to be used with the program in this file
//   is show, via an example, at the end of this file.

import java.util.*;

public class TrafficTesterView {

// NOTE: Just to keep the current tester program really simple, 
// the following constants are not encapsulated within two classes, Direction 
// and Turn, according to appropriate Information Hiding:
  static final int SOUTHWARD = 0;
  static final int EASTWARD = 1;
  static final int NORTHWARD = 2;
  static final int WESTWARD = 3;
  static final int NEVER_TURN = 0;
  static final int TURN_RIGHTWARD = 1;
  static final int TURN_LEFTWARD = -1;

  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    console.nextLine();
    int numIntersectionsInOneDirection = console.nextInt();
    System.out.print("The number of intersections in one direction ");
    System.out.println("is: " + numIntersectionsInOneDirection);
    console.nextLine();
    console.nextLine();
    int numberOfCars = console.nextInt();
    System.out.println("The number of cars is: " + numberOfCars);
    int carID;
    int row;
    int col;
    int laneDirectionCode;
    int numBlocksBeforeTurning;
    int turnDirectionCode;
    ArrayList< ArrayList<Integer> > carParameters;
    carParameters = new ArrayList< ArrayList<Integer> >();
    for (int i = 1; i <= numberOfCars; i++) {
       console.nextLine();
       console.nextLine();
       carID = console.nextInt();
       System.out.println("Car #" + carID);
       console.nextLine();
       console.nextLine();
       row = console.nextInt();
       console.nextLine();
       console.nextLine();
       col = console.nextInt();
       console.nextLine();
       console.nextLine();
       laneDirectionCode = console.nextInt();
       console.nextLine();
       console.nextLine();
       numBlocksBeforeTurning = console.nextInt();
       console.nextLine();
       console.nextLine();
       turnDirectionCode = console.nextInt();
       ArrayList<Integer> currentParams = new ArrayList<Integer>();
       currentParams.add(carID);
       currentParams.add(row);
       currentParams.add(col);
       currentParams.add(laneDirectionCode);
       currentParams.add(numBlocksBeforeTurning);
       currentParams.add(turnDirectionCode);
       carParameters.add(currentParams);
       System.out.println("  is born in the lane located at col " + col +
                          " and row " + row + ", that aims " +
                          convertToLaneDirection(laneDirectionCode) + ",");
       System.out.println("  and has " + numBlocksBeforeTurning +
                          " block(s) to go before turning");
       System.out.println("  and plans to " + 
                          convertToTurnDirection(turnDirectionCode));
    } // end for

    // check that carParameters has been appropriately populated
    for(int i=0; i<numberOfCars; i++){
        for(int param : carParameters.get(i)){
            System.out.printf("%d, ",param);
        }
        System.out.println("");
    }
  } // main

  public static String convertToLaneDirection(int laneDirectionCode) {
    if (laneDirectionCode == SOUTHWARD)      return "SOUTHWARD";
    if (laneDirectionCode == EASTWARD)       return "EASTWARD";
    if (laneDirectionCode == NORTHWARD)      return "NORTHWARD";
    if (laneDirectionCode == WESTWARD)       return "WESTWARD";
    return "ILLEGAL laneDirectionCode!!!";
  } // convertToLaneDirection

  public static String convertToTurnDirection(int turnDirectionCode) {
    if (turnDirectionCode == NEVER_TURN)     return "NEVER_TURN";
    if (turnDirectionCode == TURN_RIGHTWARD) return "TURN_RIGHTWARD";
    if (turnDirectionCode == TURN_LEFTWARD)  return "TURN_LEFTWARD";
    return "ILLEGAL turnDirectionCode!!!";
  } // convertToTurnDirection

} // TrafficTesterView

////////////////// Example of sample use of the above program //////////////////
// except for the fact that all the following lines have been made comments,  //
// and also the actual phrase "additional blocks to travel" in the data       //
// shown below has been shortened to the phrase "additional blocks" to fit    //
// the lines below into the required 80-columns per line.                     //
////////////////////////////////////////////////////////////////////////////////
//numIntersectionsInOneDirection:
//1
//number of cars created for the test:
//2
//car number:
//1
//born in the lane that is positioned at col:
//1
//born in the lane that is positioned at row:
//1
//born in the lane that is oriented in direction:
//0
//additional blocks prior to turning (-1 means the car will never turn):
//0
//direction the car will turn, when the car turns:
//1
//car number:
//2
//born in the lane that is positioned at col:
//1
//born in the lane that is positioned at row:
//1
//born in the lane that is oriented in direction:
//3
//additional blocks prior to turning (-1 means the car will never turn):
//-1 
//direction the car will turn, when the car turns:
//0
//hopper2{acharles}2484: java TrafficTesterView < data1_for_TrafficTesterView
//The number of intersections in one direction is: 1
//The number of cars is: 2
//Car #1
//  is born in the lane located at col 1 and row 1, that aims SOUTHWARD,
//  and has 0 block(s) to go before turning
//  and plans to TURN_RIGHTWARD
//Car #2
//  is born in the lane located at col 1 and row 1, that aims WESTWARD,
//  and has -1 block(s) to go before turning
//  and plans to NEVER_TURN
//
