package es.etg.daw.dawes.addcar.coche.infrastructure.web.validation;

import jakarta.validation.Payload;
import jakarta.validation.Constraint;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Documented
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CocheCoherenteValidator.class)
public @interface CocheCoherente {

    public static final String MENSAJE = "Los datos del coche no son coherentes entre sí";

    String message() default MENSAJE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}