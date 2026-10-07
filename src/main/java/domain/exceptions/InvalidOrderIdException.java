package domain.exceptions;

public class InvalidOrderIdException extends RuntimeException {
    public InvalidOrderIdException() {
        System.out.println(
                "Order id invalid, it has to be greater than 0."
        );

    }
}
