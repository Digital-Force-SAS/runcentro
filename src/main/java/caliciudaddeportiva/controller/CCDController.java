package caliciudaddeportiva.controller;

import caliciudaddeportiva.micellaneus.dto.GenericDto;
import caliciudaddeportiva.micellaneus.dto.UserDto;
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
    @CrossOrigin(origins ={"https://caliciudaddeportiva.com", "*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/createUser")
    public ResponseEntity<GenericDto> createUser(@RequestBody UserDto userDto) {System.out.println("hola amiguitos");
        return new ResponseEntity<>(GenericDto.sucess(CCDService.createUser(userDto)), HttpStatus.CREATED);
    }


    @CrossOrigin(origins ={"https://caliciudaddeportiva.com", "*","https://caliciudaddeportiva.com/ciudadela/regaloval"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/entregarregalo")
    public ResponseEntity<GenericDto> entregarregalo(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(GenericDto.sucess(CCDService.entregarregalo(userDto)), HttpStatus.CREATED);
    }
    @CrossOrigin(origins ={"https://caliciudaddeportiva.com", "*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/validarregalo")
    public ResponseEntity<GenericDto> validarregalo(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(GenericDto.sucess(CCDService.validarregalo(userDto)), HttpStatus.CREATED);
    }

    @CrossOrigin(origins ={"https://caliciudaddeportiva.com", "*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/validarregaloadulto")
    public ResponseEntity<GenericDto> validarregaloadulto(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(GenericDto.sucess(CCDService.validarregaloadulto(userDto)), HttpStatus.CREATED);
    }








    @CrossOrigin(origins ={"https://caliciudaddeportiva.com", "*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/createciudadela")
    public ResponseEntity<GenericDto> createUser3(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(GenericDto.sucess(CCDService.createciudadela(userDto)), HttpStatus.CREATED);
    }

    @CrossOrigin(origins ={"https://caliciudaddeportiva.com", "*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @GetMapping("/getAllCiudadela4ver")
    public ResponseEntity<GenericDto> getAllCiudadela4s(@RequestBody UserDto userDto){
        return ResponseEntity.ok().body(GenericDto.sucess(CCDService.getAllCiudadela4s(userDto)));
    }




    @CrossOrigin(origins ={"https://caliciudaddeportiva.com", "*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @GetMapping("/getAllUser")
    public ResponseEntity<GenericDto> getAllUsers() {
        return ResponseEntity.ok().body(GenericDto.sucess(CCDService.getAllUsers()));
    }




    @CrossOrigin(origins ={"https://caliciudaddeportiva.com", "*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/GetRegalopersona")
        public ResponseEntity<GenericDto> GetRegalopersona(@RequestBody UserDto userDto) {
            return ResponseEntity.ok().body(GenericDto.sucess(CCDService.GetRegalopersona(userDto)));
        }

    @CrossOrigin(origins ={"https://caliciudaddeportiva.com", "*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/GetRegalopersonamenor")
    public ResponseEntity<GenericDto> GetRegalopersonamenor(@RequestBody UserDto userDto) {
        return ResponseEntity.ok().body(GenericDto.sucess(CCDService.GetRegalopersonamenor(userDto)));
    }






    @CrossOrigin(origins ={"https://caliciudaddeportiva.com", "*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/getUserByText")
        public ResponseEntity<GenericDto> getUserByText(@RequestBody UserDto userDto) {
        return ResponseEntity.ok().body(GenericDto.sucess(CCDService.getUserByText(userDto)));
    }

    @CrossOrigin(origins ={"https://caliciudaddeportiva.com", "*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PostMapping("/BuscarDatosRegalo")
    public ResponseEntity<GenericDto> BuscarDatosRegalo(@RequestBody UserDto userDto) {
        return ResponseEntity.ok().body(GenericDto.sucess(CCDService.updateUser(userDto)));
    }



    @CrossOrigin(origins ={"https://caliciudaddeportiva.com", "*"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @PatchMapping("/updateUser")
    public ResponseEntity<GenericDto> updateUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok().body(GenericDto.sucess(CCDService.updateUser(userDto)));
    }



    @CrossOrigin(origins ={"https://caliciudaddeportiva.com", "https://caliciudaddeportiva.com"}, methods= {RequestMethod.GET,RequestMethod.POST})
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<GenericDto> deleteUser(@PathVariable("id") int idUsuario) {
        return ResponseEntity.ok().body(GenericDto.sucess(CCDService.deleteUser(idUsuario)));
    }

}
