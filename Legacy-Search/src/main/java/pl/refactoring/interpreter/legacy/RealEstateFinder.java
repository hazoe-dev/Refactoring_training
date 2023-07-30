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
    private List<RealEstate> bySpec(Spec spec, List<RealEstate> estates) {
        return estates.stream()
                .filter(spec::check)
                .collect(Collectors.toList());
    }

    public List<RealEstate> byMaterial(EstateMaterial material){
        Spec materialSpec = new MaterialSpec(material);
        return bySpec(materialSpec);
    }

    public List<RealEstate> byMaterialBelowArea(EstateMaterial material, float maxBuildingArea){
        Spec belowAreaSpec = new BelowAreaSpec(maxBuildingArea);
        Spec materialSpec = new MaterialSpec(material);
        List<RealEstate> foundRealEstates;
        foundRealEstates = bySpec(belowAreaSpec);
        return bySpec(materialSpec, foundRealEstates);
    }

    public List<RealEstate> byPlacement(EstatePlacement placement){
        Spec placementSpec = new PlacementSpec(placement);
        return bySpec(placementSpec);
    }

    public List<RealEstate> byAvoidingPlacement(EstatePlacement placement){
        List<RealEstate> foundRealEstates = new ArrayList<>();
        Spec placementSpec = new PlacementSpec(placement);
        for (RealEstate estate : repository) {
            if (!placementSpec.check(estate))
                foundRealEstates.add(estate);
        }
        return foundRealEstates;
    }

    public List<RealEstate> byAreaRange(float minArea, float maxArea){
        List<RealEstate> foundRealEstates = new ArrayList<>();

        for (RealEstate estate : repository) {
            if (estate.getBuildingArea() >= minArea && estate.getBuildingArea() <= maxArea)
                foundRealEstates.add(estate);
        }
        return foundRealEstates;
    }

    public List<RealEstate> byType(EstateType type){
        List<RealEstate> foundRealEstates = new ArrayList<>();
        Spec typeSpec = new EstateTypeSpec(type);
        return bySpec(typeSpec);
    }

    public List<RealEstate> byVerySpecificCriteria(EstateType type, EstatePlacement placement, EstateMaterial material){
        List<RealEstate> foundRealEstates = new ArrayList<>();
        Spec materialSpec = new MaterialSpec(material);
        Spec placementSpec = new PlacementSpec(placement);
        Spec typeSpec = new EstateTypeSpec(type);

        foundRealEstates = bySpec(materialSpec);
        foundRealEstates = bySpec(typeSpec, foundRealEstates);
        foundRealEstates = bySpec(placementSpec,foundRealEstates);

        return foundRealEstates;
    }
}
