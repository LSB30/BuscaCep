package Principal;

import Modelos.Cep;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String busca = "";
        System.out.println("Informe seu cep: ");
        busca = leitura.nextLine();
        String endereco = "https://viacep.com.br/ws/" + busca + "/json/";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            Cep meucep = gson.fromJson(json, Cep.class);
            System.out.println(meucep);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
