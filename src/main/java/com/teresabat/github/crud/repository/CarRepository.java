package com.teresabat.github.crud.repository;

import com.teresabat.github.crud.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository <Car, Long> {
}
