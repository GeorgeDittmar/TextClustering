package com.data.Document;

import java.util.List;
import java.util.Vector;

/**
 * This is a document class interface to represent the general operations that can be performed on a document.
 * User: george
 * Date: 11/29/13
 * Time: 9:25 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IDocument {


    public void setDocument(List<List<String>> document);
    public String getRawDocument();
    public void getProcessedDoc();
    public Vector<Double> getVectorRepresentation();
    public void setVectorizedDocument(Vector<Double> document);
}
