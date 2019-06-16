package com.xiaoquan.compus.entity;

public class Pagination {

    private int totalCount;
    private int pageSize = 3;
    private int pageCount;
    private int currentPage;

    private int offset;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        totalCount = totalCount < 0 ? 0 : totalCount;
        int pgCount = totalCount / pageSize;
        return totalCount % pageSize == 0 ? pgCount : pgCount+1;
    }

    public int getOffset() {
        int offset =  (currentPage-1)*pageSize;
        return offset;
    }
}
