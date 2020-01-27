package atdev.com.daggerstartingcompleteapp.ui.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import atdev.com.daggerstartingcompleteapp.R;
import atdev.com.daggerstartingcompleteapp.adapters.ReposAdapter;
import atdev.com.daggerstartingcompleteapp.pojo.components.adaptercomponent.AdapterComponent;
import atdev.com.daggerstartingcompleteapp.pojo.components.adaptercomponent.AdapterModule;
import atdev.com.daggerstartingcompleteapp.pojo.components.adaptercomponent.DaggerAdapterComponent;

public class HomeActivity extends AppCompatActivity {

    @Inject
    AdapterComponent adapterComponent;

    ReposAdapter reposAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        adapterComponent = DaggerAdapterComponent.builder()
                .adapterModule(new AdapterModule(this))
                .build();

        adapterComponent.injectHomeActicity(this);

    }
}
