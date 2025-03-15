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

        return null;
    }};
