/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalTek.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.globalTek.persistance.FacturaPersistance;
import com.globalTek.models.Factura;

/**
 *
 * @author David
 */
@Service
public class FacturaService {
    
    @Autowired
    private FacturaPersistance facturaPersistance;
    
    public Factura insert(Factura factura){
        return facturaPersistance.save(factura);
    }
    
    public Factura update(Factura factura){
        return facturaPersistance.save(factura);
    }
    
    public List<Factura> getList (){
        return facturaPersistance.findAll();
    }
    
    public void delete(Factura factura){
        facturaPersistance.delete(factura);
    }
}
