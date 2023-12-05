package practica7.model;


public class Pais {

        private int idpais;
        private String nombre;
        private String idioma;

        public Pais(String nombre, String idioma) {
            this.nombre = nombre;
            this.idioma = idioma;
        }

    public Pais() {

    }

    @Override
    public String toString() {
        return "Pais{" +
                "idpais=" + idpais + ", nombre='" + nombre + '\'' + ", idioma='" + idioma + '\'' + '}';
    }

    public String toStringSinIdioma(){
            return "Pais{" +
                    "idpais=" + idpais + ", nombre='" + nombre + '\'' + '}';
    }


    // Getters y Setters

        public int getIdpais() {
            return idpais;
        }

        public void setIdpais(int idpais) {
            this.idpais = idpais;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getIdioma() {
            return idioma;
        }

        public void setIdioma(String idioma) {
            this.idioma = idioma;
        }

}
