package com.c3.Ejercicio4.Controller;

import com.c3.Ejercicio4.Model.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class FormularioController {
    private ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    @GetMapping("/producto/nuevo")
    public String mostrarFormulario() {
        return "formulario";
    }

    @PostMapping("/producto/nuevo")
    public String guardarProducto(@RequestParam String nombre,@RequestParam double precio,@RequestParam String descripcion, Model model) {
        // Implementación de guardado en base de datos
        Producto producto = new Producto(nombre, precio, descripcion);
        System.out.println(producto);
        listaProductos.add(producto);
        model.addAttribute("mensaje","Producto Creado exitosamente: "+producto);
        return "confirmacion";
    }

    @GetMapping("/productos/lista")
    @ResponseBody
    public ArrayList<Producto> mostrarListadoProductos(Model model) {
        return listaProductos;
    }
}
