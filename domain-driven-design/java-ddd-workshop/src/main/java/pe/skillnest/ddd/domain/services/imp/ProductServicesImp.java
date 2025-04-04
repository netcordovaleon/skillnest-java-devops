package pe.skillnest.ddd.domain.services.imp;

import org.springframework.stereotype.Service;
import pe.skillnest.ddd.domain.dto.ProductDto;
import pe.skillnest.ddd.domain.repository.ProductRepository;
import pe.skillnest.ddd.domain.services.ProductServices;

@Service
public class ProductServicesImp implements ProductServices {

    private ProductRepository productRepository;

    @Override
    public void Save(ProductDto dto) {

    }
}
