package managers;

import javaModel.Joke;

import java.io.IOException;
import java.util.List;

public interface JokeManager {
    public List<Joke> fetchJokes(int count) throws IOException;

    public void printJokes(List<Joke> jokes);
}
