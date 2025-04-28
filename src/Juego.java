
public class Juego {
    private String nombre;
    private String categoria;
    private double precio;
    private int licenciasDisponibles;
    private int licenciasVendidas;

    public Juego(String nombre, String categoria, double precio, int licenciasDisponibles) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.licenciasDisponibles = licenciasDisponibles;
        this.licenciasVendidas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public int getLicenciasDisponibles() {
        return licenciasDisponibles;
    }

    public int getLicenciasVendidas() {
        return licenciasVendidas;
    }

    public void comprarLicencias(int cantidad) {
        licenciasDisponibles += cantidad;
    }

    public boolean venderLicencia() {
        if (licenciasDisponibles > 0) {
            licenciasDisponibles--;
            licenciasVendidas++;
            return true;
        } else {
            return false;
        }
    }

    public String mostrarInformacion() {
        return "Nombre: " + nombre + ", Categoría: " + categoria + ", Precio: $" + precio +
                ", Licencias Disponibles: " + licenciasDisponibles + ", Licencias Vendidas: " + licenciasVendidas;
    }
}
