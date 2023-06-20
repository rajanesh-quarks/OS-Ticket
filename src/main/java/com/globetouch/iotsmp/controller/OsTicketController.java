package com.globetouch.iotsmp.controller;

import org.apache.commons.io.IOUtils;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/osticket", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class OsTicketController {
    @GetMapping("/api/v1/ticket")
    public String getTicket(HttpServletRequest request) {
    	log.info("Inside getTicket");
        try {
           // verifyContext(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ticket response";
    }

    private void verifyContext(HttpServletRequest request) throws Exception {
    	log.info("Inside verify context");
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/api/v2/token/verification");
        httpGet.addHeader("request_token", request.getHeader("request_token"));
        CloseableHttpResponse response = httpclient.execute(httpGet);
        try {
            StatusLine statusLine = response.getStatusLine();
            if (statusLine == null || statusLine.getStatusCode() != 200) {
                throw new Exception(
                        "token not verified " + statusLine.getStatusCode());
            }
            String msg = IOUtils.toString(response.getEntity().getContent());
            System.out.println("response: "+msg);
        } finally {
            if (response != null)
                response.close();
        }

    }

}
