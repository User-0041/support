package com.support.Servicesinterfaces;

import java.util.List;

import com.support.Entitis.Breakdown;

public interface  BreakdownInterface {
    void CreateBreakdown(Breakdown b);
    void DeliteBreakdown(Breakdown b);
    public List<Breakdown> FindAll();
}