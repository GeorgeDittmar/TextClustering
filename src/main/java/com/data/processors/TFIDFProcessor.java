package com.data.processors;

import com.data.Corpus;
import com.data.Document.IDocument;
import com.data.Document.TextDocument;

import java.util.List;
import java.util.Map;

/**
 * the TFIDF processor class's role is to calculate term frequency statistics for a given corpus of documents.
 * User: george
 * Date: 11/30/13
 * Time: 12:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class TFIDFProcessor implements IFeatureProcessor {

    public void tfidf(TextDocument document,Corpus corpus){

        // loop through each term found in the corpus and compare if this term was found in the

        for(String term: corpus.getAllTerms().keySet()){
            if(document.containsTerm(term)){
                // grab its term frequency for that document and calculate the inverse document frequency from the corpus
                double freq = document.getTermFrequency(term);
                double idf = (float)corpus.size() / (float)corpus.getTermCorpusTermValue(term);
            }
        }

    }

    private Map<String,Integer> calculateTfValue(TextDocument document){
        return null;
    }

    @Override
    public Map<String, Double> process(TextDocument document, Corpus corpus) {
        return null;
    }

    @Override
    public Map<String, Double> process(List<TextDocument> documentSet, Corpus corpus) {
        return null;
    }
}
