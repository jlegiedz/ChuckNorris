import myApp.serializers.XmlDomJokeSerializer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class XmlDomJokeSerializerTest {

    XmlDomJokeSerializer DOMserializer;
    File file;

    @Before
    public void setup() {
        file = new File("DOM_file.xml");
        DOMserializer = new XmlDomJokeSerializer();

    }

    @After
    public void after() {
        File file = new File("DOM_file.xml");
        file.delete();
    }

//    @Test
//    public void doesDOMserilizerCreateAFile() throws IOException {
//        DOMserializer.serialize(new ArrayList<Joke>());
//        Assert.assertTrue(file.exists());
//
//    }

    @Test
    public void serialize() throws Exception {
    }

}