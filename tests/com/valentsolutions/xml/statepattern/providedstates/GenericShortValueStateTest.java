package com.valentsolutions.xml.statepattern.providedstates;

import junit.framework.TestCase;

/**
 * 
 */
public class GenericShortValueStateTest extends TestCase
{
    private GenericShortValueState state;

    /**
     * Constructor for GenericBooleanValueStateTest.
     * @param arg0
     */
    public GenericShortValueStateTest(String arg0)
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
        this.state = new GenericShortValueState(handler, null, parentState, parentState.getClass().getDeclaredMethod("shortMethod", new Class[] {Short.class}));
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
        assertEquals(Short.MAX_VALUE, ((Short) this.state.convertValueFromString(String.valueOf(Short.MAX_VALUE))).shortValue());
        assertEquals(0, ((Short) this.state.convertValueFromString("0")).intValue());
        assertEquals(Short.MIN_VALUE, ((Short) this.state.convertValueFromString(String.valueOf(Short.MIN_VALUE))).shortValue());
        
        try
        {
            Short result = (Short) this.state.convertValueFromString("");
            assertTrue("should have thrown a ConversionException, instead got '" + result + "'", false);
        }
        catch (ConversionException e)
        {
            // Desired outcome.
        }

        try
        {
            Short result = (Short) this.state.convertValueFromString("erut");
            assertTrue("should have thrown a ConversionException, instead got '" + result + "'", false);
        }
        catch (ConversionException e)
        {
            // Desired outcome.
        }

        try
        {
            Short result = (Short) this.state.convertValueFromString(String.valueOf(Short.MAX_VALUE + 1));
            assertTrue("should have thrown a ConversionException, instead got '" + result + "'", false);
        }
        catch (ConversionException e)
        {
            // Desired outcome.
        }

        try
        {
            Short result = (Short) this.state.convertValueFromString(String.valueOf(Short.MIN_VALUE - 1));
            assertTrue("should have thrown a ConversionException, instead got '" + result + "'", false);
        }
        catch (ConversionException e)
        {
            // Desired outcome.
        }
    }
}
