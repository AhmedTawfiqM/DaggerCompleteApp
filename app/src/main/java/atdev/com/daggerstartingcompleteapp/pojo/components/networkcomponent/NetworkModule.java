package atdev.com.daggerstartingcompleteapp.pojo.components.networkcomponent;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

@Module(includes = ContextModule.class)
public class NetworkModule {


    @Provides
    @NetworkComponentScope
    public OkHttpClient getOkHttpClient(HttpLoggingInterceptor loggingInterceptor){

        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
    }


    @Provides
    @NetworkComponentScope
    public HttpLoggingInterceptor loggingInterceptor(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return interceptor;
    }
}
