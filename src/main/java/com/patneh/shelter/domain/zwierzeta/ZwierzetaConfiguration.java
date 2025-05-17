package com.patneh.shelter.domain.zwierzeta;

import com.patneh.shelter.domain.gatunki.GatunekFacade;
import com.patneh.shelter.domain.pracownicy.PracownicyFacade;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FakturyConfiguration
 */
@Configuration
class ZwierzetaConfiguration {

  @Bean
  ZwierzetaFacade zwierzetaFacade(ZwierzetaRepository repository,
      GatunekFacade gatunekFacade,
      PracownicyFacade pracownicyFacade) {
    ZwierzetaMapper mapper = Mappers.getMapper(ZwierzetaMapper.class);
    ZwierzetaService service = new ZwierzetaService(repository,
        mapper,
        gatunekFacade,
        pracownicyFacade);
    return new ZwierzetaFacade(service);

  }

}
