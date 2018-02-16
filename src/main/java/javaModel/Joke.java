package javaModel;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;



@XStreamConverter(value = ToAttributedValueConverter.class, strings = {"joke"})
public class Joke {

    @JacksonXmlProperty(isAttribute = true)
    private Integer id;
    @JacksonXmlText()
    private String joke;

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
        return "Joke{" +
                "id=" + id +
                ", joke='" + joke + '\'' +
                '}';
    }
}