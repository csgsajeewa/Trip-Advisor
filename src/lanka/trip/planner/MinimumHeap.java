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
public class MinimumHeap
{

    Vertex vertices[]=new Vertex[1000];



  int LEFT_CHILD(int i)
   {
       return 2*i;

   }

   int RIGHT_CHILD(int i)
   {
       return 2*i+1;
   }

   int PARENT(int i)
   {
       int index=i/2;
       return index;
   }


    void MIN_HEAPIFY(int i,int heap_length)
    {
        int l=LEFT_CHILD(i);
        int r=RIGHT_CHILD(i);

        int smallest;
        Vertex vertex;
        if(l<=heap_length && vertices[l].getDistance()<vertices[i].getDistance())
        {
            smallest=l;

        }

        else
            smallest=i;
        if(r<=heap_length && vertices[r].getDistance()<vertices[smallest].getDistance())
        {
            smallest=r;

        }


        if(smallest!=i)
        {
            vertex=vertices[smallest];
           vertices[smallest]=vertices[i];
            vertices[i]=vertex;


           MIN_HEAPIFY(smallest,heap_length);
        }

    }

}