package h2tml.qlns.service;

import h2tml.qlns.model.Position;

import java.util.List;

public interface PositionService {
    List<Position> getAllPosition();

    void save(Position position);

    Position getById(Long id);

    void deleteById(Long id);
}
