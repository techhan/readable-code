package cleancode.mission.asis;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Day4 {
    public boolean validateOrder(Order order) {
        if(isOrderItemEmpty(order)) {
            log.info("주문 항목이 없습니다.");
            return false;
        }

        if(hasPrice(order)) {
            if (hasNoCustomerInfo(order)) {
                log.info("사용자 정보가 없습니다.");
                return false;
            }
                return true;
        }

        log.info("올바르지 않은 총 가격입니다.");
        return false;
    }

    private static boolean hasNoCustomerInfo(Order order) {
        return !order.hasCustomerInfo();
    }

    private static boolean hasPrice(Order order) {
        return order.getTotalPrice() > 0;
    }

    private static boolean isOrderItemEmpty(Order order) {
        return order.getItems().isEmpty();
    }
}

class Order {
    private final List<Item> orderItem = new ArrayList<>();
    private Customer customer;

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

}

class Item {
    private final String name;
    private final int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

class log {

    public static void info(String message) {
        System.out.println(message);
    }
}