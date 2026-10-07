package domain.exceptions;

public class EmptyOrderItemsException extends RuntimeException {
    public EmptyOrderItemsException() {
        System.out.println(
                "Order is empty."
        );
    }
}
