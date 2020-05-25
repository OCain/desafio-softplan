package exercicio2;

import exercicio2.application.Application;
import exercicio2.application.deserializer.DeserializeComposicao;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Application app = new Application();
        app.imprimeComposicoes(DeserializeComposicao.deserialize());
    }
}
