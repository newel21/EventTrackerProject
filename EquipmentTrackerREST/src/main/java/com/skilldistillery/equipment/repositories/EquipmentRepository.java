package com.skilldistillery.equipment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.equipment.entities.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {

}
