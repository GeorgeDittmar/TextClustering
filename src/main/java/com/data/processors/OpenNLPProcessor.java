package com.data.processors;

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
 * TextDocument processor that uses the OpenNLP framework to tokenize a document.
 * Created with IntelliJ IDEA.
 * User: george
 * Date: 11/17/13
 * Time: 7:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class OpenNLPProcessor implements INLPProcessor {

    private SentenceDetectorME sentenceDetectorME;
    private Tokenizer tokenizer;

    /**
     * Initialization method for the OpenNLPProcessor to load up any models it may need
     * for processing document text.
     * @throws IOException
     */
    public void init() throws IOException {
        // load up each model to be used in the OpenNLP pipeline. This will be hardcoded for now but should be set using
        //some sort of config

        // init sentence detector model for OpenNLP. these paths are hardcoded and should probably be set by a config file.
        InputStream sentModelIn = new FileInputStream("src/resources/OpenNLP-models/en-sent.bin");
        SentenceModel sentenceModel = new SentenceModel(sentModelIn);
        sentenceDetectorME = new SentenceDetectorME(sentenceModel);
        sentModelIn.close();

        // init tokenizer model. these paths are hardcoded and should probably be set by a config file.
        InputStream tokenModelIn = new FileInputStream("src/resources/OpenNLP-models/en-token.bin");
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


        //read in the document as a utf-8 string and then process the string through OpenNLP by using the sentence detector and
        // the tokenizer to build a list of string arrays.
        String documentString = FileUtils.readFileToString(document, "utf-8");

        return process(documentString);
    }


    @Override
    public List<String[]> processDocument(String documentString) {
        return process(documentString);  //To change body of implemented methods use File | Settings | File Templates.
    }


    private List<String[]> process(String documentString){
        List<String[]> tokenizedDocument = new LinkedList<String[]>();
        String[] sentences = sentenceDetectorME.sentDetect(documentString);
        for(String sentence: sentences){
            // tokenize this sentence and add to our accumulation list.
            tokenizedDocument.add(tokenizer.tokenize(sentence));
        }
        return tokenizedDocument;
    }

}
