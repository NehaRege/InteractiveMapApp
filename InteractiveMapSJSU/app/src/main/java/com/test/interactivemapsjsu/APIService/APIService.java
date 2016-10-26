package com.test.interactivemapsjsu.APIService;

import com.test.interactivemapsjsu.Model.TimeDistanceModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by NehaRege on 10/26/16.
 */
public interface APIService {

//    @GET("v3/events/search")
//    Call<FreeEventsObject> getAllFreeEvents(
//            @Query("price") String free,
//            @Header("Authorization") String token);

//    https://maps.googleapis.com/maps/api/distancematrix/json?key=AIzaSyBBfu4iKqlwkyBo7Puc24E3mjtik4yPU4M&destinations=San+José+State+University+Charles+W.+Davidson+College+of+Engineering,+1+Washington+Square,+San+Jose,+CA+95112&origins=37.335142,-121.881276

//    &origins=37.335142,-121.881276

    @GET("maps/api/distancematrix/json?key=AIzaSyBBfu4iKqlwkyBo7Puc24E3mjtik4yPU4M&destinations=San+José+State+University+Charles+W.+Davidson+College+of+Engineering,+1+Washington+Square,+San+Jose,+CA+95112")
    Call<TimeDistanceModel> getTimeDistEngg(
            @Query("origins") String latlong
    );

    @GET("maps/api/distancematrix/json?key=AIzaSyBBfu4iKqlwkyBo7Puc24E3mjtik4yPU4M&destinations=Dr.+Martin+Luther+King,+Jr.+Library,+150+East+San+Fernando+Street,+San Jose,+CA+95112")
    Call<TimeDistanceModel> getTimeDistKing(
            @Query("origins") String latlong
    );



}
