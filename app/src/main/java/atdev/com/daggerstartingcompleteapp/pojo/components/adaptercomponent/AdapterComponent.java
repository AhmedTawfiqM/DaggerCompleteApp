package atdev.com.daggerstartingcompleteapp.pojo.components.adaptercomponent;

import atdev.com.daggerstartingcompleteapp.adapters.ReposAdapter;
import atdev.com.daggerstartingcompleteapp.pojo.components.networkcomponent.AppNetworkComponent;
import atdev.com.daggerstartingcompleteapp.ui.test.HomeActivity;
import dagger.Component;

@ScopeAdapter
@Component(modules = AdapterModule.class, dependencies = AppNetworkComponent.class)
public interface AdapterComponent {

    void injectHomeActicity(HomeActivity homeActivity);
}
