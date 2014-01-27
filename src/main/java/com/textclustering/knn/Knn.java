package com.textclustering.knn;

import com.data.Corpus;
import com.data.Document.TextDocument;
import com.sun.istack.internal.NotNull;
import com.textclustering.IClusterAlg;

import java.util.List;
import java.util.Vector;

/**
 * Implementations of the IClusterAlg interface to build the Knn algorithm.
 * User: george
 * Date: 11/30/13
 * Time: 2:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class Knn implements IClusterAlg {

    private Corpus corpus;

    public void Knn(@NotNull Corpus corpus){
        this.corpus = corpus;
    }

    /**
     * Classifies a given document against the entire training corpus using the class
     * labels of the k nearest neighbors of the new input document.
     * @param document
     * @return
     */
    @Override
    public int classify(TextDocument document) {
        return 0;
    }

    @Override
    public int getNumberOfDocs() {
        return corpus.size();
    }

    @Override
    public void loadDocumentVectors(List<Vector<Double>> documentSpace) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

}
