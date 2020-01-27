package atdev.com.daggerstartingcompleteapp.ui.mainactivity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.squareup.picasso.Picasso;

import java.util.List;

import atdev.com.daggerstartingcompleteapp.R;
import atdev.com.daggerstartingcompleteapp.adapters.ReposAdapter;
import atdev.com.daggerstartingcompleteapp.databinding.ActivityMainBinding;
import atdev.com.daggerstartingcompleteapp.pojo.models.GithubRepo;
import atdev.com.daggerstartingcompleteapp.pojo.components.networkcomponent.AppNetworkComponent;
import atdev.com.daggerstartingcompleteapp.pojo.components.networkcomponent.ContextModule;
import atdev.com.daggerstartingcompleteapp.pojo.network.ApiService;
import atdev.com.daggerstartingcompleteapp.pojo.components.networkcomponent.DaggerAppNetworkComponent;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


//https://bitbucket.org/hvisser/android-apt/src/default/
public class MainActivity extends AppCompatActivity {

    //Vars
    ActivityMainBinding binding;
    ApiService apiService;
    Picasso picasso;

    AppNetworkComponent appComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        appComponent = DaggerAppNetworkComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        apiService = appComponent.getApiService();
        picasso = appComponent.getPicasso();

        apiService.getAllRepos().enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {

                ReposAdapter reposAdapter = new ReposAdapter(getApplicationContext(), picasso);
                reposAdapter.SetRepos(response.body());
                binding.recyclerview.setAdapter(reposAdapter);
            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {

            }
        });


    }


    public AppNetworkComponent component() {
        return appComponent;
    }
}
