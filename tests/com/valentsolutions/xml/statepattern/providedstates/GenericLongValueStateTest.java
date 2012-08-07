package com.valentsolutions.xml.statepattern.providedstates;

import java.math.BigInteger;

import junit.framework.TestCase;

/**
 * 
 */
public class GenericLongValueStateTest extends TestCase
{
    private GenericLongValueState state;

    /**
     * Constructor for GenericBooleanValueStateTest.
     * @param arg0
     */
    public GenericLongValueStateTest(String arg0)
    {
        super(arg0);
    }

    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception
    {
        super.setUp();
        
        TestHandler handler = new TestHandler(null);
        TestState parentState = new TestState(handler);
        this.state = new GenericLongValueState(handler, null, parentState, parentState.getClass().getDeclaredMethod("longMethod", new Class[] {Long.class}));
    }

    /*
     * @see TestCase#tearDown()
     */
    protected void tearDown() throws Exception
    {
        super.tearDown();
        
        this.state = null;
    }

    public void testConvertValueFromString() throws Exception
    {
        assertEquals(Long.MAX_VALUE, ((Long) this.state.convertValueFromString(String.valueOf(Long.MAX_VALUE))).longValue());
        assertEquals(0, ((Long) this.state.convertValueFromString("0")).intValue());
        assertEquals(Long.MIN_VALUE, ((Long) this.state.convertValueFromString(String.valueOf(Long.MIN_VALUE))).longValue());
        
        try
        {
            Long result = (Long) this.state.convertValueFromString("");
            assertTrue("should have thrown a ConversionException, instead got '" + result + "'", false);
        }
        catch (ConversionException e)
        {
            // Desired outcome.
        }

        try
        {
            Long result = (Long) this.state.convertValueFromString("erut");
            assertTrue("should have thrown a ConversionException, instead got '" + result + "'", false);
        }
        catch (ConversionException e)
        {
            // Desired outcome.
        }

        try
        {
            Long result = (Long) this.state.convertValueFromString(String.valueOf(BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE)));
            assertTrue("should have thrown a ConversionException, instead got '" + result + "'", false);
        }
        catch (ConversionException e)
        {
            // Desired outcome.
        }

        try
        {
            Long result = (Long) this.state.convertValueFromString(String.valueOf(BigInteger.valueOf(Long.MIN_VALUE).subtract(BigInteger.ONE)));
            assertTrue("should have thrown a ConversionException, instead got '" + result + "'", false);
        }
        catch (ConversionException e)
        {
            // Desired outcome.
        }
    }
}
