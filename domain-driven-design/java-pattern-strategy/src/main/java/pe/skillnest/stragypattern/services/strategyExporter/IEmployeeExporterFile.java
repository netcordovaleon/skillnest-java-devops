package pe.skillnest.stragypattern.services.strategyExporter;

import pe.skillnest.stragypattern.domain.entity.Employee;

import java.util.List;

public interface IEmployeeExporterFile {
    void export(List<Employee> list);
}
