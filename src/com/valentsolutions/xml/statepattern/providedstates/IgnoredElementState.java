package com.valentsolutions.xml.statepattern.providedstates;

import org.xml.sax.Attributes;

import com.valentsolutions.xml.statepattern.HandlerState;
import com.valentsolutions.xml.statepattern.StateBasedContentHandler;

/**
 * This is a dummy state to be used when you find an element that you want to
 * ignore. It just gobbles up all of the events until the end of the element.
 */
public final class IgnoredElementState
	extends ProvidedState
{
    /**
     * @param handler
     * @param parentState
     */
    public IgnoredElementState(
        StateBasedContentHandler handler,
        StateBasedErrorHandler errors,
        HandlerState parentState)
    {
        super(handler, errors, parentState);
    }

    /**
     * @see com.valentsolutions.xml.statepattern.HandlerState#characters(char[], int, int)
     */
    public void characters(char[] ch, int start, int length)
    {
    }

    /**
     * @see com.valentsolutions.xml.statepattern.HandlerState#endDocument()
     */
    public void endDocument()
    {
    }

    /**
     * @see com.valentsolutions.xml.statepattern.HandlerState#endElementImplementation(java.lang.String, java.lang.String, java.lang.String)
     */
    protected void endElementImplementation(
        String namespaceURI,
        String localName,
        String qName)
    {
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
     * @see com.valentsolutions.xml.statepattern.HandlerState#startElementImplementation(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
     * 
     * Currently this tacks more IgnoredElementState objects onto the linked
     * list. It'd probably be more efficient to just keep a count of the current
     * depth, but that's premature optimization and more error-prone.
     */
    public HandlerState startElementImplementation(
        String namespaceURI,
        String localName,
        String qName,
        Attributes atts)
    {
        return new IgnoredElementState(this.handler, this.errors, this);
    }

    /**
     * @see com.valentsolutions.xml.statepattern.HandlerState#startPrefixMapping(java.lang.String, java.lang.String)
     */
    public void startPrefixMapping(String prefix, String uri)
    {
    }
}
