package dio.primeiros_passos;

import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
/**
 * The main class for the Primeiros Passos application.
 * This class is annotated with @SpringBootApplication, indicating it's the entry point for the Spring Boot application.
 */
@SpringBootApplication
public class PrimeirosPassosApplication {
    /**
     * The main method which serves as the entry point for the application.
     * It uses SpringApplication to bootstrap and launch the Spring application.
     *
     * @param args Command line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(PrimeirosPassosApplication.class, args);
    }

    /**
     * Defines a CommandLineRunner bean that demonstrates JSON conversion.
     * This method creates a sample JSON string, converts it to a ViaCepResponse object,
     * and prints the results to the console.
     *
     * @param conversor An instance of ConversorJson used to convert JSON to ViaCepResponse.
     * @return A CommandLineRunner functional interface implementation.
     * @throws Exception If an error occurs during execution.
     */
    @Bean
    public CommandLineRunner run(ConversorJson conversor) throws Exception {
        return args -> {
            String json = "{\"cep\":\"01001-000\",\"logradouro\": \"Praca Se\", \"localidade\": \"Fortaleza\"}";
            System.out.println("JSON de entrada: " + json);
            ViaCepResponse response = conversor.converter(json);
            System.out.println("Resposta convertida: " + response);
            System.out.println("CEP: " + response.getCep());
            System.out.println("Logradouro: " + response.getLogradouro());
            System.out.println("Localidade: " + response.getLocalidade());
        };
    }
}
