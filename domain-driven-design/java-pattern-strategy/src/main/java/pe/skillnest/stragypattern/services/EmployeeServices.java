package pe.skillnest.stragypattern.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.skillnest.stragypattern.domain.entity.Employee;
import pe.skillnest.stragypattern.services.strategyExporter.EmployeeExporterFactory;
import pe.skillnest.stragypattern.services.strategyExporter.IEmployeeExporterFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeServices implements IEmployeeServices {

    private final EmployeeExporterFactory fileExporterFactory;

    @Override
    public void exportEmployees(String type) {
        //GET FROM DB
        List<Employee> employees = new ArrayList<>();

        IEmployeeExporterFile fileParser = fileExporterFactory.get(type);
        fileParser.export(employees);
    }



    /*
    public void exportEmployees(List<Employee> employees, String type) {
        if (Objects.equals(type, "PDF")) {
            //Logic for convert the list in PDF
            System.out.println("Format is PDF");
        } else if (Objects.equals(type, "XLS")) {
            //Logic for convert the list in PDF
            System.out.println("Format is EXCEL");
        } else {
            throw new IllegalArgumentException("Unsupported file type");
        }
    }*/
}
