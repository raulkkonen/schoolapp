package academy.digitallab.school.libreta.service;

import academy.digitallab.school.libreta.entity.Libreta;
import java.util.List;

public interface LibretaService {
    public List<Libreta> findLibretaAll();
    public Libreta createLibreta(Libreta libreta);
    public Libreta updateLibreta(Libreta libreta);
    public Libreta deleteLibreta(Libreta libreta);
    public Libreta getLibreta(Long id);
}
