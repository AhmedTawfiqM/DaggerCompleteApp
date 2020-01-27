package atdev.com.daggerstartingcompleteapp.pojo.components.networkcomponent;


import com.squareup.picasso.Picasso;

import atdev.com.daggerstartingcompleteapp.pojo.components.adaptercomponent.AdapterComponent;
import atdev.com.daggerstartingcompleteapp.pojo.network.ApiService;
import dagger.Component;

@NetworkComponentScope
@Component(modules = {apiServiceModule.class, PicassoModule.class,ActivityModule.class}
) //NetworkModule.class,  ContextModule.class
public interface AppNetworkComponent {

    Picasso getPicasso();

    ApiService getApiService();
}
