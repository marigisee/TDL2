package practica7.model;

public class Futbolista {

        private int idfutbolista;
        private String nombre;
        private String apellido;
        private String docIdentidad;
        private String telefono;
        private String email;
        private int idpais;


        public Futbolista() {

        }

        public Futbolista(String nombre, String apellido, int edad, String posicion, int idpais) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.docIdentidad = docIdentidad;
            this.telefono = telefono;
            this.email = email;
            this.idpais = idpais;
        }

        @Override
        public String toString() {
            return "Futbolista{" +
                    "idfutbolista=" + idfutbolista +
                    ", nombre='" + nombre + '\'' +
                    ", apellido='" + apellido + '\'' +
                    ", docIdentidad='" + docIdentidad + '\'' +
                    ", telefono='" + telefono + '\'' +
                    ", email='" + email + '\'' +
                    ", idpais=" + idpais +
                    '}';
        }


    // Getters y Setters


    public int getIdfutbolista() {
        return idfutbolista;
    }

    public void setIdfutbolista(int idfutbolista) {
        this.idfutbolista = idfutbolista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocIdentidad() {
        return docIdentidad;
    }

    public void setDocIdentidad(String docIdentidad) {
        this.docIdentidad = docIdentidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdpais() {
        return idpais;
    }

    public void setIdpais(int idpais) {
        this.idpais = idpais;
    }
}
