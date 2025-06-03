package caliciudaddeportiva.service;

import caliciudaddeportiva.micellaneus.dto.*;

import java.util.List;


public interface CCDService {

    List<UserDto> getAllUsers();

    boolean createUserCiudadela(UserDto userDto);
    boolean createUserCiudadelaCodigo(UserDto userDto);





    boolean ValidarMenor(UserDto userDto);

    boolean ValidarCupo(UserDto userDto);




    boolean loginadmin(AdminDto adminDto);

    boolean loginciudadela(AdminDto adminDto);


    List<UserDto> GetRegalopersonamenor(UserDto userDto);

    boolean entregarregalo(UserDto userDto);

    boolean createregalo(RegaloDto regaloDto);
    List<UserDto> GetRegalopersona(UserDto userDto);


    List<UserDto> GetCupoRegalo(UserDto userDto);

    boolean createcarrera(RegaloDto regaloDto);

    List<TallaDto> obtenerTallasDisponibles();

    List<HorarioDto> obtenerHorariosDisponibles();
}
