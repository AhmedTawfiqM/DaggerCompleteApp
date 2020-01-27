package atdev.com.daggerstartingcompleteapp.pojo.network;

import java.util.List;

import atdev.com.daggerstartingcompleteapp.pojo.models.GithubRepo;
import retrofit2.Call;
import retrofit2.http.GET;

//https://api.github.com/repositories

public interface ApiService {

    @GET("repositories")
    Call<List<GithubRepo>> getAllRepos();
}
