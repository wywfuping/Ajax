package com.yawei.util;

import java.util.List;

public class Page<T> {
    private Integer movieTotal;//总记录数
    private Integer pageTotal;//总页数
    private Integer currentPage;//当前页码
    private Integer num;//每页可以显示的记录数量
    private Integer start;//每页的起始位置
    private List<T> items;//当前页的数据

    public Page(Integer currentPage, Integer num, Integer movieTotal) {
        this.currentPage = currentPage;
        this.num = num;
        this.movieTotal = movieTotal;

        pageTotal = movieTotal / num;
        if (movieTotal % num != 0) {
            pageTotal++;
        }

        if (currentPage > pageTotal) {
            this.currentPage = pageTotal;
        }

        if (currentPage <= 0) {
            this.currentPage = 1;
        }

        start = (this.currentPage - 1) * num;
    }

    public void setItems(List<T> items){
        this.items=items;
    }

    public Integer getMovieTotal() {
        return movieTotal;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Integer getNum() {
        return num;
    }

    public Integer getStart() {
        return start;
    }

    public List<T> getItems() {
        return items;
    }
}
