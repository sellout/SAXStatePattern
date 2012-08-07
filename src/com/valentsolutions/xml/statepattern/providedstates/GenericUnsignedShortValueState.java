package com.valentsolutions.xml.statepattern.providedstates;

import java.lang.reflect.Method;

import com.valentsolutions.xml.statepattern.HandlerState;
import com.valentsolutions.xml.statepattern.StateBasedContentHandler;

/**
 * 
 */
public class GenericUnsignedShortValueState extends GenericIntValueState
{

    /**
     * @param handler
     * @param errors
     * @param parentState
     * @param method
     */
    public GenericUnsignedShortValueState(
        StateBasedContentHandler handler,
        StateBasedErrorHandler errors,
        HandlerState parentState,
        Method method)
    {
        super(handler, errors, parentState, method);
    }
    
    /**
     * 
     * @see GenericIntValueState#convertValueFromString(java.lang.String)
     * 
     * @pre value != null
     */
    protected Object convertValueFromString(String value)
        throws ConversionException
    {
        Integer result = (Integer) super.convertValueFromString(value);

        if (result.intValue() < 0 || result.intValue() > 65535)
        {
            throw new ConversionException(value + " is outside of the accepted range for unsignedShort");
        }
        
        return result;
    }
}
