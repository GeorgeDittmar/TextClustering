package com.examples;

import com.data.Corpus;
import com.data.DataLoader;
import com.data.Document.TextDocument;
import com.data.processors.NLPProcessorFactory;
import com.data.processors.OpenNLPProcessor;
import com.data.processors.StopWordsFilter;
import com.data.processors.TFIDFProcessor;
import com.textclustering.kmeans.KMeans;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This is an example class that shows how to process set of documents through the framework and
 * use kmeans clustering to try to learn document classification labels.
 * Created by george on 12/16/13.
 */
public class ExampleKMeans {

    public static void main(String[] args) throws IOException {


        // load text data
        Map<String,List<File>> data = DataLoader.loadDataSet(new File("src/test/sample-data/dataLoader-test"));
        Corpus corpus = new Corpus();
        corpus.setFeatureProcessor(new TFIDFProcessor());
        // setup the NLP and stopwords processors
        OpenNLPProcessor processor = (OpenNLPProcessor) NLPProcessorFactory.initNLPProcessor(OpenNLPProcessor.class);
        processor.init();

        StopWordsFilter filter = new StopWordsFilter(new File("./src/resources/stopwords.txt"));
        List<TextDocument> documentList = new LinkedList<TextDocument>();

        for(String classLabel: data.keySet()){
            // grab each document from each class label and process them through the ingestion pipeline
            for(File document: data.get(classLabel)){
                TextDocument tDoc = new TextDocument();

                //process each text document through the processors
                String rawText = FileUtils.readFileToString(document,"utf-8");
                List<String[]> parsedDoc = processor.processDocument(rawText);
                List<List<String>> filteredDoc = filter.filterStopWords(parsedDoc);

                tDoc.setOriginalDocumentString(rawText);
                tDoc.setProcessedDocument(filteredDoc);
                documentList.add(tDoc);
                // now add the document to the corpus with the given class label
                corpus.addDocument(classLabel,tDoc);
            }
        }

        // calculate the feature weights.
        corpus.calculateFeatureWeights();

        // now call the KMeans object
        KMeans kmeans = new KMeans(2,corpus);

    }
}
