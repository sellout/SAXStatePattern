package com.valentsolutions.xml.statepattern.providedstates;

import junit.framework.TestCase;

/**
 * 
 */
public class GenericByteValueStateTest extends TestCase
{
    private GenericByteValueState state;

    /**
     * Constructor for GenericBooleanValueStateTest.
     * @param arg0
     */
    public GenericByteValueStateTest(String arg0)
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
        this.state = new GenericByteValueState(handler, null, parentState, parentState.getClass().getDeclaredMethod("byteMethod", new Class[] {Byte.class}));
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
        assertEquals(127, ((Byte) this.state.convertValueFromString(String.valueOf(Byte.MAX_VALUE))).byteValue());
        assertEquals(0, ((Byte) this.state.convertValueFromString("0")).byteValue());
        assertEquals(-128, ((Byte) this.state.convertValueFromString(String.valueOf(Byte.MIN_VALUE))).byteValue());
        
        try
        {
            Byte result = (Byte) this.state.convertValueFromString("");
            assertTrue("should have thrown a ConversionException, instead got '" + result + "'", false);
        }
        catch (ConversionException e)
        {
            // Desired outcome.
        }

        try
        {
            Byte result = (Byte) this.state.convertValueFromString("eurt");
            assertTrue("should have thrown a ConversionException, instead got '" + result + "'", false);
        }
        catch (ConversionException e)
        {
            // Desired outcome.
        }

        try
        {
            Byte result = (Byte) this.state.convertValueFromString("128");
            assertTrue("should have thrown a ConversionException, instead got '" + result + "'", false);
        }
        catch (ConversionException e)
        {
            // Desired outcome.
        }

        try
        {
            Byte result = (Byte) this.state.convertValueFromString("-129");
            assertTrue("should have thrown a ConversionException, instead got '" + result + "'", false);
        }
        catch (ConversionException e)
        {
            // Desired outcome.
        }
    }
}
