// Programmer: Arthur Charlesworth  (c) Copyright 2016
// Modified by GOATS team: Alex David Rex Tom Zihao
// *****************************************************************************
// *****************************************************************************
// **** Lane 
// *****************************************************************************
// *****************************************************************************
// Latest Enhancement: Added capacity and minimum time to traverse, for stage_1

import java.util.Queue;
import java.util.LinkedList; //The implementation of a queue
import java.util.HashMap;

//Lane Class
//This class defines a "Lane" object, which will hold cars.
//Lanes can be either incoming or outgoing depending on their direction in 
//relation to intersections.
//Each lane will belong to 2 intersections: as an incoming lane for one
//and an outgoing lane for another

public class Lane {
    //**************Instance Variables**************
    private Queue<Car> q; // Stores the cars in the lane
    private HashMap<Car,int> timesInQueue;  // Stores the length of time each
                                            // car spends in the lane
    private int capacity;
    private int minTimeToTraverse;
    public boolean boundary;

    //**************Constructor**************
    public Lane(int capacity, int minTimeToTraverse)
    {
        q = new LinkedList<Car>();
        timesInQueue = new HashMap<Car,int>();
        this.capacity = capacity;
        this.minTimeToTraverse = minTimeToTraverse;
    } // end of constructor



    //**************Instance Methods**************
    //removes a Car from a Lane and returns it
    public Car get()
    {
        // Since only one car can exit a lane during a given timestep
        // We can "update" the length of time each car spends in the lane
        // in this get() method:
        for( Car c : q )
        {   // Increment c's timeInQueue
            timesInQueue.put(c,timesInQueue.get(c)+1);
        }
        if( this.peek() != null)
        {
            // if a car is able to exit, remove it from the queue
            return q.poll();
        } else {
            // return null if no car is able to exit the queue yet.
            return null;
        }
    } // end of get()



    public Car peek()
    {
        Car c = q.peek();
        if(timesInQueue.get(c) >= minTimeToTraverse)
        {
            return c;
        } else {
            // return null if no car is able to exit the queue yet.
            return null;
        }
    } // end of peek()




    //adds a provided Car c to the Lane
    public boolean add(Car c)
    {
        if(this.isFull())
        {
            System.out.println("Illegal attempt to add to a full lane");
            return;
        } // end of if(q.size() >= capacity)

        if(this.isBoundary())
        {
            System.out.println("Car" + c.getID() + "has left the grid");
            // Future enhancement: update stats for the car leaving 
            q.remove(c);
            return true;
        } // end of if(this.isBoundary())
        timesInQueue.put(c,0);
        return q.add(c);
    } // end of add(Car c)



    public boolean isEmpty()
    {
        return (q.peek() == null);
    } // end of isEmpty()

    

    public boolean isFull()
    {
        return q.size() >= capacity;
    } // end of isFull()
    
    public void setIsBoundary() {
        this.boundary = true;
    }



}