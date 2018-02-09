package serializers;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import javaModel.Joke;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JacksonXmlSerializer implements JokeSerializer {

    public void serialize(List<Joke> jokes)  {

        XmlMapper xmlMapper = new XmlMapper();
        try {
            for (int i = 0; i < jokes.size(); i++) {
                xmlMapper.writeValue(new File("jackson_file.xml"), jokes.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File("jackson_file.xml");
    }
}
