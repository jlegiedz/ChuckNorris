package javaModel;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Joke {

    @JacksonXmlProperty(isAttribute = true, namespace = "")
    private Integer id;
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
