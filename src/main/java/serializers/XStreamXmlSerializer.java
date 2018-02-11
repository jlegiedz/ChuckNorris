package serializers;

import com.thoughtworks.xstream.XStream;
import javaModel.Joke;

import java.io.*;
import java.util.List;

public class XStreamXmlSerializer implements JokeSerializer {


    public void serialize(List<Joke> jokes) {

        XStream xStream = new XStream();
        xStream.alias("joke", Joke.class);
        xStream.processAnnotations(Joke.class);
        xStream.alias("jokes", List.class);

        //@XStreamConverter(value=ToAttributedValueConverter.class, strings={"joke"})
        //node joke:Joke.class; converter treats joke filed as a text and the rest of the fields as attributes.
        //that is why no need to use:
        //xStream.useAttributeFor(Joke.class, "id");


        FileOutputStream out;
        try {
            out = new FileOutputStream("xstream_file.xml");
            String xml = xStream.toXML(jokes);
            byte[] byteVersion = ("<?xml version=\"1.0\" encoding= \"UTF-8\" standalone=\"no\"?>").getBytes("UTF-8");
            byte[] bytes = xml.getBytes("UTF-8");
            out.write(byteVersion);
            out.write(bytes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
