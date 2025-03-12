package caliciudaddeportiva.controller;

import caliciudaddeportiva.micellaneus.dto.EmailRequestDto;
import caliciudaddeportiva.service.impl.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/send-email")
@CrossOrigin(origins = "*") // Ajusta según necesites
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequestDto emailRequest) {
        if (emailRequest.getToEmail() == null || emailRequest.getToName() == null) {
            return ResponseEntity.badRequest().body("{\"error\": \"Faltan parámetros obligatorios\"}");
        }

        return emailService.sendEmail(emailRequest);
    }
}
