public class AppStore {
    private Juego[] juegos;
    private int cantidadJuegos;

    public static final double PORCENTAJE_COMPRA = 0.25;
    public static final int LIMITE_DEPORTE_AVENTURA = 10;
    public static final int LIMITE_ACCION_VELOCIDAD = 15;

    public AppStore() {
        juegos = new Juego[100]; // tamaño máximo 100 juegos
        cantidadJuegos = 0;
    }

    public void agregarJuego(Juego juego) {
        if (cantidadJuegos < juegos.length) {
            juegos[cantidadJuegos] = juego;
            cantidadJuegos++;
        }
    }

    public String mostrarTodosLosJuegos() {
        String info = "";
        for (int i = 0; i < cantidadJuegos; i++) {
            info += juegos[i].mostrarInformacion() + "\n";
        }
        return info;
    }

    public boolean comprarLicencias(String nombre, int cantidad) {
        for (int i = 0; i < cantidadJuegos; i++) {
            if (juegos[i].getNombre().equalsIgnoreCase(nombre)) {
                juegos[i].comprarLicencias(cantidad);
                return true;
            }
        }
        return false;
    }

    public boolean venderLicencia(String nombre) {
        for (int i = 0; i < cantidadJuegos; i++) {
            if (juegos[i].getNombre().equalsIgnoreCase(nombre)) {
                return juegos[i].venderLicencia();
            }
        }
        return false;
    }

    public String juegoMasVendido() {
        if (cantidadJuegos == 0) return "NINGUNO";

        Juego masVendido = juegos[0];
        for (int i = 1; i < cantidadJuegos; i++) {
            if (juegos[i].getLicenciasVendidas() > masVendido.getLicenciasVendidas()) {
                masVendido = juegos[i];
            }
        }

        boolean todosIguales = true;
        for (int i = 0; i < cantidadJuegos; i++) {
            if (juegos[i].getLicenciasVendidas() != masVendido.getLicenciasVendidas()) {
                todosIguales = false;
                break;
            }
        }

        return todosIguales ? "NINGUNO" : masVendido.getNombre();
    }

    public String consultarDescuento(int cantidad) {
        if (cantidad >= 10 && cantidad < 20) {
            return "10% de descuento";
        } else if (cantidad >= 20) {
            return "20% de descuento";
        } else {
            return "Sin descuento";
        }
    }

    public String darJuegoMenosVendido() {
        if (cantidadJuegos == 0) return "NINGUNO";

        Juego menosVendido = juegos[0];
        for (int i = 1; i < cantidadJuegos; i++) {
            if (juegos[i].getLicenciasVendidas() < menosVendido.getLicenciasVendidas()) {
                menosVendido = juegos[i];
            }
        }

        boolean todosIguales = true;
        for (int i = 0; i < cantidadJuegos; i++) {
            if (juegos[i].getLicenciasVendidas() != menosVendido.getLicenciasVendidas()) {
                todosIguales = false;
                break;
            }
        }

        return todosIguales ? "NINGUNO" : menosVendido.getNombre();
    }

    public String darComprasPorPorcentaje() {
        String nombreJuegoMenosVendido = darJuegoMenosVendido();
        if (nombreJuegoMenosVendido.equals("NINGUNO")) {
            return "NINGUNO";
        }

        int licenciasDelMenosVendido = 0;
        for (int i = 0; i < cantidadJuegos; i++) {
            if (juegos[i].getNombre().equalsIgnoreCase(nombreJuegoMenosVendido)) {
                licenciasDelMenosVendido = juegos[i].getLicenciasDisponibles();
                break;
            }
        }

        String resultado = "";
        for (int i = 0; i < cantidadJuegos; i++) {
            if (juegos[i].getLicenciasDisponibles() < licenciasDelMenosVendido * PORCENTAJE_COMPRA) {
                resultado += juegos[i].getNombre() + ", ";
            }
        }

        if (resultado.equals("")) {
            return "NINGUNO";
        } else {
            return resultado.substring(0, resultado.length() - 2); // Quitar última coma
        }
    }

    public String metodo1() {
        return "Juegos que deberían comprarse por porcentaje: " + darComprasPorPorcentaje();
    }

    public boolean seDebeComprarPorCategoria(String nombreJuego) {
        for (int i = 0; i < cantidadJuegos; i++) {
            if (juegos[i].getNombre().equalsIgnoreCase(nombreJuego)) {
                String categoria = juegos[i].getCategoria();
                int disponibles = juegos[i].getLicenciasDisponibles();

                if ((categoria.equalsIgnoreCase("Deporte") || categoria.equalsIgnoreCase("Aventura")) && disponibles < LIMITE_DEPORTE_AVENTURA) {
                    return true;
                }
                if ((categoria.equalsIgnoreCase("Accion") || categoria.equalsIgnoreCase("Velocidad")) && disponibles < LIMITE_ACCION_VELOCIDAD) {
                    return true;
                }
            }
        }
        return false;
    }

    public String metodo2() {
        String resultado = "";
        for (int i = 0; i < cantidadJuegos; i++) {
            if (seDebeComprarPorCategoria(juegos[i].getNombre())) {
                resultado += juegos[i].getNombre() + ", ";
            }
        }

        if (resultado.equals("")) {
            return "NINGUNO";
        } else {
            return resultado.substring(0, resultado.length() - 2);
        }
    }
}
