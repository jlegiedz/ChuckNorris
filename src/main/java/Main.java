
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).
                baseUrl(Constants.api).build();
        JokeService jokeService = retrofit.create(JokeService.class);

        Response<JokeResponse> response = jokeService.randomJokes(8).execute();
        printJokes(response);


        try {
            XmlWrite(response);
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }

    private static void XmlWrite(Response<JokeResponse> response) throws TransformerException {

        int numberOfJokes = response.body().getValue().size();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            //adding root element - jokes
            Element rootElement = document.createElement("jokes");
            document.appendChild(rootElement);
            //id element
            for (int i = 0; i < numberOfJokes; i++) {
                Attr attr = document.createAttribute("id");
                attr.setValue(String.valueOf(i));
                // idElement.appendChild(document.createTextNode(Integer.toString(i)));
                //add joke content
                Element jokeElement = document.createElement("joke");
                rootElement.appendChild(jokeElement);
                jokeElement.setAttributeNode(attr);
                jokeElement.appendChild(document.createTextNode(response.body().getValue().get(i).getJoke().toString()));

            }


            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("file.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }


    public static void printJokes(Response<JokeResponse> response) {
        int size = response.body().getValue().size();
        System.out.println("You have requested " + size + " jokes about Chuck Norris.");
        for (int i = 0; i < size; i++) {
            System.out.println("Joke number: " + (i + 1));
            System.out.println(response.body().getValue().get(i).getJoke());
        }
    }


}
