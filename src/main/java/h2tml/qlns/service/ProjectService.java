package h2tml.qlns.service;

import h2tml.qlns.model.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProject();

    void save(Project project);

    Project getById(Long id);

    void deleteById(Long id);
}