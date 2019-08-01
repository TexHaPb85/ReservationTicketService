package utilities;

public class CreditCardChecker {
    public static boolean isCorrectCardInfo(String cardInfo) {
        if (cardInfo.length() < 27) {
            return false;
        }
        if (cardInfo.split("[_]").length < 3) {
            return false;
        }
        String number = cardInfo.split("[_]")[0];
        String date = cardInfo.split("[_]")[1];
        String ccv = cardInfo.split("[_]")[2];
        if (number.length() < 19) {
            return false;
        }
        return true;
    }
}
