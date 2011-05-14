package util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PairTest
{
    
    @Before
    public void setUp () throws Exception
    {}
    
    @Test
    public final void testPair ()
    {
        assertEquals ("apple", Pair.pair ("apple", new Object ())._1);
    }
    
    @Test
    public final void testHas ()
    {
        fail ("Not yet implemented");
    }
    
    @Test
    public final void testSwap ()
    {
        fail ("Not yet implemented");
    }
    
}
