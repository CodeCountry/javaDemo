package com.example.demo.fullDemo.pojos;

import java.util.List;

public class Page<T> {
    private Integer pageNow;//当前页数
    //	private Integer pageCount;总页数
    private Integer rowCount;//总行数
    private Integer pageSize;//每一页行数
    private List<T> pageRow;//当前页表格数据

    public Page() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Page(Integer pageNow,Integer rowCount, Integer pageSize, List<T> pageRow) {
        super();
        this.pageNow = pageNow;
        this.rowCount = rowCount;
        this.pageSize = pageSize;
        this.pageRow = pageRow;
    }

    public Integer getPageNow() {
        return pageNow;
    }
    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }
    public Integer getPageCount() {
        Integer pageCount = rowCount%pageSize==0?rowCount/pageSize:(rowCount/pageSize+1);
        return pageCount;
    }
    /*public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }*/
    public Integer getRowCount() {
        return rowCount;
    }
    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public List<T> getpageRow() {
        return pageRow;
    }
    public void setpageRow(List<T> pageRow) {
        this.pageRow = pageRow;
    }

}
