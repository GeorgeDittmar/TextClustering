package com.data;

import com.data.Document.TextDocument;
import com.data.processors.IFeatureProcessor;

import java.util.*;

/**
 * Class to hold a large number of documents along with their associated classification mappings.
 * User: george
 * Date: 12/2/13
 * Time: 7:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class Corpus {

    // keep a mapping of all terms found in the corpus along with the number of times that term has appeared in other documents.
    private Map<String, Integer> allWordsInCorpus = new TreeMap<String, Integer>();
    private Map<String, List<TextDocument>> corpus = new HashMap<String, List<TextDocument>>();
    private List<String> termList = new LinkedList<String>();
    private IFeatureProcessor featureProcessor;
    private int size;

    /**
     * return the training corpus
     *
     * @return
     */
    public Map<String, List<TextDocument>> getCorpus() {
        return corpus;
    }

    /**
     * Add a document to the corpus and increment the term counts in the corpus to reflect if a term appears in the document.
     *
     * @param classLable
     * @param document
     */
    public void addDocument(String classLable, TextDocument document) {

        if (!corpus.containsKey(classLable)) {
            corpus.put(classLable, new LinkedList<TextDocument>());
        }

        corpus.get(classLable).add(document);
        size++;
        // add the words in this document to the allWordsInCorpus map and increment the document counts

        for (String term : document.getTerms()) {

            if (!allWordsInCorpus.containsKey(term)) {
                termList.add(term);
                allWordsInCorpus.put(term, 0);
            }

            allWordsInCorpus.put(term, allWordsInCorpus.get(term) + 1);
        }

    }

    /**
     * Adds a list of documents for a given class to the corpus.
     * @param classLabel
     * @param documents
     */
    public void addDocuments(String classLabel, List<TextDocument> documents) {
        if (corpus.containsKey(classLabel)) {
            corpus.get(classLabel).addAll(documents);

        } else if (!corpus.containsKey(classLabel)) {
            corpus.put(classLabel, documents);
        }
        addTermDocumentCounts(documents);
        size += documents.size();
    }

    /**
     * Count if a term has been found in a given document or not.
     *
     * @param documents
     */
    private void addTermDocumentCounts(List<TextDocument> documents) {
        for (TextDocument document : documents) {
            for (String term : document.getTerms()) {
                if (allWordsInCorpus.containsKey(term)) {
                    allWordsInCorpus.put(term, allWordsInCorpus.get(term) + 1);
                } else {
                    allWordsInCorpus.put(term, 0);
                }
            }
        }
    }

    public boolean containsTerm(String term) {

        return allWordsInCorpus.containsKey(term);
    }

    /**
     * returns the number of documents a given term resides in.
     *
     * @param term
     * @return
     */
    public int getTermCount(String term) {
        return allWordsInCorpus.get(term);
    }

    public int getNumberOfTerms() {
        return allWordsInCorpus.keySet().size();
    }

    public void setFeatureProcessor(IFeatureProcessor processor) {
        this.featureProcessor = processor;
    }

    /**
     * Get all terms that have been found inside this corpus.
     *
     * @return
     */
    public List<String> getAllTerms() {
        return termList;
    }

    public int size() {
        return size;
    }

    /**
     * This method is called everytime new feature weights on the corpus need to be calculated, such as when new training examples or classes are added.
     * This will call the IFeatureProcessor used by the corpus and update each documents vector representation to show the new weights.
     */
    public void calculateFeatureWeights(){
        for(String label: corpus.keySet()){
            featureProcessor.process(corpus.get(label),this);
        }
    }
}
