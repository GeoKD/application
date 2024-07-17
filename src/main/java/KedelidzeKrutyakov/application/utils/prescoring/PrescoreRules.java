package KedelidzeKrutyakov.application.utils.prescoring;

class PrescoreRules {
    public static int MIN_AMOUNT = 10000;
    public static int MIN_TERM = 6;
    public static int MIN_AGE = 18;
    public static String FIO_PATTERN = "^[A-Z][a-z]{1,29}$";
    public static String PASSPORT_SERIES_PATTERN = "^[\\d]{4}$";
    public static String PASSPORT_NUMBER_PATTERN = "^[\\d]{6}$";
    public static String EMAIL_PATTERN = "^[\\w\\.]{2,50}@[\\w\\.]{2,20}$";
}
