package com.globetouch.iotsmp.dto;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.globetouch.iotsmp.model.OsTicket;
import lombok.Data;

@Data
public class OsTicketDTOUtil {


    @JsonPOJOBuilder
    public static class Builder {
        public OsTicketDTO buildFromEntity(OsTicket entity) {
            OsTicketDTO dto = new OsTicketDTO();
            dto.setTicketId(entity.getTicketId());
            dto.setTitle(entity.getTitle());
            dto.setCategory(entity.getCategory());
            dto.setSubCategory(entity.getSubCategory());
            dto.setImsi(entity.getImsi());
            dto.setAccountId(entity.getAccountId());
            dto.setClosedDate(entity.getClosedDate());
            dto.setCreatedBy(entity.getCreatedBy());
            dto.setCreationDate(entity.getCreationDate());
            dto.setMsisdn(entity.getMsisdn());
            dto.setResolutionDate(entity.getResolutionDate());
            dto.setSeverity(entity.getSeverity());
            dto.setStatus(entity.getStatus());
            return dto;
        }
    }
}
