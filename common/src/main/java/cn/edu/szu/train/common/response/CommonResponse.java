package cn.edu.szu.train.common.response;

public class CommonResponse<T> {

    /**
     * 业务上的成功或失败
     */
    private boolean success = true;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回泛型数据，自定义类型
     */
    private T content;

    public CommonResponse() {
    }

    public CommonResponse(boolean success, String message, T content) {
        this.success = success;
        this.message = message;
        this.content = content;
    }

    // 静态工厂方法（错误响应）
    public static CommonResponse<Object> error(String message) {
        return new CommonResponse<>(false, message, null);
    }

    public CommonResponse(T content) {
        this.content = content;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CommonResponse{");
        sb.append("success=").append(success);
        sb.append(", message='").append(message).append('\'');
        sb.append(", content=").append(content);
        sb.append('}');
        return sb.toString();
    }
}
