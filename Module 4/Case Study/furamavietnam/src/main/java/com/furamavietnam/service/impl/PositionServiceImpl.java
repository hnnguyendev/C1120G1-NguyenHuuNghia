package com.furamavietnam.service.impl;

import com.furamavietnam.entity.Position;
import com.furamavietnam.repository.IPositionRepository;
import com.furamavietnam.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements IPositionService {

    @Autowired
    IPositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
