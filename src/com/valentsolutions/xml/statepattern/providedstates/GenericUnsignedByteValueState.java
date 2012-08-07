package com.valentsolutions.xml.statepattern.providedstates;

import java.lang.reflect.Method;

import com.valentsolutions.xml.statepattern.HandlerState;
import com.valentsolutions.xml.statepattern.StateBasedContentHandler;

/**
 * 
 */
public class GenericUnsignedByteValueState extends GenericShortValueState
{

    /**
     * @param handler
     * @param errors
     * @param parentState
     * @param method
     */
    public GenericUnsignedByteValueState(
        StateBasedContentHandler handler,
        StateBasedErrorHandler errors,
        HandlerState parentState,
        Method method)
    {
        super(handler, errors, parentState, method);
    }
    
    /**
     * 
     * @see GenericShortValueState#convertValueFromString(java.lang.String)
     * 
     * @pre value != null
     */
    protected Object convertValueFromString(String value)
        throws ConversionException
    {
        Short result = (Short) super.convertValueFromString(value);
        
        if (result.shortValue() < 0 || result.shortValue() > 255)
        {
            throw new ConversionException(value + " is outside of the accepted range for unsignedByte");
        }
        
        return result;
    }
}
