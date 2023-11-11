
package Logica;

import Persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMascota, String raza, String color, String observaciones, String celDuenio, String nombreDuenio, String alergico, String atencionEspecial) {
      
        //Creamos el dueño y asignamos sus valores
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        
        //Creamos la mascota y asignamos sus valores
        Mascota mascota = new Mascota();
        mascota.setNombre(nombreMascota);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setObservaciones(observaciones);
        mascota.setAlergico(alergico);
        mascota.setAtencionEspecial(atencionEspecial);
        mascota.setUnDuenio(duenio);
        
        controlPersis.guardar(mascota, duenio);
        
    }

    public List<Mascota> traerMascotas() {
        return controlPersis.traerMascotas();
    }

    public void borrarMascota(int num_cliente) {
        controlPersis.borrar(num_cliente);
    }

    public Mascota traerMascota(int num_cliente) {
        return controlPersis.traerMascota(num_cliente);
    }

    public void editarMascota(Mascota masco, String nombreMascota, String raza, String color, String observaciones, String celDuenio, String nombreDuenio, String alergico, String atencionEspecial) {
       
        //Modificacion de mascota
        masco.setNombre(nombreMascota);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencionEspecial(atencionEspecial);
        
        controlPersis.modificarMascota(masco);
        
        //Modificacion de dueño
        Duenio duenio = this.buscarDuenio(masco.getUnDuenio().getId_duenio()); //Buscamos el dueño
        duenio.setCelDuenio(celDuenio);
        duenio.setNombre(nombreDuenio);
        
        //Lamamos a la controladora de persistencia para guardar los nuevos datos
        this.modificarDuenio(duenio);
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.buscarDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenio) {
        controlPersis.modificaDuenio(duenio);
    }

    
    
}
