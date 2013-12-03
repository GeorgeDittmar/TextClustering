package com.data.Document;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: george
 * Date: 11/30/13
 * Time: 2:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class TextDocument implements IDocument {

    private Map<String,Double> termWeights = new TreeMap<String, Double>();
    private String rawDoc = "";
    private List<List<String>> processedDoc;
    private Vector<Double> vectorDoc;

    @Override
    public void setDocument(List<List<String>> document) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getRawDocument() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void getProcessedDoc() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Vector<Double> getVectorRepresentation() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setVectorizedDocument(Vector<Double> document) {
        //To change body of implemented methods use File | Settings | File Templates.
    }


}
