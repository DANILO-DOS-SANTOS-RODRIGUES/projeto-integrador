package com.example.projetointegrador.repositories;

import com.example.projetointegrador.models.Carteira;
import com.example.projetointegrador.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {//é o segundo passo
List<Carteira> findCarteiraByNome(String nome);
}
