package az.ingress.demo.mapper;

import az.ingress.demo.dto.StudentDto;
import az.ingress.demo.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface StudentMapper {

    @Mapping(target = "surname", source = "lastname")
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "address.name", source = "address")
    StudentDto entityToDto(Student student);

//    List<StudentDto> listEntityToDto(List<Student> student);
}
