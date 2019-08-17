package utilities;

public class CreditCardChecker {

    private static final int STANDART_CREDIT_CARD_LENGTH = 27;
    private static final int NUMBER_OF_SECTIONS_IN_CREDIT_CARD = 3;
    private static final int STANDART_NUMBER_LENGTH_OF_CREDIT_CARD = 19;

    public static boolean isCorrectCardInfo(String cardInfo) {
        if (cardInfo.length() < STANDART_CREDIT_CARD_LENGTH) {
            return false;
        }
        if (cardInfo.split("[_]").length < NUMBER_OF_SECTIONS_IN_CREDIT_CARD) {
            return false;
        }
        String number = cardInfo.split("[_]")[0];
        String date = cardInfo.split("[_]")[1];
        String ccv = cardInfo.split("[_]")[2];
        if (number.length() < STANDART_NUMBER_LENGTH_OF_CREDIT_CARD) {
            return false;
        }
        return true;
    }
}
