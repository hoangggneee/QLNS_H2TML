package h2tml.qlns.service;

import h2tml.qlns.model.Position;
import h2tml.qlns.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<Position> getAllPosition() {
        return positionRepository.findAll();
    }

    @Override
    public void save(Position position) {
        if (Objects.nonNull(position)) {
            positionRepository.save(position);
        }
    }

    @Override
    public Position getById(Long id) {
        Position position = null;
        if (Objects.nonNull(id)) {
            Optional<Position> optionalPosition = positionRepository.findById(id);
            if (optionalPosition.isPresent()) {
                position = optionalPosition.get();
            } else {
                throw new RuntimeException("Chức vụ không tìm thấy id:" + id);
            }

        }
        return position;
    }

    @Override
    public void deleteById(Long id) {
        if (Objects.nonNull(id)) {
            positionRepository.deleteById(id);
        }
    }
}
