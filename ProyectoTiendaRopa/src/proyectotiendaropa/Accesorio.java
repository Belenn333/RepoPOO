package proyectotiendaropa;

public class Accesorio {

    // Declaracion de atributos Clase Accesorio.
    private String codigo;
    private String nombre;
    private String color;
    private double precio;
    private int stock;

    // Aplicando encapsulamiento con getters y setters.
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            System.out.println("Error: el codigo es obligatorio.");
        } else {
            this.codigo = codigo;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Error: el nombre es obligatorio.");
        } else {
            this.nombre = nombre;
        }
    }

    // Color del accesorio.
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            System.out.println("Error: el color es obligatorio.");
        } else {
            this.color = color;
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        } else {
            System.out.println("Error: el precio no puede ser negativo.");
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            System.out.println("Error: el stock no puede ser negativo.");
        }
    }

    // ----------- APLICANDO SOBRECARGA DE METODOS -----------

    // Busca un accesorio por codigo.
    // Devuelve true si coincide y mantiene la salida por consola de Principal.
    public boolean buscar(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            System.out.println("Error: ingrese un codigo para buscar.");
            return false;
        }

        if (this.codigo != null && this.codigo.equalsIgnoreCase(codigo)) {
            mostrar();
            return true;
        }
        System.out.println("No se encontro un accesorio con ese codigo.");
        return false;
    }

    // Sobrecarga: busca un accesorio por nombre y color.
    public boolean buscar(String nombre, String color) {
        return this.nombre != null && this.color != null
                && nombre != null && color != null
                && this.nombre.equalsIgnoreCase(nombre)
                && this.color.equalsIgnoreCase(color);
    }

    // Sobrecarga: busca por nombre y stock minimo.
    // Devuelve el stock disponible o -1 si no cumple los criterios.
    public int buscar(String nombre, int stockMinimo) {
        if (nombre == null || nombre.trim().isEmpty() || stockMinimo < 0) {
            return -1;
        }
        if (this.nombre != null
                && this.nombre.equalsIgnoreCase(nombre)
                && this.stock >= stockMinimo) {
            return this.stock;
        }
        return -1;
    }

    // Metodo para registrar un nuevo accesorio.
    public boolean agregar(String codigo, String nombre, double precio, int stock) {
        if (codigo != null && !codigo.trim().isEmpty()
                && nombre != null && !nombre.trim().isEmpty()
                && precio > 0 && stock >= 0) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.precio = precio;
            this.stock = stock;
            return true;
        }
        return false;
    }

    // Sobrecarga para registrar un accesorio incluyendo el color.
    public boolean agregar(String codigo, String nombre, String color,
            double precio, int stock) {
        if (codigo != null && !codigo.trim().isEmpty()
                && nombre != null && !nombre.trim().isEmpty()
                && color != null && !color.trim().isEmpty()
                && precio > 0 && stock >= 0) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.color = color;
            this.precio = precio;
            this.stock = stock;
            return true;
        }
        return false;
    }

    // Sobrecarga para modificar solamente nombre y color.
    // No modifica el codigo, el precio ni el stock.
    public boolean agregar(String nombre, String color) {
        if (nombre != null && !nombre.trim().isEmpty()
                && color != null && !color.trim().isEmpty()) {
            this.nombre = nombre;
            this.color = color;
            return true;
        }
        return false;
    }

    // Elimina el accesorio si el codigo coincide.
    // La eliminacion del ArrayList se realiza desde Principal o el formulario.
    public boolean eliminar(String codigo) {
        return this.codigo != null && codigo != null
                && this.codigo.equalsIgnoreCase(codigo);
    }

    // Devuelve los datos para una JTable.
    public Object[] mostrar(boolean tabla) {
        return new Object[]{
            codigo,
            nombre,
            color,
            precio,
            stock
        };
    }

    // Mantiene el metodo mostrar() que utiliza Principal.java.
    public void mostrar() {
        System.out.println("Codigo: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Color: " + color);
        System.out.println("Precio: " + precio);
        System.out.println("Stock: " + stock);
    }
}
