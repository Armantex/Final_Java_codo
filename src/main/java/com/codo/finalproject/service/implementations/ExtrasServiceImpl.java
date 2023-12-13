package com.codo.finalproject.service.implementations;

import com.codo.finalproject.dto.response.ResponseDto;
import com.codo.finalproject.entity.*;
import com.codo.finalproject.repository.interfaces.*;
import com.codo.finalproject.service.interfaces.IExtrasService;
import com.codo.finalproject.service.interfaces.IReservaService;
import com.codo.finalproject.util.Aerolineas;
import com.codo.finalproject.util.MetodoPago;
import com.codo.finalproject.util.Rol;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class ExtrasServiceImpl implements IExtrasService {

    IVueloRepository vueloRepository;
    IAsientoRepository iAsientoRepository;
    IComprobanteRepository iComprobanteRepository;
    IPasajeroRepository iPasajeroRepository;
    IReservaRepository iReservaRepository;
    IUsuarioRepository iUsuarioRepository;

    public ExtrasServiceImpl(IVueloRepository vueloRepository, IAsientoRepository iAsientoRepository, IComprobanteRepository iComprobanteRepository, IPasajeroRepository iPasajeroRepository, IReservaRepository iReservaRepository, IUsuarioRepository iUsuarioRepository) {
        this.vueloRepository = vueloRepository;
        this.iAsientoRepository = iAsientoRepository;
        this.iComprobanteRepository = iComprobanteRepository;
        this.iPasajeroRepository = iPasajeroRepository;
        this.iReservaRepository = iReservaRepository;
        this.iUsuarioRepository = iUsuarioRepository;
    }

    @Override
    public ResponseDto cargarBaseDeDatos(int cantidad) {
        //cantidad = 12;
        Usuario[] usuarios = usuarioDataGen(cantidad+1);
        System.out.println(Arrays.toString(usuarios));
        List<Reserva> reservas = reservaAndComprobanteDataGen(cantidad+1,usuarios);
        vueloDataGen(cantidad,reservas);

        return new ResponseDto("La carga de datos se completo correctamente;");
    }

    private Usuario[] usuarioDataGen(int cantidad){
        Long id;
        String nombre;
        Integer telefono;
        String domicilio;
        String email;
        Rol rol;
        List<Usuario> list = new ArrayList<>();
        for(Long i = 1L; i < cantidad; i++){
            list.add(new Usuario(i,"Nombre Generico "+ i, (int) (i+100000),"Domicilio Generico "+i,"Email Generico "+i,Rol.C,null));
        }
        return list.toArray(new Usuario[0]);
    }


    private List<Reserva> reservaAndComprobanteDataGen(int cantidad,Usuario[] users) {
        Long id;
        MetodoPago metodoPago;
        Double monto;
        Integer codigo;
        Set<Pasajero> setPasajeros = new HashSet<>();
        List<Reserva> reservaList = new ArrayList<>();
        for (Long i = 1L; i < cantidad; i++) {
            Pasajero pasajero = new Pasajero();
            pasajero.setId(i);
            pasajero.setNombre("Nombre Generico " + i);
            setPasajeros.add(pasajero);

            iPasajeroRepository.save(pasajero);
        }

        for (Long i = 1L; i < cantidad; i++) {


            Reserva reserva = new Reserva();
            id = i;
            metodoPago = MetodoPago.TB;
            monto = i * 98545.3;
            codigo = Math.toIntExact(i * 8888);
            Comprobante comprobante = new Comprobante(id, metodoPago, monto, codigo, null);


            //reserva.setId(id);
            reserva.setFechaViaje(LocalDate.of(2023, Math.toIntExact(i), Math.toIntExact(i)));
            reserva.setPagada(true);
            reserva.setPasajeros(setPasajeros);
            reserva.setReservas_usuario(users[Math.toIntExact(i-1)]);
            reserva.setAsientos(setAsientoGen(cantidad));
            Usuario userSave = users[Math.toIntExact(i-1)];

            iUsuarioRepository.save(userSave);
            comprobante.setReserva(reserva);
            reservaList.add(reserva);
            iReservaRepository.save(reserva); //CascadeType.MERGE
            iComprobanteRepository.save(comprobante);
        }
        return reservaList;
    }
        private Set<Asiento> setAsientoGen(int cantidad){
            Set<Asiento> setAsientos = new HashSet<>();
            for (Long i = 1L; i < cantidad; i++) {
                Asiento asiento = new Asiento();
                asiento.setDisponibilidad(true);
                setAsientos.add(asiento);
                iAsientoRepository.save(asiento);
            }
            return setAsientos;
    }


    //Generador de data de vuelos
    private void vueloDataGen(int cantidad, List<Reserva> reservaList){
        Long id;
        LocalDateTime horaInicio;
        LocalDateTime horaFinal;
        String aeroOrigen;
        String aeroDestino;
        Double precio;
        String opcionesConexion;
        boolean isFull;
        short espacioDisponible;
        String aerolinea;
        Reserva reserva;


        for(Long i = 1L; i < cantidad; i++){

            id = i;
            horaInicio = LocalDateTime.of(2023, Math.toIntExact(i), Math.toIntExact(i), Math.toIntExact(i), Math.toIntExact(i * 3), Math.toIntExact(i));
            horaFinal = LocalDateTime.of(2023, Math.toIntExact(i)+1, Math.toIntExact(i)+1, Math.toIntExact(i)+1, Math.toIntExact(i * 3)+1, Math.toIntExact(i)+1);
            aeroOrigen = "Aeroparque, Jorge Newbery";
            aeroDestino = "Bariloche, Teniente Luis Candelaria";
            precio = i * 99999.3;
            opcionesConexion = "";
            aerolinea = Aerolineas.AEROLINEASARG.toString();
            if(i % 2 == 0){
                isFull = false;
                espacioDisponible = (short) (i*7L);
            }else {
                isFull = true;
                espacioDisponible = 0;
            }


            Vuelo vuelo = new Vuelo(id,horaInicio,horaFinal,aeroOrigen,aeroDestino,precio,opcionesConexion,isFull,espacioDisponible,aerolinea, reservaList.iterator().next(),setAsientoGen(cantidad));
            vueloRepository.save(vuelo);
        }


    }
}
