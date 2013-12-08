package com.textclustering.knn;

import com.data.Document.TextDocument;
import com.textclustering.IClusterAlg;

import java.util.List;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: george
 * Date: 11/30/13
 * Time: 2:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class Knn implements IClusterAlg {

    private int m_numberOfDocs = 0;


    @Override
    public int classify(TextDocument document) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getNumberOfDocs() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void loadDocumentVectors(List<Vector<Double>> documentSpace) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void loadDocuments(List<TextDocument> documents) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
