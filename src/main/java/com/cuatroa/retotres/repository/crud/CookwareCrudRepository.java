package com.cuatroa.retotres.repository.crud;

import com.cuatroa.retotres.model.Cookware;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author desaextremo
 */
public interface CookwareCrudRepository extends MongoRepository<Cookware, String> {
    public List<Cookware> findByPriceLessThanEqual(double price);
    public List<Cookware> findByDescriptionContainingIgnoreCase(String description);
}
