package com.example.project.remote;

public class ApiUtils {
    // REST API server URL
    public static final String BASE_URL = "http://192.168.0.9/prestige/";

    // return UserService instance
    public static UserService getUserService() {
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }

    // return BookService instance
    public static ConsultationService getConsultationService() {
        return RetrofitClient.getClient(BASE_URL).create(ConsultationService.class);
    }

}
