package other.service;

import other.domain.*;
import java.util.ArrayList;
import java.util.UUID;

public interface OrderOtherService {

    Order findOrderById(UUID id);

    CreateOrderResult create(Order newOrder);

    ChangeOrderResult saveChanges(Order order);

    CancelOrderResult cancelOrder(CancelOrderInfo coi);

    ArrayList<Order> queryOrders(QueryInfo qi);

    OrderAlterResult alterOrder(OrderAlterInfo oai);

    CalculateSoldTicketResult queryAlreadySoldOrders(CalculateSoldTicketInfo csti);

    QueryOrderResult getAllOrders();

    ModifyOrderResult modifyOrder(ModifyOrderInfo info);

}