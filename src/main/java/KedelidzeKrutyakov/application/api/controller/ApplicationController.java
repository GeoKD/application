package KedelidzeKrutyakov.application.api.controller;

import KedelidzeKrutyakov.application.api.DTO.LoanOfferDTO;
import KedelidzeKrutyakov.application.service.ApplicationService;
import KedelidzeKrutyakov.application.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;
    private final OfferService offerService;

    @PutMapping("/offer")
    public void applyOffer(@RequestBody LoanOfferDTO loanOfferDTO) {
        offerService.applyOffer(loanOfferDTO);
    }
}