package h2tml.qlns.service;

import h2tml.qlns.model.Departs;
import h2tml.qlns.repository.DepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class DepartServiceImpl implements DepartService {
    @Autowired
    private DepartRepository departRepository;

    @Override
    public List<Departs> getAllDeparts() {
        return departRepository.findAll();
    }

    @Override
    public void save(Departs departs) {
        if(Objects.nonNull(departs)){
            departRepository.save(departs);
        }
    }

    @Override
    public Departs getById(Long id) {
        Departs depart = null ;
        if(Objects.nonNull(id)){
            Optional<Departs> optionalDeparts = departRepository.findById(id);
            if(optionalDeparts.isPresent()){
                depart = optionalDeparts.get();
            }else {
                throw new RuntimeException("Dự án không tìm thấy id:" + id);
            }

        }
        return depart;
    }

    @Override
    public void deleteById(Long id) {
        if(Objects.nonNull(id)){
            departRepository.deleteById(id);
        }

    }
}
