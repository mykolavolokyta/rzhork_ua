package bebra.rzhork_ua.service;

import bebra.rzhork_ua.model.entity.Company;
import bebra.rzhork_ua.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
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

    public Company getCompany(UUID id) {
        return companyRepository.findById(id).orElse(null);
    }

}
