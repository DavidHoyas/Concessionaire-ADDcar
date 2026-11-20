package es.etg.daw.dawes.addcar.coche.infrastructure.db.repository.mock;

import java.util.Map;
import java.util.LinkedHashMap;

import es.etg.daw.dawes.addcar.coche.domain.model.Coche;
import es.etg.daw.dawes.addcar.coche.domain.model.Traccion;
import es.etg.daw.dawes.addcar.coche.domain.model.Combustion;
import es.etg.daw.dawes.addcar.coche.domain.model.Transmision;
import es.etg.daw.dawes.addcar.coche.domain.model.TipoCarroceria;

public class CocheFactory {

        private static final int ID_1 = 1;
        private static final String MARCA_1 = "Toyota";
        private static final String MODELO_1 = "Corolla";
        private static final String FOTO_1 = "https://www.tou.gal/wp-content/uploads/2023/08/corolla-active-rojo-0675lrb-1-.jpg";
        private static final double PRECIO_1 = 24900.0;
        private static final int ANIO_1 = 2021;
        private static final String COLOR_1 = "Rojo";
        private static final double CILINDRADA_1 = 1.8;
        private static final int CV_1 = 140;
        private static final int STOCK_1 = 5;

        private static final int ID_2 = 2;
        private static final String MARCA_2 = "Tesla";
        private static final String MODELO_2 = "Model 3";
        private static final String FOTO_2 = "https://upload.wikimedia.org/wikipedia/commons/e/e6/Tesla_Model_3_%282023%29_Auto_Zuerich_2023_1X7A1313.jpg?utm_source=es.wikipedia.org&utm_campaign=index&utm_content=original";
        private static final double PRECIO_2 = 39990.0;
        private static final int ANIO_2 = 2023;
        private static final String COLOR_2 = "Blanco";
        private static final double CILINDRADA_2 = 0.0;
        private static final int CV_2 = 283;
        private static final int STOCK_2 = 3;

        private static final int ID_3 = 3;
        private static final String MARCA_3 = "Audi";
        private static final String MODELO_3 = "Q5";
        private static final String FOTO_3 = "https://images.autouncle.com/es/car_images/21a815f2-4133-44ea-a638-a5f32a82b429_2010-audi-q5-s-line-241.webp";
        private static final double PRECIO_3 = 21500.0;
        private static final int ANIO_3 = 2010;
        private static final String COLOR_3 = "Negro";
        private static final double CILINDRADA_3 = 2.0;
        private static final int CV_3 = 170;
        private static final int STOCK_3 = 2;

        public static final Map<Integer, Coche> getDemoData() {
                Map<Integer, Coche> datos = new LinkedHashMap<>();

                datos.put(ID_1, Coche.builder()
                                .id(ID_1)
                                .marca(MARCA_1)
                                .modelo(MODELO_1)
                                .foto(FOTO_1)
                                .precio(PRECIO_1)
                                .anio(ANIO_1)
                                .combustion(Combustion.GASOLINA)
                                .transmision(Transmision.AUTOMATICA)
                                .traccion(Traccion.DELANTERA)
                                .tipoCarroceria(TipoCarroceria.COMPACTO)
                                .color(COLOR_1)
                                .cilindrada(CILINDRADA_1)
                                .cv(CV_1)
                                .stock(STOCK_1)
                                .build());

                datos.put(ID_2, Coche.builder()
                                .id(ID_2)
                                .marca(MARCA_2)
                                .modelo(MODELO_2)
                                .foto(FOTO_2)
                                .precio(PRECIO_2)
                                .anio(ANIO_2)
                                .combustion(Combustion.ELECTRICO)
                                .transmision(Transmision.AUTOMATICA)
                                .traccion(Traccion.TRASERA)
                                .tipoCarroceria(TipoCarroceria.SEDAN)
                                .color(COLOR_2)
                                .cilindrada(CILINDRADA_2)
                                .cv(CV_2)
                                .stock(STOCK_2)
                                .build());

                datos.put(ID_3, Coche.builder()
                                .id(ID_3)
                                .marca(MARCA_3)
                                .modelo(MODELO_3)
                                .foto(FOTO_3)
                                .precio(PRECIO_3)
                                .anio(ANIO_3)
                                .combustion(Combustion.DIESEL)
                                .transmision(Transmision.MANUAL)
                                .traccion(Traccion.TOTAL)
                                .tipoCarroceria(TipoCarroceria.SUV)
                                .color(COLOR_3)
                                .cilindrada(CILINDRADA_3)
                                .cv(CV_3)
                                .stock(STOCK_3)
                                .build());

                return datos;
        }
}