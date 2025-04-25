package follow.com.demo;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class AnswerSender {

    public void sendAnswer(String webhook, String accessToken, Object answer) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);

        Map<String, Object> body = new HashMap<>();
        body.put("answer", answer);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        RestTemplate restTemplate = new RestTemplate();

        System.out.println("🛰 Sending to: " + webhook);
        System.out.println("🧾 Headers: " + headers);
        System.out.println("📦 Payload: " + body);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(webhook, request, String.class);
            System.out.println("📤 Sent answer to webhook. Status: " + response.getStatusCode());
            System.out.println("📨 Webhook response: " + response.getBody());
        } catch (HttpClientErrorException e) {
            System.out.println("❌ Failed to send answer: " + e.getStatusCode() + " " + e.getStatusText());
            System.out.println("🧾 Response body: " + e.getResponseBodyAsString());
        } catch (Exception e) {
            System.out.println("❌ Failed to send answer: " + e.getMessage());
        }
    }
}
