// Programmer: Arthur Charlesworth  (c) Copyright 2016
// Modified by GOATS team: Alex David Rex Tom Zihao
// *****************************************************************************
// *****************************************************************************
// **** Lane 
// *****************************************************************************
// *****************************************************************************

import java.util.Queue;
import java.util.LinkedList;

//Lane Class
//This class defines a "Lane" object, which will hold cars.
//Lanes can be either incoming or outgoing depending on their direction in 
//relation to intersections.
//Each lane will belong to 2 intersections: as an incoming lane for one
//and an outgoing lane for another

public class Lane {
    //**************Instance Variables**************
    public Queue<Car> q;
    public boolean boundary;

    //**************Constructor**************
    public Lane() {
        q = new LinkedList<Car>();
        boundary = false;
    }//end of constructor



    //**************Instance Methods**************
    //removes a Car from a Lane and returns it
    public Car get() {
        return q.poll();
    }//end of get



    //adds a provided Car c to the Lane
    public boolean add(Car c) {
        if (this.boundary == true){
            System.out.println("   car#" + c.getID() + " leaves the grid");
        }//end of if (this.boundary == true)
        return q.add(c);
    }//end of add



    public boolean isEmpty() {
        return (q.peek() == null);
    }//end of isEmpty



    public void setIsBoundary() {
        this.boundary = true;
    }//end of setIsBoundary


}
