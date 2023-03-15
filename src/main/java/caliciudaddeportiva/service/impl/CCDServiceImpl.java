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
    public List<UserDto> getAllCiudadela4s(UserDto userDto) {
        try {
            return CCDRepository.getAllCiudadela4s(userDto);
        } catch (Exception e) {
            throw new BusinessCCDException(
                    e  );
        }
    }




    @Override
    public List<UserDto> GetRegalopersonamenor(UserDto userDto) {
        if (CCDRepository.getpersonaregalomenor(userDto) == 0 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.Regalono));
        } else if (CCDRepository.getRegalomenor(userDto) >= 1){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.regaloentrego));
        }
        try {

            return CCDRepository.GetRegalopersonamenor(userDto);
        } catch (Exception e) {
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.ERROR_GET_USERS));
        }
    }

    public boolean GetRegalopersona(RegaloDto regaloDto) {
        if (CCDRepository.validarpersonafinal(regaloDto) < 1 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.errorcodigonoexiste));
        }
        CCDRepository.createregaloferia(regaloDto);
        return true;

    }





    @Override
    public List<UserDto> getUserByText(UserDto userDto) {
        try {
            return CCDRepository.getUserByVariable(userDto);
        } catch (Exception e) {
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.ERROR_GET_USERS));
        }
    }




    @Override
    public boolean updateUser(UserDto userDto) {
        try {
            return CCDRepository.updateUsuario(userDto) > 0;
        } catch (Exception e) {
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.ERROR_UPDATE_USER));
        }
    }




    @Override
    public boolean entregarregalo(UserDto userDto) {
        if (CCDRepository.getpersonaregalo(userDto) == 0 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.Regalono));
        } else if (CCDRepository.getRegalo(userDto) >= 1){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.regaloentrego));
        }
        return CCDRepository.updateUsuarioregaloentregar(userDto) > 0;

    }









    @Override
    public boolean deleteUser(int idUsuario) {
        try {
            return CCDRepository.deleteUser(idUsuario) > 0;
        } catch (Exception e) {
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.ERROR_DELETE_USER));
        }
    }

    @Override
    public boolean createciudadela(UserDto userDto) {
        if (CCDRepository.buscarcluster(userDto) >= 1 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.Regalono));
        }else
            CCDRepository.createUsercodigo(userDto);

            return true;
    }








        @Override
    public boolean createUser(UserDto userDto) {
            if (CCDRepository.getUserByName(userDto) > 5){
                throw new BusinessCCDException(
                        messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.USER_ALREADY_EXIST));
            } else if (CCDRepository.getcupos(userDto) >= 21){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.ERROR_PLACA_PERSONA_ENTRADA));
        }
        return CCDRepository.createUser(userDto) > 0;
        }



    @Override
    public boolean createregalo(RegaloDto regaloDto) {

        return CCDRepository.createregalo(regaloDto) > 0;
    }


    @Override
    public List<RegaloDto> buscarultimoregistroregalo(RegaloDto regaloDto) {
        try {
            return CCDRepository.buscarultimoregistroregalo(regaloDto);
        } catch (Exception e) {
            throw new BusinessCCDException(
                    e  );
        }
    }


    @Override
    public boolean validarregalo(UserDto userDto) {
        if (CCDRepository.getpersonaregalo(userDto) >0 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.Regalono));
        } else if (CCDRepository.getRegalo(userDto) >= 1){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.regaloentrego));
        }
        return CCDRepository.updateUsuario(userDto) > 0;

    }


    @Override
    public boolean validarmenor(UserDto userDto) {
        if (CCDRepository.validarmenor(userDto) >= 1 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.Validarmenor));
        }
        return CCDRepository.createUsercodigo(userDto) > 0;

    }


    public boolean createUsercodigo(UserDto userDto) {
        if (CCDRepository.buscarcluster(userDto) >= 1 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.Regalono));
        }else if (CCDRepository.buscarclustersincamisa(userDto) >= 800 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.nocupos));
        }else

        CCDRepository.createUsercodigo(userDto);
        return true;
        }

    public boolean createUserferia(UserDto userDto) {
        if (CCDRepository.buscarclusterferia(userDto) >= 1 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.Regalono));
        }else
            CCDRepository.createUsercodigo(userDto);
        return true;

    }

    public boolean createUsercodigoval(UserDto userDto) {
        if (CCDRepository.buscarclustervalidados2(userDto) >= 1) {
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.Regalono));
        } else if (CCDRepository.buscarcodigoval(userDto) == 1) {
            CCDRepository.createUsercodigo(userDto);
            CCDRepository.updatecodigo(userDto);
            return true;
        }
        throw new BusinessCCDException(
                messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.errorcodigonoexiste));

    }


        public boolean validarcodigo(CodigoDto codigoDto) {
        if (CCDRepository.validarcodigo(codigoDto) != 1 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.errorcodigonoexiste));
        }
        return true;

    }

    public boolean validarpersonacluster(UserDto userDto) {
        if (CCDRepository.buscarcluster1(userDto) >= 1 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.Regalono));
        }
        return true;

    }

    public boolean validarpersonaferia(UserDto userDto) {
        if (CCDRepository.validarpersonaferia(userDto) >= 1 ){
            return true;

        }    throw new BusinessCCDException(
                messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.Regalono));


    }





    @Override
    public boolean validarregaloadulto(UserDto userDto) {
        if (CCDRepository.getpersonaregalodulto(userDto) == 0 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.Regalono));
        } else if (CCDRepository.getRegaloadulto(userDto) < 1){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.regaloentrego));
        }
        return true;

    }


    @Override
    public boolean loginadmin(AdminDto adminDto) {
         if (CCDRepository.loginadmin(adminDto) < 1){



             throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.login));
        }
        return true;

    }










}
