package KedelidzeKrutyakov.application.api.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoanOfferDTO {
    private Long applicationId;
    private BigDecimal requestedAmount;
    private BigDecimal totalAmount;
    private Integer term;
    private BigDecimal monthlyPayment;
    private BigDecimal rate;
    private Boolean insuranceEnabled;
    private Boolean salaryClient;
}
