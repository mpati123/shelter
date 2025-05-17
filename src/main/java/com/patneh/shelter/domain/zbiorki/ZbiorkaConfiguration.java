package com.patneh.shelter.domain.zbiorki;

import com.patneh.shelter.domain.zwierzeta.ZwierzetaFacade;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FakturyConfiguration
 */
@Configuration
class ZbiorkaConfiguration {

  @Bean
  ZbiorkaFacade zbiorkaFacade(ZbiorkaRepository repository, ZwierzetaFacade zwierzetaFacade) {
    ZbiorkaMapper mapper = Mappers.getMapper(ZbiorkaMapper.class);
    ZbiorkaService service = new ZbiorkaService(repository, mapper, zwierzetaFacade);
    return new ZbiorkaFacade(service);

  }

}
