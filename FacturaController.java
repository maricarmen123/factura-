
package mx.edu.ux.congresos.controller;

import java.util.List;
import mx.edu.ux.congresos.model.Factura;
import mx.edu.ux.congresos.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


//se devine como un controlador
@Controller
//se indica el paquete que contiene los componentes
@ComponentScan("mx.edu.ux.congresos") 
public class FacturaController {
    
    //se agrega el servicio
    @Autowired
    FacturaService facturaservice;
    
    //indice de congresos
     //ruta para el listado de congresos
    
    @RequestMapping("/facturas")
     //funcion encargada (metodo GET)
    
    public String index(Model model) {
        //se recupera la lista de congresos mediante el metodo find all del service
        List facturas = facturaservice.findAllFactura();
        //se agrega como atributo de la vista
        model.addAttribute("facturas", facturas);
         //se regresa la vista
        return "facturas/index";
    }
    
    //ruta para el detalle
    //se envia el ID del congreso como parte de la ruta
    
    @RequestMapping("/facturas/{id}")
    
    public String view(Model model, @PathVariable int id) {
        //se busca por ID
        Factura factura = facturaservice.findById(id);
        // se envia el objeto recuperado a la vista
        model.addAttribute("factura", factura);
        // se regresa la vista
        return "facturas/view";   
    }
    
    //ruta para el registro de congresos
    @RequestMapping("/factura/registro")
    public String register(Model model) {
        //se crea un congreso nuevo
        Factura factura = new Factura();
        //se agrega a la vista el congreso nuevo
        model.addAttribute("factura", factura);
        //Se regresa la vista
        return "facturas/form";   
    }
    
}
