package name.auswise.spring.webstore.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import name.auswise.spring.webstore.service.ProducerService;
import name.auswise.spring.webstore.model.Producer;

public class StringToProducerConverter implements Converter<String, Producer>{

	@Autowired
	ProducerService producerService;
	
	@Override
	public Producer convert(String producent) {
		return producerService.findByNazwa(producent);
	}

}
