package javaModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Joke {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("joke")
    @Expose
    private String joke;
    @SerializedName("categories")
    @Expose
    private List<Object> categories = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Joke() {
    }

    /**
     *
     * @param id
     * @param joke
     * @param categories
     */
    public Joke(Integer id, String joke, List<Object> categories) {
        super();
        this.id = id;
        this.joke = joke;
        this.categories = categories;
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

    public List<Object> getCategories() {
        return categories;
    }

    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("joke", joke).append("categories", categories).toString();
    }

}
