/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Administrator
 */
public class Bai2 {

    public interface OrderState {
    void confirmOrder(Order order);
    void shipOrder(Order order);
    void deliverOrder(Order order);
    void cancelOrder(Order order);
}
    public static class CreatedState implements OrderState {
    @Override
    public void confirmOrder(Order order) {
        order.setState(new ConfirmedState());
        System.out.println("Order confirmed.");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Cannot ship order in the Created state.");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Cannot deliver order in the Created state.");
    }

    @Override
    public void cancelOrder(Order order) {
        order.setState(new CancelledState());
        System.out.println("Order cancelled.");
    }
}
    public static class ConfirmedState implements OrderState {
    @Override
    public void confirmOrder(Order order) {
        System.out.println("Order is already confirmed.");
    }

    @Override
    public void shipOrder(Order order) {
        order.setState(new ShippedState());
        System.out.println("Order shipped.");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Cannot deliver order in the Confirmed state.");
    }

    @Override
    public void cancelOrder(Order order) {
        order.setState(new CancelledState());
        System.out.println("Order cancelled.");
    }
}
    public static class ShippedState implements OrderState {
    @Override
    public void confirmOrder(Order order) {
        System.out.println("Cannot confirm order in the Shipped state.");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Order is already shipped.");
    }

    @Override
    public void deliverOrder(Order order) {
        order.setState(new DeliveredState());
        System.out.println("Order delivered.");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Cannot cancel order in the Shipped state.");
    }
}
    public static class DeliveredState implements OrderState {
    @Override
    public void confirmOrder(Order order) {
        System.out.println("Cannot confirm order in the Delivered state.");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Cannot ship order in the Delivered state.");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Order is already delivered.");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Cannot cancel order in the Delivered state.");
    }
}
    public static class CancelledState implements OrderState {
    @Override
    public void confirmOrder(Order order) {
        System.out.println("Cannot confirm order in the Cancelled state.");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Cannot ship order in the Cancelled state.");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Cannot deliver order in the Cancelled state.");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Order is already cancelled.");
    }
}
    public static class Order {
    private OrderState state;

    public Order() {
        this.state = new CreatedState(); // Trạng thái ban đầu là Created
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void confirmOrder() {
        state.confirmOrder(this);
    }

    public void shipOrder() {
        state.shipOrder(this);
    }

    public void deliverOrder() {
        state.deliverOrder(this);
    }

    public void cancelOrder() {
        state.cancelOrder(this);
    }

    public String getState() {
        return state.getClass().getSimpleName();
    }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Order order = new Order();
        System.out.println(order.getState()); // Output: CreatedState
        order.confirmOrder();                 // Output: Order confirmed.
        System.out.println(order.getState()); // Output: ConfirmedState
        order.shipOrder();                    // Output: Order shipped.
        System.out.println(order.getState()); // Output: ShippedState
        order.deliverOrder();                 // Output: Order delivered.
        System.out.println(order.getState()); // Output: DeliveredState
        order.cancelOrder();                  // Output: Cannot cancel order in the Delivered state.
    }
}