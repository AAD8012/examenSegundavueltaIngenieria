package uia.com.inventarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Principal {

    public Principal() {
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Hola UIA, Realizando Examen 2DA VUELTA, Entrega de Material");


        //funcionalidad transitoria para construcción del reporte de nivel de inventario
        NivelInventario inventario = new NivelInventario();
        Volumen volumen1=new Volumen(1,1,1);
        Volumen volumen2=new Volumen(3,3,3);
        Volumen volumen3=new Volumen(2,2,2);
        Condiciones condiciones = new Condiciones("seco", "25 grados centigrados", "menor al 30%");
        Embalaje embalajePlastico = new Embalaje("Plastico", "Embalaje", "embalaje1", 1, "Ingresado,",volumen1);
        Embalaje embalajeMadera = new Embalaje("Madera", "Embalaje", "embalaje1", 1, "Ingresado,",volumen2);
        Embalaje embalajeCarton = new Embalaje("Carton", "Embalaje", "embalaje1", 1, "Ingresado,",volumen3);


        Lote lote1 = new Lote("1000", "Lote 1", "7", "10-10-2020", "700", "Acme 1",embalajePlastico,condiciones);//madera
        Lote lote2 = new Lote("2000", "Lote 2", "8", "10-10-2020", "701", "Acme 2",embalajePlastico,condiciones);//madera
        Lote lote3 = new Lote("3000", "Lote 3", "9", "10-10-2020", "703", "Acme 3",embalajePlastico,condiciones);//madera
        Lote lote4 = new Lote("4000", "Lote 4", "10", "10-10-2020", "704", "Acme 4",embalajePlastico,condiciones);//madera
        Lote lote5 = new Lote("5000", "Lote 5", "7", "10-10-2020", "705", "Acme 5",embalajePlastico,condiciones);//madera
        Lote lote6 = new Lote("6000", "Lote 6", "8", "10-10-2020", "706", "Acme 6",embalajeMadera,condiciones);
        Lote lote7 = new Lote("2000", "Lote 7", "9", "10-11-2021", "800", "Patito 1",embalajeCarton,condiciones);
        Lote lote8 = new Lote("8000", "Lote 8", "10", "10-11-2021", "801", "Patito 2",embalajeCarton,condiciones);
        Lote lote9 = new Lote("9000", "Lote 9", "7", "10-11-2021", "803", "Patito 3",embalajeCarton,condiciones);
        Lote lote10 = new Lote("10000", "Lote 10", "8", "10-11-2021", "804", "Patito 4",embalajeCarton,condiciones);
        Lote lote11 = new Lote("11000", "Lote 11", "9", "10-11-2021", "805", "Patito 5",embalajeCarton,condiciones);

        inventario.agrega("100", "Material Oficina", "110", "Sillas", "111", "Silla ejecutiva clase 1", lote1, 5);
        inventario.agrega("100", "Material Oficina", "110", "Sillas", "112", "Silla ejecutiva clase 2", lote2, 5);
        inventario.agrega("100", "Material Oficina", "110", "Sillas", "113", "Silla secretarial clase 1", lote3, 5);
        inventario.agrega("100", "Material Oficina", "110", "Sillas", "114", "Silla secretarial clase 2", lote4, 5);
        inventario.agrega("100", "Material Oficina", "110", "Sillas", "115", "Silla de espera ", lote5, 5);
        inventario.agrega("100", "Material Oficina", "120", "Mesas", "121", "Mesa ejecutivo clase 1", lote6, 5);
        inventario.agrega("100", "Material Oficina", "130", "Escritorios", "131", "Escritorio ejecutiva clase 1", lote7, 5);
        inventario.agrega("100", "Material Oficina", "130", "Escritorios", "132", "Escritorio ejecutiva clase 2", lote8, 5);
        inventario.agrega("100", "Material Oficina", "130", "Escritorios", "133", "Escritorio secretarial clase 1", lote9, 5);
        inventario.agrega("100", "Material Oficina", "130", "Escritorios", "134", "Escritorio secretarial clase 2", lote10, 5);
        inventario.agrega("100", "Material Oficina", "130", "Escritorios", "135", "Escritorio de espera ", lote11, 5);
        inventario.serializa();


        //funcionalidad transitoria para construcción de la solicitud de Entrega
        GestorEntregaInventario gestorEntrega = new GestorEntregaInventario(new ReporteEntregaInventario());

        SolicitudEntregaMaterial solicitudEntrega = gestorEntrega.agregaSolicitudSalidaMaterial(
                "SolicitudEntregaMaterial",
                "Alfonso ",
                "Profesor TSU");

        solicitudEntrega.agrega("100", "Material Oficina", "110", "Sillas", "111", "Silla ejecutiva clase 1", lote1, 2);
        solicitudEntrega.agrega("100", "Material Oficina", "110", "Sillas", "113", "Silla secretarial clase 1", lote3, 3);
        solicitudEntrega.agrega("100", "Material Oficina", "110", "Sillas", "115", "Silla de espera ", lote5, 4);
        solicitudEntrega.agrega("100", "Material Oficina", "130", "Escritorios", "131", "Escritorio ejecutiva clase 1", lote7, 2);
        solicitudEntrega.agrega("100", "Material Oficina", "130", "Escritorios", "133", "Escritorio secretarial clase 1", lote9, 3);
        solicitudEntrega.agrega("100", "Material Oficina", "130", "Escritorios", "135", "Escritorio de espera ", lote11, 4);
        solicitudEntrega.serializa();


        IEntregaInventario inventario2 = null;
        gestorEntrega = new GestorEntregaInventario(inventario2);
        gestorEntrega.cargaSolicitudEntrega("SolicitudEntregaMaterial_1.json");   // Esta es la solicitud o archivo fuente o documento que se quiere agregar o que se usa para actualizar
        gestorEntrega.cargaInventario("ReporteNivelInventario.json");   // Este es documento objetivo.. el que quieren actualizar
        gestorEntrega.cargaSolicitudEntregaToInventario();
        gestorEntrega.serializaNivelInventario("ReporteNivelInventario.json");



        SpringApplication.run(Principal.class, args);
    }

}
