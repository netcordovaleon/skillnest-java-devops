package pe.skillnest.stragypattern.services.strategyExporter;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class EmployeeExporterFactory {

    private final Map<String, IEmployeeExporterFile> fileExporter;

    public IEmployeeExporterFile get(String fileType) {
        IEmployeeExporterFile fileParser = fileExporter.get(fileType);
        if (Objects.isNull(fileParser)) {
            throw new IllegalArgumentException("Unsupported file type");
        }
        return fileParser;
    }
}
