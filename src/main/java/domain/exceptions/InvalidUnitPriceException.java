package domain.exceptions;

public class InvalidUnitPriceException extends RuntimeException {
    public InvalidUnitPriceException() {
      System.out.println(
              "Unit price invalid, it has to be greater or equal to 0."
      );
    }
}
