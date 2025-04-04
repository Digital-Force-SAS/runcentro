package caliciudaddeportiva.service.impl;

import caliciudaddeportiva.micellaneus.constantes.ValidationMessageEnum;
import caliciudaddeportiva.micellaneus.dto.AdminDto;
import caliciudaddeportiva.micellaneus.dto.RegaloDto;
import caliciudaddeportiva.micellaneus.dto.UserDto;
import caliciudaddeportiva.micellaneus.dto.TallaDto;
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
    private final EmailService emailService; // Inyectamos el servicio de email

    public CCDServiceImpl(CCDRepository CCDRepository, MessageExceptionUtil messageExceptionDtoUtil, EmailService emailService) {
        this.CCDRepository = CCDRepository;
        this.messageExceptionDtoUtil = messageExceptionDtoUtil;
        this.emailService = emailService; // Asignamos el servicio de email
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




    //CIUDADELA**************************************************************************************************


    public boolean createUserCiudadela(UserDto userDto) {
        if (CCDRepository.buscarMenorCiudadela(userDto) >= 1 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.MENOREXISTE));
        }else if (CCDRepository.buscarcupos(userDto) >= 500 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.carreramenorexiste3k));
        } else if (!CCDRepository.validarTallaDisponible(userDto.getVariable11())) {
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.TALLA_NO_DISPONIBLE));
        } else{
            CCDRepository.createUserCiudadela(userDto);
            // 🔹 Actualizar la cantidad de tallas disponibles
            int cantidadReducida = 1; // Asumiendo que se reduce una unidad por registro
            int filasAfectadas = CCDRepository.actualizarTalla(userDto.getVariable11(), cantidadReducida);

           /* // 📧 Enviar correo de confirmación
            EmailRequestDto emailRequest = new EmailRequestDto();
            emailRequest.setToEmail(userDto.getVariable7());

            // Obteniendo nombre
            emailRequest.setName(userDto.getVariable3());
            emailRequest.setLastName(userDto.getVariable4());

            // Obtener el código
            emailRequest.setCode(userDto.getVariable15());
            ResponseEntity<String> response = emailService.sendEmail(emailRequest);
            System.out.println("Email enviado: " + response.getBody()); // Opcional, para debug*/
            return true;
        }
    }

    //***************************************************************************************************

    public boolean createUserCiudadelaCodigo(UserDto userDto) {
        if (CCDRepository.buscarMenorCiudadela(userDto) >= 1 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.MENOREXISTE));
        }else    if (CCDRepository.ValidarCupo(userDto)  == 0  ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.codigoErroneo));
        } else if (CCDRepository.buscarcuposCodigo(userDto) >= 2000 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.carreramenorexiste3k));
        } else if (!CCDRepository.validarTallaDisponible(userDto.getVariable11())) {
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.TALLA_NO_DISPONIBLE));
        }   else {
            CCDRepository.createUserCiudadela(userDto);
            CCDRepository.ActualizarCodigo(userDto);

            // 🔹 Actualizar la cantidad de tallas disponibles
            int cantidadReducida = 1; // Asumiendo que se reduce una unidad por registro
            int filasAfectadas = CCDRepository.actualizarTalla(userDto.getVariable11(), cantidadReducida);

         /*   // 📧 Enviar correo de confirmación
            EmailRequestDto emailRequest = new EmailRequestDto();
            emailRequest.setToEmail(userDto.getVariable7());

            // Obteniendo nombre
            emailRequest.setName(userDto.getVariable3());
            emailRequest.setLastName(userDto.getVariable4());

            // Obtener el código
            emailRequest.setCode(userDto.getVariable15());
            ResponseEntity<String> response = emailService.sendEmail(emailRequest);
            System.out.println("Email enviado: " + response.getBody()); // Opcional, para debug*/

            return true;
        }
    }
//***********************************************************************************************
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





    @Override
    public List<UserDto> GetCupoRegalo(UserDto userDto) {
        if (CCDRepository.getRegaloadulto(userDto) == 0 ){
            throw new BusinessCCDException(
                    messageExceptionDtoUtil.resolveMessage(ValidationMessageEnum.ADULTOEXISTE));
        }
        return CCDRepository.GetRegalopersona(userDto);
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


    //FUTBOL FAM**************************************************************************************************

    // Tallas
    @Override
    public List<TallaDto> obtenerTallasDisponibles() {
        return CCDRepository.obtenerTallasDisponibles();
    }















}
