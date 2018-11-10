package com.skilldistillery.equipment.services;

import java.util.List;

import com.skilldistillery.equipment.entities.Equipment;

public interface EquipmentService {
	
	List<Equipment> index();
	Equipment show(int id);
	Equipment create(Equipment post);
	Equipment update(Equipment repPost, int id);
	Boolean delete(Equipment post);


}
