package br.com.mjv.bookcolaboradores.samples;

import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {
	
	public String chamaServico() {
		return "servico ok";
	}

}
