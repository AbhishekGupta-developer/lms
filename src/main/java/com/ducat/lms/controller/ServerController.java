package com.ducat.lms.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@RestController
@RequestMapping("/")
public class ServerController {

    @GetMapping
    public ResponseEntity<?> checkServerHealth() {
        ServerStatus serverStatus = new ServerStatus();
        return new ResponseEntity<>(serverStatus, HttpStatusCode.valueOf(200));
    }

    class ServerStatus {
        private LocalDateTime currentDateTime = LocalDateTime.now();
        private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        public String status = "Server is live!";
        public String date = currentDateTime.format(dateFormatter);
        public String time = currentDateTime.format(timeFormatter);
        public String timeZoneId = TimeZone.getDefault().getID();
    }
}
