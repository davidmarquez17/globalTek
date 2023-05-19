/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalTek.logic;

import java.util.Date;

/**
 *
 * @author David
 */
public class LogicFactura {
    public static boolean validarFecha(Date fechaFactura){
        java.util.Date fecha = new Date();
        int milisecondsByDay = 86400000;
        if((int) (fecha.getTime() - fechaFactura.getTime()) / milisecondsByDay > 1) return true;
        else return false;
    }
}
