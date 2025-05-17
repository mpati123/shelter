package com.patneh.shelter.domain.gatunki;

import com.patneh.shelter.domain.faktury.FakturyFacade;
import com.patneh.shelter.domain.faktury.FakturyRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FakturyConfiguration
 */
@Configuration
class GatunekConfiguration {

  @Bean
  GatunekFacade gatunekFacade(GatunekRepository repository) {
    GatunekMapper mapper = Mappers.getMapper(GatunekMapper.class);
    GatunekService service = new GatunekService(repository, mapper);
    return new GatunekFacade(service);

  }

}
