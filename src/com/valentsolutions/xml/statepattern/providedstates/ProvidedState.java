package com.valentsolutions.xml.statepattern.providedstates;

import org.xml.sax.SAXException;

import com.valentsolutions.xml.statepattern.HandlerState;
import com.valentsolutions.xml.statepattern.StateBasedContentHandler;

/**
 * 
 */
abstract class ProvidedState extends HandlerState
{
    protected StateBasedErrorHandler errors;

    /**
     * 
     * @param handler
     * @param errors
     * @param parentState
     * 
     * @pre handler != null
     */
    public ProvidedState(
        StateBasedContentHandler handler,
        StateBasedErrorHandler errors,
        HandlerState parentState)
    {
        super(handler, parentState);
        this.errors = errors;
    }

    /**
     * Provides a safe wrapper in case the error handler is not set.
     * 
     * @param error
     * @param context
     * @param details
     * @throws SAXException
     * 
     * @pre error != null
     */
    protected void warning(StateError error, String context, String details)
        throws SAXException
    {
        if (this.errors != null)
        {
            this.errors.warning(error, context, details);
        }
    }

    /**
     * Provides a safe wrapper in case the error handler is not set.
     * 
     * @param error
     * @param context
     * @param details
     * @throws SAXException
     * 
     * @pre error != null
     */
    protected void error(StateError error, String context, String details)
        throws SAXException
    {
        if (this.errors != null)
        {
            this.errors.error(error, context, details);
        }
    }
}