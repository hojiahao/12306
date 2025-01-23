package cn.edu.szu.train.common.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public class PageRequest {
    @NotNull(message = "页码不能为空")
    private Integer page;

    @NotNull(message = "每条页数不能为空")
    @Max(value = 100, message = "每条页数不能超过100")
    private Integer pageSize;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PageRequest{");
        sb.append("page=").append(page);
        sb.append(", pageSize=").append(pageSize);
        sb.append('}');
        return sb.toString();
    }
}
