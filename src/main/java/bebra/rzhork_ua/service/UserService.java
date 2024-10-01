package bebra.rzhork_ua.service;

import bebra.rzhork_ua.model.dto.UserWithCompanyDTO;
import bebra.rzhork_ua.model.entity.Company;
import bebra.rzhork_ua.model.entity.Role;
import bebra.rzhork_ua.model.entity.User;
import bebra.rzhork_ua.repository.RoleRepository;
import bebra.rzhork_ua.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return user;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getUser(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    public boolean saveUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        Role role = roleRepository.findByName("ROLE_JOBSEEKER");
        user.setRoles(Set.of(role));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    public boolean saveUserCompany(UserWithCompanyDTO dto) {
        User userFromDB = userRepository.findByUsername(dto.getUsername());

        if (userFromDB != null) {
            return false;
        }
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));

        Role role = roleRepository.findByName("ROLE_COMPANY");
        user.setRoles(Set.of(role));

        Company company = new Company();
        company.setTitle(dto.getCompanyTitle());
        company.setDescription(dto.getCompanyDescription());
        company.setLocation(dto.getCompanyLocation());
        company.setJoinYear(dto.getCompanyJoinYear());

        user.setCompany(company);
        company.setUser(user);
        userRepository.save(user);
        return true;
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
