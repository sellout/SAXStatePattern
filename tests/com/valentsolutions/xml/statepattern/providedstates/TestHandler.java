package com.valentsolutions.xml.statepattern.providedstates;

import org.xml.sax.Locator;

import com.valentsolutions.xml.statepattern.HandlerState;
import com.valentsolutions.xml.statepattern.StateBasedContentHandler;

/**
 * @
 */
class TestHandler extends StateBasedContentHandler
{

    /**
     * @param initialState
     */
    public TestHandler(HandlerState initialState)
    {
        super(initialState);
    }

    /**
     * @see org.xml.sax.ContentHandler#setDocumentLocator(org.xml.sax.Locator)
     */
    public void setDocumentLocator(Locator locator)
    {
    }

}
