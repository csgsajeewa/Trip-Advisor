/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lanka.trip.planner;

/**
 *
 * @author chamath sajeewa
 * @email chamaths.10@cse.mrt.ac.lk
 */
public class Road {

    private Vertex destination;
    private int distance;
    private char type; //E,A,B,C
    private boolean workInProgress;

    public Road(Vertex destination, int distance, char type) {
        this.destination = destination;
        this.distance = distance;
        this.type = type;
        this.workInProgress = false;
    }

    public Road(Vertex destination, int distance, char type, boolean workInProgress) {
        this.destination = destination;
        this.distance = distance;
        this.type = type;
        this.workInProgress = workInProgress;
    }
    


    public Vertex getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setType(char type) {
        this.type = type;
    }

    public char getType() {
        return type;
    }

    public boolean isWorkInProgress() {
        return workInProgress;
    }

    public void setWorkInProgress(boolean workInProgress) {
        this.workInProgress = workInProgress;
    }

    
    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    

}
