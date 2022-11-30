package codesa.controller;

import codesa.micellaneus.dto.EntradaDto;
import codesa.micellaneus.dto.GenericDto;
import codesa.micellaneus.dto.UserDto;
import codesa.service.CodesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/codesa")
public class CodesaController {

    @Autowired
    private CodesaService codesaService;
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
        @PostMapping("/createUser")
    public ResponseEntity<GenericDto> createUser(@RequestBody UserDto userDto) {System.out.println("hola amiguitos");
        return new ResponseEntity<>(GenericDto.sucess(codesaService.createUser(userDto)), HttpStatus.CREATED);
    }


    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    @PostMapping("/createUser1")
    public ResponseEntity<GenericDto> createUser1(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(GenericDto.sucess(codesaService.createUser1(userDto)), HttpStatus.CREATED);
    }


    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    @PostMapping("/createUser3")
    public ResponseEntity<GenericDto> createUser3(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(GenericDto.sucess(codesaService.createUser3(userDto)), HttpStatus.CREATED);
    }


    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    @PostMapping("/updateentrada")
    public ResponseEntity<GenericDto> updateentrada(@RequestBody EntradaDto entradaDto) {
        return new ResponseEntity<>(GenericDto.sucess(codesaService.updateentrada(entradaDto)), HttpStatus.CREATED);

    }


    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    @PostMapping("/consultentrada")
    public ResponseEntity<GenericDto> consultentrada(@RequestBody EntradaDto entradaDto) {
        return new ResponseEntity<>(GenericDto.sucess(codesaService.consultentrada(entradaDto)), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    @GetMapping("/getAllUser")
    public ResponseEntity<GenericDto> getAllUsers() {
        return ResponseEntity.ok().body(GenericDto.sucess(codesaService.getAllUsers()));
    }


    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    @PostMapping("/getUserByText")
        public ResponseEntity<GenericDto> getUserByText(@RequestBody UserDto userDto) {
        return ResponseEntity.ok().body(GenericDto.sucess(codesaService.getUserByText(userDto)));
    }
    @CrossOrigin(origins = "*", methods = {RequestMethod.PATCH})
    @PatchMapping("/updateUser")
    public ResponseEntity<GenericDto> updateUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok().body(GenericDto.sucess(codesaService.updateUser(userDto)));
    }
    @CrossOrigin(origins = "*", methods = {RequestMethod.DELETE})
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<GenericDto> deleteUser(@PathVariable("id") int idUsuario) {
        return ResponseEntity.ok().body(GenericDto.sucess(codesaService.deleteUser(idUsuario)));
    }
}
