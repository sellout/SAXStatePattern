package com.valentsolutions.xml.statepattern.providedstates;

import java.lang.reflect.Method;

import com.valentsolutions.xml.statepattern.HandlerState;
import com.valentsolutions.xml.statepattern.StateBasedContentHandler;

/**
 * 
 */
public class GenericUnsignedIntValueState extends GenericLongValueState
{

    /**
     * @param handler
     * @param errors
     * @param parentState
     * @param method
     */
    public GenericUnsignedIntValueState(
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
        Long result = (Long) super.convertValueFromString(value);
        
        if (result.longValue() < 0 || result.longValue() > 4294967295L)
        {
            throw new ConversionException(value + " is outside of the accepted range for unsignedInt");
        }
        
        return result;
    }
}
