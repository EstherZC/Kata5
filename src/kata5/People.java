package kata5;

class People {

    private String name;
    private String apellidos;
    private String departamento;

    People(String name, String apellidos, String departamento) {
        this.name = name;
        this.apellidos = apellidos;
        this.departamento = departamento;
    }

    String getName() {
        return this.name;
    }

    String getApellidos() {
        return this.apellidos;
    }

    String getDepartamento() {
        return this.departamento;
    }
    
}