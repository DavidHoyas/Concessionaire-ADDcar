package es.etg.daw.dawes.addcar.coche.infrastructure.web.validation;

import java.time.Year;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import es.etg.daw.dawes.addcar.coche.domain.model.Combustion;
import es.etg.daw.dawes.addcar.coche.domain.model.Transmision;
import es.etg.daw.dawes.addcar.coche.infrastructure.web.mvc.dto.CocheRequest;

public class CocheCoherenteValidator implements ConstraintValidator<CocheCoherente, CocheRequest> {

    private static final String CAMPO_TRANSMISION = "transmision";
    private static final String CAMPO_CILINDRADA = "cilindrada";
    private static final String CAMPO_CV = "cv";
    private static final String CAMPO_ANIO = "anio";

    private static final String TRANSMISION_ELECTRICO = "Un coche eléctrico solo puede ser automático";
    private static final String CILINDRADA_ELECTRICO = "Un coche eléctrico no tiene cilindrada (debe ser 0)";
    private static final String CILINDRADA_NO_ELECTRICO = "Si no es eléctrico, la cilindrada debe ser mayor que 0";
    private static final String CV_POR_LITRO = "La potencia es demasiado alta para esa cilindrada (máximo %d CV por litro)";
    private static final String ANIO_FUTURO = "El año no puede ser futuro";
    private static final int CV_MAX_POR_LITRO = 250;

    @Override
    public boolean isValid(CocheRequest c, ConstraintValidatorContext ctx) {
        ctx.disableDefaultConstraintViolation();
        boolean valido = true;

        if (c.combustion() == Combustion.ELECTRICO) {
            if (c.transmision() == Transmision.MANUAL)
                valido = error(ctx, CAMPO_TRANSMISION, TRANSMISION_ELECTRICO);
            if (c.cilindrada() != 0)
                valido = error(ctx, CAMPO_CILINDRADA, CILINDRADA_ELECTRICO);
        } else if (c.combustion() != null) {
            if (c.cilindrada() <= 0) {
                valido = error(ctx, CAMPO_CILINDRADA, CILINDRADA_NO_ELECTRICO);

            } else if (c.combustion() != Combustion.HIBRIDO && c.cv() > c.cilindrada() * CV_MAX_POR_LITRO) {
                valido = error(ctx, CAMPO_CV, CV_POR_LITRO.formatted(CV_MAX_POR_LITRO));
            }
        }

        if (c.anio() > Year.now().getValue())
            valido = error(ctx, CAMPO_ANIO, ANIO_FUTURO);

        return valido;
    }

    private boolean error(ConstraintValidatorContext ctx, String campo, String mensaje) {
        ctx.buildConstraintViolationWithTemplate(mensaje)
                .addPropertyNode(campo)
                .addConstraintViolation();
        return false;
    }
}