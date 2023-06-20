package com.globetouch.iotsmp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OsTicket implements Serializable {
	
	private static final long serialVersionUID = -7376986323821421206L;

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
