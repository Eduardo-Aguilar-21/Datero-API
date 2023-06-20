package com.b.dateroapi.Repositories;

import com.b.dateroapi.Models.BusesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusesRepository extends JpaRepository<BusesModel, Long> {
    @Query(value = "SELECT * FROM LISTBUSESD", nativeQuery = true)
    List<Object[]>ListBusesD();

    @Query(value = "CALL BUSESXEMPT(:emp)", nativeQuery = true)
    List<Object[]>ListBusesxEmp(@Param("emp") Long emp);

    @Query(value = "CALL BUSESXEMPH(:est,:emp)", nativeQuery = true)
    List<Object[]>ListBusesxEmpH(@Param("est") Boolean est ,@Param("emp") Long emp);

    @Query(value = "CALL BUSESXEMPD(:emp)", nativeQuery = true)
    List<Object[]>ListBusesxEmpD(@Param("emp") Long emp);
}
