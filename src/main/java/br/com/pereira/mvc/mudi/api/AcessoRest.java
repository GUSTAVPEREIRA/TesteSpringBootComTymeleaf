package br.com.pereira.mvc.mudi.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pereira.mvc.mudi.interceptador.InterceptadorDeAcesso;
import br.com.pereira.mvc.mudi.interceptador.InterceptadorDeAcesso.Acesso;

@RequestMapping("acessos")
@RestController
public class AcessoRest {
	
	@GetMapping
	public List<Acesso> getAcessos(){
		return InterceptadorDeAcesso.acessos;
	}
}
