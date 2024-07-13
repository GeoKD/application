package KedelidzeKrutyakov.application.api.controller;

import KedelidzeKrutyakov.application.api.DTO.LoanApplicationRequestDTO;
import KedelidzeKrutyakov.application.api.DTO.LoanOfferDTO;
import KedelidzeKrutyakov.application.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/application")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping
    public List<LoanOfferDTO> getLoanOffers(
            @RequestBody LoanApplicationRequestDTO loanApplicationRequestDTO ) {
        return applicationService.getLoanOffers(loanApplicationRequestDTO);
    }

}
