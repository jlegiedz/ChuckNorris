import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface JokeService {

    @GET("random/{randomCount}")
    Call<JokeResponse> randomJokes(@Path("randomCount") int randomCount);
}
