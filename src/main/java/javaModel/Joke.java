package javaModel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import org.apache.commons.lang.builder.ToStringBuilder;

@JacksonXmlRootElement(localName = "joke")
public class Joke {

    @JacksonXmlProperty(isAttribute = true)
    private Integer id;
    @JacksonXmlText()
    protected String joke;

    public Joke() {
    }


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
