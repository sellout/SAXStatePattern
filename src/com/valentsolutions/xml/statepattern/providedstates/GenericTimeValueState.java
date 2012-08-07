package com.valentsolutions.xml.statepattern.providedstates;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

import com.valentsolutions.xml.statepattern.HandlerState;
import com.valentsolutions.xml.statepattern.StateBasedContentHandler;

/**
 * To be used for elements that have a "time" content model.
 */
public class GenericTimeValueState extends GenericDateBasedValueState
{
	static
    {
        formatter = new SimpleDateFormat("HH:mm:ss.SSSZ");
    }

    /**
     * @param handler
     * @param parentState
     * 
     * @pre handler != null
     * @pre method != null
     * @pre parentState instanceof method.getDeclaringClass()
     * @pre method.getParameterTypes().length == 1
     * @pre method.getParameterTypes()[0].getName() == "java.util.Date"
     */
    public GenericTimeValueState(
		StateBasedContentHandler handler,
        StateBasedErrorHandler errors,
		HandlerState parentState,
		Method method)
	{
		super(handler, errors, parentState, method);
	}
}