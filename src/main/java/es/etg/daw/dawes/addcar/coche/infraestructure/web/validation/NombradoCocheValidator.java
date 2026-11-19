package es.etg.daw.dawes.addcar.coche.infraestructure.web.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NombradoCocheValidator implements ConstraintValidator<NombradoCoche, String> {

    private static final String STR_BLANCO = " ";
    private static final String STR_SALTO = "\n";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null)
            return true;

        return !value.contains(STR_BLANCO) && !value.contains(STR_SALTO);
    }
}