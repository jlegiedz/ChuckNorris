package serializers;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.aalto.stax.InputFactoryImpl;
import com.fasterxml.aalto.stax.OutputFactoryImpl;
import javaModel.Joke;

import java.io.File;
import java.io.IOException;

import java.util.List;

public class JacksonXmlSerializer implements JokeSerializer {

    public void serialize(List<Joke> jokes) {

        XmlFactory factory = new XmlFactory(
                new InputFactoryImpl(), new OutputFactoryImpl());

        XmlMapper xmlMapper = new XmlMapper();
        File file = new File("jackson_file.xml");
        try {
            xmlMapper.writer().withRootName("jokes").writeValue(file, jokes);

        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}
