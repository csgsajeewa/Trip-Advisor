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


 public class PlaningEngine
{
 

  int getBestPlan(int i,int duration,int rates[],float durations[],int numOfCities)
    {
         int maxRates[][]=new int[numOfCities+1][duration+1];
         int keep[][]=new int[numOfCities+1][duration+1];
         int maximumRate=0,j,k;

         for( j=0;j<=numOfCities;j++)
         {
             for( k=0;k<=duration;k++)
             {
                maxRates[j][k]=-1;
                 keep[j][k]=0;
             }
         }


         for(k=0;k<=duration;k++)
             {
                if(k<durations[numOfCities])
                {
                   maxRates[numOfCities][k]=0;
                }
                else{
                    maxRates[numOfCities][k]=rates[numOfCities];
                    keep[numOfCities][k]=1;
                 }
             }

       for( j=numOfCities-1;j>=i;j--)
         {
             for( k=0;k<=duration;k++)
             {
                 if(durations[j]<=k )
                {

                    int num=k-Math.round(durations[j]);
                     maximumRate= maxRates[j][k]=Math.max(maxRates[j+1][k],rates[j]+maxRates[j+1][num]);
                     if(maxRates[j+1][k]<rates[j]+maxRates[j+1][num] ){
                         keep[j][k]=1;
                     }
                     else
                         keep[j][k]=0;

                }
                if( durations[j]>k )
                {

                   maximumRate=maxRates[j][k]=maxRates[j+1][k];
                      keep[j][k]=0;

                }

             }
         }


         for( j=1;j<=numOfCities;j++)
         {
             for( k=0;k<=duration;k++)
             {
               System.out.format("%s\t",maxRates[j][k]);
             }
              System.out.format("\n");


         }
         System.out.println("/////////////////////////////////////////////////////");
          for( j=1;j<=numOfCities;j++)
         {
             for( k=0;k<=duration;k++)
             {
               System.out.format("%s\t",keep[j][k]);
             }
              System.out.format("\n");


         }
           int z=duration;
          for( j=1;j<=numOfCities;j++)
         {

            if(keep[j][z]==1){
                System.out.println(j);
                z=z-Math.round(durations[j]);
            }
         }
       return maximumRate;
    }
}
