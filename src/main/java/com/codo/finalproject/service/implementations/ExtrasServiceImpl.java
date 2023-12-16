package com.codo.finalproject.service.implementations;

import com.codo.finalproject.dto.response.ResponseDto;
import com.codo.finalproject.entity.*;
import com.codo.finalproject.repository.interfaces.*;
import com.codo.finalproject.service.interfaces.IExtrasService;
import com.codo.finalproject.util.Aerolineas;
import com.codo.finalproject.util.MetodoPago;
import com.codo.finalproject.util.Rol;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class ExtrasServiceImpl implements IExtrasService {

    IVueloRepository ivueloRepository;
    IAsientoRepository iAsientoRepository;
    IComprobanteRepository iComprobanteRepository;
    IPasajeroRepository iPasajeroRepository;
    IReservaRepository iReservaRepository;
    IUsuarioRepository iUsuarioRepository;

    public ExtrasServiceImpl(IVueloRepository vueloRepository, IAsientoRepository iAsientoRepository, IComprobanteRepository iComprobanteRepository, IPasajeroRepository iPasajeroRepository, IReservaRepository iReservaRepository, IUsuarioRepository iUsuarioRepository) {
        this.ivueloRepository = vueloRepository;
        this.iAsientoRepository = iAsientoRepository;
        this.iComprobanteRepository = iComprobanteRepository;
        this.iPasajeroRepository = iPasajeroRepository;
        this.iReservaRepository = iReservaRepository;
        this.iUsuarioRepository = iUsuarioRepository;
    }

    @Override
    public ResponseDto cargarBaseDeDatos(int cantidad) {
        cantidad = cantidad + 1;
        List<Usuario> usuarios = usuarioDataGen(cantidad);
        List<Comprobante> comprobantes = comprobanteDataGen(cantidad);
        List<Vuelo> vuelos = vueloDataGen(cantidad);
        List<Reserva> reservas = reservaDataGen(cantidad, usuarios, vuelos, comprobantes);
        List<Pasajero> pasajeros = pasajeroDataGen(cantidad * 2, reservas);
        asientoDataGen(cantidad * 30, reservas, vuelos, pasajeros);
        return new ResponseDto("Se completo correctamente la ddbb");
    }

    private List<Usuario> usuarioDataGen(int cantidad) {
        List<Usuario> usuarios = new ArrayList<>();
        for (long i = 1L; i < cantidad; i++) {
            Usuario usuario = new Usuario();
            usuario.setId(i);
            usuario.setNombre("Nombre Generico " + i);
            usuario.setRol(Rol.C);
            usuario.setDomicilio("Domicilio Generico " + i);
            usuario.setReservas(null);
            usuario.setTelefono((int) (i + 100000));
            usuario.setEmail("Email Generico " + i);
            usuarios.add(usuario);
        }
        iUsuarioRepository.saveAll(usuarios);
        return usuarios;
    }
    private List<Vuelo> vueloDataGen(int cantidad) {
        List<Vuelo> vuelos = new ArrayList<>();
        for (long i = 1L; i < cantidad; i++) {
            Vuelo vuelo = new Vuelo();
            vuelo.setId(i);
            vuelo.setHorarioInicio(LocalDateTime.of(2023, Math.toIntExact(i), Math.toIntExact(i), Math.toIntExact(i), Math.toIntExact(i * 3), Math.toIntExact(i)));
            vuelo.setHorarioFinal(LocalDateTime.of(2023, Math.toIntExact(i) + 1, Math.toIntExact(i) + 1, Math.toIntExact(i) + 1, Math.toIntExact(i * 3) + 1, Math.toIntExact(i) + 1));
            vuelo.setAeropuertoOrigen("Aeroparque, Jorge Newbery");
            vuelo.setAeropuertoDestino("Bariloche, Teniente Luis Candelaria");
            vuelo.setPrecio(i * 99999.3);
            vuelo.setOpcionesConexion("");
            vuelo.setAerolinea(Aerolineas.AEROLINEASARG.toString());
            if (i % 2 == 0) {
                vuelo.setIsFull(false);
                vuelo.setEspacioDisponible((short) (i * 7L));
            } else {
                vuelo.setIsFull(true);
                vuelo.setEspacioDisponible((short) 0);
            }
            vuelos.add(vuelo);
        }
        ivueloRepository.saveAll(vuelos);
        return vuelos;
    }
    private List<Comprobante> comprobanteDataGen(int cantidad) {
        List<Comprobante> comprobantes = new ArrayList<>();
        Random rand = new Random();
        int maxC=1000, minC=500, maxM=2000, minM=1000;
        for (long i = 1L; i < cantidad; i++) {
            double monto = rand.nextDouble(maxM - minM + 1) + minM;
            Comprobante comprobante = new Comprobante();
            comprobante.setId(i);
            comprobante.setMetodoPago(MetodoPago.TB);
            comprobante.setCodigoComprobante(rand.nextInt(maxC - minC + 1) + minC);
            comprobante.setMonto(Math.round(monto * 100)/100D);
            comprobantes.add(comprobante);
        }
        iComprobanteRepository.saveAll(comprobantes);
        return comprobantes;
    }

    private List<Pasajero> pasajeroDataGen(int cantidad, List<Reserva> reservas){
        List<Pasajero> pasajeros = new ArrayList<>();
        Random rand = new Random();
        int max = reservas.size(), min=0;
        for (long i = 1L; i < cantidad; i++) {
            int indexReservaRamdom = rand.nextInt(min, max);
            Pasajero pasajero = new Pasajero();
            pasajero.setId(i);
            pasajero.setNombre("Nombre Generico " + i);
            pasajero.setPasajeros_reserva(reservas.get(indexReservaRamdom));
            pasajeros.add(pasajero);
        }
        iPasajeroRepository.saveAll(pasajeros);
        return pasajeros;
    }

    private List<Reserva> reservaDataGen(int cantidad, List<Usuario> usuarios, List<Vuelo> vuelos, List<Comprobante> comprobantes) {
        List<Reserva> reservas = new ArrayList<>();
        Random rand = new Random();
        int max = usuarios.size(), min=0, maxV = vuelos.size(), minV=0;
        List<Integer> shuffleNumber = new ArrayList<>();
        for (int i = 0; i < comprobantes.size(); i++){
            shuffleNumber.add(i);
        }
        Collections.shuffle(shuffleNumber);

        for (long i = 1L; i < cantidad; i++) {
            int indexUsuarioRamdom = rand.nextInt(min, max);
            int indexVuelosRamdom = rand.nextInt(minV, maxV);
            Reserva reserva = new Reserva();
            reserva.setId(i);
            reserva.setFechaViaje(LocalDate.of(2023, Math.toIntExact(i), Math.toIntExact(i)));
            reserva.setPagada(false);
            reserva.setComprobante_reserva(comprobantes.get(shuffleNumber.get((int) i - 1)));
            reserva.setReservas_usuario(usuarios.get(indexUsuarioRamdom));
            reserva.setReservas_vuelo(vuelos.get(indexVuelosRamdom));
            reservas.add(reserva);
        }
        iReservaRepository.saveAll(reservas);
        return reservas;
    }

    private void asientoDataGen(int cantidad, List<Reserva> reservas, List<Vuelo> vuelos, List<Pasajero> pasajeros) {
        List<Asiento> asientos = new ArrayList<>();
        Random rand = new Random();
        int maxV = vuelos.size(), minV= 0;
        List<Integer> indexReservasVuelos = new ArrayList<>();
        List<Integer> indexVuelos = new ArrayList<>();
        for(Reserva reserva : reservas){
            for (Pasajero pasajero: pasajeros){
                if (Objects.equals(pasajero.getPasajeros_reserva().getId(), reserva.getId())){
                    indexVuelos.add((int) (long) reserva.getReservas_vuelo().getId() - 1);
                    indexReservasVuelos.add((int)(long) reserva.getId() - 1);
                }
            }
        }
        for (int i = 0; i < cantidad - indexReservasVuelos.size(); i++){
            indexVuelos.add(rand.nextInt(minV, maxV));
        }
        Collections.shuffle(indexVuelos);

        for (long i = 1L; i < cantidad; i++) {
            int numVuelo = indexVuelos.get((int) i - 1);
            Reserva reservaInicial = reservas.get(numVuelo);
            Asiento asiento = new Asiento();
            asiento.setId(i);
            if (indexReservasVuelos.contains(numVuelo)) {
                asiento.setAsientos_reserva(reservaInicial);
                asiento.setDisponibilidad(false);
                indexReservasVuelos.remove(indexReservasVuelos.indexOf(numVuelo));
            } else {
                asiento.setDisponibilidad(true);
                asiento.setAsientos_reserva(null);
            }

            asiento.setAsientos_vuelo(vuelos.get(indexVuelos.get((int) i - 1)));
            asientos.add(asiento);
        }
        iAsientoRepository.saveAll(asientos);

    }

}
