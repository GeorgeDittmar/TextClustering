package com.textclustering.processors;

import edu.stanford.nlp.ling.Document;
import opennlp.tools.sentdetect.SentenceDetector;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: george
 * Date: 11/17/13
 * Time: 7:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class OpenNLPProcessor implements INLPProcessor {
    private SentenceDetectorME sentenceDetectorME;


    public void init(){
        // load up each model to be used in the OpenNLP pipeline. This will be hardcoded for now but should be set using
        //some sort of config

        // init sentence detector
        try {
            InputStream sentModelIn = new FileInputStream("/src/resources/OpenNLP-models/en-sent.bin");
            SentenceModel sentenceModel = new SentenceModel(sentModelIn);
            sentenceDetectorME = new SentenceDetectorME(sentenceModel);
        } catch (Exception e) {
            throw new RuntimeException("Could not read in NLP model.",e);
        }

        // init tokenizer model

        // init chunker model

    }

    @Override
    public void processDocument(File document) throws IOException {
        //read in the whole file as a string and then process through opennlp
        String documentString = FileUtils.readFileToString(document,"utf-8");

    }


    public void tokenize(String document) {
        //To change body of implemented methods use File | Settings | File Templates.
    }


}
