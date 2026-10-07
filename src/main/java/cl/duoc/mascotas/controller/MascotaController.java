package cl.duoc.mascotas.controller;

import cl.duoc.mascotas.model.Mascota;
import cl.duoc.mascotas.service.MascotaService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    private final MascotaService mascotaService;

    // Inyección del servicio por constructor
    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }


    // POST /api/mascotas
    @PostMapping
    public ResponseEntity<Mascota> crearMascota(
            @Valid @RequestBody Mascota mascota) {

        Mascota nuevaMascota = mascotaService.guardar(mascota);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevaMascota);
    }


    // GET /api/mascotas
    @GetMapping
    public ResponseEntity<List<Mascota>> listarMascotas() {

        return ResponseEntity.ok(
                mascotaService.listarTodas()
        );
    }


    // GET /api/mascotas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Mascota> buscarMascota(
            @PathVariable Long id) {

        return mascotaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    // PUT /api/mascotas/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Mascota> actualizarMascota(
            @PathVariable Long id,
            @Valid @RequestBody Mascota mascota) {

        return mascotaService.actualizar(id, mascota)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    // DELETE /api/mascotas/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMascota(
            @PathVariable Long id) {

        boolean eliminada = mascotaService.eliminar(id);

        if (!eliminada) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}