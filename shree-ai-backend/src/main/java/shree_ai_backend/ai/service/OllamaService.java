package shree_ai_backend.ai.service;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OllamaService {

    private final WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:11434")
            .build();

    public String ask(String prompt) {

    try {

        String requestBody = """
        {
          "model":"llama3.2:1b",
          "prompt":%s,
          "stream":false
        }
        """.formatted("\"" + prompt.replace("\"", "\\\"").replace("\n", "\\n") + "\"");

        String response = webClient.post()
                .uri("/api/generate")
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(response);

        return json.get("response").asText();

    } catch (Exception e) {
        e.printStackTrace();
        return e.getMessage();
    }
}
}