import com.data.DataLoader;
import com.data.Document.TextDocument;
import com.data.processors.NLPProcessorFactory;
import com.data.processors.OpenNLPProcessor;
import com.data.processors.StopWordsFilter;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Unit tests for the TextDocument object.
 * Created by george on 12/22/13.
 */
public class TestTextDocument {

    private Map<String,List<File>> data;
    private TextDocument document;

    /**
     * init method to load a document and process it through the ingestion pipeline then load it into a TestDocument
     */
    @BeforeTest
    public void init() throws FileNotFoundException {
        data = DataLoader.loadDataSet(new File("src/test/sample-data/dataLoader-test"));
        document = new TextDocument();
    }

    /**
     * Test that we can save the raw document string correctly and retrieve it from the TextDocument Object.
     * @throws IOException
     */
    @Test
    public void testTextDocument() throws IOException {
        TextDocument document = new TextDocument();

        // Process one of the documents through the nlp processor
        String rawDoc = FileUtils.readFileToString(data.get("class1").get(0), "utf-8");
        document.setOriginalDocumentString(rawDoc);

        Assert.assertTrue(rawDoc.equalsIgnoreCase(document.getRawDocument()));
    }

    /**
     * Test that we can save the processed document inside the TextDocument object and that the term maps
     * are correctly being counted.
     * @throws java.io.IOException
     */
    @Test
    public void testProcessedDocument() throws IOException {

        // Process one of the documents through the nlp processor
        String rawDoc = FileUtils.readFileToString(data.get("class2").get(0), "utf-8");
        document.setOriginalDocumentString(rawDoc);
        Assert.assertTrue(rawDoc.equalsIgnoreCase(document.getRawDocument()));

        // Call the OpenNLP Processor to begin processing the document.
        OpenNLPProcessor processor = (OpenNLPProcessor) NLPProcessorFactory.initNLPProcessor(OpenNLPProcessor.class);
        processor.init();
        StopWordsFilter filter = new StopWordsFilter();
        filter.loadStopWords(new File("./src/resources/stopwords.txt"));

        List<String[]> terms = processor.processDocument(document.getRawDocument());
        List<List<String>> filtered = filter.filterStopWords(terms);

        document.setProcessedDocument(filtered);

        // be sure the document contains the term bobby and the correct term count.
        Assert.assertTrue(document.containsTerm("bobby") && document.getTermCounts().get("bobby") == 1);
        Assert.assertTrue(document.containsTerm("cat") && document.getTermCounts().get("cat") == 2);

        // test that correct term frequency value is being calculated
        Assert.assertEquals(document.getTermFrequency("cat"),(double)2/(double)7);
    }

    @Test
    public void testDocumentTermFrequencies(){

    }
}
