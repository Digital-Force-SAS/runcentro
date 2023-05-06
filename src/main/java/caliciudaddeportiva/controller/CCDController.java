package caliciudaddeportiva.controller;

import caliciudaddeportiva.micellaneus.dto.*;
import caliciudaddeportiva.service.CCDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/caliciudaddeportiva")
public class CCDController {

    @Autowired
    private CCDService CCDService;



    //USUARIOS****************************************************************************************************

    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @GetMapping("/getAllUser")
    public ResponseEntity<GenericDto> getAllUsers() {
        return ResponseEntity.ok().body(GenericDto.sucess(CCDService.getAllUsers()));
    }
    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/loginadministrador")
    public ResponseEntity<GenericDto> loginadmin(@RequestBody AdminDto adminDto) {
        return new ResponseEntity<>(GenericDto.sucess(CCDService.loginadmin(adminDto)), HttpStatus.CREATED);
    }
    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/loginciudadela")
    public ResponseEntity<GenericDto> loginciudadela(@RequestBody AdminDto adminDto) {
        return new ResponseEntity<>(GenericDto.sucess(CCDService.loginciudadela(adminDto)), HttpStatus.CREATED);
    }
    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/logincarrera")
    public ResponseEntity<GenericDto> logincarrera(@RequestBody AdminDto adminDto) {
        return new ResponseEntity<>(GenericDto.sucess(CCDService.logincarrera(adminDto)), HttpStatus.CREATED);
    }


    //CIUDADELA****************************************************************************************************

    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/createUserCiudadela")
    public ResponseEntity<GenericDto> createUserferia(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(GenericDto.sucess(CCDService.createUserCiudadela(userDto)), HttpStatus.CREATED);
    }

    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/ValidarMenor")
    public ResponseEntity<GenericDto> ValidarMenor(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(GenericDto.sucess(CCDService.ValidarMenor(userDto)), HttpStatus.CREATED);
    }


    //CARRERA****************************************************************************************************


    //FUTBOLFAM****************************************************************************************************


}
