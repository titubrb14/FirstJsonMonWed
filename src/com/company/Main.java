package com.company;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) {
	    var dataGrabber = HttpClient.newHttpClient();
        var requestMaker = HttpRequest.newBuilder();
        var webAddress = URI.create("http://universities.hipolabs.com/search?name=Young");
        var dataRequest = requestMaker.uri(webAddress).build();
        HttpResponse<String> response = null;
        try{
            response = dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString());
        }
        catch(IOException exception){
            System.out.println("Error connecting to networked resource.");
        }
        catch (InterruptedException e){
            System.out.println("An error has occurred getting a response from the server.");
        }
        if(response == null){
            System.out.println("Something went terribly wrong - we have to close now.");
            System.exit(-1);
        }
        System.out.println(response);
    }

}
