package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String apiKey = "57f810d";

        System.out.println("Digite o filme que você deseja procurar:");
        var busca = leitura.nextLine();
        busca = busca.replace(" ", "+");

        String url = String.format("http://www.omdbapi.com?t=%s&apikey=%s", busca, apiKey);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        Gson gson = new Gson();
        Titulo titulo = gson.fromJson(json, Titulo.class);
        System.out.println(titulo);

    }
}
