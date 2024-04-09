package emart.pojo;

public class OrderPojo {
    private String orderId;
    private String productId;
    private int quantity;
    private String userId;

    public OrderPojo() {
    }

    public OrderPojo(String orderId, String productId, int quantity, String userId) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
