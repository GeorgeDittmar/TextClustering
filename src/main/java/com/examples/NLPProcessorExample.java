package com.examples;

import com.data.processors.INLPProcessor;
import com.data.processors.NLPProcessorFactory;
import com.data.processors.OpenNLPProcessor;
import com.data.processors.StopWordsFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Created by george on 12/9/13.
 */
public class NLPProcessorExample {

    public static void main(String[] args) throws FileNotFoundException {
        INLPProcessor processor = NLPProcessorFactory.initNLPProcessor(OpenNLPProcessor.class);

        if( processor == null){
            throw new RuntimeException("NLP processor was not initialized.");
        }

        // Initialize the NLP processor
        try {
            processor.init();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // once the processor is initialized lets give it some document to process.

        List<String[]> processed = processor.processDocument("Bob said hi. Hi bob!");
        System.out.println("Number of sentences: "+processed.size());


        // now filter stopwords out of the sentence.
        StopWordsFilter filter = new StopWordsFilter();
        filter.loadStopWords(new File("./src/resources/stopwords.txt"));

        List<List<String>> filteredDoc = filter.filterStopWords(processed);

        System.out.println("Number of words left: "+filteredDoc.get(0).size() );

        for(List<String> sent: filteredDoc){
            for(String word: sent){

                System.out.print(word+" ");
            }
            System.out.println();
        }
    }
}
