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
 

  int max_profit_bu(int i,int capacity,int price[],float weight[],int number_of_goods)
    {
         int profit[][]=new int[number_of_goods+1][capacity+1];
         int keep[][]=new int[number_of_goods+1][capacity+1];
         int max_profit=0,j,k;

         for( j=0;j<=number_of_goods;j++)
         {
             for( k=0;k<=capacity;k++)
             {
                 profit[j][k]=-1;
                 keep[j][k]=0;
             }
         }


         for(k=0;k<=capacity;k++)
             {
                if(k<weight[number_of_goods])
                {
                    profit[number_of_goods][k]=0;
                }
                else{
                    profit[number_of_goods][k]=price[number_of_goods];
                    keep[number_of_goods][k]=1;
                 }
             }

       for( j=number_of_goods-1;j>=i;j--)
         {
             for( k=0;k<=capacity;k++)
             {
                 if(weight[j]<=k )
                {

                    int num=k-Math.round(weight[j]);
                     max_profit= profit[j][k]=Math.max(profit[j+1][k],price[j]+profit[j+1][num]);
                     if(profit[j+1][k]<price[j]+profit[j+1][num] ){
                     }
                     else
                         keep[j][k]=0;

                }
                if( weight[j]>k )
                {

                    max_profit=profit[j][k]=profit[j+1][k];
                      keep[j][k]=0;

                }

             }
         }


         for( j=1;j<=number_of_goods;j++)
         {
             for( k=0;k<=capacity;k++)
             {
               System.out.format("%s\t",profit[j][k]);
             }
              System.out.format("\n");


         }
         System.out.println("/////////////////////////////////////////////////////");
          for( j=1;j<=number_of_goods;j++)
         {
             for( k=0;k<=capacity;k++)
             {
               System.out.format("%s\t",keep[j][k]);
             }
              System.out.format("\n");


         }
           int z=capacity;
          for( j=1;j<=number_of_goods;j++)
         {

            if(keep[j][z]==1){
                System.out.println(j);
                z=z-Math.round(weight[j]);
            }
         }
       return max_profit;
    }
}
