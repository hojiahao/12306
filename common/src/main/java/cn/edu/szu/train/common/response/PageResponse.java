package cn.edu.szu.train.common.response;

import java.io.Serializable;
import java.util.List;

public class PageResponse<T> implements Serializable {
    // 总条数
    private Long total;
    // 当前页的列表
    private List<T> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageResponse{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
