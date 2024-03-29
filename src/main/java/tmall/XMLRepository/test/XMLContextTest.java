package tmall.XMLRepository.test;

import tmall.XMLRepository.ProxyXmlContext;
import tmall.XMLRepository.XMLContext;
import tmall.model.entity.Buyer;

import java.util.List;

public class XMLContextTest {

    public static void main(String[] args) {

        // 订单XML数据库上下文，你可以通过对订单数据进行操作
        XMLContext<OrderTest> xmlContext = new ProxyXmlContext<>(OrderTest.class);

        OrderTest order1 = new OrderTest();
        order1.setOrderTestId("00001");
        order1.setAddressId("00001");
        order1.setBuyerId("00001");
        order1.setShopId("00001");
        order1.setOrderAmount("3");
        order1.setCreateDate("2021-10-21");
        order1.setStatus("已签收");

        OrderTest order2 = new OrderTest("00002", "00002", "00002", "00002", "2021-10-22", "已发送", "2");

        // sava test
        xmlContext.save(order1, order2);


//        XMLContext<Buyer> buyerXMLContext = new ProxyXmlContext<>(Buyer.class);
//        Buyer buyer = new Buyer();
//        buyerXMLContext.save(buyer);


        // findById test
        System.out.println("============ findById Test ============");
        OrderTest orderFindById = xmlContext.findById("00002");
        System.out.println(orderFindById.toString());


        // init test
        System.out.println("============ init Test ============");
        List<OrderTest> orderList = xmlContext.init(OrderTest.class);
        for (OrderTest orderTest : orderList) {
            System.out.println(orderTest.toString());
        }


        // deleteById test
        System.out.println("============ deleteById Test ============");
        xmlContext.deleteById("00001");
        List<OrderTest> orderListAfterDelete = xmlContext.init(OrderTest.class);
        for (OrderTest order : orderListAfterDelete) {
            System.out.println(order.toString());
        }
    }

}
