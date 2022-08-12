package academy.digitallab.school.libreta.service;

import academy.digitallab.school.libreta.entity.Libreta;

public interface LibretaService {
    public Libreta createLibreta(Libreta libreta);
    public Libreta updateLibreta(Libreta libreta);
    public Libreta deleteLibreta(Libreta libreta);
    public Libreta getLibreta(Long id);
}
