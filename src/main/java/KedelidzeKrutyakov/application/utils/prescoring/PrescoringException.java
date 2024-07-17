package KedelidzeKrutyakov.application.utils.prescoring;

import KedelidzeKrutyakov.application.api.DTO.PrescoringExceptionResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PrescoringException extends RuntimeException {

    private PrescoringExceptionResponse prescoringExceptionResponse;

}
