package KedelidzeKrutyakov.application.service;

import KedelidzeKrutyakov.application.api.DTO.LoanApplicationRequestDTO;
import KedelidzeKrutyakov.application.api.DTO.LoanOfferDTO;
import KedelidzeKrutyakov.application.api.feign.DealApi;
import KedelidzeKrutyakov.application.utils.prescoring.PrescoreManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final DealApi dealApi;

    public List<LoanOfferDTO> getLoanOffers(LoanApplicationRequestDTO loanApplicationRequestDTO) {
        PrescoreManager.prescoreLoanApplicationRequestDTO(loanApplicationRequestDTO);
        return dealApi.getLoanOffers(loanApplicationRequestDTO);
    }
}
