package agenda_contacto;

import agenda_contacto.data.ContactoDao;
import agenda_contacto.data.ContactoDaoImpl;
import agenda_contacto.dominio.Contacto;

import java.util.Scanner;

public class AgendaContactos {

    public static void main(String[] args) {

        ContactoDao agenda= new ContactoDaoImpl();
        boolean salir=false;
        Scanner sc = new Scanner(System.in);
        while(!salir){

            int opcion=menu(sc);
            salir= ejecutarOpciones(opcion,sc,agenda);

        }

    }

    private static int menu(Scanner sc) {

        System.out.print("""
                menu:
                1. agregar contacto
                2. ver contactos
                3.eliminar contacto
                4. salir
                "elija una opcion:\s""");
    return sc.nextInt();
    }

    private static boolean ejecutarOpciones(int opcion, Scanner sc, ContactoDao agenda) {
        boolean salir = false;
        switch (opcion) {

            case 1 -> agregarContacto(sc, agenda);
            case 2-> System.out.println(agenda.listContactos());
            case 3->eliminarContacto(sc,agenda);
            case 4->salir=true;
            default -> salir=false;
        }
        return salir;
    }

    private static void agregarContacto(Scanner sc, ContactoDao agenda) {
        sc.nextLine();
        System.out.print("numero de telefono: ");
        String telefono=sc.nextLine();
        System.out.print("nombres del contacto: ");
        String nombres=sc.nextLine();
        System.out.print("apellidos del contacto: ");
        String apellidos=sc.nextLine();
        System.out.print("correo del contacto: ");
        String correo=sc.nextLine();
        System.out.print("dirrecion del contacto: ");
        String direccion=sc.nextLine();
        System.out.print("cargo del contacto: ");
        String cargo=sc.nextLine();

        Contacto nuevo= new Contacto(telefono,nombres,apellidos,correo,direccion,cargo);
        agenda.newContacto(nuevo);
        System.out.println("!conntacto agregado exitosamente!");

    }
    private static void eliminarContacto(Scanner sc, ContactoDao agenda) {

        System.out.print("contacto a eliminar (id,telefono): ");
        String dato= sc.next();
        Contacto eliminar= (dato.length()>=9)? agenda.findByTelefono(new Contacto(dato)): agenda.getContacto(new Contacto(Integer.parseInt(dato)));
        agenda.deleteContacto(eliminar);
    }
}
