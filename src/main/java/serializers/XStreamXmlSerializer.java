package serializers;

import com.thoughtworks.xstream.XStream;
import javaModel.Joke;

import java.util.List;

public class XStreamXmlSerializer implements JokeSerializer {


    public void serialize(List<Joke> jokes) {
        JokeXstream js = new JokeXstream();
        js.jokeXList = jokes;
        XStream xStream = new XStream();
        xStream.alias("joke", Joke.class);
        xStream.processAnnotations(JokeXstream.class);
        xStream.alias("jokes", List.class);
        xStream.addImplicitCollection(JokeXstream.class, "jokeXList");

        //@XStreamConverter(value=ToAttributedValueConverter.class, strings={"joke"})
        //node joke:Joke.class; converter treats joke filed as a text and the rest of the fields as attributes.
        //that is why no need to use:
        //xStream.useAttributeFor(Joke.class, "id");

        String xml = xStream.toXML(jokes);
        System.out.println(xml);

    }

    private class JokeXstream {
        List<Joke> jokeXList;
    }
}
