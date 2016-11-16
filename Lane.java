// Programmer: Arthur Charlesworth  (c) Copyright 2016
// Modified by GOATS team: Alex David Rex Tom Zihao
// *****************************************************************************
// *****************************************************************************
// **** Lane 
// *****************************************************************************
// *****************************************************************************
// Latest Enhancement: Made inbound, outbound boundary lanes have no max capc.

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
    private HashMap<Car,Integer> timesInQueue;  // Stores the length of time 
                                            // each car spends in the lane
    private int capacity;
    private int minTimeToTraverse;
    public boolean inboundBoundary;
    public boolean outboundBoundary;

    //**************Constructor**************
    public Lane(int capacity, int minTimeToTraverse)
    {
        q = new LinkedList<Car>();
        timesInQueue = new HashMap<Car,Integer>();
        this.capacity = capacity;
        this.minTimeToTraverse = minTimeToTraverse;
    } // end of constructor



    //**************Instance Methods**************
    //removes a Car from a Lane and returns it
    public Car get()
    {
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
        if( c != null && timesInQueue.get(c) >= minTimeToTraverse)
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
            return true;
        } // end of if(this.isFull())

        if(this.isOutboundBoundary())
        {
            System.out.println("   car#" + c.getID() + " has left the grid");
            // Future enhancement: update stats for the car leaving 
        } // end of if(this.isOutboundBoundary())
        timesInQueue.put(c,0);
        c.setHasChangedLanes(true);
        return q.add(c);
    } // end of add(Car c)



    public boolean initialAdd(Car c)
    {
        boolean done = this.add(c);
        timesInQueue.put(c, minTimeToTraverse);
        return done;
    }



    // We "update" the length of time each car spends in the lane
    public void update()
    {
        for( Car c : q )
        {   
            if (!c.hasItMoved()){
            // Increment c's timeInQueue
            timesInQueue.put(c,timesInQueue.get(c)+1);
        }
        } // end of for( Car c : q )
    } // end of update()



    public boolean isEmpty()
    {
        return (q.peek() == null);
    } // end of isEmpty()

    

    public boolean isFull()
    {
        if( this.isInboundBoundary() || this.isOutboundBoundary() )
        {
            return false;
        } // end of if ( this.isInboundBoundary() || this.isOutboundBoundary() )
        return q.size() >= capacity;
    } // end of isFull()



    public void setInboundBoundary() {
        this.inboundBoundary = true;
    } // end of isInboundBoundary()



    public void setOutboundBoundary() {
        this.outboundBoundary = true;
    } // end of isOutboundBoundary()

    
    
    public boolean isInboundBoundary() {
        return this.inboundBoundary;
    } // end of isInboundBoundary()



    public boolean isOutboundBoundary() {
        return this.outboundBoundary;
    } // end of isOutboundBoundary()



}
