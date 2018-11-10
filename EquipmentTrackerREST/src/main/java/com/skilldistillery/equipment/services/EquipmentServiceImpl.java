package com.skilldistillery.equipment.services;

import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Equipment create(Equipment post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Equipment update(Equipment repPost, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Equipment post) {
		// TODO Auto-generated method stub
		return null;
	}

}
