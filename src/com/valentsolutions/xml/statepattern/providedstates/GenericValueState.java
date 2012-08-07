package com.valentsolutions.xml.statepattern.providedstates;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.valentsolutions.xml.statepattern.HandlerState;
import com.valentsolutions.xml.statepattern.StateBasedContentHandler;

/**
 * A provided state to be used as a shortcut for elements that have simple
 * content models.
 * 
 * @inv parentState != null
 * @inv method != null
 * @inv value != null
 */
public abstract class GenericValueState extends ProvidedState
{
    private Method method;
    private String value = "";

    /**
     * @param handler
     * @param parentState
     * 
     * @pre handler != null
     * @pre parentState != null
     * @pre method != null
     * @pre parentState instanceof method.getDeclaringClass()
     * @pre method.getParameterTypes().length == 1
     */
    public GenericValueState(
        StateBasedContentHandler handler,
        StateBasedErrorHandler errors,
        HandlerState parentState,
        Method method)
    {
        super(handler, errors, parentState);
        this.method = method;
    }

    /**
     * @see com.valentsolutions.xml.statepattern.HandlerState#characters(char[], int, int)
     */
    public void characters(char[] ch, int start, int length)
    {
        value += new String(ch, start, length);
    }

    /**
     * @see com.valentsolutions.xml.statepattern.HandlerState#endElement(java.lang.String, java.lang.String, java.lang.String)
     */
    public void endElementImplementation(String namespaceURI, String localName, String qName)
        throws SAXException
    {
        try
        {
            this.method.invoke(this.parentState, new Object[] {this.convertValueFromString(value)});
        }
        catch (ConversionException e)
        {
            this.error(StateError.ILLEGAL_VALUE, localName, e.getMessage());
        }
        catch (IllegalAccessException e)
        {
        	this.error(StateError.METHOD, "", "could not access method '" + this.method.getName() + "': " + e.getMessage());
        }
        catch (InvocationTargetException e)
        {
			this.error(StateError.METHOD, "", "error calling method '" + this.method.getName() + "':" + e.getMessage());
        }
    }
    
    /**
     * Converts a string to the type required by the method argument.
     * 
     * @param value is the string to convert.
     * @return the new value.
     * @throws ConversionException if the string can not be converted
     *                             successfully.
     * 
     * @pre value != null
     */
    protected abstract Object convertValueFromString(String value)
        throws ConversionException;

	/**
	 * @see com.valentsolutions.xml.statepattern.HandlerState#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	public HandlerState startElementImplementation(
		String namespaceURI,
		String localName,
		String qName,
		Attributes atts)
        throws SAXException
	{
		this.error(StateError.ILLEGAL_ELEMENT, "", qName);
		return new IgnoredElementState(this.handler, this.errors, this);
	}

    /**
     * @see com.valentsolutions.xml.statepattern.HandlerState#endDocument()
     */
    public void endDocument()
        throws SAXException
    {
		this.error(StateError.END_OF_DOCUMENT, "", "");
    }

    /**
     * @see com.valentsolutions.xml.statepattern.HandlerState#endPrefixMapping(java.lang.String)
     */
    public void endPrefixMapping(String prefix)
    {
    }

    /**
     * @see com.valentsolutions.xml.statepattern.HandlerState#ignorableWhitespace(char[], int, int)
     */
    public void ignorableWhitespace(char[] ch, int start, int length)
    {
    }

    /**
     * @see com.valentsolutions.xml.statepattern.HandlerState#processingInstruction(java.lang.String, java.lang.String)
     */
    public void processingInstruction(String target, String data)
    {
    }

    /**
     * @see com.valentsolutions.xml.statepattern.HandlerState#skippedEntity(java.lang.String)
     */
    public void skippedEntity(String name)
    {
    }

    /**
     * @see com.valentsolutions.xml.statepattern.HandlerState#startDocument()
     */
    public void startDocument()
    {
    }

    /**
     * @see com.valentsolutions.xml.statepattern.HandlerState#startPrefixMapping(java.lang.String, java.lang.String)
     */
    public void startPrefixMapping(String prefix, String uri)
    {
    }
}