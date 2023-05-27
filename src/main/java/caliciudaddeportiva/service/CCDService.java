package caliciudaddeportiva.service;

import caliciudaddeportiva.micellaneus.dto.AdminDto;
import caliciudaddeportiva.micellaneus.dto.CodigoDto;
import caliciudaddeportiva.micellaneus.dto.RegaloDto;
import caliciudaddeportiva.micellaneus.dto.UserDto;

import java.util.List;


public interface CCDService {

    List<UserDto> getAllUsers();

    boolean createUserCiudadela(UserDto userDto);


    boolean createUserCarrera7k(UserDto userDto);

    boolean createUserCarrera(UserDto userDto);


    boolean ValidarMenor(UserDto userDto);

    boolean loginadmin(AdminDto adminDto);

    boolean loginciudadela(AdminDto adminDto);

    boolean logincarrera(AdminDto adminDto);

    List<UserDto> GetRegalopersonamenor(UserDto userDto);

    boolean entregarregalo(UserDto userDto);

    boolean createregalo(RegaloDto regaloDto);
    List<UserDto> GetRegalopersona(UserDto userDto);


    List<UserDto> GetCupoRegalo(UserDto userDto);

    boolean createcarrera(RegaloDto regaloDto);








}
