/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lanka.trip.planner;

import java.util.LinkedList;



/**
 *
 * @author chamath sajeewa
 * @email chamaths.10@cse.mrt.ac.lk
 */


public class Main {

    public static void main(String[] args)
    {
         LinkedList <Road>adjucenyList[]=new LinkedList[9];
         int numOfVertices=9;
         Vertex verticesA[]=new Vertex[numOfVertices];
        for (int i = 0; i < adjucenyList.length; i++) {
            adjucenyList[i]=new LinkedList<Road>();

        }
         verticesA[0]=new Vertex("Thissa",0,"History",2);
          verticesA[1]=new Vertex("Tangalle",1,"Wild Life",1);
          verticesA[2]=new Vertex("Matara",2,"Beach",2);
          verticesA[3]=new Vertex("Galle",3,"History",1);
          verticesA[4]=new Vertex("Kandy",4,"History",5);
          verticesA[5]=new Vertex("Colombo",5,"Shopping",1);
          verticesA[6]=new Vertex("Matale",6,"Hill Country",3);
          verticesA[7]=new Vertex("Anuradhapura",7,"History",8);
          verticesA[8]=new Vertex("Deniyaya",8,"Hill Country",4);

         Road road1=new Road( verticesA[1],50,'B');
         adjucenyList[0].add(road1);
         Road road2=new Road( verticesA[2],20,'A');
         adjucenyList[1].add(road2);
         Road road3=new Road( verticesA[3],40,'A');
         adjucenyList[2].add(road3);
          Road road4=new Road( verticesA[5],120,'E');
         adjucenyList[3].add(road4);
          Road road5=new Road( verticesA[4],80,'A');
         adjucenyList[5].add(road5);
          Road road6=new Road(verticesA[7],300,'A');
         adjucenyList[5].add(road6);
          Road road7=new Road( verticesA[6],65,'B');
         adjucenyList[4].add(road7);
          Road road8=new Road( verticesA[8],75,'B');
         adjucenyList[2].add(road8);
          Road road9=new Road( verticesA[4],120,'C');
         adjucenyList[8].add(road9);
         Road road10=new Road( verticesA[0],50,'B');
         adjucenyList[1].add(road10);
         Road road11=new Road( verticesA[1],20,'A');
         adjucenyList[2].add(road11);

      SearchEngine uniform_cost_search=new SearchEngine();
      uniform_cost_search.UCS(adjucenyList,  verticesA[2]);// find path from source to all destinations within given duration
      //////////////////////planing/////////////////////////////////
      int counter=0;
      String userLocation="Matara";
      String userInterest="History";
      for (int i = 0; i < verticesA.length; i++) {
           if(!verticesA[i].getCity_name().equals(userLocation) && verticesA[i].getInterest().equals(userInterest)){
               if(verticesA[i].getTravelTime()!=0){
                   counter++;
               }
           }

        }

     Vertex selectedCities[]=new Vertex[counter];
      int j=0;
      for (int i = 0; i < verticesA.length; i++) {
           if(!verticesA[i].getCity_name().equals(userLocation) && verticesA[i].getInterest().equals(userInterest)){
               if(verticesA[i].getTravelTime()!=0){
                  selectedCities[j]=verticesA[i];
                  j++;
               }
           }

        }
     int rates[]=new int[counter+1];
     rates[0]=0;
     float durations[]=new float[counter+1];
     durations[0]=0;
      for (int i = 1; i <= selectedCities.length; i++) {
              rates[i]=selectedCities[i-1].getRate();
              durations[i]=selectedCities[i-1].getTravelTime();

        }

     PlaningEngine planingEngine=new PlaningEngine();
     planingEngine.max_profit_bu(1,4, rates, durations, selectedCities.length);




     






      /////////////////////////////////////////////////
      System.out.println(verticesA[7].getDistance());
      System.out.println("-------------------------Path--------------------------------");
      uniform_cost_search.print_path(verticesA[2],verticesA[0]);
       System.out.println();
      System.out.println("-------------------------Path--------------------------------");
      uniform_cost_search.print_path(verticesA[2],verticesA[3]);
       System.out.println();
      System.out.println("-------------------------Path--------------------------------");
      uniform_cost_search.print_path(verticesA[2],verticesA[4]);
       System.out.println();
      System.out.println("-------------------------Path--------------------------------");
      uniform_cost_search.print_path(verticesA[2],verticesA[7]);
       System.out.println();



       
    }

}

