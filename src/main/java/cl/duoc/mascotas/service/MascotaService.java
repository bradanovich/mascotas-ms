package cl.duoc.mascotas.service;

import cl.duoc.mascotas.model.Mascota;
import cl.duoc.mascotas.repository.MascotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    // Repository que nos permite trabajar con la base de datos
    private final MascotaRepository mascotaRepository;

    // Inyección de dependencia por constructor
    public MascotaService(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }


    // Guarda una nueva mascota en la base de datos
    public Mascota guardar(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }


    // Devuelve todas las mascotas
    public List<Mascota> listarTodas() {
        return mascotaRepository.findAll();
    }


    // Busca una mascota por su ID
    public Optional<Mascota> buscarPorId(Long id) {
        return mascotaRepository.findById(id);
    }


    // Actualiza una mascota si existe
    public Optional<Mascota> actualizar(Long id, Mascota datosMascota) {

        return mascotaRepository.findById(id).map(mascota -> {

            mascota.setUsuarioId(datosMascota.getUsuarioId());
            mascota.setNombre(datosMascota.getNombre());
            mascota.setEspecie(datosMascota.getEspecie());
            mascota.setRaza(datosMascota.getRaza());
            mascota.setSexo(datosMascota.getSexo());
            mascota.setFechaNacimiento(datosMascota.getFechaNacimiento());

            return mascotaRepository.save(mascota);
        });
    }


    // Elimina una mascota si existe
    public boolean eliminar(Long id) {

        if (!mascotaRepository.existsById(id)) {
            return false;
        }

        mascotaRepository.deleteById(id);
        return true;
    }
}