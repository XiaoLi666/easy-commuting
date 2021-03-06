package sg.edu.ntu.cz2006.seproject.model;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Definitions for requesting NEA's APIs
 */
public interface NEAService {
    @GET("api/WebAPI/")
    Observable<UVIndexResponse> getUVIndex(
            @Query("dataset") String dataset,
            @Query("keyref") String apiKey
    );

    @GET("api/WebAPI/")
    Observable<PSIResponse> getPSI(
            @Query("dataset") String dataset,
            @Query("keyref") String apiKey
    );

    @GET("api/WebAPI/")
    Observable<WeatherResponse> getWeather(
            @Query("dataset") String dataset,
            @Query("keyref") String apiKey
    );
}
