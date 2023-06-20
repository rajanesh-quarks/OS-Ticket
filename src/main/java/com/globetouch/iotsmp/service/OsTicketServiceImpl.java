package com.globetouch.iotsmp.service;

import com.globetouch.iotsmp.dto.OsTicketPageDTO;
import com.globetouch.iotsmp.model.OsTicket;
import com.globetouch.iotsmp.util.PaginationDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class OsTicketServiceImpl implements OsTicketService {

    @Override
    public OsTicketPageDTO searchOsTickets() {
        OsTicketPageDTO tickets = this.getMockTickets();
        return tickets;
    }

    private OsTicketPageDTO getMockTickets() {
        List<OsTicket> list = new ArrayList<OsTicket>();
        OsTicket ticket1 = new OsTicket();
        ticket1.setTicketId(123456L);
        ticket1.setTitle("Device not working");
        ticket1.setCategory("Platform_issue");
        ticket1.setSubCategory("SIM ordering");
        ticket1.setAccountId("S3_buadmin_imsis");
        ticket1.setImsi("375918739374583");
        ticket1.setMsisdn("756818739374210");
        ticket1.setCreationDate(new Date());
        ticket1.setClosedDate(new Date());
        ticket1.setResolutionDate(new Date());
        ticket1.setCreatedBy("KSA");
        ticket1.setSeverity("Low");
        ticket1.setStatus("Open");
        list.add(ticket1);

        OsTicket ticket2 = new OsTicket();
        ticket2.setTicketId(342589L);
        ticket2.setTitle("Account Lock");
        ticket2.setCategory("Billing_Dispute");
        ticket2.setSubCategory("Billing Dispute");
        ticket2.setAccountId("S3_buadmin_imsis");
        ticket2.setImsi("375918739377582");
        ticket2.setMsisdn("756818739375297");
        ticket2.setCreationDate(new Date());
        ticket2.setClosedDate(new Date());
        ticket2.setResolutionDate(new Date());
        ticket2.setCreatedBy("KSA");
        ticket2.setSeverity("Medium");
        ticket2.setStatus("Re-Open");
        list.add(ticket2);


        PaginationDTO<OsTicket> page = new PaginationDTO<OsTicket>();
        page.pageNumber = 0;
        page.pageSize = 10;
        page.totalPage = 1;
        page.totalCount = 2;
        page.values = list;
        return OsTicketPageDTO.entity2DTO(page);
    }


}
