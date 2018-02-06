package serializers;

import javaModel.Joke;

import java.util.List;

public interface JokeSerializer {

    public void serialize(List<Joke> jokes);

}
