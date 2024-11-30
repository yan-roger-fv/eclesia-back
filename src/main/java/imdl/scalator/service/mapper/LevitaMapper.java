package imdl.scalator.service.mapper;

import imdl.scalator.domain.Instrumento;
import imdl.scalator.domain.Levita;
import imdl.scalator.domain.LevitaResumed;
import imdl.scalator.entity.LevitaEntity;
import imdl.scalator.entity.LevitaResumedEntity;

import java.util.Comparator;

public class LevitaMapper {

    public static LevitaEntity domainToEntity(Levita domain){
        LevitaEntity entity = new LevitaEntity();
        entity.setId(domain.getId());
        entity.setNome(domain.getNome());
        entity.setEmail(domain.getEmail());
        entity.setContato(domain.getContato());
        entity.setDescricao(domain.getDescricao());
        entity.setInstrumentos(domain.getInstrumentos().stream().map(InstrumentoMapper::domainToEntity).toList());
        entity.setAgenda(domain.getAgenda());
        return entity;
    }

    public static Levita entityToDomain(LevitaEntity entity){
        Levita domain = new Levita();
        domain.setId(entity.getId());
        domain.setNome(entity.getNome());
        domain.setEmail(entity.getEmail());
        domain.setContato(entity.getContato());
        domain.setDescricao(entity.getDescricao());
        domain.setAgenda(entity.getAgenda());
        domain.setEscalas(entity.getEscalas().stream().map(EscalaMapper::entityToDomain).toList());
        domain.setInstrumentos(entity.getInstrumentos().stream().map(InstrumentoMapper::entityToDomain).sorted(Comparator.comparingLong(Instrumento::getId)).toList());
        return domain;
    }

    public static LevitaResumed entityToDomainResumed(LevitaResumedEntity entity){
        LevitaResumed levita = new LevitaResumed();
        levita.setId(entity.getId());
        levita.setNome(entity.getNome());
        levita.setEmail(entity.getEmail());
        levita.setContato(entity.getContato());
        levita.setDescricao(entity.getDescricao());
        levita.setAgenda(entity.getAgenda());
        levita.setInstrumentos(entity.getInstrumentos().stream().map(InstrumentoMapper::entityToDomain).toList());
        return levita;
    }
}
