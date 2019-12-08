package rodrigo.provatecnica.codeheros.ViewModel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import rodrigo.provatecnica.codeheros.API.HerosService;
import rodrigo.provatecnica.codeheros.API.ModuleRetrofit;
import rodrigo.provatecnica.codeheros.Models.MarvelHeros;
import rodrigo.provatecnica.codeheros.Models.Result;

public class MainViewModel extends ViewModel {
    private MutableLiveData<List<Result>> heros = new MutableLiveData<>();

    public LiveData<List<Result>> loadHeros() {
        return heros;
    }

    private int limitt = 4;
    private int offset = 4;
    private String apikey;
    private String hash;

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public void more(int offset) {
        this.offset += offset;
        getHeroes();
    }

    public void minus(int offset) {
        this.offset -= offset;
        getHeroes();
    }

    public void getHeroes() {
        HerosService service = ModuleRetrofit.getService(HerosService.class);
        Call<MarvelHeros> call =
                service.getHeroes(1, apikey,
                        hash, limitt, offset);

        call.enqueue(new Callback<MarvelHeros>() {
            @Override
            public void onResponse(Call<MarvelHeros> call, Response<MarvelHeros> response) {
                if (response.isSuccessful()) {
                    heros.setValue(response.body().getData().getResults());
                }
            }

            @Override
            public void onFailure(Call<MarvelHeros> call, Throwable t) {

            }
        });
    }
}
