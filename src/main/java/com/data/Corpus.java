package com.data;

import com.data.Document.TextDocument;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Class to hold a large number of documents along with their associated classification mappings.
 * User: george
 * Date: 12/2/13
 * Time: 7:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class Corpus {

    // keep a mapping of all terms found in the corpus along with the number of times that term has appeared in other documents.
    private Map<String, Integer> allWordsInCorpus = new HashMap<String, Integer>();
    private Map<String, List<TextDocument>> corpus = new HashMap<String, List<TextDocument>>();

    /**
     * return the training corpus
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

        // add the words in this document to the allWordsInCorpus map and increment the document counts
        for (String term : document.getTerms()) {

            if (!allWordsInCorpus.containsKey(term)) {
                allWordsInCorpus.put(term, 0);
            }

            allWordsInCorpus.put(term, allWordsInCorpus.get(term) + 1);
        }

    }

    public void addDocuments(String classLabel, List<TextDocument> documents) {
        if(corpus.containsKey(classLabel)){
            corpus.get(classLabel).addAll(documents);
        }else if(!corpus.containsKey(classLabel)){
            corpus.put(classLabel,documents);
        }
    }

    public boolean containsTerm(String term) {

        return allWordsInCorpus.containsKey(term);
    }

    public int getTermCorpusTermValue(String term) {
        return allWordsInCorpus.get(term);
    }
}
