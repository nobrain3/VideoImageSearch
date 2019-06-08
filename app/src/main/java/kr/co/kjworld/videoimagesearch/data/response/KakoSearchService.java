package kr.co.kjworld.videoimagesearch.data.response;


import io.reactivex.Single;
import kr.co.kjworld.videoimagesearch.data.response.data.ImageData;
import kr.co.kjworld.videoimagesearch.data.response.data.VideoData;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface KakoSearchService {
    @GET("/v2/search/image")
    Single<ImageData> getImageData(@Header("Authorization") String auth, @Query("query") String query, @Query("sort") String sort, @Query("page") int page, @Query("size") int size);

    @GET("/v2/search/vclip")
    Single<VideoData> getVideoData(@Header("Authorization") String auth, @Query("query") String query, @Query("sort") String sort, @Query("page") int page, @Query("size") int size);

}
