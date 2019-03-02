package com.projectShare.serviceImpl;

import com.projectShare.Pojo.Assortment;
import com.projectShare.mapper.AssortmentMapper;
import com.projectShare.service.AssortmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssortmentServiceImpl implements AssortmentService {
    @Autowired
    private AssortmentMapper assortmentMapper;

    @Override
    public void insertAssortment(Assortment assortment) {
                assortmentMapper.insertAssortment(assortment);
    }

    @Override
    public void changeAssortment(Assortment assortment) {
                assortmentMapper.changeAssortment(assortment);
    }

    @Override
    public void deleteAssortment(Assortment assortment) {
            assortmentMapper.deleteAssortment(assortment);
    }

    @Override
    public List<Assortment> selectAssortment() {
        List<Assortment> assortments=assortmentMapper.selectAssortment();
        return assortments;
    }
}
