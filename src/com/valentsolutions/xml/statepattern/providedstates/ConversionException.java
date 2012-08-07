package com.valentsolutions.xml.statepattern.providedstates;

/**
 * 
 */
public class ConversionException
    extends Exception
{
    /**
     * 
     */
    public ConversionException()
    {
        super();
    }

    /**
     * @param message
     */
    public ConversionException(String message)
    {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public ConversionException(String message, Throwable cause)
    {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public ConversionException(Throwable cause)
    {
        super(cause);
    }
}
