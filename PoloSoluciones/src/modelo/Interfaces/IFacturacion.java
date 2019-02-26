/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Interfaces;

/**
 *
 * @author cdap_
 */
public interface IFacturacion extends ICrud{
    public Object RegistrarFactura(Object object, Object object2);
    /***
     * Filtra los documentos que tienen movimiento de dinero, para asi mostrarlo
     * en el cuadre de la caja.
     * @param object
     * @return 
     */
    public Object MostrarTodoEnCaja(Object object);
    /***
     * Mètodo encargado de mostrar la informaciòn agrupada de los movimientos de 
     * dinero en un dìa
     * @param object
     * @return 
     */
    public Object MostrarResumenEnCaja(Object object);
}
