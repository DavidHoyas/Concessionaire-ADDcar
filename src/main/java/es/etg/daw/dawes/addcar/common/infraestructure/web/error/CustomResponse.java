package es.etg.daw.dawes.addcar.common.infraestructure.web.error;

import lombok.Getter;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class CustomResponse {

	private final LocalDateTime date;
	private final HttpStatus status;
	private final String message;
}