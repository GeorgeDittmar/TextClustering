package com.data.processors;

import com.data.Corpus;
import com.data.Document.IDocument;
import com.data.Document.TextDocument;

import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * the TFIDF processor class's role is to calculate term frequency statistics for a given corpus of documents.
 * User: george
 * Date: 11/30/13
 * Time: 12:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class TFIDFProcessor implements IFeatureProcessor {

    /**
     * Private method to calculate the tfidf score of a term in a document. This is called by the
     * process methods and can generally be easily swapped out for other feature weights.
     * @param document
     * @param corpus
     */
    private void tfidf(TextDocument document,Corpus corpus){
        Vector<Double> documentVector = new Vector<Double>();

        // loop through each term found in the corpus and compare if this term was found in the
        for(String term: corpus.getAllTerms().keySet()){
            if(document.containsTerm(term)){
                // grab its term frequency for that document and calculate the inverse document frequency from the corpus
                double freq = document.getTermFrequency(term);
                double idf = Math.log((float)corpus.size() / (float)corpus.getTermCount(term));
                double tfidf = freq*idf;
                documentVector.add(tfidf);
            }
        }
        // set the document object's vector representation
        document.setVectorizedDocument(documentVector);
    }

    @Override
    public void process(TextDocument document, Corpus corpus) {
        // calculate the tfidf scores for each term in a document and store that vector inside the document object
        tfidf(document,corpus);
    }

    @Override
    public void process(List<TextDocument> documentSet, Corpus corpus) {
        for(TextDocument document: documentSet){
            tfidf(document,corpus);
        }
    }
}
