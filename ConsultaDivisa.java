package com.alura.conversor.conversion;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaDivisa {
    public Divisas calculaDivisa(String baseCode, String targetCode, double monto){
        String apiKey = "b1bfc93cbb0de898b302f1bc";
        String direccion = "https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/"+baseCode+"/"+targetCode+"/"+monto;
        Gson gson= new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            //hacer un response ********************
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            //System.out.println(json);
            CambioPar cambioDivisa = gson.fromJson(json, CambioPar.class);
            Divisas divisaConvertida = new Divisas(cambioDivisa);
            return divisaConvertida;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}