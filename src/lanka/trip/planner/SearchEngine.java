/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lanka.trip.planner;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author chamath sajeewa
 * @email chamaths.10@cse.mrt.ac.lk
 */
public class SearchEngine
{

 // colours - grey - frontier,black- explored
   MinPriorityQueue frontier;

    public SearchEngine() {
        frontier=new MinPriorityQueue();
    }


    void UCS(LinkedList<Road>G[],Vertex s)
    {

        s.setDistance(0);
        s.setPi(null);
        float duration =5;
        frontier.INSERT(s);
        while(frontier.getHeap_size()!=0)
        {
            Vertex u=frontier.EXTRACT_MINIMUM();
            u.setColour("black");
            ListIterator iter=G[u.getNum()].listIterator();
          // if(u.getTravelTime()<duration){
            while(iter.hasNext())
            {
                Road road=(Road)iter.next();
                if(road.getDestination().getColour().equals("white")){
                    if(u.getTravelTime()+getTravelTime(road.getDistance(),road.getType())<=duration){
                    road.getDestination().setDistance(u.getDistance()+road.getDistance());
                    road.getDestination().setPi(u);
                    road.getDestination().setColour("gray");
                    road.getDestination().setTravelTime(u.getTravelTime()+getTravelTime(road.getDistance(),road.getType()));
                    frontier.INSERT(road.getDestination());
                    }
                }
                 else if(road.getDestination().getColour().equals("gray") && (road.getDestination().getTravelTime()>(u.getTravelTime()+getTravelTime(road.getDistance(),road.getType())))){
                      road.getDestination().setDistance(u.getDistance()+road.getDistance());
                      road.getDestination().setPi(u);
                      road.getDestination().setTravelTime(u.getTravelTime()+getTravelTime(road.getDistance(),road.getType()));
                 }
            }
          //  }

        }


    }

    void print_path(Vertex s,Vertex v)
    {

        
        if(s.getCity_name().equals(v.getCity_name()))
         System.out.print("    "+s.getCity_name());

        else if(v.getPi()==null)
        System.out.format("cannot reach from %s to %s within time duration \n",s.getCity_name(),v.getCity_name());

       else
        {
           print_path(s,v.getPi());
           System.out.print("     "+v.getCity_name()+ " "+v.getTravelTime() );
        }
       

    }

    float getTravelTime(int distance, char type){
        float typeEAverageSpeed=90;
        float typeAAverageSpeed=60;
        float typeBAverageSpeed=40;
        float typeCAverageSpeed=30;
        float travelTime;
        DecimalFormat decimalFormat=new DecimalFormat("#.##");
        
        if(type == 'E')
            travelTime=distance/typeEAverageSpeed;
        else if(type == 'A')
            travelTime=distance/typeAAverageSpeed;
        else if(type == 'B')
            travelTime=distance/typeBAverageSpeed;
        else
            travelTime=distance/typeCAverageSpeed;

        return travelTime;
    }
}