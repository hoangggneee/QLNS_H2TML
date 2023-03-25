package h2tml.qlns.service;

import h2tml.qlns.model.Departs;

import java.util.List;

public interface DepartService {
    List<Departs> getAllDeparts();

    void save(Departs departs);

    Departs getById(Long id);

    void deleteById(Long id);

}