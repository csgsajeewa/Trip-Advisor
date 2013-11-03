/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lanka.trip.planner;

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chamath
 */
public class SearchEngineTest {

    public SearchEngineTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of UCS method, of class SearchEngine.
     */
    @Test
    public void testUCS() {
        System.out.println("UCS");
        LinkedList<Road>[] G = null;
        Vertex s = null;
        float duration = 0.0F;
        SearchEngine instance = new SearchEngine();
        instance.UCS(G, s, duration);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print_path method, of class SearchEngine.
     */
    @Test
    public void testPrint_path() {
        System.out.println("print_path");
        Vertex s = null;
        Vertex v = null;
        int duration = 0;
        SearchEngine instance = new SearchEngine();
        instance.print_path(s, v, duration);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTravelTime method, of class SearchEngine.
     */
    @Test
    public void testGetTravelTime() {
        System.out.println("getTravelTime");
        int distance = 0;
        char type = ' ';
        SearchEngine instance = new SearchEngine();
        float expResult = 0.0F;
        float result = instance.getTravelTime(distance, type);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}