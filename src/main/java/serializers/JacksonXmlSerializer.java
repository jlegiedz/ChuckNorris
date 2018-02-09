package serializers;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import javaModel.Joke;

import java.io.File;
import java.io.IOException;

import java.util.List;

public class JacksonXmlSerializer implements JokeSerializer {

    public void serialize(List<Joke> jokes) {
        XmlMapper xmlMapper = new XmlMapper();
        File file = new File("jackson_file.xml");
        try {
            System.out.println(xmlMapper.writer().withRootName("jokes").writeValueAsString(jokes));
            xmlMapper.writeValue(file, jokes);

        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}
