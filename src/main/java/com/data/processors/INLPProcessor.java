package com.data.processors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * The INLPProcessor is an interface to allow for the easy usage of different nlp frameworks such as OpenNLP and StanfordNLP.
 * User: george
 * Date: 11/23/13
 * Time: 10:35 PM
 * To change this template use File | Settings | File Templates.
 */
public interface INLPProcessor {
    public void init() throws IOException;
    public List<String[]> processDocument(File document) throws IOException;
    public List<String[]> processDocument(String document);
}
