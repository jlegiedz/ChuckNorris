package serializers;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import javaModel.Joke;

import java.io.File;
import java.io.IOException;

import java.io.OutputStream;
import java.util.List;

public class JacksonXmlSerializer implements JokeSerializer {

    public void serialize(List<Joke> jokes) {

        JokeCollection jc = new JokeCollection();
        jc.jokeList = jokes;
        XmlMapper xmlMapper = new XmlMapper();
        File file = new File("jackson_file.xml");

        try {

            xmlMapper.writer().withRootName("jokes").writeValue(file, jc);

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    private class JokeCollection {
        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "joke")
        public List<Joke> jokeList;
    }
}
