package com.valentsolutions.xml.statepattern.providedstates;

import java.lang.reflect.Method;

import com.valentsolutions.xml.statepattern.HandlerState;
import com.valentsolutions.xml.statepattern.StateBasedContentHandler;

/**
 * To be used for elements that have a "long" or "integer" content model.
 */
public class GenericLongValueState extends GenericValueState
{
    /**
     * @param handler
     * @param parentState
     * 
     * @pre handler != null
     * @pre method != null
     * @pre parentState instanceof method.getDeclaringClass()
     * @pre method.getParameterTypes().length == 1
     * @pre method.getParameterTypes()[0].getName() == "java.lang.Long"
     */
    public GenericLongValueState(
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
        try
        {
            return Long.valueOf(value);
        }
        catch (NumberFormatException e)
        {
            throw new ConversionException(value, e);
        }
	}
}