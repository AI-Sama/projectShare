package com.projectShare.service;

import com.projectShare.Pojo.Assortment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssortmentService {
        public void insertAssortment(Assortment assortment);
        public void changeAssortment(Assortment assortment);
        public void deleteAssortment(Assortment assortment);
        public List<Assortment> selectAssortment();
}
