package com.example.provaa2.Controllers;


import com.example.provaa2.Models.Endereco;
import com.example.provaa2.Models.Pessoa;
import com.example.provaa2.Repositories.GetEndereco;
import com.example.provaa2.Repositories.GetPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/api")
public class RestController {

    @Autowired
    private GetPessoa person;

    @Autowired
    private GetEndereco address;

    //Consulta as pessoas
    @GetMapping(value = "/pessoas")
    public ResponseEntity consultarPessoas(){
        return ResponseEntity.ok().body(person.findAll());
    }

    //Cadastra as pessoas
    @PostMapping(value = "/pessoas")
    public ResponseEntity cadastrarPessoas(@RequestBody Pessoa pessoa){
        return ResponseEntity.ok().body(person.save(pessoa));
    }

    //deleta as pessoas
    @PostMapping(value = "/pessoas/delete/{id}")
    public ResponseEntity deletarPessoas(@RequestBody Pessoa pessoa){
        person.delete(pessoa);
        return ResponseEntity.ok().body("Pessoa deletada com sucesso");
    }

    //Consulta os endereços
    @GetMapping(value = "/enderecos")
    public ResponseEntity consultarEnderecos(){
        return ResponseEntity.ok().body(address.findAll());
    }

    //Cadastra os endereços
    @PostMapping(value = "/enderecos")
    public ResponseEntity cadastrarEnderecos(@RequestBody Endereco endereco){
        return ResponseEntity.ok().body(address.save(endereco));
    }

    //deleta os endereços
    @PostMapping(value = "/enderecos/delete/{id}")
    public ResponseEntity deletarEnderecos(@RequestBody Endereco endereco){
        address.delete(endereco);
        return ResponseEntity.ok().body("Endereço deletado com sucesso");
    }

}
