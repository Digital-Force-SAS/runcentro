package codesa.service;

import codesa.micellaneus.dto.EntradaDto;
import codesa.micellaneus.dto.UserDto;

import java.util.List;


public interface CodesaService {

    List<UserDto> getAllUsers();

    List<UserDto> getUserByText(UserDto userDto);


    boolean updateUser(UserDto userDto);

    boolean deleteUser(int idUsuario);


    boolean createUser(UserDto userDto);

    boolean updateentrada(EntradaDto entradaDto);

    boolean consultentrada(EntradaDto entradaDto);


    boolean createUser3(UserDto userDto);

    boolean createUser1(UserDto userDto);


}
