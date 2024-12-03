package com.gerenciamentohotel.hotelmanagement.repository;

import com.gerenciamentohotel.hotelmanagement.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
