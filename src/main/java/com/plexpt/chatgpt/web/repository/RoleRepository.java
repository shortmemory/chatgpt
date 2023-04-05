package com.plexpt.chatgpt.web.repository;

import com.plexpt.chatgpt.web.domain.Role;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {

    public default Specification<Role> findRoles(String name, boolean enabled) {
        Specification<Role> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(StringUtils.isNotBlank(name)) {
                predicates.add(criteriaBuilder.like(root.get("name"), name + "%"));
            }
            predicates.add(criteriaBuilder.equal(root.get("enabled"), enabled));
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        return spec;
    }

    public default Page<Role> findRolesPage(String name, boolean enabled) {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());
        Specification<Role> spec = this.findRoles("admin", true);
        return findAll(spec, pageable);
    }

    public default Long countRoles(boolean enabled) {
        return count((root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("enabled"), enabled);
        });
    }

}