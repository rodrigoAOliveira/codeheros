package rodrigo.provatecnica.codeheros.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rodrigo.provatecnica.codeheros.Models.MarvelHeros;

public interface HerosService {

    @GET("v1/public/characters")
    Call<MarvelHeros> getHeroes(
            @Query("ts") int ts,
            @Query("apikey") String apikey,
            @Query("hash") String hash,
            @Query("limit") int limit,
            @Query("offset") int offset

    );
}
