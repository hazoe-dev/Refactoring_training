package pl.refactoring.interpreter.legacy;

import pl.refactoring.interpreter.legacy.criteria.*;
import pl.refactoring.interpreter.legacy.field.EstateMaterial;
import pl.refactoring.interpreter.legacy.field.EstatePlacement;
import pl.refactoring.interpreter.legacy.field.EstateType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
public class RealEstateFinder {
    private List<RealEstate> repository;

    public RealEstateFinder(List<RealEstate> repository) {
        this.repository = repository;
    }

    public List<RealEstate> byBelowArea(float maxBuildingArea){
        Spec spec = new BelowAreaSpec(maxBuildingArea);
        return bySpec(spec);
    }

    private List<RealEstate> bySpec(Spec spec) {
        return repository.stream()
                .filter(spec::check)
                .collect(Collectors.toList());
    }

    public List<RealEstate> byMaterial(EstateMaterial material){
        Spec materialSpec = new MaterialSpec(material);
        return bySpec(materialSpec);
    }

    public List<RealEstate> byMaterialBelowArea(EstateMaterial material, float maxBuildingArea){
        Spec combineSpec = new BelowAreaSpec(new MaterialSpec(material), maxBuildingArea);
        return bySpec(combineSpec);
    }

    public List<RealEstate> byPlacement(EstatePlacement placement){
        Spec placementSpec = new PlacementSpec(placement, true);
        return bySpec(placementSpec);
    }

    public List<RealEstate> byAvoidingPlacement(EstatePlacement placement){
        Spec placementSpec = new PlacementSpec(placement, false);
        return bySpec(placementSpec);
    }

    public List<RealEstate> byAreaRange(float minArea, float maxArea){
        return repository.stream()
                .filter(estate -> estate.getBuildingArea() >= minArea && estate.getBuildingArea() <= maxArea)
                .collect(Collectors.toList());
    }

    public List<RealEstate> byType(EstateType type){
        Spec typeSpec = new EstateTypeSpec(type);
        return bySpec(typeSpec);
    }

    public List<RealEstate> byVerySpecificCriteria(EstateType type, EstatePlacement placement, EstateMaterial material){
        Spec combineSpec = new MaterialSpec(new PlacementSpec(new EstateTypeSpec(type),placement, true),material);
        return bySpec(combineSpec);
    }
}
