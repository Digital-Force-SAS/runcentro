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

    public final CCDRepository  CCDRepository;
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

    @Override
    public boolean loginadmin(AdminDto adminDto) {
        if (CCDRepository.loginadmin(adminDto) < 1){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.administradornoexiste));
        }
        return true;
    }
    public boolean loginciudadela(AdminDto adminDto) {
        if (CCDRepository.loginciudadela(adminDto) < 1){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.ciudadelvalidaranoexiste));
        }
        return true;
    }
    public boolean logincarrera(AdminDto adminDto) {
        if (CCDRepository.logincarrera(adminDto) < 1){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.carreravalidarnoexiste));
        }
        return true;
    }



    //CIUDADELA**************************************************************************************************


    public boolean createUserCiudadela(UserDto userDto) {
        if (CCDRepository.buscarMenorCiudadela(userDto) >= 1 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.MENOREXISTE));
        } else{

            CCDRepository.createUserCiudadela(userDto);
            CCDRepository.ActualizarCodigo(userDto);
            return true;
        }
    }

    @Override
    public boolean ValidarMenor(UserDto userDto) {
        if (CCDRepository.validarmenor(userDto)  == 0  ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.codigoErroneo));
        }
        return true;

    }


    @Override
    public boolean ValidarCupo(UserDto userDto) {
        if (CCDRepository.ValidarCupo(userDto)  == 0  ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.codigoErroneo));
        }else if (CCDRepository.buscarcupos(userDto) >= 750 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.carreramenorexiste3k));
        }
        return true;

    }


    public List<UserDto> GetRegalopersonamenor(UserDto userDto) {
        if (CCDRepository.getpersonaregalomenor(userDto) == 0 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.MENORNOEXISTE));
        } else if (CCDRepository.getRegalomenor(userDto) >= 1){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.REGALOENTREGADOMENOR));
        }else{

            return CCDRepository.GetRegalopersonamenor(userDto);
        }
    }



    @Override
    public boolean entregarregalo(UserDto userDto) {
        if (CCDRepository.getpersonaregalomenor(userDto) == 0 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.MENORNOEXISTE));
        } else if (CCDRepository.getRegalomenor(userDto) >= 1){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.REGALOENTREGADOMENOR));
        }else{

            return  CCDRepository.updateUsuarioregaloentregar(userDto)>0;

            }


    }

    public boolean createregalo(RegaloDto regaloDto) {

        return CCDRepository.createregalo(regaloDto) > 0;
    }


    @Override
    public List<UserDto> GetRegalopersona(UserDto userDto) {
        if (CCDRepository.getpersonaregalodulto(userDto) == 0 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.ADULTOEXISTE));
        } else if (CCDRepository.getRegaloadulto(userDto) < 1){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.REGALOENTREGADOADULTO));
        }else {

            return CCDRepository.GetRegalopersona(userDto) ;
        }
    }



    //CARRERA**************************************************************************************************


    public boolean createUserCarrera(UserDto userDto) {
        if (CCDRepository.buscarcuposcarrera3k(userDto) >= 480 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.carreramenorexiste3k));
        }  else if (CCDRepository.buscarmenorcarrera3k(userDto) >= 1 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.carreramenorexiste3k));
        } else if (CCDRepository.buscaradultocarrera3k(userDto) >= 1 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.carreraadultoexiste3k));
        }else{

            CCDRepository.createUserCarrera(userDto);
            return true;
        }
    }

    public boolean createUserCarrera7k(UserDto userDto) {
        if (CCDRepository.buscarcuposcarrera7k(userDto) >= 1000 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.carreracupos7kno));
        }  else if (CCDRepository.buscarmenorcarrera7k(userDto) >= 1 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.carreramenorexiste7k));
        } else{

            CCDRepository.createUserCarrera(userDto);
            return true;
        }


    }

    @Override
    public boolean createcarrera (RegaloDto regaloDto){
        if (CCDRepository.validarnumero(regaloDto) >= 1 ){
            CCDRepository.actualizarkit(regaloDto);
            CCDRepository.actualizausuregalo(regaloDto);

            return true;
        } else {
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.numero));
        }


    }

    @Override
    public List<UserDto> GetCupoRegalo(UserDto userDto) {
        if (CCDRepository.getpersonaregalomenorcarrera1(userDto) >= 1 ){
            return CCDRepository.getpersonaregalomenorcarrera(userDto);

        } else{
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.regaloentrego));
        }

    }


    //FUTBOL FAM**************************************************************************************************
















}
