package com.Classification;

import com.data.Corpus;
import com.data.Document.TextDocument;

import java.util.*;

/**
 * This is a simple Naive Bayes implementation of a text classifier.
 */
public class NaiveBayesClassifier {

    private int numClasses = 0;
    private Corpus m_corpus;
    private Map<String, Double> m_priorsMap;
    private Set<String> m_classLabels;
    private Map<String,Map<String,Double>> m_probMap;

    /**
     * Sets up our Classifier object so that we have access to priors and class labels at initialization
     *
     * @param m_corpus
     */
    public void NaiveBayesClassifier(Corpus m_corpus) {
        this.m_corpus = m_corpus;
    }

    private void calculatePriors() {

        m_classLabels = new HashSet<String>();
        m_priorsMap = new HashMap<String, Double>();

        for (String label : m_corpus.getCorpus().keySet()) {
            m_classLabels.add(label);
            double prior = m_corpus.getCorpus().get(label).size() / (double) m_corpus.size();
            m_priorsMap.put(label, prior);
        }
    }

    // train the bayesian classifier on the corpus object
    public void train() {
        calculatePriors();

        // now we need to generate the term probabilities for each given class
        for (String label : m_classLabels) {
            // store a map of terms to their probabilities for a given class.
            Map<String, Double> termProbsForClass = new HashMap<String, Double>();
            double termProb = 0.0;
            for (String term : m_corpus.getAllTerms()) {
                termProb = calcProbForTerm(term, label);
            }
            m_probMap.put(label, termProbsForClass);
//            double classScore = Math.log(m_priorsMap.get(label))+termProb;
        }

    }

    private double calcProbForTerm(String term,String classLabel){
        double prob = 0.0;
        int vocabSize = m_corpus.getNumberOfTerms();
        int termCount = 0;

        int count = 0;

        for(TextDocument doc: m_corpus.getCorpus().get(classLabel)){
            // for each doc  count the number of terms and append to count
            termCount += doc.getTermCount(term);
            for(List<String> line: doc.getProcessedDoc()){

                count += line.size();
            }
        }

        prob = (double)(termCount + 1)/(count+vocabSize);
        return prob;
    }

    public String classify(List<TextDocument> documents) {

        Map<String, Double> classResults = new HashMap<String, Double>();

        for (String label : m_classLabels) {
            double logPrior = Math.log(m_priorsMap.get(label));
        }
        return null;
    }

    public Corpus getCorpus() {
        return m_corpus;
    }

    public void setCorpus(Corpus corpus) {

    }
}
