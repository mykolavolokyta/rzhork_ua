package bebra.rzhork_ua.repository;

import bebra.rzhork_ua.model.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {
    @Query("SELECT c FROM Company c WHERE "
            + "(c.title LIKE %:search% OR c.location LIKE %:search%) ")
    Page<Company> findFilteredCompanies(@Param("search") String search,
                                        Pageable pageable);
}
