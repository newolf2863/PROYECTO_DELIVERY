/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_ecomienda.BDYValidaciones;

import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class ValidadorCedulas {

    private static final int[] COEFFICIENTS = {4, 3, 2, 7, 6, 5, 4, 3, 2};
    private static final int CONSTANT = 11;
    private static final int NUM_PROVINCES = 24;

    public static boolean validarCedula(String cedula) {
        // Verificar si la cédula tiene 10 dígitos
        if (cedula.length() != 10) {
            return false;
        }

        // Extraer los primeros 9 dígitos de la cédula
        String digitosCedula = cedula.substring(0, 9);

        // Verificar si los primeros 9 dígitos son numéricos
        if (!digitosCedula.matches("[0-9]+")) {
            return false;
        }

        // Convertir los dígitos a un array de enteros
        int[] numeros = new int[9];
        for (int i = 0; i < 9; i++) {
            numeros[i] = Integer.parseInt(digitosCedula.substring(i, i + 1));
        }

        // Calcular el dígito verificador
        int digitoVerificador = Integer.parseInt(cedula.substring(9));
        int suma = 0;
        for (int i = 0; i < 9; i++) {
            int numero = numeros[i];
            if (i % 2 == 0) {
                numero *= 2;
                if (numero > 9) {
                    numero -= 9;
                }
            }
            suma += numero;
        }
        int digitoCalculado = 10 - (suma % 10);
        if (digitoCalculado == 10) {
            digitoCalculado = 0;
        }

        // Comparar el dígito verificador calculado con el proporcionado
        return digitoCalculado == digitoVerificador;
    }

    public static boolean validaRucEP(String ruc) {

        int num_provincias = 24; // Supongo que hay 24 provincias en Ecuador
        ruc = ruc.trim(); // Elimina espacios en blanco al principio y al final
        int prov = Integer.parseInt(ruc.substring(0, 2));
        boolean isValid = false;

        // Verificar si el código de provincia es válido
        if (prov >= 1 && prov <= num_provincias) {
            Integer[] d = new Integer[10]; // Usar un arreglo de objetos Integer para evitar problemas con valores nulos

            for (int i = 0; i < 10; i++) {
                d[i] = Integer.parseInt(ruc.substring(i, i + 1));
            }

            // Calcular la suma ponderada de los dígitos
            int sumatoria = d[0] * 3 + d[1] * 2 + d[2] * 7 + d[3] * 6 + d[4] * 5 + d[5] * 4 + d[6] * 3 + d[7] * 2;
            int modulo = sumatoria % 11;
            int sustraendo = modulo * 11;
            int digito = 11 - (sumatoria - sustraendo);

            //System.out.println("Digito RUC       -> " + digito);
            //System.out.println("Digito Calculado -> " + d[8]);
            // Verificar si el dígito calculado coincide con el dígito dado
            if (digito == d[8]) {
                isValid = true;
            }
        }

        return isValid;
    }

    public static boolean validarCedula1(String cedula) {
        int num_provincias = 24; // Supongo que hay 24 provincias en Ecuador
        int longitudCedula = 10; // Supongo que la cédula tiene 10 dígitos

        // Verificar la longitud de la cédula
        if (cedula.length() != longitudCedula) {
            //System.out.println("Error: La cédula ingresada debe tener " + longitudCedula + " dígitos");
            return false;
        }

        // Verificar que los dos primeros dígitos correspondan a una provincia válida
        int prov = Integer.parseInt(cedula.substring(0, 2));
        if (prov < 1 || prov > num_provincias) {
            //System.out.println("Error: La cédula ingresada no es válida");
            return false;
        }

        int[] digitos = new int[longitudCedula];

        // Convertir la cadena de cédula en un arreglo de dígitos
        for (int i = 0; i < longitudCedula; i++) {
            digitos[i] = Character.getNumericValue(cedula.charAt(i));
        }

        int sumaImpares = 0;
        int sumaPares = 0;

        // Sumar los duplicados de los dígitos en posición impar
        for (int i = 0; i < longitudCedula - 1; i += 2) {
            int resultado = digitos[i] * 2;
            sumaImpares += (resultado > 9) ? resultado - 9 : resultado;
        }

        // Sumar los dígitos en posición par
        for (int i = 1; i < longitudCedula - 1; i += 2) {
            sumaPares += digitos[i];
        }

        int sumaTotal = sumaImpares + sumaPares;
        int decimaSuperior = (sumaTotal + 10) - (sumaTotal % 10);

        // Calcular el décimo dígito
        int d10 = (decimaSuperior - sumaTotal) % 10;

        // Si el décimo dígito calculado es igual al dígito proporcionado, la cédula es válida
        if (d10 == digitos[longitudCedula - 1]) {
            return true;
        } else {
            //System.out.println("Error: La cédula ingresada no es válida");
            return false;
        }
    }

    public static boolean validaRucPP(String ruc) {
    // Verifica que los dos primeros dígitos correspondan a un valor entre 1 y NUMERO_DE_PROVINCIAS
    int provinceCode = Integer.parseInt(ruc.substring(0, 2));

    if (!(provinceCode > 0 && provinceCode <= NUM_PROVINCES)) {
        System.out.println("Error: RUC ingresado incorrecto");
        return false;
    }

    // Verifica que el último dígito del RUC sea válido
    int[] digits = new int[10];
    int sum = 0;

    // Asignamos el string a un array de dígitos
    for (int i = 0; i < digits.length; i++) {
        digits[i] = Integer.parseInt(String.valueOf(ruc.charAt(i)));
    }

    for (int i = 0; i < digits.length - 1; i++) {
        digits[i] *= COEFFICIENTS[i];
        sum += digits[i];
    }

    System.out.println("Suma es: " + sum);

    int aux = sum % CONSTANT;
    int resp = CONSTANT - aux;

    resp = (resp == 10) ? 0 : resp;

    System.out.println("Aux: " + aux);
    System.out.println("Resp " + resp);
    System.out.println("d[9] " + digits[9]);

    return resp == digits[9];
}

    public static boolean validarRUC(String ruc) {
        if (ruc.length() != 13) {
            //JOptionPane.showMessageDialog(null, "El RUC debe constar de 13 caracteres");
            return false; // RUC no válido, la longitud no es correcta
        }
        char tercerDigito = ruc.charAt(2); // Obtener el tercer dígito del RUC
        if (tercerDigito == '6') {
            // Llamar a la función validaRucEP cuando el tercer dígito es igual a 6
            return validaRucEP(ruc);
        } else if (tercerDigito < '6') {
            // Llamar a la función validarCedula1 cuando el tercer dígito es menor que 6
            return validarCedula1(ruc.substring(0, 10));
        } else if (tercerDigito == '9') {
            // Llamar a la función validaRucPP cuando el tercer dígito es igual a 9
            return validaRucPP(ruc);
        }

        return false; // RUC no válido, tercer dígito desconocido
    }

}
