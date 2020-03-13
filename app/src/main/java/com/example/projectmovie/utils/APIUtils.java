package com.example.projectmovie.utils;

public class APIUtils {
    static String localhost = "192.168.1.15";
    private static String baseUrl = "http://"+localhost+"/servermovie/";
    public static DataClient GetData(){
        return RetrofitClient.GetClient(baseUrl).create(DataClient.class);
    }
}
