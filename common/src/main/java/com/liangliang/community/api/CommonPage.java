package com.liangliang.community.api;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Liangliang
 * @date 2020/4/27
 * @desc
 */
public class CommonPage<T> {
    /**
     * 当前页数
     */
    private Integer pageNum;
    /**
     * 页条数
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 总条数
     */
    private Long total;
    /**
     * 数据
     */
    private List<T> list;

    public static <T> CommonPage<T> restPage(List<T> list) {
        CommonPage<T> commonPage = new CommonPage<>();
        PageInfo<T> pageInfo = new PageInfo<>(list);
        commonPage.setTotalPage(pageInfo.getPages());
        commonPage.setPageNum(pageInfo.getPageNum());
        commonPage.setPageSize(pageInfo.getPageSize());
        commonPage.setTotal(pageInfo.getTotal());
        commonPage.setList(pageInfo.getList());
        return commonPage;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
