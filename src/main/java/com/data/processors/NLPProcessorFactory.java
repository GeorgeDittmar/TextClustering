package com.data.processors;

/**
 * Factory class to create a new NLPProcessor
 * User: george
 * Date: 12/8/13
 * Time: 12:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class NLPProcessorFactory {

    public static INLPProcessor  initNLPProcessor(Class nlpFramework){
        // since this code is built against java 1.6 cant use a string in a switch case so have to use if else...

        if(nlpFramework.getCanonicalName().equalsIgnoreCase("com.data.processors.OpenNLPProcessor")){
            return new OpenNLPProcessor();
        }
        return null;
    }
}
