package Principal;

import Modelos.Endereco;
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

        ConsultaCep consultaCep = new ConsultaCep();
        consultaCep.buscaEndereco(busca);
    }
}
