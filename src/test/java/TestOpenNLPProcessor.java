import com.data.processors.INLPProcessor;
import com.data.processors.OpenNLPProcessor;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * OpenNLP Processor unit tests
 * User: george
 * Date: 11/26/13
 * Time: 11:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestOpenNLPProcessor {
    private INLPProcessor processor = new OpenNLPProcessor();

    @Test
    void testInit() {
        try {
            processor.init();
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(dependsOnMethods = "testInit")
    public void testprocessDocument() {

        List<String[]> tokenizedDocument = new LinkedList<String[]>();

        try {
            tokenizedDocument = processor.processDocument(new File("src/test/sample-data/dataLoader-test/class2/doc-class2.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(tokenizedDocument.size(), 2);
        assertEquals(tokenizedDocument.get(0).length, 11);
        assertEquals(tokenizedDocument.get(1).length, 6);


    }
}
