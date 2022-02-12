package com.example.project.remote;

import com.example.project.model.Consultation;
import com.example.project.model.DeleteResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ConsultationService {

   // @GET("api/consultation/?order=conDesc&orderType=asc")
    //Call<List<Consultation>> getLectConsultation(@Header("api-key") String api_key);

    @GET("api/consultation")
    Call<List<Consultation>> getStudConsultation(@Header("api-key") String api_key);

}
