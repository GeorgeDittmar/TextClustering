package com.textclustering.processors;

import edu.stanford.nlp.ling.Document;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: george
 * Date: 11/17/13
 * Time: 7:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class OpenNLPProcessor implements INLPProcessor {

    /**
     *
     * @param documents
     */
    public static void termvector(List<Document> documents){

        // go through each document and create the master term vector

    }

    public void init(){
        // load up each model to be used in the OpenNLP pipeline
    }


}
