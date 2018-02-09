
import javaModel.Joke;
import managers.JokeManager;
import managers.RetrofitJokeManager;
import serializers.JacksonXmlSerializer;
import serializers.JokeSerializer;
import serializers.XStreamXmlSerializer;
import serializers.XmlDomJokeSerializer;

import java.io.IOException;
import java.util.List;


public class Main {


    public static void main(String[] args) throws IOException {

        JokeManager jokeManager = new RetrofitJokeManager();
        List<Joke> jokes = jokeManager.fetchJokes(5);

        jokeManager.printJokes(jokes);

        JokeSerializer xmlDomSerializer = new XmlDomJokeSerializer();
        xmlDomSerializer.serialize(jokes);

        JokeSerializer jacksonXmlSerializer = new JacksonXmlSerializer();
        jacksonXmlSerializer.serialize(jokes);

        XStreamXmlSerializer xSteramSerializer = new XStreamXmlSerializer();
        xSteramSerializer.serialize(jokes);


    }


}


