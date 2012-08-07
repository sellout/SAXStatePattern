package com.valentsolutions.xml.statepattern.providedstates;

import junit.framework.TestCase;

/**
 * 
 */
public class GenericBooleanValueStateTest extends TestCase
{
    private GenericBooleanValueState state;

    /**
     * Constructor for GenericBooleanValueStateTest.
     * @param arg0
     */
    public GenericBooleanValueStateTest(String arg0)
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
        this.state = new GenericBooleanValueState(handler, null, parentState, parentState.getClass().getDeclaredMethod("booleanMethod", new Class[] {Boolean.class}));
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
        assertTrue(((Boolean) this.state.convertValueFromString("true")).booleanValue());
        assertFalse(((Boolean) this.state.convertValueFromString("false")).booleanValue());
        
        try
        {
            Boolean result = (Boolean) this.state.convertValueFromString("");
            assertTrue("should have thrown a ConversionException, instead got '" + result + "'", false);
        }
        catch (ConversionException e)
        {
            // Desired outcome.
        }

        try
        {
            Boolean result = (Boolean) this.state.convertValueFromString("eurt");
            assertTrue("should have thrown a ConversionException, instead got '" + result + "'", false);
        }
        catch (ConversionException e)
        {
            // Desired outcome.
        }

        try
        {
            Boolean result = (Boolean) this.state.convertValueFromString("1");
            assertTrue("should have thrown a ConversionException, instead got '" + result + "'", false);
        }
        catch (ConversionException e)
        {
            // Desired outcome.
        }

        try
        {
            Boolean result = (Boolean) this.state.convertValueFromString("0");
            assertTrue("should have thrown a ConversionException, instead got '" + result + "'", false);
        }
        catch (ConversionException e)
        {
            // Desired outcome.
        }
    }
}
