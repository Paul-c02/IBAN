public class IbanValidationService {
    private static String iBan;
    private int calculatedChecksum;

    public IbanValidationService(String iBan) {
        this.iBan = iBan;
        this.calculatedChecksum = -1;
    }
    public static String getCountryCode(){
        return iBan.substring(0,2);
    }
    public int getCheckSum(){
        return Integer.valueOf(iBan.substring(2,4));
    }
    public static String getAccountNumber(){
        return iBan.substring(4,20);
    }
    public static String getCountryCodeNumber(){
        return "" + (getCountryCode().charAt(0) - 'A' + 10) + (getCountryCode().charAt(1) - 'A' + 10)*100;
    }
    public static String getFullCode(){
        return "" + getAccountNumber() + getCountryCodeNumber();
    }
    public static int[] buildArray(){
        String fullCode = getFullCode();
        int[] arr = new int[fullCode.length()];
        for (int i = 0; i < fullCode.length(); i++) {
            arr[i] = fullCode.charAt(i) - '0';
        }
        return arr;
    }
    public int calcCheckSum(){
        int[] arr = buildArray();
        int value = 0;
        for (int i = 0; i < arr.length; i++) {
            value = (10*value+arr[i])%97;
        }
        return 98-value;
    }
    public boolean isIbanCorrect(){
        if (getCheckSum() == calcCheckSum()) {
            return true;
        } else return false;
    }
}
