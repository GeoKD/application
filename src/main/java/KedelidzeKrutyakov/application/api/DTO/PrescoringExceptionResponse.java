package KedelidzeKrutyakov.application.api.DTO;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class PrescoringExceptionResponse {
    private List<String> errors;

    public PrescoringExceptionResponse() {
        errors = new LinkedList<>();
    }
}
