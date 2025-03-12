package caliciudaddeportiva.service.impl;

import caliciudaddeportiva.micellaneus.dto.EmailRequestDto;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import java.util.Base64;

@Service
public class EmailService {
    public ResponseEntity<String> sendEmail(EmailRequestDto request) {
        String API_URL = "https://passtrackid.ipzmarketing.com/api/v1/send_emails";
        String AUTH_TOKEN = "uq9_Ny3YzqTHstKxHGSvJ31MGA9sLz9BJx2EydLy";

        RestTemplate restTemplate = new RestTemplate();

        // Leer la imagen y convertirla a Base64
        String imageBase64 = encodeImageToBase64("src/main/resources/static/run_centro_5k_final.png");

        // Cuerpo del email
        Map<String, Object> emailData = new HashMap<>();
        emailData.put("from", Map.of("email", "contacto@passtrackid.com", "name", "Carrera Run Centro 5k"));
        emailData.put("to", List.of(Map.of("email", request.getToEmail(), "name", request.getFullName())));
        emailData.put("subject", "Confirmación de inscripción a Carrera Run Centro 5k");
        emailData.put("html_part",
                "<html>" +
                        "<body style='font-family: Arial, sans-serif; color: #333;'>" +
                        "<p>Hola <strong>" + request.getFullName() + "</strong>,</p>" +
                        "<p>¡Gracias por inscribirte en la <strong>Carrera Run Centro 5K</strong>! Estamos emocionados de que te unas a este gran evento.</p>" +
                        "<p>A continuación, te compartimos la información clave para que no te pierdas ningún detalle:</p>" +
                        "<h4 style='margin-top: 20px;'>📅 Entrega de Kits</h4>" +
                        "<ul>" +
                        "<li><strong>Fecha:</strong> Sábado, 15 de marzo</li>" +
                        "<li><strong>Horario:</strong> 8:00 a.m. a 5:00 p.m.</li>" +
                        "<li><strong>Lugar:</strong> Coliseo de Hockey - Miguel Calero</li>" +
                        "<li><strong>Dirección:</strong> Calle 9 con Carrera 39</li>" +
                        "</ul>" +
                        "<p>En el punto de entrega recibirás tu kit de participación e información clave para que disfrutes al máximo.</p>" +
                        "<p>Si tienes alguna pregunta, no dudes en contactarnos.</p>" +
                        "<p>Saludos cordiales,</p>" +
                        "<p><strong>Equipo de la Carrera Run Centro 5K</strong></p>" +
                        "</body>" +
                        "</html>");
        emailData.put("text_part_auto", true);

        // Adjuntar la imagen
        Map<String, Object> imageAttachment = new HashMap<>();
        imageAttachment.put("file_name", "run_centro_5k.png");
        imageAttachment.put("content", imageBase64);
        imageAttachment.put("content_type", "image/png");
        imageAttachment.put("content_id", "");

        emailData.put("attachments", List.of(imageAttachment));

        // Configurar headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-auth-token", AUTH_TOKEN);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(emailData, headers);

        // Enviar la solicitud HTTP POST
        return restTemplate.exchange(API_URL, HttpMethod.POST, entity, String.class);
    }

    private String encodeImageToBase64(String imagePath) {
        try {
            byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
            return Base64.getEncoder().encodeToString(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
