import javaModel.Joke;
import serializers.JacksonXmlSerializer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class JacksonXmlSerializerTest {

    JacksonXmlSerializer jacksonXmlserializer;
    File file;

    @Before
    public void setup() {
        file = new File("jackson_file.xml");
        jacksonXmlserializer = new JacksonXmlSerializer();

    }


    @After
    public void after() {
        File file = new File("jackson_file.xml");
        file.delete();
    }

    @Test
    public void doesJacksonSerializerCreateAFile() throws IOException {
        jacksonXmlserializer.serialize(new ArrayList<Joke>());
        Assert.assertTrue(file.exists());

    }

    @Test
    public void checkXmlXstreamLength() {
        Joke joke = new Joke(1, "");
        List<Joke> testList = new ArrayList<>();
        String xml = "<jokes><joke id=\"1\"></joke></jokes>";
        int expectedNumberOfBytes = xml.getBytes().length;
        testList.add(joke);
        jacksonXmlserializer.serialize(testList);
        int actualNumberOfBytes = (int) file.length();
        Assert.assertEquals(expectedNumberOfBytes, actualNumberOfBytes);
    }


}
