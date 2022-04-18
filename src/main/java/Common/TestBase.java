package Common;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestBase {
    @BeforeSuite

    @BeforeMethod
    public void setUp() {
        WebdriverUtils.initDriver("firefox");
        WebdriverUtils.navigateTo(Constant.HOMEPAGEURL);
        WebdriverUtils.maximizeWindow();
    }

    @AfterMethod
    public void tearDown() {
        WebdriverUtils.quitBrowser();
    }

    @DataProvider
    public Iterator<Object[]> readData() throws IOException, CsvValidationException {
        String csvPath = "src/test/resources//"+this.getClass().getSimpleName()+".csv";
        Reader reader = new FileReader(csvPath);
        CSVReader csvReader = new CSVReader(reader);
        List<Object[]> list = new ArrayList<>();
        String[] nextLine = csvReader.readNext();
        while (nextLine != null) {
            Object[] objLine = nextLine;
            list.add(objLine);
            nextLine = csvReader.readNext();
        }
        Iterator<Object[]> data= list.iterator();
        return data;
    }
}
