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
    private Map<String,List<File>> dataset;
    private StopWordsFilter stopwords;


    @BeforeSuite
    /**
     * read the document and save it to a string
     */
    public void init() throws FileNotFoundException {
        this.dataset = DataLoader.loadDataSet(new File("src/test/sample-data/dataLoader-test/"));
        this.stopwords.loadStopWords(new File("src\\resources\\stopwords.txt"));
    }



    @Test
    public void testFilter(){

        for(String classLabel: this.dataset.keySet()){
            File tmp = (File) this.dataset.get(classLabel);

            try {
                String doc = FileUtils.readFileToString(tmp,"utf-8");

            } catch (Exception e) {
                Assert.fail();
            }

        }

    }
}
