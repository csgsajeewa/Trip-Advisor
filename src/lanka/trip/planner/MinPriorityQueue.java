

package lanka.trip.planner;




/**
 *
 * @author chamath sajeewa
 * @email chamaths.10@cse.mrt.ac.lk
 */

public class MinPriorityQueue
{

    private int heap_size;
    private MinimumHeap mh=new MinimumHeap();
    public MinPriorityQueue()
    {
       heap_size=0;
    }
    //return the vertex with minimum distance value
    Vertex MINIMUM()
    {
        return mh.vertices[1];
    }
    // extract(remove) the vertex with the minimum distance value and return the vertex
    Vertex EXTRACT_MINIMUM()
    {
        Vertex min;

        min=mh.vertices[1];

        mh.vertices[1]=mh.vertices[heap_size];
        heap_size=heap_size-1;
        mh.MIN_HEAPIFY(1,heap_size);
        return min;
    }
    // use to insert a vertex
    void INSERT(Vertex vertex)
    {
        heap_size=heap_size+1;
         mh.vertices[heap_size]=new Vertex((int)Double.POSITIVE_INFINITY);
         DECREASE_KEY(heap_size,vertex);
    }
    //maintain the heap property after inserting a new element
    void DECREASE_KEY(int i,Vertex vertex)
    {
        if(mh.vertices[i].getDistance()<vertex.getDistance())
        {
            System.out.println("can't perform this action");
        }

        else
        {
            mh.vertices[i] = vertex;
        while(i>1 && mh.vertices[mh.PARENT(i)].getDistance()>mh.vertices[i].getDistance())
        {
            Vertex temp=mh.vertices[mh.PARENT(i)];
            mh.vertices[mh.PARENT(i)]=mh.vertices[i];
            mh.vertices[i]=temp;
            i=mh.PARENT(i);
        }
        }

    }

    public int getHeap_size() {
        return heap_size;
    }


    

    void print() ///////////////////
    {
        for(int i=1;i<=heap_size;i++)
        {
            System.out.println("city name- "+mh.vertices[i].getCity_name()+"distance- "+mh.vertices[i].getDistance());

        }
    }

}



