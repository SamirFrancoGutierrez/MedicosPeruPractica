/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package medicosperu;

import java.util.Scanner;

/**
 *
 * @author U22244871
 */

class Medico {
    private final String nombres;
    private final String apellidos;
    private final int dni;
    private final String ciudad;
    private final int edad;
    private final String usuario;

    public Medico(String nombres, String apellidos, int dni, String ciudad, int edad) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.ciudad = ciudad;
        this.edad = edad;
        this.usuario = String.valueOf(dni) + apellidos.substring(0, 2).toUpperCase();
    }

    public String getUsuario() {
        return usuario;
    }

    public void mostrarDatos() {
        System.out.println("\n¡Registro exitoso!");
        System.out.println("Nombres: " + nombres);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("DNI: " + dni);
        System.out.println("Ciudad: " + ciudad);
        System.out.println("Edad: " + edad);
        System.out.println("Usuario: " + usuario);
    }
}

public class MedicosPeru {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al registro de médicos");
        Medico medico = null;

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Registrarse");
            System.out.println("2. Buscar Cita");
            System.out.println("3. Agregar Cita");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1 -> medico = registrarMedico(scanner);
                case 2 -> {
                    if (medico != null) {
                        buscarCita(medico, scanner);
                    } else {
                        System.out.println("Primero debe registrarse antes de buscar citas.");
                    }
                 }
                case 3 -> {
                    if (medico != null) {
                        agregarCita(medico, scanner);
                    } else {
                        System.out.println("Primero debe registrarse antes de agregar citas.");
                    }
                 }
                case 4 -> {
                    System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                    return;
                 }
                default -> System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
       
            }
    }
    
}
    
 private static Medico registrarMedico(Scanner scanner) {
        System.out.println("Por favor ingrese sus datos:");

        System.out.print("Nombres: ");
        String nombres = scanner.nextLine();

        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();

        System.out.print("DNI (7 cifras): ");
        int dni = obtenerDNI(scanner);

        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        return new Medico(nombres, apellidos, dni, ciudad, edad);
    }

private static void buscarCita(Medico medico, Scanner scanner) {
        System.out.println("Buscar cita para el usuario: " + medico.getUsuario());
        // Aquí puedes implementar la lógica para buscar citas por usuario
    }

    private static void agregarCita(Medico medico, Scanner scanner) {
        System.out.println("Agregar cita para el usuario: " + medico.getUsuario());
        System.out.println("Seleccione la especialidad:");
        System.out.println("1. Médico General");
        System.out.println("2. Médico Especialista");
        System.out.print("Opción: ");
        int opcionEspecialidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        String especialidad = "";
        switch (opcionEspecialidad) {
            case 1 -> especialidad = "Médico General";
            case 2 -> especialidad = "Médico Especialista";
            default -> {
                System.out.println("Opción no válida. Seleccionando Médico General por defecto.");
                especialidad = "Médico General";
            }
        }

        System.out.println("Seleccione el horario:");
        System.out.println("M - MAÑANA");
        System.out.println("T - TARDE");
        System.out.println("N - NOCHE");
        System.out.print("Horario: ");
        String horario = scanner.nextLine().toUpperCase();

        System.out.println("Cita agregada para el usuario " + medico.getUsuario() + ":");
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Horario: " + horario);
    }

    private static int obtenerDNI(Scanner scanner) {
        int dni;
        while (true) {
            try {
                dni = Integer.parseInt(scanner.nextLine());
                if (String.valueOf(dni).length() == 7)
                    break;
                else
                    System.out.println("El DNI debe tener 7 cifras. Por favor, inténtelo de nuevo:");
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido para el DNI:");
            }
        }
        return dni;
    }
}