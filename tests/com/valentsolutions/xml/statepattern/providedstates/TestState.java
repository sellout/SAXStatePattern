package com.valentsolutions.xml.statepattern.providedstates;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.valentsolutions.xml.statepattern.HandlerState;
import com.valentsolutions.xml.statepattern.StateBasedContentHandler;

/**
 * @
 */
class TestState extends ProvidedState
{

    /**
     * @param handler
     * 
     * @pre handler != null
     */
    public TestState(StateBasedContentHandler handler)
    {
        super(handler, null, null);
    }

    /**
     * @see com.valentsolutions.xml.statepattern.HandlerState#characters(char[], int, int)
     */
    public void characters(char[] ch, int start, int length)
        throws SAXException
    {
    }

    /**
     * @see com.valentsolutions.xml.statepattern.HandlerState#endDocument()
     */
    public void endDocument() throws SAXException
    {
    }

    /**
     * @see com.valentsolutions.xml.statepattern.HandlerState#endElementImplementation(java.lang.String, java.lang.String, java.lang.String)
     */
    protected void endElementImplementation(
        String namespaceURI,
        String localName,
        String qName)
        throws SAXException
    {
    }

    /**
     * @see com.valentsolutions.xml.statepattern.HandlerState#endPrefixMapping(java.lang.String)
     */
    public void endPrefixMapping(String prefix) throws SAXException
    {
    }

    /**
     * @see com.valentsolutions.xml.statepattern.HandlerState#ignorableWhitespace(char[], int, int)
     */
    public void ignorableWhitespace(char[] ch, int start, int length)
        throws SAXException
    {
        // TODO Auto-generated method stub

    }

    /**
     * @see com.valentsolutions.xml.statepattern.HandlerState#processingInstruction(java.lang.String, java.lang.String)
     */
    public void processingInstruction(String target, String data)
        throws SAXException
    {
        // TODO Auto-generated method stub

    }

    /**
     * @see com.valentsolutions.xml.statepattern.HandlerState#skippedEntity(java.lang.String)
     */
    public void skippedEntity(String name) throws SAXException
    {
    }

    /**
     * @see com.valentsolutions.xml.statepattern.HandlerState#startDocument()
     */
    public void startDocument() throws SAXException
    {
    }

    /**
     * @see com.valentsolutions.xml.statepattern.HandlerState#startElementImplementation(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
     */
    public HandlerState startElementImplementation(
        String namespaceURI,
        String localName,
        String qName,
        Attributes atts)
        throws SAXException
    {
        return new TestState(this.handler);
    }

    /**
     * @see com.valentsolutions.xml.statepattern.HandlerState#startPrefixMapping(java.lang.String, java.lang.String)
     */
    public void startPrefixMapping(String prefix, String uri)
        throws SAXException
    {
    }

    public void booleanMethod(Boolean value)
    {
    }
    
    public void byteMethod(Byte value)
    {
    }
    
    public void shortMethod(Short value)
    {
    }
    
    public void intMethod(Integer value)
    {
    }
    
    public void longMethod(Long value)
    {
    }
    
    public void floatMethod(Float value)
    {
    }
    
    public void doubleMethod(Double value)
    {
    }
}
