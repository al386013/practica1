//package principal;
//
//import interfaces.Accion;
//import menus.MenuPrincipal;
//import principal.acciones.SeleccionaOpcionClientes;
//import principal.acciones.SeleccionaOpcionPrincipal;
//import principal.excepciones.OpcionIncorrectaException;
//
//import java.util.Scanner;
//
//public class MenuYopcion {
//    static BaseDeDatos baseDeDatos;
//    private transient Scanner sc = new Scanner(System.in);
//    static transient MenuPrincipal opcionMenu = null;
//
//    public MenuYopcion(BaseDeDatos baseDeDatos) {
//        this.baseDeDatos = baseDeDatos;
//    }
//
//    public void run() {
//        do {
//            mostrarMenu();
//            System.out.print("Introduce una opción: ");
//            byte opcion = sc.nextByte();
//            if (opcion < 0 || opcion > 4) System.out.println("\n-------------> Opcion incorrecta <-------------");
//            else {
//                opcionMenu = MenuPrincipal.getOpcion(opcion);
//                opcionMenu.ejecutaOpcion(baseDeDatos);
//                sc.reset();
//            }
//        } while (opcionMenu != MenuPrincipal.SALIR_GUARDAR);
//    }
//
//    private void mostrarMenu() {
//        System.out.println("\n* * * * * * * OPCIONES DISPONIBLES * * * * * * *\n");
//        System.out.println(MenuPrincipal.getMenu());
//    }
//}
