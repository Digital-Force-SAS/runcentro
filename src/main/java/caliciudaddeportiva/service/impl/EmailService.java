package caliciudaddeportiva.service.impl;

import caliciudaddeportiva.micellaneus.dto.EmailRequestDto;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import caliciudaddeportiva.micellaneus.dto.EmailRequestDto;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

import java.io.ByteArrayOutputStream;
import java.util.*;

import java.util.Base64;

@Service
public class EmailService {
    public ResponseEntity<String> sendEmail(EmailRequestDto request) {
        String API_URL = "https://passtrackid.ipzmarketing.com//api/v1/send_emails";
        String AUTH_TOKEN = "uq9_Ny3YzqTHstKxHGSvJ31MGA9sLz9BJx2EydLy";
        RestTemplate restTemplate = new RestTemplate();

        // Generar el PDF y convertirlo a Base64
        String pdfBase64 = generatePdf(request);

        // Cuerpo del email
        Map<String, Object> emailData = new HashMap<>();
        emailData.put("from", Map.of("email", "contacto@passtrackid.com", "name", "Carrera Centro Run 5k 2025"));
        emailData.put("to", List.of(Map.of("email", request.getToEmail(), "name", request.getFullNameMenor())));
        emailData.put("subject", "Bienvenido a la Carrera Centro Run 5k 2025");
        emailData.put("html_part", "<html><body><p>Felicidades, " + request.getFullNameMenor() +
                ", te inscribiste exitosamente a la carrera Run Centro 5K. </p>" +
                "<p>A continuación dejamos la programación del sábado 15 y domingo 16 de marzo de 2025.</p></body></html>");
        emailData.put("text_part_auto", true);

        // Adjuntar el PDF
        Map<String, Object> pdfAttachment = new HashMap<>();
        pdfAttachment.put("file_name", "Confirmacion_Registro.pdf");
        pdfAttachment.put("content", pdfBase64);
        pdfAttachment.put("content_type", "application/pdf");
        pdfAttachment.put("content_id", "");

        emailData.put("attachments", List.of(pdfAttachment));

        // Configurar headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-auth-token", AUTH_TOKEN);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(emailData, headers);

        // Enviar la solicitud HTTP POST
        return restTemplate.exchange(API_URL, HttpMethod.POST, entity, String.class);
    }

    private String generatePdf(EmailRequestDto request) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(baos);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf, PageSize.LETTER);

            // Ruta de la imagen de la boleta (debe estar en resources/static)
            String imagePath = "src/main/resources/static/boleta.png";

            // Cargar la imagen
            ImageData imageData = ImageDataFactory.create(imagePath);
            Image image = new Image(imageData);
            image.scaleToFit(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());
            image.setFixedPosition(0, 0);

            // Agregar la imagen como fondo
            document.add(image);

            // Agregar los datos sobre la boleta
            // String adultName = request.getFullNameAdulto();
            String minorName = request.getFullNameMenor();
           /* document.add(new Paragraph(adultName)
                    .setFontSize(18)
                    .setBold()
                    .setFixedPosition(300, 445, 400)); // Convertido desde (250, 310) del frontend*/

            document.add(new Paragraph(minorName)
                    .setFontSize(18)
                    .setBold()
                    .setFixedPosition(300, 410, 400)); // Convertido desde (250, 20) del frontend

            document.add(new Paragraph(request.getCode())
                    .setFontSize(18)
                    .setBold()
                    .setFixedPosition(300, 380, 400)); // Convertido desde (250, 23) del frontend

            document.close();

            // Convertir el PDF a Base64
            return Base64.getEncoder().encodeToString(baos.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
/*public class EmailService {
    public ResponseEntity<String> sendEmail(EmailRequestDto request) {
        String API_URL = "https://passtrackid.ipzmarketing.com//api/v1/send_emails";
        String AUTH_TOKEN = "uq9_Ny3YzqTHstKxHGSvJ31MGA9sLz9BJx2EydLy";
        RestTemplate restTemplate = new RestTemplate();

        // Generar el PDF y convertirlo a Base64
        String pdfBase64 = generatePdf(request);

        // Cuerpo del email
        Map<String, Object> emailData = new HashMap<>();
        emailData.put("from", Map.of("email", "contacto@passtrackid.com", "name", "Carrera Centro Run 5k 2025"));
        emailData.put("to", List.of(Map.of("email", request.getToEmail(), "name", request.getFullNameMenor())));
        emailData.put("subject", "Bienvenido a la Carrera Centro Run 5k 2025");
        emailData.put("html_part", "<html><body><p>Felicidades, " + request.getFullNameMenor() +
                ", te inscribiste exitosamente a la carrera Run Centro 5K. </p>" +
                "<p>A continuación dejamos la programación del sábado 15 y domingo 16 de marzo de 2025.</p></body></html>");
        emailData.put("text_part_auto", true);

        // Adjuntar el PDF
        Map<String, Object> pdfAttachment = new HashMap<>();
        pdfAttachment.put("file_name", "Confirmacion_Registro.pdf");
        pdfAttachment.put("content", pdfBase64);
        pdfAttachment.put("content_type", "application/pdf");
        pdfAttachment.put("content_id", "");

        emailData.put("attachments", List.of(pdfAttachment));

        // Configurar headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-auth-token", AUTH_TOKEN);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(emailData, headers);

        // Enviar la solicitud HTTP POST
        return restTemplate.exchange(API_URL, HttpMethod.POST, entity, String.class);
    }

    private String generatePdf(EmailRequestDto request) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(baos);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf, PageSize.LETTER);

            // Ruta de la imagen de la boleta (debe estar en resources/static)
            String imagePath = "src/main/resources/static/boleta.png";

            // Cargar la imagen
            ImageData imageData = ImageDataFactory.create(imagePath);
            Image image = new Image(imageData);
            image.scaleToFit(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());
            image.setFixedPosition(0, 0);

            // Agregar la imagen como fondo
            document.add(image);

            // Agregar los datos sobre la boleta
            // String adultName = request.getFullNameAdulto();
            String minorName = request.getFullNameMenor();
           *//* document.add(new Paragraph(adultName)
                    .setFontSize(18)
                    .setBold()
                    .setFixedPosition(300, 445, 400)); // Convertido desde (250, 310) del frontend*//*

            document.add(new Paragraph(minorName)
                    .setFontSize(18)
                    .setBold()
                    .setFixedPosition(300, 410, 400)); // Convertido desde (250, 20) del frontend

            document.add(new Paragraph(request.getCode())
                    .setFontSize(18)
                    .setBold()
                    .setFixedPosition(300, 380, 400)); // Convertido desde (250, 23) del frontend

            document.close();

            // Convertir el PDF a Base64
            return Base64.getEncoder().encodeToString(baos.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}*/
