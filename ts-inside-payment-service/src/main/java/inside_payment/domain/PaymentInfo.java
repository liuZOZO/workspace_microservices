package inside_payment.domain;

/**
 * Created by Administrator on 2017/6/20.
 */
public class PaymentInfo {
    public PaymentInfo(){}

    private String orderId;
    private String tripId;
    private String userId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
