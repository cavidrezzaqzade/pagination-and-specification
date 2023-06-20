package az.ingress.paginationandspecification.service.specification;

import az.ingress.paginationandspecification.dao.entity.User;
import az.ingress.paginationandspecification.dao.entity.User_;
import az.ingress.paginationandspecification.model.criteria.UserCriteria;
import az.ingress.paginationandspecification.util.PredicateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import static az.ingress.paginationandspecification.util.PredicateUtil.applyLikePattern;

/**
 * @author caci
 */

@AllArgsConstructor
public class UserSpecification implements Specification<User> {

    private UserCriteria userCriteria;

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        var predicates = PredicateUtil.builder()
                .addNullSafety(userCriteria.getName(),
                        birthPlace -> cb.like(root.get(User_.NAME), applyLikePattern(birthPlace))
                )
                .addNullSafety(userCriteria.getAgeFrom(), ageFrom -> cb.greaterThanOrEqualTo(root.get("age"), ageFrom))
                .addNullSafety(userCriteria.getAgeTo(), ageTo -> cb.lessThanOrEqualTo(root.get("age"), ageTo))
                .build();

        return cb.and(predicates);
    }
}
