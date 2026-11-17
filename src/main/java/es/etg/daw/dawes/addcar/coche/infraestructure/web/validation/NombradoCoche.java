package es.etg.daw.dawes.addcar.coche.infraestructure.web.validation;

import jakarta.validation.Payload;
import jakarta.validation.Constraint;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NombradoCocheValidator.class)
@Documented

public @interface NombradoCoche {

    String message() default "{es.etg.daw.dawes.addcar.coche.infraestructure.web.validation.NombradoCoche.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
