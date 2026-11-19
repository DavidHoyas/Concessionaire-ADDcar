package es.etg.daw.dawes.addcar.coche.infraestructure.web.validation;

import java.time.Year;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import es.etg.daw.dawes.addcar.coche.domain.model.Combustion;
import es.etg.daw.dawes.addcar.coche.domain.model.Estado;
import es.etg.daw.dawes.addcar.coche.domain.model.Transmision;
import es.etg.daw.dawes.addcar.coche.infraestructure.web.mvc.dto.CocheRequest;

public class CocheCoherenteValidator implements ConstraintValidator<CocheCoherente, CocheRequest> {

    private static final int KM_MAX_POR_ANIO = 60000;
    private static final double CV_MAX_POR_LITRO = 250.0;
    private static final int ANIOS_MAX_SEMINUEVO = 4;

    @Override
    public boolean isValid(CocheRequest c, ConstraintValidatorContext ctx) {
        if (c == null)
            return true;

        ctx.disableDefaultConstraintViolation();
        int actual = Year.now().getValue();

        boolean valido = true;
        valido &= validarMotor(c, ctx);
        valido &= validarCarroceria(c, ctx);
        valido &= validarEstadoYKm(c, ctx, actual);
        valido &= validarAnio(c, ctx, actual);
        return valido;
    }

    private boolean validarMotor(CocheRequest c, ConstraintValidatorContext ctx) {
        if (c.combustion() == null)
            return true;

        boolean ok = true;
        if (c.combustion() == Combustion.ELECTRICO) {
            if (c.transmision() != null && c.transmision() != Transmision.AUTOMATICA)
                ok = error(ctx, "transmision", "{coche.valid.coherente.electrico_transmision}");
            if (c.cilindrada() != null && c.cilindrada() != 0)
                ok = error(ctx, "cilindrada", "{coche.valid.coherente.electrico_cilindrada}");
        } else if (c.cilindrada() != null) {
            if (c.cilindrada() <= 0)
                ok = error(ctx, "cilindrada", "{coche.valid.coherente.cilindrada_requerida}");
            else if (c.cv() != null && c.cv() / (c.cilindrada() / 1000.0) > CV_MAX_POR_LITRO)
                ok = error(ctx, "cv", "{coche.valid.coherente.cv_cilindrada}");
        }
        return ok;
    }

    private boolean validarCarroceria(CocheRequest c, ConstraintValidatorContext ctx) {
        boolean ok = true;
        if (c.tipoCarroceria() != null) {
            if (c.puertas() != null && !c.tipoCarroceria().admitePuertas(c.puertas()))
                ok = error(ctx, "puertas", "{coche.valid.coherente.puertas_carroceria}");
            if (c.plazas() != null && !c.tipoCarroceria().admitePlazas(c.plazas()))
                ok = error(ctx, "plazas", "{coche.valid.coherente.plazas_carroceria}");
        }
        if (c.plazas() != null && c.puertas() != null && c.plazas() == 2 && c.puertas() > 3)
            ok = error(ctx, "puertas", "{coche.valid.coherente.plazas_puertas}");
        return ok;
    }

    private boolean validarEstadoYKm(CocheRequest c, ConstraintValidatorContext ctx, int actual) {
        boolean ok = true;
        Integer km = c.kilometros();
        if (c.estado() != null && km != null) {
            if (c.estado() == Estado.NUEVO && km != 0)
                ok = error(ctx, "kilometros", "{coche.valid.coherente.nuevo_km}");
            if (c.estado() == Estado.SEMINUEVO && km <= 0)
                ok = error(ctx, "kilometros", "{coche.valid.coherente.seminuevo_km}");
            if (c.estado() == Estado.OCASION && km <= 0)
                ok = error(ctx, "kilometros", "{coche.valid.coherente.ocasion_km}");
        }
        // Año y km coherentes
        if (km != null && c.anio() != null && c.anio() <= actual
                && km > (long) (actual - c.anio() + 1) * KM_MAX_POR_ANIO)
            ok = error(ctx, "kilometros", "{coche.valid.coherente.km_anio}");
        return ok;
    }

    private boolean validarAnio(CocheRequest c, ConstraintValidatorContext ctx, int actual) {
        if (c.anio() == null)
            return true;

        boolean ok = true;
        if (c.anio() > actual)
            ok = error(ctx, "anio", "{coche.valid.coherente.anio_futuro}");
        if (c.estado() == Estado.NUEVO && c.anio() < actual - 1)
            ok = error(ctx, "anio", "{coche.valid.coherente.nuevo_anio}");
        if (c.estado() == Estado.SEMINUEVO && c.anio() < actual - ANIOS_MAX_SEMINUEVO)
            ok = error(ctx, "anio", "{coche.valid.coherente.seminuevo_anio}");
        return ok;
    }

    private boolean error(ConstraintValidatorContext ctx, String campo, String mensaje) {
        ctx.buildConstraintViolationWithTemplate(mensaje)
                .addPropertyNode(campo)
                .addConstraintViolation();
        return false;
    }
}
