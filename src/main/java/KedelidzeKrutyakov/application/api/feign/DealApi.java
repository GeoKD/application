package KedelidzeKrutyakov.application.api.feign;

import KedelidzeKrutyakov.application.api.DTO.LoanApplicationRequestDTO;
import KedelidzeKrutyakov.application.api.DTO.LoanOfferDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient (name = "deal", url = "http://localhost:8081/deal")
public interface DealApi {

    @PostMapping("/application")
    List<LoanOfferDTO> getLoanOffers(
            @RequestBody LoanApplicationRequestDTO loanApplicationRequestDTO );

    @PutMapping("/offer")
    void applyOffer(
            @RequestBody LoanOfferDTO loanOfferDTO );

}
