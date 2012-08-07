package com.valentsolutions.xml.statepattern.providedstates;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.DateFormat;

import com.valentsolutions.xml.statepattern.HandlerState;
import com.valentsolutions.xml.statepattern.StateBasedContentHandler;

/**
 * Extend this to write a generic handler that uses a DateFormat. Just set
 * formatter to whatever you want your SimpleDateFormat.
 * 
 * @inv formatter != null
 */
abstract public class GenericDateBasedValueState extends GenericValueState
{
	protected static DateFormat formatter;

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
    public GenericDateBasedValueState(
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
     * @post return instanceof java.util.Date
     */
    protected Object convertValueFromString(String value)
        throws ConversionException
    {
        try
        {
            return formatter.parse(value);
        }
        catch (ParseException e)
        {
            throw new ConversionException(value, e);
        }
    }
}