package cn.edu.szu.train.common.response;

import java.io.Serializable;
import java.util.List;

public class PageResp<T> implements Serializable {
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
        final StringBuffer sb = new StringBuffer("PageResp{");
        sb.append("total=").append(total);
        sb.append(", rows=").append(rows);
        sb.append('}');
        return sb.toString();
    }
}
