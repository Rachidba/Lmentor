package ma.lmentor.restapi.mappers;

import ma.lmentor.restapi.entities.Experience;
import ma.lmentor.restapi.vo.ExperienceVo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExperienceMapperTest {
    @Autowired
    private ExperienceMapper experienceMapper;

    @Test
    public void experienceVoToExperience() {
        final String companyName = "ATS";
        final String role = "Software engineer";
        final int startYear = 2019;
        final int startMonth = 2;
        final int endYear = -1;
        final int endMonth = -1;
        final String description = "Capital Markets Research Engineer";

        var expectedExperience = Experience.builder()
                .companyName(companyName)
                .role(role)
                .startYear(startYear)
                .startMonth(startMonth)
                .endYear(endYear)
                .endMonth(endMonth)
                .description(description)
                .build();

        var experienceVo = ExperienceVo.builder()
                .companyName(companyName)
                .role(role)
                .startYear(startYear)
                .startMonth(startMonth)
                .endYear(endYear)
                .endMonth(endMonth)
                .description(description)
                .build();
        var actualExperience = experienceMapper.toExperience(experienceVo);
        Assertions.assertEquals(expectedExperience, actualExperience);
    }
}
