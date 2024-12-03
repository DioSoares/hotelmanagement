package com.gerenciamentohotel.hotelmanagement.repository;

import com.gerenciamentohotel.hotelmanagement.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
