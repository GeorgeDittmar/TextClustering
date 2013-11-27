package com.textclustering.processors;

import edu.stanford.nlp.ling.Document;
import opennlp.tools.sentdetect.SentenceDetector;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Document processor that uses the OpenNLP framework to tokenize a document.
 * Created with IntelliJ IDEA.
 * User: george
 * Date: 11/17/13
 * Time: 7:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class OpenNLPProcessor implements INLPProcessor {

    private SentenceDetectorME sentenceDetectorME;
    private Tokenizer tokenizer;

    public void init() throws IOException {
        // load up each model to be used in the OpenNLP pipeline. This will be hardcoded for now but should be set using
        //some sort of config

        // init sentence detector model for OpenNLP
        InputStream sentModelIn = new FileInputStream("/src/resources/OpenNLP-models/en-sent.bin");
        SentenceModel sentenceModel = new SentenceModel(sentModelIn);
        sentenceDetectorME = new SentenceDetectorME(sentenceModel);
        sentModelIn.close();

        // init tokenizer model
        InputStream tokenModelIn = new FileInputStream("/src/resources/OpenNLP-models/en-token.bin");
        TokenizerModel tokenizerModel = new TokenizerModel(tokenModelIn);
        tokenizer = new TokenizerME(tokenizerModel);
    }

    /**
     * Process document is called when we must preprocess an input document to the framework. Depending on the task at hand,
     * different preprocessing steps may occur. For most document related tasks however, tokenization, stopword removal, and stemming will most
     * likely be done.
     *
     * @param document
     * @throws IOException
     */
    @Override
    public List<String[]> processDocument(File document) throws IOException {
        List<String[]> tokenizedDocument = new LinkedList<String[]>();

        //read in the document as a utf-8 string and then process the string through OpenNLP by using the sentence detector and
        // the tokenizer to build a list of string arrays.
        String documentString = FileUtils.readFileToString(document, "utf-8");

        String[] sentences = sentenceDetectorME.sentDetect(documentString);
        for(String sentence: sentences){
            // tokenize this sentence and add to our accumulation list.
            tokenizedDocument.add(tokenizer.tokenize(sentence));
        }
        return tokenizedDocument;
    }
}
