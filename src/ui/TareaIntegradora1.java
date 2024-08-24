import java.util.*;

//Variables de entrada= nombre, id, op_menu, numGuias, numPart, tempC, humRel
//Variablas de salida  = busesNec, totalAsis

//Descripción: Primero, el organizador voluntario tendrá que identificarse con nombre y cédula para que, posteriormente,
//elija del menú la caminata que programará; entre la Ruta Farallones, la Ruta Ladera y la Ruta Oriente. Después, se le
//mostrará al usuario la hora de comienzo y finalización de la ruta, además del punto de encuentro. Ya escogida la ruta,
//se le pedirá al organizador voluntario que defina la cantidad de guías y participantes que asistirán a la caminata, para
//que así mismo el programa defina la cantidad de buses necesarios para la realización de la caminata, teniendo en cuenta que
//cada bus tiene una capacidad de 25 personas. Para finalizar, se le solicitará al organizador voluntario la temperatura
//en grados centígrados y la humedad real, porque si estas dos se encuentran por encima del rango de 20C-25C grados y 
//40%-60% de humedad relativa la caminata no podrá realizarse por condiciones adversas. Si ambos parámetros están en su rango
//correspondiente se le mostrará al organizador voluntario el mensaje: "¡Hace un buen día para caminar en Cali!", sino le mostrará
//el siguiente mensaje: "Lo siento, hace un mal día. La caminata se deberá hacer en otro día".

//(el # indica mensaje del sistema):

//Ejemplo 1:

//#Por favor, dígita tu nombre
//Juan Manuel Ramírez
//#Ingrese su cédula
//1107836945
//#--Indique qué ruta quiere programar--
//#(1) Ruta Ladera
//#(2) Ruta oriente
//#(3) Ruta Farallones
//#(4) Salir
//1
//#¡Excelente! La Ruta Ladera tiene como punto de encuentro El Bulevar del Rio, inicia a las 7:30 am y termina a las 1:30 pm
//#¿Cuántos participantes acudirán a la caminata?
//20
//#¿Cuántos guías acudirán a la caminata?
//10
//#Como esta caminata tendrá 30 participantes, se necesitan 2 buses.
//#Ingresar la temperatura en grados centígrados
//23
//#Ingrese el porcentaje de humedad relativa
//45
//#¡Hace un buen día para caminar en Cali!

//Ejemplo 2:

//#Por favor, dígita tu nombre
//Juan Manuel Ramírez
//#Ingrese su cédula
//1107836945
//#--Indique qué ruta quiere programar--
//#(1) Ruta Ladera
//#(2) Ruta oriente
//#(3) Ruta Farallones
//#(4) Salir
//#1
//#¡Excelente! La Ruta Ladera tiene como punto de encuentro El Bulevar del Rio, inicia a las 7:30 am y termina a las 1:30 pm
//#¿Cuántos participantes acudirán a la caminata?
//20
//#¿Cuántos guías acudirán a la caminata?
//10
//#Como esta caminata tendrá 30 participantes, se necesitan 2 buses.
//#Ingresar la temperatura en grados centígrados
//30
//#Ingrese el porcentaje de humedad relativa
//62
//#Lo siento, hace un mal día. La caminata se deberá hacer en otro día



public class TareaIntegradora1 
{   
    public static void main(String[]args)
    {
        String nombre, id;
        int op_menu;

        Scanner lector = new Scanner(System.in);
        
        System.out.println(" Bienvenido a la aplicación de Interacción de Rutas Ecológicas COP 16 Cali - Colombia.");
        System.out.println("Por favor, dígita tu nombre");
        nombre = lector.nextLine();

        System.out.println("Hola " + nombre + ", ahora digita tu cédula");
        id = lector.nextLine();

        
        System.out.println("--Indique qué ruta quiere programar--");
        System.out.println("(1) Ruta Ladera");
        System.out.println("(2) Ruta oriente");
        System.out.println("(3) Ruta Farallones");
        System.out.println("(4) Salir");

        

        op_menu = lector.nextInt();

        switch (op_menu)
        {
            case 1:
                System.out.println("¡Excelente! La Ruta Ladera tiene como punto de encuentro El Bulevar del Rio, inicia a las 7:30 am y termina a las 1:30 pm");
                calculo_buses();
                temp_hum();
                break;
            case 2:
                System.out.println("¡Excelente! La Ruta Oriente tiene como punto de encuentro El Bulevar del Rio, inicia a las 7:00 am y termina a las 1:00 pm");
                calculo_buses();
                temp_hum();
                break;
            case 3:
                System.out.println("¡Excelente! La Ruta Farallones tiene como punto de encuentro Calle 16 - Universidad del Valle, inicia a las 6:40 am y termina a las 2:30 pm");
                calculo_buses();
                temp_hum();
                break;
            case 4:
                System.out.println("Saliste de la aplicación");
            default: break;
        }

    }


    /**
     * La función entrega la cantidad de buses que se necesitan para la caminata,
     * teniendo en cuenta que cada bus tiene una capacidad de 25 personas
     * @return la cantidad de buses necesarios para la caminata
     */
    public static int calculo_buses()
    {
        int totalAsis;
        int numGuias, numPart;
        final int capacidadBus = 25;

        Scanner lector = new Scanner(System.in);

        System.out.println("¿Cuántos participantes acudirán a la caminata?");
        numPart = lector.nextInt();
        System.out.println("¿Cuántos guías acudirán a la caminata?");
        numGuias = lector.nextInt();



        totalAsis = numGuias + numPart;
        int busesNec = (int) Math.ceil((double) totalAsis / capacidadBus);

        System.out.println("Como esta caminata tendrá " + totalAsis + " participantes, se necesitan " + busesNec + " buses.");

        return busesNec;
    }

    /**
     * La función pide al organizador voluntario la temperatura en grados centígrados y la humedad real.
     * Si la temperatura está entre 20 y 25 grados centígrados, y la humedad real está entre el 40 y 60 por ciento,
     * hace un buen día para realizar la caminata
     */
    public static void temp_hum()
    {
        float tempC, humRel;

        
        Scanner lector = new Scanner(System.in);

        System.out.println("Ingresar la temperatura en grados centígrados");
        tempC = lector.nextFloat();
        System.out.println("Ingrese el porcentaje de humedad relativa");
        humRel = lector.nextFloat();

        if (tempC >= 20 && tempC <= 25 && humRel >= 40 && humRel <= 60 ) 
        {
            System.out.println("¡Hace un buen día para caminar en Cali!");
        }else
        {
            System.out.println("Lo siento, hace un mal día. La caminata se deberá hacer en otro día");

        }
    }
}