package com.udea.domain;

import static com.udea.domain.AsientoTestSamples.*;
import static com.udea.domain.ReservaTestSamples.*;
import static com.udea.domain.VueloTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.udea.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class VueloTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Vuelo.class);
        Vuelo vuelo1 = getVueloSample1();
        Vuelo vuelo2 = new Vuelo();
        assertThat(vuelo1).isNotEqualTo(vuelo2);

        vuelo2.setId(vuelo1.getId());
        assertThat(vuelo1).isEqualTo(vuelo2);

        vuelo2 = getVueloSample2();
        assertThat(vuelo1).isNotEqualTo(vuelo2);
    }

    @Test
    void reservasTest() {
        Vuelo vuelo = getVueloRandomSampleGenerator();
        Reserva reservaBack = getReservaRandomSampleGenerator();

        vuelo.addReservas(reservaBack);
        assertThat(vuelo.getReservas()).containsOnly(reservaBack);
        assertThat(reservaBack.getVuelo()).isEqualTo(vuelo);

        vuelo.removeReservas(reservaBack);
        assertThat(vuelo.getReservas()).doesNotContain(reservaBack);
        assertThat(reservaBack.getVuelo()).isNull();

        vuelo.reservas(new HashSet<>(Set.of(reservaBack)));
        assertThat(vuelo.getReservas()).containsOnly(reservaBack);
        assertThat(reservaBack.getVuelo()).isEqualTo(vuelo);

        vuelo.setReservas(new HashSet<>());
        assertThat(vuelo.getReservas()).doesNotContain(reservaBack);
        assertThat(reservaBack.getVuelo()).isNull();
    }

    @Test
    void asientosTest() {
        Vuelo vuelo = getVueloRandomSampleGenerator();
        Asiento asientoBack = getAsientoRandomSampleGenerator();

        vuelo.addAsientos(asientoBack);
        assertThat(vuelo.getAsientos()).containsOnly(asientoBack);
        assertThat(asientoBack.getVuelo()).isEqualTo(vuelo);

        vuelo.removeAsientos(asientoBack);
        assertThat(vuelo.getAsientos()).doesNotContain(asientoBack);
        assertThat(asientoBack.getVuelo()).isNull();

        vuelo.asientos(new HashSet<>(Set.of(asientoBack)));
        assertThat(vuelo.getAsientos()).containsOnly(asientoBack);
        assertThat(asientoBack.getVuelo()).isEqualTo(vuelo);

        vuelo.setAsientos(new HashSet<>());
        assertThat(vuelo.getAsientos()).doesNotContain(asientoBack);
        assertThat(asientoBack.getVuelo()).isNull();
    }
}
