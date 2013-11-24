package com.textclustering.processors;

import java.io.File;

/**
 * The INLPProcessor is an interface to allow for the easy usage of different nlp frameworks such as OpenNLP and StanfordNLP.
 * User: george
 * Date: 11/23/13
 * Time: 10:35 PM
 * To change this template use File | Settings | File Templates.
 */
public interface INLPProcessor {
    public void init();
    public void processDocument(File document);
    public void tokenize(String document);
}
