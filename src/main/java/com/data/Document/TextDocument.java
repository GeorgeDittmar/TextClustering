package com.data.Document;

import java.util.*;

/**
 * The TextDocument class is an object that represents a parsed document in the clustering framework. This object holds the original
 * text along with a map of all features extracted from the document and the vectorized representation of a document. TextDocument
 * class is meant to make it easy to update feature weights and recalculate vector representations of documents to cluster.
 *
 * User: George Dittmar
 * Date: 11/30/13
 * Time: 2:13 PM
 *
 */
public class TextDocument implements IDocument {

    // We use a treemap to keep the keys in sorted order.
    private Map<String,Double> termFrequencies = new TreeMap<String, Double>();
    private Map<String,Integer> termCounts = new TreeMap<String,Integer>();
    private String rawDoc = "";
    private List<List<String>> processedDoc;
    private Vector<Double> vectorDoc;

    @Override
    public void setProcessedDocument(List<List<String>> document) {
        processedDoc = document;
    }

    @Override
    public void setOriginalDocumentString(String document) {
        rawDoc = document;
    }

    @Override
    public String getRawDocument() {
        return rawDoc;
    }

    @Override
    public List<List<String>> getProcessedDoc() {
        return processedDoc;
    }

    @Override
    public Vector<Double> getVectorRepresentation() {

        return vectorDoc;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setVectorizedDocument(Vector<Double> document) {
       vectorDoc = document;
    }

    public Set<String> getTerms(){
        return termFrequencies.keySet();
    }

    public Map<String,Double> getTermFrequencies(){
        return termFrequencies;
    }

    public Map<String,Integer> getTermCounts(){
        return termCounts;
    }

    public boolean containsTerm(String term){
        return termCounts.containsKey(term);
    }

    public double getTermCount(String term){
        return termCounts.get(term);
    }

    public double getTermFrequency(String term){
        return termFrequencies.get(term);
    }

}
