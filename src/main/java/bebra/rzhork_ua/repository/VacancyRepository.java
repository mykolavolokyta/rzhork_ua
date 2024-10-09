package bebra.rzhork_ua.repository;

import bebra.rzhork_ua.model.entity.Vacancy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, UUID> {

    @Query("SELECT v FROM Vacancy v WHERE "
            + "(v.title LIKE %:search% OR v.location LIKE %:search%) "
            + "AND v.salary BETWEEN :minSalary AND :maxSalary "
            + "AND v.date BETWEEN :startDate AND :endDate")
    Page<Vacancy> findFilteredVacancies(@Param("search") String search,
                                        @Param("minSalary") Double minSalary,
                                        @Param("maxSalary") Double maxSalary,
                                        @Param("startDate") LocalDateTime startDate,
                                        @Param("endDate") LocalDateTime endDate,
                                        Pageable pageable);
}
