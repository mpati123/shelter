package com.patneh.shelter.domain.faktury;

import com.patneh.shelter.domain.lecznice.LecznicaFacade;
import com.patneh.shelter.domain.zwierzeta.ZwierzetaFacade;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FakturyConfiguration
 */
@Configuration
class FakturyConfiguration {

  @Bean
  FakturyFacade currencyAccountFacade(FakturyRepository repository, LecznicaFacade lecznicaFacade, ZwierzetaFacade zwierzetaFacade) {
    FakturyMapper mapper = Mappers.getMapper(FakturyMapper.class);
    FakturyService service = new FakturyService(repository, mapper, lecznicaFacade, zwierzetaFacade);
    return new FakturyFacade(service);

  }

}
