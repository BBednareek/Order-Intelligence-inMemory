package domain.exceptions;

public class InvalidQuantityCountException extends RuntimeException {
    public InvalidQuantityCountException() {
        System.out.println(
                "Quantity count invalid, it has to be greater than 0."
        );
    }
}
