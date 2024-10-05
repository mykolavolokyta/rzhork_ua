package bebra.rzhork_ua.service;

import bebra.rzhork_ua.model.entity.Company;
import bebra.rzhork_ua.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public Page<Company> getFilteredCompanies(String search, int page) {
        Pageable pageable = PageRequest.of(page, 4);
        search = (search == null) ? "" : search;

        return companyRepository.findFilteredCompanies(search, pageable);
    }

    public Company getCompany(UUID id) {
        return companyRepository.findById(id).orElse(null);
    }

}
