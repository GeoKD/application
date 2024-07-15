package KedelidzeKrutyakov.application.service;

import KedelidzeKrutyakov.application.api.DTO.LoanOfferDTO;
import KedelidzeKrutyakov.application.api.feign.DealApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OfferService {

    private final DealApi dealClient;

    public void applyOffer(LoanOfferDTO loanOfferDTO) {
        dealClient.applyOffer(loanOfferDTO);
    }
}
