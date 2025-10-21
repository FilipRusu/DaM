package Jaxb.PruebaUT1;



import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement(name = "almacen")
@XmlType(propOrder = {"articulos"})
public class Almacen {
    
    private List<Articulo> articulos;

    public Almacen() {}

    public Almacen(List<Articulo> articulos) {
        this.articulos = articulos;
    }
    @XmlElement(name = "articulos")
    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }
}