package caliciudaddeportiva.service;

import caliciudaddeportiva.micellaneus.dto.AdminDto;
import caliciudaddeportiva.micellaneus.dto.RegaloDto;
import caliciudaddeportiva.micellaneus.dto.UserDto;

import java.util.List;


public interface CCDService {

    List<UserDto> getAllUsers();
    List<UserDto> getAllCiudadela4s(UserDto userDto);
    List<UserDto> GetRegalopersona(UserDto userDto);
    List<UserDto> GetRegalopersonamenor(UserDto userDto);


    List<RegaloDto> buscarultimoregistroregalo(RegaloDto regaloDto);

    List<UserDto> getUserByText(UserDto userDto);


    boolean createciudadela(UserDto userDto);
    boolean createregalo(RegaloDto regaloDto);





    boolean loginadmin(AdminDto adminDto);


    boolean updateUser(UserDto userDto);

    boolean entregarregalo(UserDto userDto);

    boolean deleteUser(int idUsuario);


    boolean createUser(UserDto userDto);


    boolean validarregalo(UserDto userDto);
    boolean validarregaloadulto(UserDto userDto);



}
