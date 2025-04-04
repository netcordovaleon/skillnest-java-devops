package pe.skillnest.ddd.domain.services;

import org.springframework.stereotype.Service;
import pe.skillnest.ddd.domain.dto.ProductDto;


public interface ProductServices {
    void Save (ProductDto dto);
}
