/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion.tarea.Servicio;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.webservicex.Airport;
import net.webservicex.AirportSoap;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

/**
 *
 * @author PedroPablo
 */
@WebService(serviceName = "Servicio")
public class Servicio {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "Servicio")
    public String[] Servicio(@WebParam(name = "country") String country) {
        
        GlobalWeather gw = new GlobalWeather();
        GlobalWeatherSoap gwSoap = gw.getGlobalWeatherSoap();
        Airport airport = new Airport();
        AirportSoap airportSoap = airport.getAirportSoap();
        
        String cities = gwSoap.getCitiesByCountry(country);
        String aeropuerto = airportSoap.getAirportInformationByCountry(country);
        String[] resultado = new String[2];
        resultado[0] = cities;
        resultado[1] = aeropuerto;
        return resultado;
    }
}
