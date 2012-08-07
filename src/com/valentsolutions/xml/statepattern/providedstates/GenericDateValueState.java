package com.valentsolutions.xml.statepattern.providedstates;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

import com.valentsolutions.xml.statepattern.HandlerState;
import com.valentsolutions.xml.statepattern.StateBasedContentHandler;

/**
 * To be used for elements that have a "date" content model.
 */
public class GenericDateValueState extends GenericDateBasedValueState
{
	static
    {
        formatter = new SimpleDateFormat("yyyy-MM-dd");
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
    public GenericDateValueState(
		StateBasedContentHandler handler,
        StateBasedErrorHandler errors,
		HandlerState parentState,
		Method method)
	{
		super(handler, errors, parentState, method);
	}
}