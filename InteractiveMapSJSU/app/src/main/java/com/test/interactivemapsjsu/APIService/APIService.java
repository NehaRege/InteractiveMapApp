package com.test.interactivemapsjsu.APIService;

import com.test.interactivemapsjsu.Model.TimeDistanceModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by NehaRege on 10/26/16.
 */
public interface APIService {

//    King Library: Dr. Martin Luther King, Jr. Library, 150 East San Fernando Street, San Jose, CA 95112
//
//    Engineering Building: San José State University Charles W. Davidson College of Engineering, 1 Washington Square, San Jose, CA 95112
//
//    Yoshihiro Uchida Hall: Yoshihiro Uchida Hall, San Jose, CA 95112
//
//    Student Union: Student Union Building, San Jose, CA 95112
//
//    BBC: Boccardo Business Complex, San Jose, CA 95112
//
//    South Parking Garage: San Jose State University South Garage, 330 South 7th Street, San Jose, CA 95112

    @GET("maps/api/distancematrix/json?key=AIzaSyBBfu4iKqlwkyBo7Puc24E3mjtik4yPU4M&destinations=San+José+State+University+Charles+W.+Davidson+College+of+Engineering,+1+Washington+Square,+San+Jose,+CA+95112")
    Call<TimeDistanceModel> getTimeDistEngg(
            @Query("origins") String latlong
    );

    @GET("maps/api/distancematrix/json?key=AIzaSyBBfu4iKqlwkyBo7Puc24E3mjtik4yPU4M&destinations=Dr.+Martin+Luther+King,+Jr.+Library,+150+East+San+Fernando+Street,+San Jose,+CA+95112")
    Call<TimeDistanceModel> getTimeDistKing(
            @Query("origins") String latlong
    );

    @GET("maps/api/distancematrix/json?key=AIzaSyBBfu4iKqlwkyBo7Puc24E3mjtik4yPU4M&destinations=San+Jose+State+University+South+Garage,+330+South+7th+Street,+San+Jose,+CA+95112")
    Call<TimeDistanceModel> getTimeDistGarage(
            @Query("origins") String latlong
    );

    @GET("maps/api/distancematrix/json?key=AIzaSyBBfu4iKqlwkyBo7Puc24E3mjtik4yPU4M&destinations=Boccardo+Business+Complex,+San+Jose,+CA+95112")
    Call<TimeDistanceModel> getTimeDistBbc(
            @Query("origins") String latlong
    );

    @GET("maps/api/distancematrix/json?key=AIzaSyBBfu4iKqlwkyBo7Puc24E3mjtik4yPU4M&destinations=Yoshihiro+Uchida+Hall,+San+Jose,+CA+95112")
    Call<TimeDistanceModel> getTimeDistYuh(
            @Query("origins") String latlong
    );

    @GET("maps/api/distancematrix/json?key=AIzaSyBBfu4iKqlwkyBo7Puc24E3mjtik4yPU4M&destinations=Student+Union+Building,+San+Jose,+CA+95112")
    Call<TimeDistanceModel> getTimeDistSu(
            @Query("origins") String latlong
    );


}
