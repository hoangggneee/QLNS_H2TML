package h2tml.qlns.service;

import h2tml.qlns.model.Project;
import h2tml.qlns.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    @Override
    public void save(Project project) {
        if(Objects.nonNull(project)){
            projectRepository.save(project);
        }
    }

    @Override
    public Project getById(Long id) {
        Project project = null ;
        if(Objects.nonNull(id)){
            Optional<Project> optionalProject = projectRepository.findById(id);
            if(optionalProject.isPresent()){
                project = optionalProject.get();
            }else {
                throw new RuntimeException("Dự án không tìm thấy id:" + id);
            }

        }
        return project;
    }

    @Override
    public void deleteById(Long id) {
        if(Objects.nonNull(id)){
            projectRepository.deleteById(id);
        }

    }
}