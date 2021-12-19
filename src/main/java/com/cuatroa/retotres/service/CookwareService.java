package com.cuatroa.retotres.service;

import com.cuatroa.retotres.model.Cookware;
import com.cuatroa.retotres.repository.CookwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author desaextremo
 */
@Service
public class CookwareService {

    @Autowired
    private CookwareRepository cookwareRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Cookware> getAll() {
        return cookwareRepository.getAll();
    }

    public Optional<Cookware> getCookware(String reference) {
        return cookwareRepository.getCookware(reference);
    }

    public Cookware create(Cookware cookware) {
        if (cookware.getReference() == null) {
            return cookware;
        } else {
            return cookwareRepository.create(cookware);
        }
    }

    public Cookware update(Cookware cookware) {

        if (cookware.getReference() != null) {
            Optional<Cookware> CookwareDb = cookwareRepository.getCookware(cookware.getReference());
            if (CookwareDb.isEmpty()) {
                if (cookware.getBrand()!= null) {
                    CookwareDb.get().setBrand(cookware.getBrand());
                }
                
                if (cookware.getCategory() != null) {
                    CookwareDb.get().setCategory(cookware.getCategory());
                }

                if (cookware.getMateriales() != null) {
                    CookwareDb.get().setMateriales(cookware.getMateriales());
                }

                if (cookware.getDimensiones() != null) {
                    CookwareDb.get().setDimensiones(cookware.getDimensiones());
                }
                
                if (cookware.getDescription() != null) {
                    CookwareDb.get().setDescription(cookware.getDescription());
                }
                if (cookware.getPrice() != 0.0) {
                    CookwareDb.get().setPrice(cookware.getPrice());
                }
                if (cookware.getQuantity() != 0) {
                    CookwareDb.get().setQuantity(cookware.getQuantity());
                }
                if (cookware.getPhotography() != null) {
                    CookwareDb.get().setPhotography(cookware.getPhotography());
                }
                
                CookwareDb.get().setAvailability(cookware.isAvailability());
                cookwareRepository.update(CookwareDb.get());
                return CookwareDb.get();
            } else {
                return cookware;
            }
        } else {
            return cookware;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getCookware(reference).map(cookware -> {
            cookwareRepository.delete(cookware);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    public List<Cookware> getByPrice(double price){
        return cookwareRepository.getByPrice(price);
    }
    public List<Cookware> getByDescriptionContains(String description){
        return cookwareRepository.getByDescriptionContains(description);
    }
}
