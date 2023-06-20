package com.globetouch.iotsmp.controller;

import com.globetouch.iotsmp.dto.OsTicketPageDTO;
import com.globetouch.iotsmp.service.OsTicketService;
import org.apache.commons.io.IOUtils;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/osticket", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class OsTicketController {

    @Autowired
    OsTicketService osTicketService;
    @GetMapping("/api/v1/tickets")
    public ResponseEntity<?> getTickets(HttpServletRequest request) {
    	log.info("Inside getTicket");
        try {
            OsTicketPageDTO ticketPageDTO = osTicketService.searchOsTickets();
            return new ResponseEntity<>(ticketPageDTO, HttpStatus.OK);
        }  catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
