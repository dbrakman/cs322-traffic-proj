// Programmers: GOATS team: Alex David Rex Tom Zihao
// *****************************************************************************
// *****************************************************************************
// **** TrafficTesterModel
// *****************************************************************************
// *****************************************************************************
// The purpose of the TrafficTesterModel is to create a grid given a provided
// numRows and numCols.  Provided cars are then inserted into the grid.
// Latest Enhancement: Stage 0 Corrections

import java.util.ArrayList;

public class TrafficTesterModel{
    Grid g;
    int t;
    int lengthOfSimulation;

    //************Constructor************
    public TrafficTesterModel(int numRows, int numCols, 
    ArrayList< ArrayList<Integer> > carParameters, int lengthOfSim){
        //System.out.println("In TrafficTesterModel(): ");
        //********Creating a new grid********
        //System.out.println("  Constructing a Grid...");
        g = new Grid(numRows, numCols);

        //********Teling the grid to make and insert cars********
        //System.out.println("  Telling the grid to make and insert cars...");
        g.insertCars(carParameters);

        lengthOfSimulation = lengthOfSim;

        //System.out.println("Exiting TrafficTesterModel()");
    }// End of TrafficTesterModel constructor 



    //Calls update() on the Grid, causing the intersections to be looked at
    public void run(){
        //System.out.println("In TrafficTesterModel: running simulation");
        for(t = 1; t <= lengthOfSimulation; t++){
            System.out.println("");
            System.out.println("******************* During timestep: "
                               + t +" *******************");
            g.update();
        }// End of for(t < lengthOfSimulation; t++)
        //g.update();
    }// End of run method



}
