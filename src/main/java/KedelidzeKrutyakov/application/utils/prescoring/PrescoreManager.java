package KedelidzeKrutyakov.application.utils.prescoring;

import KedelidzeKrutyakov.application.api.DTO.LoanApplicationRequestDTO;
import KedelidzeKrutyakov.application.api.DTO.PrescoringExceptionResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrescoreManager {

    private static final Pattern fioPattern = Pattern.compile(PrescoreRules.FIO_PATTERN);

    private static final Pattern emailPattern = Pattern.compile(PrescoreRules.EMAIL_PATTERN);

    private static final Pattern passportSeriesPattern =
            Pattern.compile(PrescoreRules.PASSPORT_SERIES_PATTERN);

    private static final Pattern passportNumberPattern
            = Pattern.compile(PrescoreRules.PASSPORT_NUMBER_PATTERN);

    private static PrescoringExceptionResponse possibleResponse;

    static public void prescoreLoanApplicationRequestDTO(
            LoanApplicationRequestDTO loanApplicationRequestDTO ) {

        possibleResponse = new PrescoringExceptionResponse();
        String middleName = loanApplicationRequestDTO.getMiddleName();

        prescoreAmount(loanApplicationRequestDTO.getAmount());
        prescoreTerm(loanApplicationRequestDTO.getTerm());
        prescoreFirstName(loanApplicationRequestDTO.getFirstName());
        prescoreLastName(loanApplicationRequestDTO.getLastName());
        if (!middleName.isBlank()) prescoreMiddleName(middleName);
        prescoreEmail(loanApplicationRequestDTO.getEmail());
        prescoreBirthDate(loanApplicationRequestDTO.getBirthDate());
        prescorePassportSeries(loanApplicationRequestDTO.getPassportSeries());
        prescorePassportNumber(loanApplicationRequestDTO.getPassportNumber());

        if (!possibleResponse.getErrors().isEmpty()) {
            throw new PrescoringException(possibleResponse);
        }
    }

    private static void prescoreAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.valueOf(PrescoreRules.MIN_AMOUNT)) <= 0) {
            possibleResponse.getErrors().add(
                    "Value of amount must be greater then " + PrescoreRules.MIN_AMOUNT);
        }
    }

    private static void prescoreTerm(Integer term) {
        if (term < PrescoreRules.MIN_TERM) {
            possibleResponse.getErrors().add(
                    "Value of term must be greater then " + PrescoreRules.MIN_TERM);
        }
    }

    private static void prescoreFirstName(String firstName) {
        Matcher matcher = fioPattern.matcher(firstName);
        if (!matcher.matches()) {
            possibleResponse.getErrors().add(
                    "First name must contain 2-30 letters, and start with capital letter");
        }
    }

    private static void prescoreLastName(String lastName) {
        Matcher matcher = fioPattern.matcher(lastName);
        if (!matcher.matches()) {
            possibleResponse.getErrors().add(
                    "Last name must contain 2-30 letters, and start with capital letter");
        }
    }

    private static void prescoreMiddleName(String middleName) {
        Matcher matcher = fioPattern.matcher(middleName);
        if (!matcher.matches()) {
            possibleResponse.getErrors().add(
                    "Middle name must contain 2-30 letters, and start with capital letter");
        }
    }

    private static void prescoreEmail(String email) {
        Matcher matcher = emailPattern.matcher(email);
        if (!matcher.matches()) {
            possibleResponse.getErrors().add( "Email is no valid" );
        }
    }

    private static void prescoreBirthDate(LocalDate birthDate) {
        LocalDate minBirthDate = LocalDate.now().minusYears(PrescoreRules.MIN_AGE);
        if(birthDate.isAfter(minBirthDate)) {
            possibleResponse.getErrors().add( "Client must be 18 y.o. or greater" );
        }
    }

    private static void prescorePassportSeries(String passportSeries) {
        Matcher matcher = passportSeriesPattern.matcher(passportSeries);
        if(!matcher.matches()) {
            possibleResponse.getErrors().add( "Passport series must consist of 4 digits" );
        }
    }

    private static void prescorePassportNumber(String passportNumber) {
        Matcher matcher = passportNumberPattern.matcher(passportNumber);
        if(!matcher.matches()) {
            possibleResponse.getErrors().add( "Passport number must consist of 6 digits" );
        }
    }
}
