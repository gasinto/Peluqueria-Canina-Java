
package kayrek.peluqueriacanina;

import GUI.Principal;

public class PeluqueriaCanina {

    public static void main(String[] args) {
        Principal princ = new Principal(); //Instanciamos la ventana principal apra usarla
        princ.setVisible(true); //Hacemos visible a la venta principal
        princ.setLocationRelativeTo(null); //Hacemos que la ventana principal siempre aparezca al medio de la pantalla
    }
}
