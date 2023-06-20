package com.globetouch.iotsmp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OsTicketDTO {
    private Long ticketId;
    private String title;
    private String category;
    private String subCategory;
    private String imsi;
    private String msisdn;
    private String accountId;
    private Date creationDate;
    private Date resolutionDate;
    private Date closedDate;
    private String createdBy;
    private String severity;
    private String status;
}
