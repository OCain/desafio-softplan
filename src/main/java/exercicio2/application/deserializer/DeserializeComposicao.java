package exercicio2.application.deserializer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DeserializeComposicao {
    private static final String PATH = "src/main/java/exercicio2/application/deserializer/dados-entrada-servicos-composicoes.json";

    public static List<EntradaDadosComposicao> deserialize() {
        Gson gson = new Gson();
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(PATH));
        } catch (IOException e) {
            System.out.println("Erro ao localizar arquivo JSON");
            e.printStackTrace();
        }
        return gson.fromJson(reader, new TypeToken<List<EntradaDadosComposicao>>(){}.getType());
    }
}
