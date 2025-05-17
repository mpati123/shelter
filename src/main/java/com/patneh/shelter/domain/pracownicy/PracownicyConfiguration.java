package com.patneh.shelter.domain.pracownicy;

import com.patneh.shelter.domain.ludzie.LudzieFacade;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FakturyConfiguration
 */
@Configuration
class PracownicyConfiguration {

  @Bean
  PracownicyFacade pracownicyFacade(PracownicyRepository repository, LudzieFacade ludzieFacade) {
    PracownicyMapper mapper = Mappers.getMapper(PracownicyMapper.class);
    PracownicyService service = new PracownicyService(repository, mapper, ludzieFacade);
    return new PracownicyFacade(service);

  }

}
