package com.valentsolutions.xml.statepattern;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * Extend this for each specific element you want to handle. You may one to add
 * another abstract layer in between to provide default implementations for most
 * of the methods.
 * 
 * @inv handler != null
 */
public abstract class HandlerState
// implements ContentHandler
// 
// NOTE: should not _actually_ implement ContentHandler, because that implies we
//       can be used in all the same situations as a ContentHandler, which is
//       not true. However, the interfaces must still match (with the exception
//       of setDocumentLocator).
{
	protected StateBasedContentHandler handler;
	protected HandlerState parentState;

    /**
     * 
     * @param handler
     * @param parentState
     * 
     * @pre handler != null
     */
	public HandlerState(StateBasedContentHandler handler, HandlerState parentState)
	{
		this.handler = handler;
		this.parentState = parentState;
	}

	public abstract void characters(char[] ch, int start, int length)
		throws SAXException;

	public abstract void endDocument()
		throws SAXException;

	public final void endElement(String namespaceURI, String localName, String qName)
		throws SAXException
	{
		this.endElementImplementation(namespaceURI, localName, qName);

        if (this.parentState == null)
        {
            throw new SAXException("State must not be null");
        }

		this.handler.setState(this.parentState);
	}

	protected abstract void endElementImplementation(String namespaceURI, String localName, String qName)
		throws SAXException;

	public abstract void endPrefixMapping(String prefix)
		throws SAXException;

	public abstract void ignorableWhitespace(char[] ch, int start, int length)
		throws SAXException;

	public abstract void processingInstruction(String target, String data)
		throws SAXException;

	public abstract void skippedEntity(String name)
		throws SAXException;

	public abstract void startDocument()
		throws SAXException;

	public final void startElement(String namespaceURI, String localName, String qName, Attributes atts)
		throws SAXException
	{
		HandlerState newState = this.startElementImplementation(namespaceURI, localName, qName, atts);

// NOTE: should be unnecessary because of the postcondition of startElementImplementation
//        if (newState == null)
//        {
//            throw new SAXException("State must not be null");
//        }
        
		this.handler.setState(newState);
	}

    /**
     * 
     * @param namespaceURI
     * @param localName
     * @param qName
     * @param atts
     * @return the state that should be used to handle events from this point.
     * @throws SAXException
     * 
     * @post return != null
     */
	public abstract HandlerState startElementImplementation(String namespaceURI, String localName, String qName, Attributes atts)
		throws SAXException;

	public abstract void startPrefixMapping(String prefix, String uri)
		throws SAXException;
}

