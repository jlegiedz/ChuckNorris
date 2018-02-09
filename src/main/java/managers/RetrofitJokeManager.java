package managers;

import javaModel.Constants;
import javaModel.Joke;
import javaModel.JokeResponse;
import jdk.nashorn.internal.scripts.JO;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RetrofitJokeManager implements JokeManager {

    List<Joke> jokesRetro;


    public List<Joke> fetchJokes(int count) throws IOException {

        List<Joke> jokes = new ArrayList<Joke>();
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).
                baseUrl(Constants.api).build();

        JokeService jokeService = retrofit.create(JokeService.class);
        Response<JokeResponse> response = jokeService.randomJokes(count).execute();
        jokes = response.body().getValue();
        jokesRetro = jokes;
        return jokes;

    }



    public void printJokes(List<Joke> jokes) {
        int size = jokes.size();
        System.out.println("You have requested " + size + " jokes about Chuck Norris.");
        for (int i = 0; i < size; i++) {
            System.out.println("Joke number: " + jokes.get(i).getId());
            System.out.println(jokes.get(i).getJoke());
        }
    }
}

