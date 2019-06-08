package kr.co.kjworld.videoimagesearch.data.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kr.co.kjworld.videoimagesearch.data.response.data.ImageData;
import kr.co.kjworld.videoimagesearch.data.response.data.VideoData;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCreator {
    private static final String BASE_URL = "https://dapi.kakao.com";

    private static Retrofit retrofit;

    public static Retrofit getInstance()
    {
        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(ImageData.class, new KakaoImageDataDeserializer())
                    .create();

            Gson videoGson = new GsonBuilder()
                    .registerTypeAdapter(VideoData.class, new KakaoVideoDataDeserializer())
                    .create();

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addConverterFactory(GsonConverterFactory.create(videoGson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

        }
        return retrofit;
    }
}
