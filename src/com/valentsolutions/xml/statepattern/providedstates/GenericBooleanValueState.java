package com.valentsolutions.xml.statepattern.providedstates;

import java.lang.reflect.Method;

import com.valentsolutions.xml.statepattern.HandlerState;
import com.valentsolutions.xml.statepattern.StateBasedContentHandler;

/**
 * 
 */
public class GenericBooleanValueState extends GenericValueState
{
    /**
     * @param handler
     * @param parentState
     * 
     * @pre handler != null
     * @pre method != null
     * @pre parentState instanceof method.getDeclaringClass()
     * @pre method.getParameterTypes().length == 1
     * @pre method.getParameterTypes()[0].getName() == "java.lang.Boolean"
     */
    public GenericBooleanValueState(
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
     * @post return instanceof Boolean
     */
    protected Object convertValueFromString(String value)
        throws ConversionException
    {
        Boolean result = Boolean.valueOf(value);
        if (result.booleanValue() == false
            && !value.equalsIgnoreCase("false"))
        {
            throw new ConversionException("'" + value + "' is not a valid boolean value");
        }
        
        return result;
    }
}