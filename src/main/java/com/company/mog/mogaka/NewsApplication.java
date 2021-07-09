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
        HttpResponse<JsonNode> response = Unirest.get("https://google-news1.p.rapidapi.com/topic-headlines?topic=WORLD&country=US&lang=en")
                .header("x-rapidapi-key", "cb50711466msh8ab234bdc5f2765p1e59a1jsnd0b9f945cd64")
                .header("x-rapidapi-host", "google-news1.p.rapidapi.com")
                .asJson();

        HttpResponse<JsonNode> response1 = Unirest.get("https://api.nytimes.com/svc/news/v3/content/all/all.json?api-key=HtjYdnd2cGXa9bNpf0XA4uEzrt9hnzBQ")
                .header("new-york_timesapi-key", "HtjYdnd2cGXa9bNpf0XA4uEzrt9hnzBQ")
                .header("newyork_times", "api.nytimes.com")
                .asJson();

        HttpResponse<JsonNode> response2 = Unirest.get("")
                .header("", "")
                .header("", "")
                .asJson();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(response.getBody().toString());
        JsonElement je1 = jp.parse(response1.getBody().toString());
        JsonElement je2 = jp.parse(response2.getBody().toString());
        String prettyJsonString = gson.toJson(je);
        String prettyJsonString1 = gson.toJson(je1);
        String prettyJsonString2 = gson.toJson(je2);

        System.out.println("Google News ...\n");
        System.out.println(prettyJsonString);
        System.out.println("New York Times ... \n");
        System.out.println(prettyJsonString1);
    }
}
