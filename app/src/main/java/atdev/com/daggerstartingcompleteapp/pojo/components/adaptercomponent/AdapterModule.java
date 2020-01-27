package atdev.com.daggerstartingcompleteapp.pojo.components.adaptercomponent;

import com.squareup.picasso.Picasso;

import atdev.com.daggerstartingcompleteapp.adapters.ReposAdapter;
import atdev.com.daggerstartingcompleteapp.ui.mainactivity.MainActivity;
import atdev.com.daggerstartingcompleteapp.ui.test.HomeActivity;
import dagger.Module;
import dagger.Provides;

@Module
public class AdapterModule {

    private final HomeActivity mainActivity;

    public AdapterModule(HomeActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @ScopeAdapter
    public ReposAdapter getReposAdapter(Picasso picasso) {

        ReposAdapter reposAdapter = new ReposAdapter(mainActivity,picasso);
        return reposAdapter;
    }
}
