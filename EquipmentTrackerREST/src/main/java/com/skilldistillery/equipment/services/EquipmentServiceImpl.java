package com.skilldistillery.equipment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.equipment.entities.Equipment;
import com.skilldistillery.equipment.repositories.EquipmentRepository;

@Service
public class EquipmentServiceImpl implements EquipmentService {
	
	@Autowired
	private EquipmentRepository repo;

	@Override
	public List<Equipment> index() {
		return repo.findAll();
	}

	@Override
	public Equipment show(int id) {
		Equipment equipment = null;
		Optional<Equipment> opt = repo.findById(id);
		if(opt.isPresent()) {
			equipment = opt.get();
			return equipment;
		}
		return null;
	}

	@Override
	public Equipment create(Equipment equipment) {
		repo.saveAndFlush(equipment);
		return equipment;
	}

	@Override
	public Equipment update(Equipment equipment, int id) {
//		Equipment managedEquipment = null;
		Optional<Equipment> opt = repo.findById(id);
		if(opt.isPresent()) {
//			System.err.println(equipment.getName());
//			managedEquipment.setName(equipment.getName());
//			managedEquipment.setDescription(equipment.getDescription());
//			managedEquipment.setNsn(equipment.getNsn());
//			managedEquipment.setSerial(equipment.getSerial());
//			managedEquipment.setQuantity(equipment.getQuantity());
			equipment.setId(id);
			repo.saveAndFlush(equipment);
		}
		
		return equipment;
	}

	@Override
	public Boolean delete(int id) {
		boolean deleted = false;
		try {
		repo.deleteById(id);
		deleted = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return deleted;
	}

}
