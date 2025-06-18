package com.kainmvc.gia_vi_sandwich.service;

import com.kainmvc.gia_vi_sandwich.entity.Sandwich;

import java.util.List;

public interface ISandwichService {
    List<Sandwich> listSandwich();
    void add(Sandwich sandwich);
}
