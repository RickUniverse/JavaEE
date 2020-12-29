package com.book.pojo;

import java.util.List;

/**
 * 分页的pagebean
 * T 表示具体分页的javabean
 * @author lijichen
 * @date 2020/10/15 - 14:19
 */
public class Page<T> {
    //每页显示条数
    public static final Integer PAGE_SIZE = 3;
    //当前页
    private Integer pageNo;
    //每页条数
    private Integer pageSize = PAGE_SIZE;
    //总记录数
    private Integer pageTotalCount;
    //总页数
    private Integer pageTotal;

    //下一页
    private Integer nextPage;
    //上一页
    private Integer prePage;

    //当前分页的集合
    private List<T> items;

    //连接的servlet地址
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", pageTotal=" + pageTotal +
                ", nextPage=" + nextPage +
                ", prePage=" + prePage +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }

    public Integer getNextPage() {
        return this.nextPage = this.pageNo >= this.pageTotal ? this.pageTotal : this.pageNo+1;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getPrePage() {
        return this.prePage = this.pageNo <= 1 ? 1 : this.pageNo-1;
    }

    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }
    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageNo > this.pageTotal) {
            pageNo = this.pageTotal;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
