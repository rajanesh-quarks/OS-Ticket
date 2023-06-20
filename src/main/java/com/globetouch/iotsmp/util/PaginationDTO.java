package com.globetouch.iotsmp.util;

import java.util.List;

public class PaginationDTO<E> {

    public int pageNumber;
    public int pageSize;
    public long totalCount;
    public int totalPage;
    public List<E> values;


}
