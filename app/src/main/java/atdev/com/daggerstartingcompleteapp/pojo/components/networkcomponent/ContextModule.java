package atdev.com.daggerstartingcompleteapp.pojo.components.networkcomponent;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private final Context context;


    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @NetworkComponentScope
    @ApplicationContext
    public Context context() {
        return context;
    }

}
