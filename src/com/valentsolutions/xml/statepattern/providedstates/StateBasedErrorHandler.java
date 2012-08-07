package com.valentsolutions.xml.statepattern.providedstates;

import org.xml.sax.SAXException;


/**
 * 
 */
public interface StateBasedErrorHandler
{
    /**
     * 
     * @param error
     * @param context
     * @param details
     * @throws SAXException
     * 
     * @pre error != null
     */
    void warning(StateError error, String context, String details)
        throws SAXException;

    /**
     * 
     * @param error
     * @param context
     * @param details
     * @throws SAXException
     * 
     * @pre error != null
     */
    void error(StateError error, String context, String details)
        throws SAXException;
}
