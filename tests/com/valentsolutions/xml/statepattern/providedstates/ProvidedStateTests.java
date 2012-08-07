package com.valentsolutions.xml.statepattern.providedstates;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @
 */
public class ProvidedStateTests
{

    public static Test suite()
    {
        TestSuite suite =
            new TestSuite("Test for com.valentsolutions.xml.statepattern.providedstates");
        //$JUnit-BEGIN$
        suite.addTest(new TestSuite(GenericBooleanValueStateTest.class));
        suite.addTest(new TestSuite(GenericByteValueStateTest.class));
        suite.addTest(new TestSuite(GenericShortValueStateTest.class));
        suite.addTest(new TestSuite(GenericIntValueStateTest.class));
        suite.addTest(new TestSuite(GenericLongValueStateTest.class));
        //$JUnit-END$
        return suite;
    }
}
