/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalTek.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import com.globalTek.models.Factura;
import org.springframework.stereotype.Repository;
/**
 *
 * @author David
 */
@Repository
public interface FacturaPersistance extends JpaRepository<Factura, Integer>{
    
}
