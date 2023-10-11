package br.edu.ifrs.riogrande.tads.cobaia;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zaxxer.hikari.HikariDataSource;

import br.edu.ifrs.riogrande.tads.cobaia.controller.CobaiaController;
import br.edu.ifrs.riogrande.tads.cobaia.domain.entity.Aluno;
import br.edu.ifrs.riogrande.tads.cobaia.repository.AlunoRepository;

@SpringBootApplication
public class CobaiaApplication {

	@Autowired
	AlunoRepository alunoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CobaiaApplication.class, args);
	}

	@PostConstruct
	void popularBanco() {
		System.out.println("Rodando o Post Construct");

		Aluno a = new Aluno();
		a.setNome("Marcio Torres");
		a.setCpf("12345678901");

		alunoRepository.save(a);

		Aluno b = new Aluno();
		b.setNome("Teste");
		b.setCpf("09876543210");

		alunoRepository.save(b);

		System.out.println("Matrícula:" + a.getMatricula());

		System.out.println(alunoRepository.findAll());

	}
}
