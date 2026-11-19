package es.etg.daw.dawes.addcar.coche.infraestructure.web.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CocheCoherenteValidator.class)
@Documented
public @interface CocheCoherente {

    String message() default "{coche.valid.coherente}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
