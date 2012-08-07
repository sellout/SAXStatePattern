package com.valentsolutions.xml.statepattern;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

/**
 * Extend this to create the ContentHandler for your Parser.
 * 
 * All of the ContentHandler calls (witht the exception of setDocumentLocator)
 * are passed through to the current HandlerState.
 * 
 * @inv state != null
 */
public abstract class StateBasedContentHandler
	implements ContentHandler
{
	private HandlerState state;

    /**
     * Create a content handler with events being passed to the initialState
     * 
     * @param initialState is the HandlerState that events should initially be
     *                     passed to.
     * 
     * @pre initialState != null
     * @post this.state == initialState
     */
	public StateBasedContentHandler(HandlerState initialState)
	{
		this.state = initialState;
	}

    /**
     * @see org.xml.sax.ContentHandler#characters(char[], int, int)
     */
	public final void characters(char[] ch, int start, int length)
		throws SAXException
	{
		this.state.characters(ch, start, length);
	}

    /**
     * @see org.xml.sax.ContentHandler#endDocument()
     */
	public final void endDocument()
		throws SAXException
	{
		this.state.endDocument();
	}

    /**
     * @see org.xml.sax.ContentHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
     */
	public final void endElement(String namespaceURI, String localName, String qName)
		throws SAXException
	{
		this.state.endElement(namespaceURI, localName, qName);
	}

    /**
     * @see org.xml.sax.ContentHandler#endPrefixMapping(java.lang.String)
     */
	public final void endPrefixMapping(String prefix)
		throws SAXException
	{
		this.state.endPrefixMapping(prefix);
	}

    /**
     * @see org.xml.sax.ContentHandler#ignorableWhitespace(char[], int, int)
     */
	public final void ignorableWhitespace(char[] ch, int start, int length)
		throws SAXException
	{
		this.state.ignorableWhitespace(ch, start, length);
	}

    /**
     * @see org.xml.sax.ContentHandler#processingInstruction(java.lang.String, java.lang.String)
     */
	public final void processingInstruction(String target, String data)
		throws SAXException
	{
		this.state.processingInstruction(target, data);
	}

    /**
     * @see org.xml.sax.ContentHandler#skippedEntity(java.lang.String)
     */
	public final void skippedEntity(String name)
		throws SAXException
	{
		this.state.skippedEntity(name);
	}

    /**
     * @see org.xml.sax.ContentHandler#startDocument()
     */
	public final void startDocument()
		throws SAXException
	{
		this.state.startDocument();
	}

    /**
     * @see org.xml.sax.ContentHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
     */
	public final void startElement(String namespaceURI, String localName, String qName, Attributes atts)
		throws SAXException
	{
		this.state.startElement(namespaceURI, localName, qName, atts);
	}

    /**
     * @see org.xml.sax.ContentHandler#startPrefixMapping(java.lang.String, java.lang.String)
     */
	public final void startPrefixMapping(String prefix, String uri)
		throws SAXException
	{
		this.state.startPrefixMapping(prefix, uri);
	}
	
    /**
     * Change the current HandlerState
     * 
     * @param state is the new HandlerState to pass events to.
     * 
     * @pre state != null
     * @post this.state == state
     */
    protected final void setState(HandlerState state)
    {
        this.state = state;
    }
}