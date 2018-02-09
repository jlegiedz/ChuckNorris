package serializers;

import com.thoughtworks.xstream.XStream;
import javaModel.Joke;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XStreamXmlSerializer implements JokeSerializer {


    public void serialize(List<Joke> jokes) {
        XStream xStream = new XStream();
        xStream.alias("joke", Joke.class);
        xStream.alias("jokes", List.class);
        xStream.useAttributeFor(Joke.class, "id");

        String xml = xStream.toXML(jokes);
        System.out.println(xml);

    }
}
