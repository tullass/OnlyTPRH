package org.techforumist.jwt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.techforumist.jwt.domain.Areaa;

@Repository
public interface AreaaRepository extends CrudRepository<Areaa, Long> {

}
