
package Persistencia;

import Logica.Duenio;
import Logica.Mascota;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascotaJpa = new MascotaJpaController();

    public void guardar(Mascota mascota, Duenio duenio) {
        
        //Crear en la BD el dueño
        duenioJpa.create(duenio);
        
        //Crear en la BD la mascota
        mascotaJpa.create(mascota);
        
    }

    public List<Mascota> traerMascotas() {
        return mascotaJpa.findMascotaEntities();
    }

    public void borrar(int num_cliente) {
        try {
            mascotaJpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mascota traerMascota(int num_cliente) {
        return mascotaJpa.findMascota(num_cliente);
    }

    public Duenio buscarDuenio(int id_duenio) {
        return duenioJpa.findDuenio(id_duenio);
    }

    public void modificaDuenio(Duenio duenio) {
        try {
            duenioJpa.edit(duenio);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarMascota(Mascota masco) {
        try {
            mascotaJpa.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
