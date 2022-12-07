import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String iBan = "AT022050302101023600";
       IbanValidationService test = new IbanValidationService(iBan);
        System.out.println(test.getCheckSum());
        System.out.println(test.getCountryCode());
        System.out.println(test.getAccountNumber());
        System.out.println(test.getFullCode());
        int[] arr = IbanValidationService.buildArray();
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println(test.calcCheckSum());
        System.out.println(test.isIbanCorrect());
    }
}