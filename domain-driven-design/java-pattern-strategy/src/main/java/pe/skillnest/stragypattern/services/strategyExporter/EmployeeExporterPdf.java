package pe.skillnest.stragypattern.services.strategyExporter;

import org.springframework.stereotype.Service;
import pe.skillnest.stragypattern.domain.entity.Employee;
import pe.skillnest.stragypattern.services.types.TypeFile;

import java.util.List;

@Service(TypeFile.PDF)
public class EmployeeExporterPdf implements  IEmployeeExporterFile{
    @Override
    public void export(List<Employee> list) {

    }
}
