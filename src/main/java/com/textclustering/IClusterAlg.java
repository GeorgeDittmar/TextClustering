package com.textclustering;

import com.data.Document.TextDocument;

import java.util.List;
import java.util.Vector;

/**
 * An interface to define the basic calls that are used between different clustering algorithms.
 * User: george
 * Date: 11/30/13
 * Time: 2:22 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IClusterAlg {

    public int classify(TextDocument document);
    public int getNumberOfDocs();
    public void loadDocumentVectors(List<Vector<Double>> documentSpace);

}
