import com.data.DataLoader;
import com.textclustering.processors.StopWordsFilter;
import junit.framework.Assert;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: george
 * Date: 11/24/13
 * Time: 8:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestStopWordsFilter {
    private Map<String, List<File>> dataset;
    private StopWordsFilter stopwords = new StopWordsFilter();


    @BeforeSuite
    /**
     * read the document and save it to a string
     */
    public void init() throws FileNotFoundException {
        this.dataset = DataLoader.loadDataSet(new File("./src/test/sample-data/dataLoader-test/"));
        this.stopwords.loadStopWords(new File("./src/resources/stopwords.txt"));
    }


    @Test
    public void testFilter_1() {

        File tmp = this.dataset.get("class1").get(0);

        try {
            String doc = FileUtils.readFileToString(tmp, "utf-8");
            Assert.assertNotNull(doc);

            String newString = this.stopwords.filterStopWords(doc).trim();
            Assert.assertTrue(newString.equalsIgnoreCase(""));

        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void testFilter_2() {

        File tmp = this.dataset.get("class2").get(0);

        try {
            String doc = FileUtils.readFileToString(tmp, "utf-8");
            Assert.assertNotNull(doc);

            String newString = this.stopwords.filterStopWords(doc).trim();
            Assert.assertTrue(newString.equalsIgnoreCase("bobby man loved cat. best cat infact!."));

        } catch (Exception e) {
            Assert.fail();
        }

    }
}
