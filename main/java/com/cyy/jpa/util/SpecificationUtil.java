package com.cyy.jpa.util;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SpecificationUtil {

    public static Specification getEqualSpec(Map<String,Object> params) {
        return(root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            for(Map.Entry<String,Object > entry:params.entrySet()){
                if (entry.getValue() != null) {
                    predicates.add(criteriaBuilder.equal(root.get(entry.getKey()),entry.getValue()));
                }
            }
            return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        };
    }

}
