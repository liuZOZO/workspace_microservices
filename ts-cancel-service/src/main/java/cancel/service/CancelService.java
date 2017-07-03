package cancel.service;

import cancel.domain.CalculateRefundResult;
import cancel.domain.CancelOrderInfo;
import cancel.domain.CancelOrderResult;

public interface CancelService {

    CancelOrderResult cancelOrder(CancelOrderInfo info,String loginToken);

    CalculateRefundResult calculateRefund(CancelOrderInfo info);

}
