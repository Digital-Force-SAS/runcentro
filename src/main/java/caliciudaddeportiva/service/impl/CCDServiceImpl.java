package caliciudaddeportiva.service.impl;

import caliciudaddeportiva.micellaneus.constantes.ValidationMessageEnum;
import caliciudaddeportiva.micellaneus.dto.AdminDto;
import caliciudaddeportiva.micellaneus.dto.CodigoDto;
import caliciudaddeportiva.micellaneus.dto.RegaloDto;
import caliciudaddeportiva.micellaneus.dto.UserDto;
import caliciudaddeportiva.micellaneus.exeption.BusinessCCDException;
import caliciudaddeportiva.micellaneus.util.MessageExceptionUtil;
import caliciudaddeportiva.repository.CCDRepository;
import caliciudaddeportiva.service.CCDService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CCDServiceImpl implements CCDService {

    public final CCDRepository CCDRepository;
    private final MessageExceptionUtil messageExceptionDtoUtil;

    public CCDServiceImpl(CCDRepository CCDRepository, MessageExceptionUtil messageExceptionDtoUtil) {
        this.CCDRepository = CCDRepository;
        this.messageExceptionDtoUtil = messageExceptionDtoUtil;
    }


    //USUARIOS**************************************************************************************************
    @Override
    public List<UserDto> getAllUsers() {
        try {
            return CCDRepository.getAllUsers();
        } catch (Exception e) {
            throw new BusinessCCDException(
                e  );
        }
    }



    //CIUDADELA**************************************************************************************************


    public boolean createUserCiudadela(UserDto userDto) {
        if (CCDRepository.buscarMenorCiudadela(userDto) >= 1 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.MENOREXISTE));
        }  else if (CCDRepository.ContarUserCiudadela(userDto) >= 5 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.CIUDADELALLENA));
        }else{

            CCDRepository.createUserCiudadela(userDto);
            return true;
        }
    }

    @Override
    public boolean ValidarMenor(UserDto userDto) {
        if (CCDRepository.validarmenor(userDto)  == 0  ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.MENORNOEXISTE));
        }
        return true;

    }


    //CARRERA**************************************************************************************************


    //FUTBOL FAM**************************************************************************************************
















}
