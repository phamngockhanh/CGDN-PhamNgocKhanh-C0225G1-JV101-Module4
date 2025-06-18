package com.kainmvc.gia_vi_sandwich.service;

import com.kainmvc.gia_vi_sandwich.entity.Sandwich;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SandwichService implements ISandwichService{
    private static List<Sandwich> sandwichList = new ArrayList<>();

    @Override
    public List<Sandwich> listSandwich() {
        return sandwichList;
    }

    @Override
    public void add(Sandwich sandwich) {
        sandwichList.add(sandwich);
    }


}
