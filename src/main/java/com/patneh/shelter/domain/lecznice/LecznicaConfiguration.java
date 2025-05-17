package com.patneh.shelter.domain.lecznice;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FakturyConfiguration
 */
@Configuration
class LecznicaConfiguration {

  @Bean
  LecznicaFacade lecznicaFacade(LecznicaRepository repository) {
    LecznicaMapper mapper = Mappers.getMapper(LecznicaMapper.class);
    LecznicaService service = new LecznicaService(repository, mapper);
    return new LecznicaFacade(service);

  }

}
