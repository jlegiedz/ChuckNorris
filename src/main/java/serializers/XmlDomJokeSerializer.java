package serializers;

import javaModel.Joke;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class XmlDomJokeSerializer implements JokeSerializer {


    public void serialize(List<Joke> jokes) {

        int numberOfJokes = jokes.size();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = builder.newDocument();

        //adding root element - jokes
        Element rootElement = document.createElement("jokes");
        document.appendChild(rootElement);
        //id element
        for (int i = 0; i < numberOfJokes; i++) {
            Attr attr = document.createAttribute("id");

            String id = document.createTextNode(Integer.toString(jokes.get(i).getId())).getWholeText();
            attr.setValue(id);

            //add joke content
            Element jokeElement = document.createElement("joke");
            rootElement.appendChild(jokeElement);
            jokeElement.setAttributeNode(attr);
            jokeElement.appendChild(document.createTextNode(jokes.get(i).getJoke()));

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = null;
            try {
                transformer = transformerFactory.newTransformer();
            } catch (TransformerConfigurationException e) {
                e.printStackTrace();
            }
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("DOM_file.xml"));

            try {
                transformer.transform(source, result);
            } catch (TransformerException e) {
                e.printStackTrace();
            }

        }

    }
}


