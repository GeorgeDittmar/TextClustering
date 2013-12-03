import com.data.DataLoader;
import com.textclustering.processors.INLPProcessor;
import com.textclustering.processors.OpenNLPProcessor;
import com.textclustering.processors.StopWordsFilter;
import junit.framework.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.fail;
/**
 * This is an integration test for the document ingestion process when loading documents into the framework. This test will
 * excercise the DataLoader, OpenNLPProcess, and StopWordsFilter classes to insure that each one works as expected when used to form
 * the document ingestion pipeline.
 * User: george
 * Date: 11/26/13
 * Time: 11:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class DocumentIngestionIT {

    private INLPProcessor processor = new OpenNLPProcessor();
    private StopWordsFilter stopwords = new StopWordsFilter();
    @BeforeClass
    public void init(){
        try {
            processor.init();
            stopwords.loadStopWords(new File("./src/resources/stopwords.txt"));
        } catch (IOException e) {
            fail();
        }


    }

    @Test
    public void testPipeline() throws IOException {

        Map<String,List<File>> data = DataLoader.loadDataSet(new File("src/test/sample-data/dataLoader-test"));

        File docs1 = data.get("class1").get(0);

        List<String[]> tokenizedDoc = processor.processDocument(docs1);

        // make sure that there are 16 characters in the tokenized sentence.
        Assert.assertTrue(tokenizedDoc.get(0).length == 16);

        List<List<String>> processedDoc = stopwords.filterStopWords(tokenizedDoc);

        Assert.assertEquals(0, processedDoc.get(0).size());

        File docs2 = data.get("class2").get(0);

        List<String[]> tokenizedDoc2 = processor.processDocument(docs2);
        Assert.assertTrue(tokenizedDoc2.get(0).length == 11);
        Assert.assertTrue(tokenizedDoc2.get(1).length == 6);

        List<List<String>> processedDoc2 = stopwords.filterStopWords(tokenizedDoc2);
        List<String> sentence1 = Arrays.asList("Bobby", "man", "loved", "cat", ".");
        List<String> sentence2 = Arrays.asList("best", "cat", "infact","!",".");
        Assert.assertEquals(sentence1,processedDoc2.get(0));
        Assert.assertEquals(sentence2,processedDoc2.get(1));
        // maybe dont use the below code
//        for(String key: data.keySet()){
//            for(File file: data.get(key) ){
//
//                List<String[]> tokenizedDoc = processor.processDocument(file);
//                Assert.assertTrue(tokenizedDoc.size() > 0);
//
//                if(key.equalsIgnoreCase("class1")){
//
//
//                    Assert.assertTrue(tokenizedDoc.get(0).length == 16);
//
//                }else if(key.equalsIgnoreCase("class2")){
//
//                    Assert.assertTrue(tokenizedDoc.get(0).length == 11);
//                    Assert.assertTrue(tokenizedDoc.get(1).length == 6);
//                }
//                System.out.println("TextDocument tokenized correctly.");
//            }
//        }
    }
}
