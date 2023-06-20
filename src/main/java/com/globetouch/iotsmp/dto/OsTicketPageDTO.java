package com.globetouch.iotsmp.dto;

import com.globetouch.iotsmp.model.OsTicket;
import com.globetouch.iotsmp.util.PaginationDTO;

import java.util.ArrayList;
import java.util.List;

public class OsTicketPageDTO extends PaginationDTO<OsTicketDTO> {

    private OsTicketPageDTO(int pageNumber, int pageSize, long totalCount, List<OsTicketDTO> values) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = totalCount == 0 ? 0 : (int) Math.ceil((double) totalCount / pageSize);
        this.values = values;
    }

    public static OsTicketPageDTO entity2DTO(PaginationDTO<OsTicket> entity) {
        final OsTicketPageDTO.Builder builder = new OsTicketPageDTO.Builder();
        builder.withPageNum(entity.pageNumber).withPageSize(entity.pageSize)
                .withTotalCount(entity.totalCount);
        entity.values.forEach(e -> {
            try {
                builder.addValue(new OsTicketDTOUtil.Builder().buildFromEntity(e));
            } catch (Exception e1) {

            }
        });
        return builder.build();
    }

    public static class Builder {
        private int pageNumber;
        private int pageSize;
        private long totalCount;
        private List<OsTicketDTO> values = new ArrayList<OsTicketDTO>();

        public OsTicketPageDTO.Builder withPageNum(int pageNumber) {
            this.pageNumber = pageNumber;
            return this;
        }

        public OsTicketPageDTO.Builder withPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public OsTicketPageDTO.Builder withTotalCount(long totalCount) {
            this.totalCount = totalCount;
            return this;
        }

        public OsTicketPageDTO.Builder withValues(List<OsTicketDTO> values) {
            this.values.addAll(values);
            return this;
        }

        public OsTicketPageDTO.Builder addValue(OsTicketDTO value) {
            this.values.add(value);
            return this;
        }

        public OsTicketPageDTO build() {
            return new OsTicketPageDTO(pageNumber, pageSize, totalCount, values);
        }
    }
}
