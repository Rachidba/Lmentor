package ma.lmentor.restapi.mappers;

import ma.lmentor.restapi.entities.Education;
import ma.lmentor.restapi.vo.EducationVo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class EducationMapperTest {
    @Autowired
    private EducationMapper educationMapper;

    @Test
    public void educationVoToEducation() {
        final String school = "FST Mohamedia";
        final String degree = "Master";
        final String fieldOfStudy = "IT";
        final String description = "Software engineering";
        final int startYear = 2016;
        final int endYear = 2019;

        var expectedEducation = Education.builder()
                .school(school)
                .degree(degree)
                .fieldOfStudy(fieldOfStudy)
                .description(description)
                .startYear(startYear)
                .endYear(endYear)
                .build();

        var educationVo = EducationVo.builder()
                .school(school)
                .degree(degree)
                .fieldOfStudy(fieldOfStudy)
                .description(description)
                .startYear(startYear)
                .endYear(endYear)
                .build();

        var actualEducation = educationMapper.toEducation(educationVo);
        Assertions.assertEquals(expectedEducation, actualEducation);
    }



//    private Integer id;
//    private String school;
//    private String degree;
//    @Column(name = "field_of_study")
//    private String fieldOfStudy;
//    @Column(name = "start_year")
//    private int startYear;
//    @Column(name = "end_year")
//    private int endYear;
//    private String description;
}
