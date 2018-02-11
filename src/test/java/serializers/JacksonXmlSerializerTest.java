package serializers;

import javaModel.Joke;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class JacksonXmlSerializerTest {

    @After
    public void after() {
        File file = new File("jackson_file.xml");
        file.delete();
    }

    @Test
    public void whenJacksonSerializerCreatesAFile() throws IOException {
        JacksonXmlSerializer serializer = new JacksonXmlSerializer();
        File file = new File("jackson_file.xml");
        serializer.serialize(new ArrayList<Joke>());
        Assert.assertTrue(file.exists());

    }

}