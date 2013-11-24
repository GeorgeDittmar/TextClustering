import com.data.DataLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: george
 * Date: 11/17/13
 * Time: 9:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestDataLoader {

    @Test
    public void testDataLoader(){
        Map<String,List<File>> data = DataLoader.loadDataSet(new File("src/test/sample-data/dataLoader-test"));
        Assert.assertNotNull(data);
        Assert.assertEquals(data.size(),2);

        Assert.assertEquals(data.get("class1").get(0).getName(),"doc-class1.txt");
        Assert.assertEquals(data.get("class2").get(0).getName(),"doc-class2.txt");
    }
}
