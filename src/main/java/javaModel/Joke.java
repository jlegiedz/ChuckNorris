package javaModel;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.apache.commons.lang.builder.ToStringBuilder;

@JacksonXmlRootElement(localName="Metadata")
public class Joke {

    @JacksonXmlProperty(isAttribute = true, namespace = "")
    private Integer id;
    private String joke;


    /**
     * No args constructor for use in serialization
     */
    public Joke() {
    }

    /**
     * @param id
     * @param joke
     */
    public Joke(Integer id, String joke) {
        super();
        this.id = id;
        this.joke = joke;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .toString();
    }

}
