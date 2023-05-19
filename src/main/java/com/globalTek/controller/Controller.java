/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalTek.controller;

import com.globalTek.logic.LogicFactura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.globalTek.service.FacturaService;
import com.globalTek.models.Factura;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author David
 */
@RestController
@RequestMapping("/api/v1/facturas")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class Controller {
    
    @Autowired
    private FacturaService facturaService;
    
    @RequestMapping
    public List<Factura> getFacturas(ModelMap model){
        return facturaService.getList();
    }
    
    @PostMapping
    public Factura insert(@RequestBody Factura factura){
        if(factura.getSubTotal() > 0){
            factura.setTotalDescuento((int) (factura.getSubTotal() * ((double) factura.getDescuento()/100)));  //calcula el descuento
            factura.setTotalImpuesto((int) (factura.getSubTotal() - factura.getTotalDescuento()) * ((double) factura.getIva()/100)); // calcula el impuesto
            factura.setTotal(factura.getSubTotal() - factura.getTotalDescuento() + factura.getTotalImpuesto()); //calcula el total
            
            if(LogicFactura.validarFecha(factura.getFecha())) return null; //valida que sea la fecha actual
            else return facturaService.insert(factura);
        }        
                
        else return null;
    }
    
    @PutMapping
    public Factura update(@RequestBody Factura factura){
        if(factura.getSubTotal() > 0){
            factura.setTotalDescuento((int) (factura.getSubTotal() * ((double) factura.getDescuento()/100))); //calcula el descuento
            factura.setTotalImpuesto((int) (factura.getSubTotal() - factura.getTotalDescuento()) * ((double) factura.getIva()/100)); // calcula el impuesto
            factura.setTotal(factura.getSubTotal() - factura.getTotalDescuento() + factura.getTotalImpuesto()); //calcula el total
            return facturaService.update(factura);
        }
        else return null;
    }
    
    @DeleteMapping
    public void delete(@RequestBody Factura factura){
        facturaService.delete(factura);
    }
}
