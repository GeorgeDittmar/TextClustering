import com.data.processors.StopWordsFilter;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Unit test of the StopWordsFilter class. Tests that common terms should be removed from an input stream while uncommon terms are kept.
 * User: george
 * Date: 11/24/13
 * Time: 8:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestStopWordsFilter {
    private Map<String, List<File>> dataset;
    private StopWordsFilter stopwords = new StopWordsFilter();
    //TODO - fix failed unit test to work with new StopWordFilter api change.
//
//    @BeforeSuite
//    /**
//     * read the document and save it to a map.
//     */
//    public void init() throws FileNotFoundException {
//        this.dataset = DataLoader.loadDataSet(new File("./src/test/sample-data/dataLoader-test/"));
//        this.stopwords.loadStopWords(new File("./src/resources/stopwords.txt"));
//    }
//
//
//    @Test
//    public void testFilter_1() {
//
//        File tmp = this.dataset.get("class1").get(0);
//
//        try {
//            String doc = FileUtils.readFileToString(tmp, "utf-8");
//            Assert.assertNotNull(doc);
//
//            String newString = this.stopwords.filterStopWords(doc).trim();
//            Assert.assertTrue(newString.equalsIgnoreCase(""));
//
//        } catch (Exception e) {
//            Assert.fail();
//        }
//    }
//
//    @Test
//    public void testFilter_2() {
//
//        File tmp = this.dataset.get("class2").get(0);
//
//        try {
//            String doc = FileUtils.readFileToString(tmp, "utf-8");
//            Assert.assertNotNull(doc);
//
//            String newString = this.stopwords.filterStopWords(doc).trim();
//            Assert.assertTrue(newString.equalsIgnoreCase("bobby man loved cat. best cat infact!."));
//
//        } catch (Exception e) {
//            Assert.fail();
//        }
//
//    }
}
