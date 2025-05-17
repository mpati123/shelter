package com.patneh.shelter.domain.ludzie;

import com.patneh.shelter.domain.lecznice.LecznicaRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FakturyConfiguration
 */
@Configuration
class LudzieConfiguration {

  @Bean
  LudzieFacade ludzieFacade(LudzieRepository repository) {
    LudzieMapper mapper = Mappers.getMapper(LudzieMapper.class);
    LudzieService service = new LudzieService(repository, mapper);
    return new LudzieFacade(service);

  }

}
