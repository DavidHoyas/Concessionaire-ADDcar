package es.etg.daw.dawes.addcar.common.infraestructure.web.error;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class CustomResponse {

	private final LocalDateTime date;
	private final HttpStatus status;
	private final String message;
}