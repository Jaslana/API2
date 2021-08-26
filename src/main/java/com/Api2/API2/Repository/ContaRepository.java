package com.Api2.API2.Repository;


import com.Api2.API2.Model.ContaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<ContaModel, Integer> {

    Optional<ContaModel> findBynconta(String nconta);
}
