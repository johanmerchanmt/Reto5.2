package com.cuatroa.retotres.repository;

import com.cuatroa.retotres.model.Cookware;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cuatroa.retotres.repository.crud.CookwareCrudRepository;

/**
 *
 * @author desaextremo
 */
@Repository
public class CookwareRepository {
    @Autowired
    private CookwareCrudRepository CookwareCrudRepository;

    public List<Cookware> getAll() {
        return CookwareCrudRepository.findAll();
    }

    public Optional<Cookware> getCookware(String reference) {
        return CookwareCrudRepository.findById(reference);
    }
    
    public Cookware create(Cookware cookware) {
        return CookwareCrudRepository.save(cookware);
    }

    public void update(Cookware cookware) {
        CookwareCrudRepository.save(cookware);
    }
    
    public void delete(Cookware cookware) {
        CookwareCrudRepository.delete(cookware);
    }
    
    public List<Cookware> getByPrice(double price){
        return CookwareCrudRepository.findByPriceLessThanEqual(price);
    }

    public List<Cookware> getByDescriptionContains(String description){
        return CookwareCrudRepository.findByDescriptionContainingIgnoreCase(description);
    }
}
