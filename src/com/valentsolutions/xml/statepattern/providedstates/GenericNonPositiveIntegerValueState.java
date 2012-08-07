package com.valentsolutions.xml.statepattern.providedstates;

import java.lang.reflect.Method;

import com.valentsolutions.xml.statepattern.HandlerState;
import com.valentsolutions.xml.statepattern.StateBasedContentHandler;

/**
 * 
 */
public class GenericNonPositiveIntegerValueState extends GenericLongValueState
{

    /**
     * @param handler
     * @param errors
     * @param parentState
     * @param method
     */
    public GenericNonPositiveIntegerValueState(
        StateBasedContentHandler handler,
        StateBasedErrorHandler errors,
        HandlerState parentState,
        Method method)
    {
        super(handler, errors, parentState, method);
    }

    /**
     * 
     * @see GenericValueState#convertValueFromString(java.lang.String)
     * 
     * @pre value != null
     * @post return != null
     * @post return instanceof Long
     */
    protected Object convertValueFromString(String value)
        throws ConversionException
    {
        Long result = (Long) super.convertValueFromString(value);
        
        if (result.longValue() > 0)
        {
            throw new ConversionException(value + " is outside of the accepted range for nonPositiveInteger");
        }
        
        return result;
    }
}
