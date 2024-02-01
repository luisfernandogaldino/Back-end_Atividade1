package com.controleAlunos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controleAlunos.entities.Alunos;
import com.controleAlunos.service.AlunosService;

import jakarta.validation.Valid;

	@RestController
	@RequestMapping("/alunos")

	public class AlunosController {

		private final AlunosService alunosService;

		@Autowired
		public AlunosController(AlunosService alunosService) {
			this.alunosService = alunosService;
		}

		@GetMapping("/{id}")
		public ResponseEntity<Alunos> buscaAlunosControlId(@PathVariable Long id) {
			Alunos Alunos= alunosService.buscaAlunosId(id);
			if (Alunos != null) {
				return ResponseEntity.ok(Alunos);
			} else {
				return ResponseEntity.notFound().build();
			}
		}

		@GetMapping
		public ResponseEntity<List<Alunos>> buscaTodosAlunosControl() {
			List<Alunos> Alunos = alunosService.buscaTodosAlunos();
			return ResponseEntity.ok(Alunos);
		}

		@PostMapping
		public ResponseEntity<Alunos> salvaAlunosControl(@RequestBody Alunos Alunos) {
			Alunos salvaAlunos = alunosService.salvaAlunos( Alunos);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvaAlunos);
		}

		@PutMapping("/{id}")
		public ResponseEntity< Alunos> alteraAlunosControl(@PathVariable Long id, @RequestBody @Valid Alunos  Alunos) {
			Alunos alterarAlunos =  alunosService.alterarAlunos(id, Alunos);
			if (alterarAlunos != null) {
				return ResponseEntity.ok( Alunos);
			} else {
				return ResponseEntity.notFound().build();
			}
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<Alunos> apagarAlunosControl(@PathVariable Long id) {
			boolean apagar =  alunosService.apagarAlunos(id);
			if (apagar) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			} else {
				return ResponseEntity.notFound().build();
			}
		}



	}
