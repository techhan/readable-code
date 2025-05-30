package cleancode.mission.day4;

import java.util.ArrayList;
import java.util.List;


public class Day4 {
    public void run() {
        System.out.println("======= 시작 =======");

        Order order1 = new Order();
        validateOrder(order1); // "주문 항목이 없습니다."

        Order order2 = new Order();
        Item item = new Item(1000);
        order2.setItem(item);
        validateOrder(order2); // "사용자 정보가 없습니다."

        Order order3 = new Order();
        Item item2 = new Item(-10);
        order3.setCustomer(new Customer("id3"));
        order3.setItem(item2);
        validateOrder(order3);// "올바르지 않은 총 가격입니다."

        Order order4 = new Order();
        Item item4 = new Item(1000);
        order4.setCustomer(new Customer("id4"));
        order4.setItem(item4);
        validateOrder(order4); // "유효성 검사를 통과했습니다."

    }

    public boolean validateOrder(Order order) {
        try {
            isOrderItemsEmpty(order);
            isCustomerInfoEmpty(order);
            isTotalPricePositive(order);

            System.out.println("유효성 검사를 통과했습니다.");
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void isCustomerInfoEmpty(Order order) {
        if(!order.hasCustomerInfo()) {
            throw new IllegalArgumentException("사용자 정보가 없습니다.");
        }
    }

    private static void isTotalPricePositive(Order order) {
        if(order.getTotalPrice() < 0) {
            throw new IllegalArgumentException("올바르지 않은 총 가격입니다.");
        }
    }

    private static void isOrderItemsEmpty(Order order) {
        if(order.getItems().isEmpty()) {
            throw new IllegalArgumentException("주문 항목이 없습니다.");
        }
    }
}

class Order {
    private final List<Item> orderItem = new ArrayList<>();
    private Customer customer;

    public void setItem(Item item) {
        orderItem.add(item);
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return orderItem;
    }

    public int getTotalPrice() {
        int totalPrice = 0;

        for(Item item : orderItem) {
            totalPrice += item.getPrice();
        }

        return totalPrice;
    }

    public boolean hasCustomerInfo() {
        return customer != null;
    }
}

class Customer {
    private String id;

    public Customer(String id) {
        this.id = id;
    }

}

class Item {
    private final int price;

    public Item(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}