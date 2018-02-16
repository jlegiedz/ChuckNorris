import javaModel.Joke;
import serializers.XStreamXmlSerializer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XStreamXmlSerializerTest {

    XStreamXmlSerializer xStreamXmlSerializer;
    File file;

    @Before
    public void setup() {
        xStreamXmlSerializer = new XStreamXmlSerializer();
        file = new File("xstream_file.xml");
    }

    @After
    public void after() {
        file.delete();
    }


    @Test
    public void doesXstreamSerializerCreateFile() throws Exception {
        xStreamXmlSerializer.serialize(new ArrayList<Joke>());
        Assert.assertTrue(file.exists());
    }


    @Test
    public void checkXmlXstreamLength() {
        Joke joke = new Joke(1, "");
        List<Joke> testList = new ArrayList<>();
        String xml = "<?xml version=\"1.0\" encoding= \"UTF-8\" standalone=\"no\"?><jokes>\n" +
                "  <joke id=\"1\"></joke>\n" +
                "</jokes>";
        int expectedNumberOfBytes = xml.getBytes().length;
        testList.add(joke);
        xStreamXmlSerializer.serialize(testList);
        int actualNumberOfBytes = (int) file.length();
        Assert.assertEquals(expectedNumberOfBytes, actualNumberOfBytes);

    }

}