package com.support.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.support.Entitis.Breakdown;
import com.support.Repositories.BreakdownRepositorie;
import com.support.Servicesinterfaces.BreakdownInterface;
@Service
public class BreakDownService implements BreakdownInterface {
    @Autowired
    BreakdownRepositorie BreakdownRepositorie;
    @Override
    public void CreateBreakdown(Breakdown b) {
        BreakdownRepositorie.save(b);
        
    }

    @Override
    public void DeliteBreakdown(Breakdown b) {
        BreakdownRepositorie.delete(b);
    }

    public List<Breakdown> FindAll(){
        return BreakdownRepositorie.findAll();
    }
     
}
