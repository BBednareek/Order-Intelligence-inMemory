package domain.exceptions;

public class InvalidCustomerIdException extends RuntimeException {
    public InvalidCustomerIdException() {
        System.out.println(
                "Customer id invalid, it cannot be neither empty nor contain only whitespaces."
        );
    }
}
