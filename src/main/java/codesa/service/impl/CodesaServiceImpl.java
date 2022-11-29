package codesa.service.impl;

import codesa.micellaneus.constantes.ValidationMessageEnum;
import codesa.micellaneus.dto.EntradaDto;
import codesa.micellaneus.dto.UserDto;
import codesa.micellaneus.exeption.BusinessCodesaException;
import codesa.micellaneus.util.MessageExceptionUtil;
import codesa.repository.CodesaRepository;
import codesa.service.CodesaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodesaServiceImpl implements CodesaService {

    public final CodesaRepository codesaRepository;
    private final MessageExceptionUtil messageExceptionDtoUtil;

    public CodesaServiceImpl(CodesaRepository codesaRepository, MessageExceptionUtil messageExceptionDtoUtil) {
        this.codesaRepository = codesaRepository;
        this.messageExceptionDtoUtil = messageExceptionDtoUtil;
    }

    @Override
    public List<UserDto> getAllUsers() {
        try {
            return codesaRepository.getAllUsers();
        } catch (Exception e) {
            throw new BusinessCodesaException(
                e  );
        }
    }

    @Override
    public List<UserDto> getUserByText(UserDto userDto) {
        try {
            return codesaRepository.getUserByText(userDto);
        } catch (Exception e) {
            throw new BusinessCodesaException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.ERROR_GET_USERS));
        }
    }



    @Override
    public boolean updateUser(UserDto userDto) {
        try {
            return codesaRepository.updateUsuario(userDto) > 0;
        } catch (Exception e) {
            throw new BusinessCodesaException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.ERROR_UPDATE_USER));
        }
    }


    @Override
    public boolean updateentrada(EntradaDto entradaDto) {
        if (codesaRepository.getentrada(entradaDto) != 1){
            throw new BusinessCodesaException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.ERROR_NATE_ENTRADA));


        }
        return codesaRepository.validarEntrada(entradaDto) > 0;
    }

    @Override
    public boolean consultentrada(EntradaDto entradaDto) {
        if (codesaRepository.getentrada(entradaDto) > 0){

            throw new BusinessCodesaException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.ERROR_UPDATE_ENTRADA));
        }
        return codesaRepository.getentrada(entradaDto) > 0;

    }



    @Override
    public boolean deleteUser(int idUsuario) {
        try {
            return codesaRepository.deleteUser(idUsuario) > 0;
        } catch (Exception e) {
            throw new BusinessCodesaException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.ERROR_DELETE_USER));
        }
    }





    @Override
    public boolean createUser(UserDto userDto) {
            if (codesaRepository.getUserByName(userDto) > 0){
                throw new BusinessCodesaException(
                        messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.USER_ALREADY_EXIST));
            } else if (codesaRepository.getcupos(userDto) >= 21){
            throw new BusinessCodesaException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.ERROR_PLACA_PERSONA_ENTRADA));
        }
        return codesaRepository.createUser(userDto) > 0;
        }


    @Override
    public boolean createUser1(UserDto userDto) {
        if (codesaRepository.getUserByName(userDto) > 0){
            throw new BusinessCodesaException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.ERROR_USUARION_PERSONA_ENTRADA));
        }

        EntradaDto entradaDto = new EntradaDto();
        entradaDto.setCodigo(userDto.getCodigo());

        if (codesaRepository.getentrada(entradaDto) != 1){
            throw new BusinessCodesaException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.ERROR_NATE_ENTRADA));
        }


        return codesaRepository.createUser(userDto) > 0;
    }





}
