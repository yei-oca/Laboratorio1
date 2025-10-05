package com.udea.domain;

import static com.udea.domain.PasajeroTestSamples.*;
import static com.udea.domain.ReservaTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.udea.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class PasajeroTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Pasajero.class);
        Pasajero pasajero1 = getPasajeroSample1();
        Pasajero pasajero2 = new Pasajero();
        assertThat(pasajero1).isNotEqualTo(pasajero2);

        pasajero2.setId(pasajero1.getId());
        assertThat(pasajero1).isEqualTo(pasajero2);

        pasajero2 = getPasajeroSample2();
        assertThat(pasajero1).isNotEqualTo(pasajero2);
    }

    @Test
    void reservasTest() {
        Pasajero pasajero = getPasajeroRandomSampleGenerator();
        Reserva reservaBack = getReservaRandomSampleGenerator();

        pasajero.addReservas(reservaBack);
        assertThat(pasajero.getReservas()).containsOnly(reservaBack);
        assertThat(reservaBack.getPasajero()).isEqualTo(pasajero);

        pasajero.removeReservas(reservaBack);
        assertThat(pasajero.getReservas()).doesNotContain(reservaBack);
        assertThat(reservaBack.getPasajero()).isNull();

        pasajero.reservas(new HashSet<>(Set.of(reservaBack)));
        assertThat(pasajero.getReservas()).containsOnly(reservaBack);
        assertThat(reservaBack.getPasajero()).isEqualTo(pasajero);

        pasajero.setReservas(new HashSet<>());
        assertThat(pasajero.getReservas()).doesNotContain(reservaBack);
        assertThat(reservaBack.getPasajero()).isNull();
    }
}
