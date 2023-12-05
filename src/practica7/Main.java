package practica7;
import practica7.interfaces.*;
import practica7.model.*;
import practica7.dao.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        connectionDB c = iniciarSesion();

        DAOPais daoPais = new DAOPaisImpl(c);

        DAOFutbolista daoFutbolista = new DAOFutbolistaImpl(c);

        DAOSede daoSede = new DAOSedeImpl(c);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Menú:");

        boolean condicion = true;

        do {
            System.out.println("1. Ingresar datos básicos de paises");
            System.out.println("2. Listar los paises presentes en la base da datos");
            System.out.println("3. Ingresar futbolistas a la base de datos");
            System.out.println("4. Listar los futbolistas presentes en la base de datos");
            System.out.println("5. Ingresar sedes a la base de datos");
            System.out.println("6. Listar las sedes presentes en la base de datos");
            System.out.println("7. Modificar una sede de la base de datos");
            System.out.println("8. Eliminar una sede de la base de datos");
            System.out.println("9. Salir");
            System.out.println("Ingrese una opción:");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ((DAOPaisImpl) daoPais).insertarMientras();
                    break;
                case 2:
                    System.out.println("Listando paises...");
                    List<Pais> listaPaises = ((DAOPaisImpl) daoPais).listar();
                    if (listaPaises == null) {
                        System.out.println("No hay paises en la base de datos");
                    }
                    else {
                        for (Pais p : listaPaises) {
                            System.out.println(p.toStringSinIdioma());
                        }
                    }
                    break;
                case 3:
                    ((DAOFutbolistaImpl) daoFutbolista).insertarMientras();
                    break;
                case 4:
                    System.out.println("Listando futbolistas...");
                    List<Futbolista> listaFutbolista = ((DAOFutbolistaImpl) daoFutbolista).listar();
                    if (listaFutbolista == null) {
                        System.out.println("No hay futbolistas en la base de datos");
                    }
                    else {
                        for (Futbolista f : listaFutbolista) {
                            System.out.println(f.toString());
                        }
                    }
                    break;
                case 5:
                    ((DAOSedeImpl) daoSede).insertarMientras();
                    break;
                case 6:
                    System.out.println("Listando sedes...");
                    List<Sede> listaSedes = ((DAOSedeImpl) daoSede).listar();
                    if (listaSedes == null)
                    {
                        System.out.println("No hay sedes en la base de datos");
                    }
                    else {
                        for (Sede s : listaSedes) {
                            System.out.println(s.toString());
                        }
                    }
                    break;
                case 7:
                    System.out.println("Modificando sede...");
                    //((DAOSedeImpl) daoSede).modificar();
                    break;
                case 8:
                    System.out.println("Eliminando sede...");
                    ((DAOSedeImpl) daoSede).eliminar();
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    condicion = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        } while (condicion);
     c.cerrar();
    }

    public static connectionDB iniciarSesion(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la base de datos: ");
        String url = sc.nextLine();
        url = "jdbc:mysql://localhost:3306/" + url;
        System.out.println("Ingrese el usuario de la base de datos: ");
        String user = sc.nextLine();

        System.out.println("Ingrese la contraseña de la base de datos: ");
        String password = sc.nextLine();

        connectionDB c = new connectionDB(url,user,password);
        c.conectar(); // Establish the connection

        return c;

    }

}

