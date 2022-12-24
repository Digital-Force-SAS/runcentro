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


    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/buscarultimoregistroregalo")
    public ResponseEntity<GenericDto> buscarultimoregistroregalo(@RequestBody RegaloDto regaloDto){
        return ResponseEntity.ok().body(GenericDto.sucess(CCDService.buscarultimoregistroregalo(regaloDto)));
    }


    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/createregalo")
    public ResponseEntity<GenericDto> createregalo(@RequestBody RegaloDto regaloDto) {
        return new ResponseEntity<>(GenericDto.sucess(CCDService.createregalo(regaloDto)), HttpStatus.CREATED);
    }

    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/createUsercodigo")
    public ResponseEntity<GenericDto> createUsercodigo(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(GenericDto.sucess(CCDService.createUsercodigo(userDto)), HttpStatus.CREATED);
    }
    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/createUsercodigoval")
    public ResponseEntity<GenericDto> createUsercodigoval(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(GenericDto.sucess(CCDService.createUsercodigoval(userDto)), HttpStatus.CREATED);
    }

    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/createUserferia")
    public ResponseEntity<GenericDto> createUserferia(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(GenericDto.sucess(CCDService.createUserferia(userDto)), HttpStatus.CREATED);
    }




    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/validarcodigo")
    public ResponseEntity<GenericDto> validarcodigo(@RequestBody CodigoDto codigoDto) {
        return new ResponseEntity<>(GenericDto.sucess(CCDService.validarcodigo(codigoDto)), HttpStatus.CREATED);
    }
    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/validarpersonacluster")
    public ResponseEntity<GenericDto> validarpersonacluster(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(GenericDto.sucess(CCDService.validarpersonacluster(userDto)), HttpStatus.CREATED);
    }





    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/validarmenor")
    public ResponseEntity<GenericDto> validarmenor(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(GenericDto.sucess(CCDService.validarmenor(userDto)), HttpStatus.CREATED);
    }

    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/validarregalo")
    public ResponseEntity<GenericDto> validarregalo(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(GenericDto.sucess(CCDService.validarregalo(userDto)), HttpStatus.CREATED);
    }



    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/loginadmin")
    public ResponseEntity<GenericDto> loginadmin(@RequestBody AdminDto adminDto) {
        return new ResponseEntity<>(GenericDto.sucess(CCDService.loginadmin(adminDto)), HttpStatus.CREATED);
    }


    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/validarregaloadulto")
    public ResponseEntity<GenericDto> validarregaloadulto(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(GenericDto.sucess(CCDService.validarregaloadulto(userDto)), HttpStatus.CREATED);
    }




    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/entregaregalo")
    public ResponseEntity<GenericDto> entregarregalo(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(GenericDto.sucess(CCDService.entregarregalo(userDto)), HttpStatus.CREATED);
    }



    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/createciudadela")
    public ResponseEntity<GenericDto> createciudadela(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(GenericDto.sucess(CCDService.createciudadela(userDto)), HttpStatus.CREATED);
    }

    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @GetMapping("/getAllCiudadela4ver")
    public ResponseEntity<GenericDto> getAllCiudadela4s(@RequestBody UserDto userDto){
        return ResponseEntity.ok().body(GenericDto.sucess(CCDService.getAllCiudadela4s(userDto)));
    }




    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @GetMapping("/getAllUser")
    public ResponseEntity<GenericDto> getAllUsers() {
        return ResponseEntity.ok().body(GenericDto.sucess(CCDService.getAllUsers()));
    }




    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/GetRegalopersona")
        public ResponseEntity<GenericDto> GetRegalopersona(@RequestBody UserDto userDto) {
            return ResponseEntity.ok().body(GenericDto.sucess(CCDService.GetRegalopersona(userDto)));
        }

    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/GetRegalopersonamenor")
    public ResponseEntity<GenericDto> GetRegalopersonamenor(@RequestBody UserDto userDto) {
        return ResponseEntity.ok().body(GenericDto.sucess(CCDService.GetRegalopersonamenor(userDto)));
    }






    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/getUserByText")
        public ResponseEntity<GenericDto> getUserByText(@RequestBody UserDto userDto) {
        return ResponseEntity.ok().body(GenericDto.sucess(CCDService.getUserByText(userDto)));
    }

    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/BuscarDatosRegalo")
    public ResponseEntity<GenericDto> BuscarDatosRegalo(@RequestBody UserDto userDto) {
        return ResponseEntity.ok().body(GenericDto.sucess(CCDService.updateUser(userDto)));
    }



    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PatchMapping("/updateUser")
    public ResponseEntity<GenericDto> updateUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok().body(GenericDto.sucess(CCDService.updateUser(userDto)));
    }



    @CrossOrigin(origins ={"https://caliciudaddeportiva.com/","https://caliciudaddeportiva.com", "http://localhost:4200","**","*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<GenericDto> deleteUser(@PathVariable("id") int idUsuario) {
        return ResponseEntity.ok().body(GenericDto.sucess(CCDService.deleteUser(idUsuario)));
    }

}
