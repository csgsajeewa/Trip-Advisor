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
//main data structre
 public class Vertex
{

    private String city_name;
    private int distance;//distance from source
    private float travelTime;//time taken to travel from source to that city

    private Vertex pi;//parent vertex of the route we calculated
    private int num;//used to find adjucney list of that node index
    private String colour;
    private String interest;// to match with user's interest
    private int rate;

    public Vertex(String city_name, int num,String interest,int rate) {
        this.city_name = city_name;
        this.distance = 0;
        this.travelTime = 0;
        this.pi = null;
        this.num = num;
        this.colour = "white";
        this.interest=interest;
        this.rate=rate;

    }

   
//used by Insert function in min priority queue
    public Vertex(int distance) {
        this.distance=distance;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }
    

    public void setTravelTime(float travelTime) {
        this.travelTime = travelTime;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }
    

    public float getTravelTime() {
        return travelTime;
    }

    
    public String getCity_name() {
        return city_name;
    }

    public int getDistance() {
        return distance;
    }

    public Vertex getPi() {
        return pi;
    }

    public int getNum() {
        return num;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }
    
    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setPi(Vertex pi) {
        this.pi = pi;
    }
    
}