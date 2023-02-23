package com.springboot.live_comm.coding.leetcode.towyue;

public class PageQuery {
    // 分页大小
    private static final int pageSize = 100;
    // 页号
    private int pageNo;

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageNo() {
        return pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }
}