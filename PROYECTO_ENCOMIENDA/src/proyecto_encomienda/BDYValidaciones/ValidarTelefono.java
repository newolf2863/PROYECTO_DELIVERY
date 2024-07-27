/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_encomienda.BDYValidaciones;

/**
 *
 * @author USUARIO
 */
public class ValidarTelefono {
   public static boolean validarTelefonoCliente(String telefono, String tipoCliente) {
    if (tipoCliente.equals("Nacional")) {
        String regexNacional = "^\\+593-\\d{9}$"; // Formato: +593-XXXXXXXXX
   
        if (!telefono.matches(regexNacional)) {
            //JOptionPane.showMessageDialog(null, "El formato del teléfono nacional no es válido" + "\nUse el formato +593-XXXXXXXXX.");

            return false;
        } else {
            return true;
        }
    } else {
        String regexExtranjero ="^\\+("
                    + "93|355|49|593|376|244|1|966|213|54|374|61|43|994|1|880|1|973|32|501|229|375|591|387|267|55|"
                    + "673|359|226|257|975|238|855|237|1|974|235|56|86|357|57|269|850|82|225|506|385|53|45|"
                    + "1|20|503|971|291|421|386|34|1|372|251|679|63|358|33|241|220|995|233|1|30|502|224|240|"
                    + "245|592|509|504|36|91|62|964|98|353|354|692|677|972|39|1|81|962|7|254|996|686|965|856|"
                    + "233|266|371|961|231|218|423|370|352|389|261|60|265|960|223|356|212|230|222|52|691|"
                    + "373|377|976|382|258|95|264|674|977|505|227|234|47|64|968|31|92|680|507|675|595|51|48|"
                    + "351|44|236|420|242|243|1|250|40|7|685|1|378|1|1|239|221|381|248|232|65|963|252|94|268|"
                    + "27|249|211|46|41|597|66|255|992|670|228|676|1|216|993|90|688|380|256|598|998|678|58|84|"
                    + "967|253|260|263)-\\d{9,11}";
        if (!telefono.matches(regexExtranjero)) {
            //JOptionPane.showMessageDialog(null, "El formato del teléfono extranjero no es válido" + "\nUse el formato adecuado.");       
            return false;
        } else {
            return true;
        }
    }
    
}
   
   public boolean validarTelefonoNegocio(String telefono) {
        String regex = "^(02|03|04|05|06|07)-\\d{7}$";
        return telefono.matches(regex);
    }
   
   public static boolean validarTelefonoClienteFactura(String telefono, String tipoCliente) {
        if (tipoCliente.equals("Nacional")) {
            String regexNacional = "^\\+593-\\d{9}$"; // Formato: +593-XXXXXXXXX
            boolean telefonoValido = telefono.matches(regexNacional);
            return telefonoValido;
        } else {
            String regexExtranjero = "^\\+("
                    + "93|355|49|593|376|244|1|966|213|54|374|61|43|994|1|880|1|973|32|501|229|375|591|387|267|55|"
                    + "673|359|226|257|975|238|855|237|1|974|235|56|86|357|57|269|850|82|225|506|385|53|45|"
                    + "1|20|503|971|291|421|386|34|1|372|251|679|63|358|33|241|220|995|233|1|30|502|224|240|"
                    + "245|592|509|504|36|91|62|964|98|353|354|692|677|972|39|1|81|962|7|254|996|686|965|856|"
                    + "233|266|371|961|231|218|423|370|352|389|261|60|265|960|223|356|212|230|222|52|691|"
                    + "373|377|976|382|258|95|264|674|977|505|227|234|47|64|968|31|92|680|507|675|595|51|48|"
                    + "351|44|236|420|242|243|1|250|40|7|685|1|378|1|1|239|221|381|248|232|65|963|252|94|268|"
                    + "27|249|211|46|41|597|66|255|992|670|228|676|1|216|993|90|688|380|256|598|998|678|58|84|"
                    + "967|253|260|263)-\\d{9,11}";
            boolean telefonoValido = telefono.matches(regexExtranjero);
            return telefonoValido;
        }
    }

}

