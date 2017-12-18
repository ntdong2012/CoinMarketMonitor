package dinostudio.coinmarketmonitor.base.dj.module;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dinostudio.coinmarketmonitor.BuildConfig;
import dinostudio.coinmarketmonitor.base.dj.qualifier.CoinUrl;
import dinostudio.coinmarketmonitor.base.dj.qualifier.MuseumUrl;
import dinostudio.coinmarketmonitor.base.model.http.api.CoinApis;
import dinostudio.coinmarketmonitor.base.model.http.api.MuseumApi;
import dinostudio.coinmarketmonitor.base.model.prefs.PreferencesHelper;
import dinostudio.coinmarketmonitor.base.model.prefs.PreferencesHelperImpl;
import dinostudio.coinmarketmonitor.base.utils.Common;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/20/17.
 */

@Module
public class HttpModule {

    public HttpModule() {
    }


    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }


    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    @CoinUrl
    Retrofit provideBtsRetrofit(Retrofit.Builder builder, OkHttpClient client) {

        String baseURL = "https://api.coinmarketcap.com/v1/";
        return createRetrofit(builder, client, baseURL);
    }


    @Singleton
    @Provides
    @MuseumUrl
    Retrofit provideMuseumRetrofit(Retrofit.Builder builder, OkHttpClient client) {

        String baseURL = "https://api.coinmarketcap.com/v1/";
        return createRetrofit(builder, client, baseURL);
    }


    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder) {
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }


        PreferencesHelper php = new PreferencesHelperImpl();

        File cacheFile = new File(Common.PATH_CACHE);
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
//        Interceptor cacheInterceptor = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                if (!SystemUtil.isNetworkConnected()) {
//                    request = request.newBuilder()
//                            .cacheControl(CacheControl.FORCE_CACHE)
//                            .build();
//                }
//                Response response = chain.proceed(request);
//                if (SystemUtil.isNetworkConnected()) {
//                    int maxAge = 0;
//                    response.newBuilder()
//                            .header("Cache-Control", "public, max-age=" + maxAge)
//                            .removeHeader("Pragma")
//                            .build();
//                } else {
//                    int maxStale = 60 * 60 * 24 * 28;
//                    response.newBuilder()
//                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
//                            .removeHeader("Pragma")
//                            .build();
//                }
//                return response;
//            }
//        };

//        For eParking
        Interceptor apikey = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                request = request.newBuilder()
                        .addHeader("X-Iot-Tenant", "iot1234567890")
                        .build();
                return chain.proceed(request);
            }
        };


        // For Bts
//        Interceptor apikey = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                request = request.newBuilder()
//                        .addHeader("token", token)
//                        .build();
//                return chain.proceed(request);
//            }
//        };


        builder.addInterceptor(apikey);
        builder.addInterceptor(new BasicAuthInterceptor("admin", "123456a@"));
//        builder.addNetworkInterceptor(cacheInterceptor);
//        builder.addInterceptor(cacheInterceptor);
        builder.cache(cache);

        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);

        builder.retryOnConnectionFailure(true);
        return builder.build();
    }

    @Singleton
    @Provides
    CoinApis provideBtsApiService(@CoinUrl Retrofit retrofit) {
        return retrofit.create(CoinApis.class);
    }

    @Singleton
    @Provides
    MuseumApi provideMuseumApiService(@MuseumUrl Retrofit retrofit) {
        return retrofit.create(MuseumApi.class);
    }

    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return builder
                .baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
