package uia.com.inventarios;

public class Lote extends InfoUIA{

    private String fechaIngreso = "";
    private Proveedor proveedor = new Proveedor();

    private Embalaje embalaje=new Embalaje();

    private Condiciones condiciones=new Condiciones();
    public Lote() {
        super();
    }

//    public Lote(String clase, String id, String name, String cantidad, String estatus, String fechaIngreso, Proveedor proveedor, Embalaje embalaje, Condiciones condiciones) {
//        super(clase, id, name, cantidad, estatus);
//        this.fechaIngreso = fechaIngreso;
//        this.proveedor = proveedor;
//        this.embalaje = embalaje;
//        this.condiciones = condiciones;
//    }





        public Lote(String idLote, String descLote, String cantidad, String fechaIngreso, String idProv, String descProv,Embalaje embalaje, Condiciones condiciones)
    {
        super("Lote", idLote, descLote, cantidad, "Ingresado");
        this.fechaIngreso = fechaIngreso;
        proveedor.setName(descLote);
        proveedor.setId(idProv);
        this.embalaje = embalaje;
        this.condiciones = condiciones;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Embalaje getEmbalaje() {
        return embalaje;
    }

    public void setEmbalaje(Embalaje embalaje) {
        this.embalaje = embalaje;
    }

    public Condiciones getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(Condiciones condiciones) {
        this.condiciones = condiciones;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
