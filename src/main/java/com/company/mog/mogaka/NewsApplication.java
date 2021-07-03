package com.company.mog.mogaka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.net.URLEncoder;

public class NewsApplication {
    public static void main(String[] args) throws Exception {
//        //Host URL
//        String host = "https://google-news1.p.rapidapi.com";
//        String charset = "UTF-8";
//        //Headers for the request
//        String x_rapidapi_host = "google-news1.p.rapidapi.com";
//        String x_rapidapi_key = "63a618be9cmsh26eab68acd52dc5p10";//rapid api key
//        //Params
//        String s = "Pulp";
//        //Format query to avoid encoding problems
//        String query = String.format("s=%s", URLEncoder.encode(s, charset));

        HttpResponse<JsonNode> response = Unirest.get("https://google-news1.p.rapidapi.com/topic-headlines?topic=WORLD&country=US&lang=en")
                .header("x-rapidapi-key", "cb50711466msh8ab234bdc5f2765p1e59a1jsnd0b9f945cd64")
                .header("x-rapidapi-host", "google-news1.p.rapidapi.com")
                .asJson();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(response.getBody().toString());
        String prettyJsonString = gson.toJson(je);

        System.out.println(prettyJsonString);

//        System.out.println(response.getStatus());
//        System.out.println(response.getHeaders().get("Content-Type"));
    }
}
