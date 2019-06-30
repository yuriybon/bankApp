package ua.bondary.bankapp.finance.repo;


import ua.bondary.bankapp.finance.domain.BaseEntity;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface EntityRepo {
    Optional<Class<BaseEntity>> findById(@NotNull Long id, Class<BaseEntity> entityClass);

    boolean save(Class<BaseEntity> entity);

    void deleteById(@NotNull Long id);

    int update(Class<BaseEntity> entity);
}
