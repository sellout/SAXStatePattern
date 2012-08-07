package com.valentsolutions.xml.statepattern.providedstates;

import junit.framework.TestCase;

/**
 * 
 */
public class GenericIntValueStateTest extends TestCase
{
    private GenericIntValueState state;

    /**
     * Constructor for GenericBooleanValueStateTest.
     * @param arg0
     */
    public GenericIntValueStateTest(String arg0)
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
        this.state = new GenericIntValueState(handler, null, parentState, parentState.getClass().getDeclaredMethod("intMethod", new Class[] {Integer.class}));
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
        assertEquals(Integer.MAX_VALUE, ((Integer) this.state.convertValueFromString(String.valueOf(Integer.MAX_VALUE))).intValue());
        assertEquals(0, ((Integer) this.state.convertValueFromString("0")).intValue());
        assertEquals(Integer.MIN_VALUE, ((Integer) this.state.convertValueFromString(String.valueOf(Integer.MIN_VALUE))).intValue());
        
        try
        {
            Integer result = (Integer) this.state.convertValueFromString("");
            assertTrue("should have thrown a ConversionException, instead got '" + result + "'", false);
        }
        catch (ConversionException e)
        {
            // Desired outcome.
        }

        try
        {
            Integer result = (Integer) this.state.convertValueFromString("erut");
            assertTrue("should have thrown a ConversionException, instead got '" + result + "'", false);
        }
        catch (ConversionException e)
        {
            // Desired outcome.
        }

        try
        {
            Integer result = (Integer) this.state.convertValueFromString(String.valueOf(Integer.MAX_VALUE + 1L));
            assertTrue("should have thrown a ConversionException, instead got '" + result + "'", false);
        }
        catch (ConversionException e)
        {
            // Desired outcome.
        }

        try
        {
            Integer result = (Integer) this.state.convertValueFromString(String.valueOf(Integer.MIN_VALUE - 1L));
            assertTrue("should have thrown a ConversionException, instead got '" + result + "'", false);
        }
        catch (ConversionException e)
        {
            // Desired outcome.
        }
    }
}
